/*
    Copyright 2018 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.ericsson.eiffel.remrem.semantics.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.semantics.LinkType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class EiffelValidator {

    private static final String REGEX_PATH = "\\/\\d*";
    private static final String CUSTOM_DATA = "customData";
    private static final String SLASH = "/";
    private static final String DOT = ".";
    private static final String REMREM_GENERATE_FAILURES = "remremGenerateFailures";
    private static final String PATH = "path";
    private static final String MESSAGE = "message";
    private static final String TYPE = "type";
    private static final String REQUIRED = "required";
    private static final String POINTER = "pointer";
    private static final String INSTANCE = "instance";
    private static final String KEYWORD = "keyword";
    public static final Logger log = LoggerFactory.getLogger(EiffelValidator.class);
    private static final String DATA = "data";
    private JsonSchema validationSchema;
    private String schemaResourceName;
    private String eventType;
    private List<String> requiredLinkTypes;
    private List<String> optionalLinkTypes;
    private List<String> allLinkTypes;

    public EiffelValidator(String schemaResourceName, String eventType, List<String> requiredLinkTypes, List<String> optionalLinkTypes, List<String> allLinkTypes) {
        this.schemaResourceName = schemaResourceName;
        this.eventType = eventType;
        this.requiredLinkTypes = requiredLinkTypes;
        this.optionalLinkTypes = optionalLinkTypes;
        this.allLinkTypes = allLinkTypes;

        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            validationSchema = factory.getJsonSchema(
                    mapper.readTree(classLoader.getResourceAsStream(schemaResourceName))
            );
            log.debug("Validation schema loaded: {}", schemaResourceName);
        } catch (Exception e) {
            String message = "Cannot parse JSON schema. The resource: "
                    + schemaResourceName + ". " + e.getClass() + ":  " + e.getMessage();
            log.error(message, e);
            throw new IllegalArgumentException(message, e);
        }
    }

    public JsonObject validate(JsonObject jsonObjectInput) throws EiffelValidationException {
        return validate(jsonObjectInput, false);
    }

    public JsonObject validate(JsonObject jsonObjectInput, Boolean lenientValidation) throws EiffelValidationException {
        JsonArray remremGenerateFailures = new JsonArray();
        log.debug("VALIDATING Schema used: {}", schemaResourceName);
        try {
            final ProcessingReport report = validationSchema.validate(JsonLoader.fromString(jsonObjectInput.toString()),
                    true);
            if (!report.isSuccess() && lenientValidation) {
                log.info("Trying to revalidate the Eiffel message with only mandatory Eiffel message fields.");
                String revalidatedJson = removeErrorProperties(report, jsonObjectInput, remremGenerateFailures);
                ProcessingReport report2 = validationSchema.validate(JsonLoader.fromString(revalidatedJson), true);
                handleErrorReport(jsonObjectInput, report2);
                log.debug("VALIDATED. Schema used: {}", schemaResourceName);
                return addRemremGenerateFailuresToCustomData(JsonParser.parseString(revalidatedJson).getAsJsonObject(), remremGenerateFailures);
            } else {
                handleErrorReport(jsonObjectInput, report);
            }
            log.debug("VALIDATED. Schema used: {}", schemaResourceName);
            return jsonObjectInput;
        } catch (Exception e) {
            final String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }

    private void handleErrorReport(JsonObject jsonObjectInput, ProcessingReport report) throws EiffelValidationException {
        if (!report.isSuccess()) {
            throw new EiffelValidationException(getErrorsList(report));
        }
    }

    /**
     * removeErrorProperties for removing the validation failures from Eiffel event and list the validation failures
     * @param report
     * @param jsonObjectInput
     * @param remremGenerateFailures
     * @return
     * @throws ValidationException
     */
    private String removeErrorProperties(ProcessingReport report, JsonObject jsonObjectInput, JsonArray remremGenerateFailures) throws EiffelValidationException {
        JsonParser parser = new JsonParser();
        DocumentContext doc = JsonPath.parse(jsonObjectInput.toString());
        for (ProcessingMessage processingMessage : report) {
            if (LogLevel.ERROR.equals(processingMessage.getLogLevel())) {
                JsonElement element = parser.parse(processingMessage.asJson().toString());
                if (element.getAsJsonObject().get(KEYWORD).getAsString().equals(REQUIRED) || element.getAsJsonObject().get(KEYWORD).getAsString().equals(TYPE)) {
                    throw new EiffelValidationException(getErrorsList(report));
                }
                String errorPath = element.getAsJsonObject().get(INSTANCE).getAsJsonObject().get(POINTER)
                        .getAsString();
                JsonObject addValidationFailurs = addValidationFailures(element, processingMessage.getMessage());
                remremGenerateFailures.add(addValidationFailurs);
                doc.delete(getPath(errorPath));
            }
        }
        return doc.jsonString();
    }

    /**
     * getPath for create the DocumentContext path from validation failure path
     * example 
     * 1) meta/tags/0 --> $.meta.tags[0]
     * 2) links/0/target --> $.links[0]
     * 3) /data/outcome/conclusion --> $.data.outcome.conclusion
     * @param errorPath
     * @return path
     */
    private String getPath(String errorPath) {
        final Pattern pattern = Pattern.compile(REGEX_PATH, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(errorPath);
        while (matcher.find()) {
            if(matcher.group(0).length()>1) {
                errorPath = errorPath.substring(0, errorPath.indexOf(matcher.group(0))+matcher.group(0).length());
                errorPath = errorPath.replaceAll(matcher.group(0), "["+matcher.group(0).substring(1)+"]");
            }
        }
        return "$" + errorPath.replace(SLASH, DOT);
    }

    private JsonObject addValidationFailures(JsonElement element, String message) {
        log.debug("Adding the error field information to the array");
        String type = element.getAsJsonObject().get(KEYWORD).getAsString();
        String path = element.getAsJsonObject().get(INSTANCE).getAsJsonObject().get(POINTER).getAsString();
        JsonObject object = new JsonObject();
        object.addProperty(TYPE, type);
        object.addProperty(MESSAGE, message);
        object.addProperty(PATH, path);
        return object;
    }

    private JsonObject addRemremGenerateFailuresToCustomData(JsonObject inputJson, JsonArray remremGenerateFailures) {
        if (remremGenerateFailures.size() > 0) {
            JsonArray customData = getCustomData(inputJson);
            JsonObject object = new JsonObject();
            object.addProperty("key", REMREM_GENERATE_FAILURES);
            object.add("value", remremGenerateFailures);
            customData.add(object);
        }
        return inputJson;
    }

    /**
     * Gets the customData array from an Eiffel message
     * @param JsonObject json
     * @return customData array
     */
    public JsonArray getCustomData(JsonObject json) {
        if (json.isJsonObject() && json.getAsJsonObject().has(DATA)
                && json.getAsJsonObject().getAsJsonObject(DATA).has(CUSTOM_DATA)) {
            return json.getAsJsonObject().getAsJsonObject(DATA).get(CUSTOM_DATA).getAsJsonArray();
        }
        return null;
    }

    /**
     *
     * @param report json validation report
     * @return error message
     */
    private String getErrorsList(final ProcessingReport report) {
        List<String> messages = new ArrayList<String>();
        for (final ProcessingMessage processingMessage : report) {
            if (LogLevel.ERROR.equals(processingMessage.getLogLevel())) {
                messages.add(processingMessage.getMessage().toString());
            }
        }
        return messages.toString();
    }

    /**
     * This method is used to validate links in an event
     * @param JsonArray of links in an event
     * @throws EiffelValidationException if any validation fails
     */
    public void customValidation(JsonObject jsonObjectInput) throws EiffelValidationException {
        // Links validation
        Map<String, Integer> linksCountMapForEvent = new HashMap<String, Integer>();
        try {
            JsonArray links = jsonObjectInput.get("links").getAsJsonArray();
            for (JsonElement link : links) {
                String linkType = link.getAsJsonObject().get("type").getAsString();
                Integer count = linksCountMapForEvent.get(linkType);
                if (count == null) {
                    count = 0;
                }
                count++;
                linksCountMapForEvent.put(linkType, count);
            }
            Set<String> linksSet = new HashSet<>(linksCountMapForEvent.keySet());

            for (String requiredLinkType : requiredLinkTypes) {
                Integer count = linksCountMapForEvent.get(requiredLinkType);
                if (count == null) {
                    throw new EiffelValidationException("Mandatory link type " + requiredLinkType + " is missing");
                } else if (count > 1 && !LinkType.valueOf(requiredLinkType).isMultipleAllowed()) {
                    throw new EiffelValidationException(
                            "Multiple trace links are not allowed for link type " + requiredLinkType);
                }
                linksSet.remove(requiredLinkType);
            }
            for (String optionalLinkType : optionalLinkTypes) {
                Integer count = linksCountMapForEvent.get(optionalLinkType);
                if (count != null && (count > 1 && !LinkType.valueOf(optionalLinkType).isMultipleAllowed())) {
                    throw new EiffelValidationException(
                            "Multiple trace links are not allowed for link type " + optionalLinkType);
                }
                linksSet.remove(optionalLinkType);
            }
            if (!linksSet.isEmpty()) {
                throw new EiffelValidationException(
                        StringUtils.join(linksSet, ',') + " link types are invalid for the event " + eventType);
            }
        } catch (Exception e) {
            String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }
}