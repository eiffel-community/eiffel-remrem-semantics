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
package com.ericsson.eiffel.remrem.semantics;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_CANCELED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_TRIGGERED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ANNOUNCEMENT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.COMPOSITION_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIDENCELEVEL_MODIFIED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIGURATION_APPLIED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ENVIRONMENT_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.FLOWCONTEXT_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.SOURCECHANGE_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.SOURCECHANGE_SUBMITTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTCASE_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTCASE_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTSUITE_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTSUITE_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ISSUE_VERIFIED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_REUSED;

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
    @Test
    public void TestValidAnnouncementPublishedOutput() throws Exception {
        String json = getResourceContents("output/AnnouncementPublished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ANNOUNCEMENT_PUBLISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
     @Test
    public void TestValidCompositionDefinedOutput() throws Exception {
        String json = getResourceContents("output/CompositionDefined.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(COMPOSITION_DEFINED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidConfigurationAppliedOutput() throws Exception {
        String json = getResourceContents("output/ConfigurationApplied.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(CONFIGURATION_APPLIED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidEnvironmentDefinedOutput() throws Exception {
        String json = getResourceContents("output/EnvironmentDefined.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ENVIRONMENT_DEFINED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidFlowContextDefinedOutput() throws Exception {
        String json = getResourceContents("output/FlowContextDefined.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(FLOWCONTEXT_DEFINED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidSourceChangeCreatedOutput() throws Exception {
        String json = getResourceContents("output/SourceChangeCreated.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(SOURCECHANGE_CREATED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidSourceChangeSubmittedOutput() throws Exception {
        String json = getResourceContents("output/SourceChangeSubmitted.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(SOURCECHANGE_SUBMITTED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidTestCaseFinishedOutput() throws Exception {
        String json = getResourceContents("output/TestCaseFinished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(TESTCASE_FINISHED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidTestCaseStartedOutput() throws Exception {
        String json = getResourceContents("output/TestCaseStarted.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(TESTCASE_STARTED);

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidTestSuiteStartedOutput() throws Exception {
        String json = getResourceContents("output/TestSuiteStarted.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(TESTSUITE_STARTED);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
    
     @Test
    public void TestValidTestSuiteFinishedOutput() throws Exception {
        String json = getResourceContents("output/TestSuiteFinished.json");
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(TESTSUITE_FINISHED);
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        validator.validate(jsonObject);
        
    }
     
     @Test
     public void TestValidIssueVerifiedOutput() throws Exception {
    	 String json = getResourceContents("output/IssueVerified.json");
    	 EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ISSUE_VERIFIED);
    	 JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
    	 validator.validate(jsonObject);
     }
     
     @Test
     public void TestValidArtifactReusedOutput() throws Exception {
    	 String json = getResourceContents("output/ArtifactReused.json");
    	 EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(ARTIFACT_REUSED);
    	 JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
    	 validator.validate(jsonObject);
     }
    
    
}