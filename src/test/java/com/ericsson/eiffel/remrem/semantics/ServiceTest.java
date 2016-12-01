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

import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityCanceledEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityStartedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityTriggeredEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactCreatedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelConfidenceLevelModifiedEvent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ServiceTest {

	private String ACTIVITY_FINISHED = "eiffelactivityfinished";
    private String ARTIFACT_PUBLISHED = "eiffelartifactpublished";
    private String ARTIFACT_CREATED = "eiffelartifactcreated";
    private String ACTIVITY_TRIGGERED = "eiffelactivitytriggered";
    private String ACTIVITY_STARTED = "eiffelactivitystarted";
    private String ACTIVITY_CANCELED = "eiffelactivitycanceled";
    private String CONFIDENCELEVEL_MODIFIED = "eiffelconfidencelevelmodified";

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
            String msg = service.generateMsg(msgType, input);
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
    
    @Test
    public void testUnknownMessage() {
        try {
            File file = new File(
                    getClass().getClassLoader().getResource("input/UnkownArtifactPublished.json").getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg("unknownmessage", input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Unknown message type requested"));
            Assert.assertTrue(msg.contains("cause"));
        } catch (FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }

    @Test
    public void testInvalidMessage() {
        try {
            File file = new File(
                    getClass().getClassLoader().getResource("input/ActivityFinishedInvalid.json").getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(ACTIVITY_FINISHED, input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Cannot validate given JSON string"));
            Assert.assertTrue(msg.contains("cause"));
            Assert.assertTrue(msg.contains("missing required properties ([\\\"domainId"));
        } catch (FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }
}
