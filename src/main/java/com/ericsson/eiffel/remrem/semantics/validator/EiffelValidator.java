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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo optional fields links.causes and links.context should be mutual exclusive
public class EiffelValidator {
    public static final Logger log = LoggerFactory.getLogger(EiffelValidator.class);

    private JsonSchema validationSchema;
    private String schemaResourceName;

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

}
