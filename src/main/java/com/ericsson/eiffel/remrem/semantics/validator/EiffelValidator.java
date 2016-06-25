package com.ericsson.eiffel.remrem.semantics.validator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//todo optional fields links.causes and links.context should be mutual exclusive
// Do we really need all that when we can use protobuf to validate message for us?
public class EiffelValidator {
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
            log.error(message, e);
            throw new EiffelValidationException(message, e);
        }
    }

}
