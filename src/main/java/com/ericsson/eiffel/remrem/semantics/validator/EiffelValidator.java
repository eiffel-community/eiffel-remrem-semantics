/*
    Copyright 2017 Ericsson AB.
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class EiffelValidator {
    public static final Logger log = LoggerFactory.getLogger(EiffelValidator.class);

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

    public void validate(JsonObject jsonObjectInput) throws EiffelValidationException {
        try {
            ProcessingReport report = validationSchema.validate(JsonLoader.fromString(jsonObjectInput.toString()));
            if (!report.isSuccess()) {
                log.warn(jsonObjectInput.toString());
                throw new EiffelValidationException(getErrorsList(report));
            }
            log.debug("VALIDATED. Schema used: {}", schemaResourceName);
        } catch (Exception e) {
            String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }

    /**
     *
     * @param report json validation report
     * @return error message
     */
    private String getErrorsList(ProcessingReport report) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        String message = "";
        for (ProcessingMessage processingMessage : report) {
            if(LogLevel.ERROR.equals(processingMessage.getLogLevel())) {
                JsonElement element=parser.parse(processingMessage.asJson().toString());
                element.getAsJsonObject().remove("schema");
                element.getAsJsonObject().remove("level");
                message = gson.toJson(element);
                log.debug(message);
            }
        }
        return message;
    }
    /**
     * This method is used to validate links in an event
     * @param JsonArray of links in an event
     * @throws EiffelValidationException if any validation fails
     */
    public void customValidation(JsonObject jsonObjectInput) throws EiffelValidationException {
        // Links validation
        Map<String, Integer> linksCountMapForEvent = new HashMap<String, Integer>();
        String CAUSE_LINK = "CAUSE";
        String CONTEXT_LINK = "CONTEXT";
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
            if (linksCountMapForEvent.containsKey(CAUSE_LINK) && linksCountMapForEvent.containsKey(CONTEXT_LINK)) {
                throw new EiffelValidationException(
                        "Link types " + CAUSE_LINK + " and " + CONTEXT_LINK + " should not be in one event");
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
                linksSet.retainAll(allLinkTypes);
                if (!linksSet.isEmpty()) {
                    throw new EiffelValidationException(
                            StringUtils.join(linksSet, ',') + " link types are not allowed for event " + eventType);
                }
            }
        } catch (Exception e) {
            String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }
}