package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;

public class ValidationTest {

    private final ClassLoader classLoader = getClass().getClassLoader();

    private String getResourceContents(String resourceName) throws Exception {
        URL resource = classLoader.getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("Can't find resource: " + resourceName);
        }

        return Files.toString(new File(resource.getFile()), Charsets.UTF_8);
    }

    @Test
    public void TestValidActivityFinishedOutput() throws Exception {
        String json = getResourceContents("output/ActivityFinished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_FINISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }

    @Test(expected = EiffelValidationException.class)
    public void TestInvalidActivityFinishedOutput() throws Exception {
        String json = getResourceContents("output/ActivityFinished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_FINISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("data");
        validator.validate(jsonObject);
    }

    @Test
    public void TestValidArtifactPublishedOutput() throws Exception {
        String json = getResourceContents("output/ArtifactPublished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ARTIFACT_PUBLISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    @Test(expected = EiffelValidationException.class)
    public void TestInvalidArtifactPublishedOutput() throws Exception {
        String json = getResourceContents("output/ArtifactPublished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ARTIFACT_PUBLISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
}
