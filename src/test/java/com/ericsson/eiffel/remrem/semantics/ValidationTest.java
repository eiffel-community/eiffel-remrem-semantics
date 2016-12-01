package com.ericsson.eiffel.remrem.semantics;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_TRIGGERED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_CANCELED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIDENCELEVEL_MODIFIED;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
    @Test
    public void TestValidArtifactCreatedOutput() throws Exception {
        String json = getResourceContents("output/ArtifactCreated.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ARTIFACT_CREATED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    
    @Test(expected = EiffelValidationException.class)
    public void TestInvalidArtifactCreatedOutput() throws Exception {
        String json = getResourceContents("output/ArtifactCreated.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ARTIFACT_CREATED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
    @Test
    public void TestValidActivityStartedOutput() throws Exception {
        String json = getResourceContents("output/ActivityStarted.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_STARTED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    
    @Test(expected = EiffelValidationException.class)
    public void TestInvalidActivityStartedOutput() throws Exception {
        String json = getResourceContents("output/ActivityStarted.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_STARTED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
    @Test
    public void TestValidActivityCanceledOutput() throws Exception {
        String json = getResourceContents("output/ActivityCanceled.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_CANCELED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    
    @Test(expected = EiffelValidationException.class)
    public void TestInvalidActivityCanceledOutput() throws Exception {
        String json = getResourceContents("output/ActivityCanceled.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_CANCELED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
    @Test
    public void TestValidActivityTriggeredOutput() throws Exception {
        String json = getResourceContents("output/ActivityTriggered.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_TRIGGERED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    
    @Test(expected = EiffelValidationException.class)
    public void TestInvalidActivityTriggeredOutput() throws Exception {
        String json = getResourceContents("output/ActivityTriggered.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ACTIVITY_TRIGGERED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
    @Test
    public void TestValidConfidenceLevelModifiedOutput() throws Exception {
        String json = getResourceContents("output/ConfidenceLevelModified.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(CONFIDENCELEVEL_MODIFIED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
    }

    
    @Test(expected = EiffelValidationException.class)
    public void TestInvalidConfidenceLevelModifiedOutput() throws Exception {
        String json = getResourceContents("output/ConfidenceLevelModified.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(CONFIDENCELEVEL_MODIFIED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        jsonObject.remove("links");
        validator.validate(jsonObject);
       
    }
}
