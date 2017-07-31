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

import com.ericsson.eiffel.remrem.semantics.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.LinkTypes;
import com.ericsson.eiffel.remrem.semantics.config.LinksConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo optional fields links.causes and links.context should be mutual exclusive
public class EiffelValidator {
    public static final Logger log = LoggerFactory.getLogger(EiffelValidator.class);

    private JsonSchema validationSchema;
    private String schemaResourceName;

    private static final String LINKS = "links";
    private static final String CAUSE_LINK = "CAUSE";
    private static final String CONTEXT_LINK = "CONTEXT";
    private static final String CONFIG_FILE = "linksValidation.properties";

    public EiffelValidator(String schemaResourceName) {
        this.schemaResourceName = schemaResourceName;

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
                log.warn(report.toString());
                log.warn(jsonObjectInput.toString());
                throw new EiffelValidationException(report.toString());
            }

            log.debug("VALIDATED. Schema used: {}", schemaResourceName);
        } catch (Exception e) {
            String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }

    public void linksValidation(EiffelEventType eiffelType, JsonObject jsonObject) throws EiffelValidationException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        try {
            List<String> requiredLinks = LinksConfiguration.getRequiredLinks(eiffelType.getEventName());
            List<String> optionalLinks = LinksConfiguration.getOptionalLinks(eiffelType.getEventName());

            if(requiredLinks == null && optionalLinks == null) {
                throw new EiffelValidationException(eiffelType.getEventName()+"event links not configured in property file "+CONFIG_FILE);
            }
            JsonArray links = jsonObject.getAsJsonObject().getAsJsonArray(LINKS);

            if (links.size() != 0) {
                for (JsonElement link : links) {
                    String linkType = link.getAsJsonObject().get("type").getAsString();
                    Integer count = map.get(linkType);
                    if (count == null) {
                        count = 0;
                    }
                    count++;
                    map.put(linkType, count);
                }
                Set<String> linksSet = new HashSet<>(map.keySet());
                if(requiredLinks != null) {
                    linksSet.removeAll(requiredLinks);
                }
                linksSet.removeAll(optionalLinks);
                if(!linksSet.isEmpty()) {
                    throw new EiffelValidationException(StringUtils.join(linksSet, ',') + " link types not allowed for event "+eiffelType.getEventName());
                }
                if(requiredLinks != null) {
                    for (String requiredLink : requiredLinks) {
                        Integer count = map.get(requiredLink);
                        if(count == null) {
                            throw new EiffelValidationException("Mandatory links missing");
                        } else if(count > 1 && !LinkTypes.valueOf(requiredLink).isMultipleAllowed()) {
                            throw new EiffelValidationException("Multiple trace links not allowed for link type " +requiredLink);
                        }
                    }
                }
                if(map.containsKey(CAUSE_LINK) && map.containsKey(CONTEXT_LINK)) {
                    throw new EiffelValidationException("Link types " +CAUSE_LINK+" and "+CONTEXT_LINK+" should not be in one event");
                }
                for (String optionalLink : optionalLinks) {
                    Integer count = map.get(optionalLink);
                    if(count != null && (count > 1 && !LinkTypes.valueOf(optionalLink).isMultipleAllowed())) {
                        throw new EiffelValidationException("Multiple trace links not allowed for link type " +optionalLink);
                    }
                }
            }
            else if(requiredLinks != null && map.isEmpty()) {
                throw new EiffelValidationException("Mandatory links missing");
            }
        } catch (Exception e) {
            String message = "Cannot validate given JSON string";
            log.debug(message, e);
            throw new EiffelValidationException(message, e);
        }
    }
}
