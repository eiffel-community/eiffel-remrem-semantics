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

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.jar.Attributes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.ericsson.eiffel.remrem.protocol.ValidationResult;
import com.ericsson.eiffel.semantics.events.EiffelActivityCanceledEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityTriggeredEvent;
import com.ericsson.eiffel.semantics.events.EiffelAnnouncementPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactReusedEvent;
import com.ericsson.eiffel.semantics.events.EiffelCompositionDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelConfidenceLevelModifiedEvent;
import com.ericsson.eiffel.semantics.events.EiffelEnvironmentDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelFlowContextDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelIssueVerifiedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeSubmittedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseCanceledEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseTriggeredEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestExecutionRecipeCollectionCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestSuiteFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestSuiteStartedEvent;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public class ServiceTest {

    private String ACTIVITY_FINISHED = "EiffelActivityFinishedEvent";
    private String ARTIFACT_PUBLISHED = "EiffelArtifactPublishedEvent";
    private String ARTIFACT_CREATED = "EiffelArtifactCreatedEvent";
    private String ACTIVITY_TRIGGERED = "EiffelActivityTriggeredEvent";
    private String ACTIVITY_STARTED = "EiffelActivityStartedEvent";
    private String ACTIVITY_CANCELED = "EiffelActivityCanceledEvent";
    private String CONFIDENCELEVEL_MODIFIED = "EiffelConfidenceLevelModifiedEvent";
    private String ANNOUNCEMENT_PUBLISHED = "EiffelAnnouncementPublishedEvent";
    private String COMPOSITION_DEFINED = "EiffelCompositionDefinedEvent";
    private String ENVIRONMENT_DEFINED = "EiffelEnvironmentDefinedEvent";
    private String FLOWCONTEXT_DEFINED = "EiffelFlowContextDefinedEvent";
    private String SOURCECHANGE_CREATED = "EiffelSourceChangeCreatedEvent";
    private String SOURCECHANGE_SUBMITTED = "EiffelSourceChangeSubmittedEvent";
    private String TESTCASE_FINISHED = "EiffelTestCaseFinishedEvent";
    private String TESTCASE_STARTED = "EiffelTestCaseStartedEvent";
    private String TESTSUITE_FINISHED = "EiffelTestSuiteFinishedEvent";
    private String TESTSUITE_STARTED = "EiffelTestSuiteStartedEvent";
    private String ISSUE_VERIFIED = "EiffelIssueVerifiedEvent";
    private String ARTIFACT_REUSED = "EiffelArtifactReusedEvent";
    private String TESTCASE_CANCELED="EiffelTestCaseCanceledEvent";
    private String TESTCASE_TRIGGERED="EiffelTestCaseTriggeredEvent";
    private String EXECUTION_RECIPE_COLLECTION_CREATED="EiffelTestExecutionRecipeCollectionCreatedEvent";
    
    
    JsonParser parser = new JsonParser();

    @InjectMocks
    SemanticsService service = new SemanticsService();	
	@InjectMocks
    EiffelActivityFinishedEvent fEvent = new EiffelActivityFinishedEvent();
    
    @InjectMocks
    EiffelArtifactPublishedEvent aEvent = new EiffelArtifactPublishedEvent();
    
    @InjectMocks
    EiffelArtifactCreatedEvent cEvent = new EiffelArtifactCreatedEvent();
    
    @InjectMocks
    EiffelActivityTriggeredEvent tEvent = new EiffelActivityTriggeredEvent();
    
    @InjectMocks
    EiffelActivityStartedEvent sEvent = new EiffelActivityStartedEvent();
    
    @InjectMocks
    EiffelActivityCanceledEvent acEvent = new EiffelActivityCanceledEvent();
    
    @InjectMocks
    EiffelConfidenceLevelModifiedEvent clEvent = new EiffelConfidenceLevelModifiedEvent();
    
    @InjectMocks
    EiffelAnnouncementPublishedEvent apEvent = new EiffelAnnouncementPublishedEvent();
    
    @InjectMocks
    EiffelCompositionDefinedEvent cdEvent = new EiffelCompositionDefinedEvent();
    
    EiffelTestCaseCanceledEvent tcEvent = new EiffelTestCaseCanceledEvent();
    
    @InjectMocks
    EiffelEnvironmentDefinedEvent edEvent = new EiffelEnvironmentDefinedEvent();
    
    @InjectMocks
    EiffelFlowContextDefinedEvent fcEvent = new EiffelFlowContextDefinedEvent();
    
    @InjectMocks
    EiffelSourceChangeCreatedEvent sccEvent = new EiffelSourceChangeCreatedEvent();
    
    @InjectMocks
    EiffelSourceChangeSubmittedEvent scsEvent = new EiffelSourceChangeSubmittedEvent();
    
     @InjectMocks
    EiffelTestCaseFinishedEvent tcfEvent = new EiffelTestCaseFinishedEvent();
    
    @InjectMocks
    EiffelTestCaseStartedEvent tcsEvent = new EiffelTestCaseStartedEvent();
    
    @InjectMocks
    EiffelTestSuiteFinishedEvent tsfEvent = new EiffelTestSuiteFinishedEvent();
    
    @InjectMocks
    EiffelTestSuiteStartedEvent tssEvent = new EiffelTestSuiteStartedEvent();
    
    @InjectMocks
    EiffelIssueVerifiedEvent ivEvent = new EiffelIssueVerifiedEvent();
    
    @InjectMocks
    EiffelArtifactReusedEvent arEvent = new EiffelArtifactReusedEvent();
    
    @InjectMocks
    EiffelTestCaseCanceledEvent tccEvent = new EiffelTestCaseCanceledEvent();
    
    @InjectMocks
    EiffelTestCaseTriggeredEvent tctEvent = new EiffelTestCaseTriggeredEvent();
    
    @InjectMocks
    EiffelTestExecutionRecipeCollectionCreatedEvent terEvent = new EiffelTestExecutionRecipeCollectionCreatedEvent();
      
    @Before
    public void setUp() throws Exception {
        Attributes attributes = mock(Attributes.class);
        MockitoAnnotations.initMocks(this);        
        when(attributes.getValue(anyString())).thenReturn("0.2.3");        
    }

    private void testGenerateMsg(String msgType, String fileName) {

        try {
        	URL url = getClass().getClassLoader().getResource(fileName);
            String path = url.getPath().replace("%20"," ");
            File file = new File(path); 
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(msgType,input);
            System.out.println(msgType);
            System.out.println(msg);
            Assert.assertTrue(msg.contains("data"));
            Assert.assertTrue(msg.contains("meta"));
            Assert.assertTrue(msg.contains("links"));
        } catch(FileNotFoundException e){
            Assert.assertFalse(false);
        }
    }

    @Test public void testActivityFinished() {
        testGenerateMsg(ACTIVITY_FINISHED, "input/ActivityFinished.json");
    }
    @Test public void testArtifactPublished() {
        testGenerateMsg(ARTIFACT_PUBLISHED, "input/ArtifactPublished.json");
    }
    
    @Test public void testArtifactCreated() {
        testGenerateMsg(ARTIFACT_CREATED, "input/ArtifactCreated.json");
    }
    @Test public void testActivityTriggered() {
        testGenerateMsg(ACTIVITY_TRIGGERED, "input/ActivityTriggered.json");
    }
    @Test public void testAcivityStarted() {
        testGenerateMsg(ACTIVITY_STARTED, "input/ActivityStarted.json");     
    }
    @Test public void testActivityCanceled() {
        testGenerateMsg(ACTIVITY_CANCELED, "input/ActivityCanceled.json");
    }
    @Test public void testConfidenceLevelModified() {
        testGenerateMsg(CONFIDENCELEVEL_MODIFIED, "input/ConfidenceLevelModified.json");
    }
    
    @Test public void testAnnouncementPublished() {
        testGenerateMsg(ANNOUNCEMENT_PUBLISHED, "input/AnnouncementPublished.json");
    }
    @Test public void testCompositionDefined() {
        testGenerateMsg(COMPOSITION_DEFINED, "input/CompositionDefined.json");
    }
    
    @Test public void testEnvironmentDefined() {
        testGenerateMsg(ENVIRONMENT_DEFINED, "input/EnvironmentDefined.json");
    }
    @Test public void testFlowContextDefined() {
        testGenerateMsg(FLOWCONTEXT_DEFINED, "input/FlowContextDefined.json");
       
    }
    @Test public void testSourceChangeCreated() {
        testGenerateMsg(SOURCECHANGE_CREATED, "input/SourceChangeCreated.json");
    }
    @Test public void testSourceChangeSubmitted() {
        testGenerateMsg(SOURCECHANGE_SUBMITTED, "input/SourceChangeSubmitted.json");
    }
     @Test public void testTestCaseFinished() {
        testGenerateMsg(TESTCASE_FINISHED, "input/TestCaseFinished.json");
    }
    @Test public void testTestCaseStarted() {
        testGenerateMsg(TESTCASE_STARTED, "input/TestCaseStarted.json");
    }
    
    @Test public void testTestSuiteStarted() {
        testGenerateMsg(TESTSUITE_STARTED, "input/TestSuiteStarted.json");
    }
    @Test public void testTestSuiteFinished() {
        testGenerateMsg(TESTSUITE_FINISHED, "input/TestSuiteFinished.json");
    }
    @Test public void testTestIssueVerified() {
    	testGenerateMsg(ISSUE_VERIFIED, "input/IssueVerified.json");
    }
    @Test public void testTestCaseCanceled() {
    	testGenerateMsg(TESTCASE_CANCELED, "input/TestCaseCanceled.json");
    }
    @Test public void testTestCaseTriggered() {
        testGenerateMsg(TESTCASE_TRIGGERED, "input/TestCaseTriggered.json");
    }
    @Test public void testTestExcecutionRecipeCollectionCreated() {
        testGenerateMsg(EXECUTION_RECIPE_COLLECTION_CREATED, "input/ExecutionRecipeCollection.json");
    }
    @Test public void testTestArtifactReused() {
        testGenerateMsg(ARTIFACT_REUSED, "input/ArtifactReused.json");
    }
    @Test public void testUnknownMessage() {
        try {
        	URL url = getClass().getClassLoader().getResource("input/ArtifactPublished.json");
            String path = url.getPath().replace("%20"," ");
            File file = new File(path); 
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg("unknownmessage",input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Unknown event type requested"));
            Assert.assertTrue(msg.contains("SUPPORTED_EVENT_TYPES"));
        } catch(FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }
    
    @Test
    public void testInvalidMessage() {
        try {
        	URL url = getClass().getClassLoader().getResource("input/ActivityFinishedInvalid.json");
            String path = url.getPath().replace("%20"," ");
            File file = new File(path); 
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(ACTIVITY_FINISHED, input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Cannot validate given JSON string"));
            Assert.assertTrue(msg.contains("cause"));
            Assert.assertTrue(msg.contains("missing required properties ([\\\"groupId"));
        } catch(FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }

    @Test
    public void validateMessage() {
    	URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20"," ");
        File file = new File(path);
        JsonObject input;
        ValidationResult msg = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            msg = service.validateMsg(ACTIVITY_FINISHED, input);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(msg);
        Assert.assertTrue(msg.isValid());
    }
    
    @Test
    public void testGetFamily() {
    	URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20"," ");
        File file = new File(path);
        JsonObject input;
        String family = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            family = service.getFamily(input);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals("activity", family);
    }

    @Test
    public void testGetType() {
    	URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20"," ");
        File file = new File(path);
        JsonObject input;
        String type = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            type = service.getType(input);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals("finished", type);
    }
}