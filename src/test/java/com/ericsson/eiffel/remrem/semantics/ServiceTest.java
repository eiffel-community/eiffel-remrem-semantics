package com.ericsson.eiffel.remrem.semantics;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.ericsson.eiffel.remrem.protocol.ValidationResult;
import com.ericsson.eiffel.remrem.semantics.SemanticsService;
import com.ericsson.eiffel.semantics.events.EiffelActivityCanceledEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityTriggeredEvent;
import com.ericsson.eiffel.semantics.events.EiffelAnnouncementPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelCompositionDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelConfidenceLevelModifiedEvent;
import com.ericsson.eiffel.semantics.events.EiffelConfigurationAppliedEvent;
import com.ericsson.eiffel.semantics.events.EiffelEnvironmentDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelFlowContextDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeSubmittedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseStartedEvent;
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
    private String CONFIGURATION_APPLIED = "EiffelConfigurationAppliedEvent";
    private String ENVIRONMENT_DEFINED = "EiffelEnvironmentDefinedEvent";
    private String FLOWCONTEXT_DEFINED = "EiffelFlowContextDefinedEvent";
    private String SOURCECHANGE_CREATED = "EiffelSourceChangeCreatedEvent";
    private String SOURCECHANGE_SUBMITTED = "EiffelSourceChangeSubmittedEvent";
    private String TESTCASE_FINISHED = "EiffelTestCaseFinishedEvent";
    private String TESTCASE_STARTED = "EiffelTestCaseStartedEvent";
    private String TESTSUITE_FINISHED = "EiffelTestSuiteFinishedEvent";
    private String TESTSUITE_STARTED = "EiffelTestSuiteStartedEvent";
    
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
    
    @InjectMocks
    EiffelConfigurationAppliedEvent caEvent = new EiffelConfigurationAppliedEvent();
    
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
      
    @Before
    public void setUp() throws Exception {
        Attributes attributes = mock(Attributes.class);
        MockitoAnnotations.initMocks(this);        
        when(attributes.getValue(anyString())).thenReturn("0.1.5");        
    }

    private void testGenerateMsg(String msgType, String fileName) {

        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(msgType,input);
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
    
    @Test public void testConfigurationApplied() {
        testGenerateMsg(CONFIGURATION_APPLIED, "input/ConfigurationApplied.json");
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
    @Test public void testUnknownMessage() {
        try {
            File file = new File(getClass().getClassLoader().getResource("input/ArtifactPublished.json").getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg("unknownmessage",input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Unknown message type requested"));
            Assert.assertTrue(msg.contains("cause"));
        } catch(FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }
    
    @Test public void testInvalidMessage() {
        try {
            File file = new File(getClass().getClassLoader().getResource("input/ActivityFinishedInvalid.json").getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(ACTIVITY_FINISHED, input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Cannot validate given JSON string"));
            Assert.assertTrue(msg.contains("cause"));
            Assert.assertTrue(msg.contains("missing required properties ([\\\"domainId"));
        } catch(FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }

    @Test
    public void validateMessage() {
        File file = new File(getClass().getClassLoader().getResource("output/ActivityFinished.json").getFile());
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
}
