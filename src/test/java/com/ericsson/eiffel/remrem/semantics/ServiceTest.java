package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes;

public class ServiceTest {

    private String ACTIVITY_FINISHED = "eiffelactivityfinished";
    private String ARTIFACT_PUBLISHED = "eiffelartifactpublished";

    JsonParser parser = new JsonParser();

    @InjectMocks
    SemanticsService service = new SemanticsService();	
    
    @InjectMocks
    EiffelActivityFinishedEvent fEvent = new EiffelActivityFinishedEvent();
    
    @InjectMocks
    EiffelArtifactPublishedEvent aEvent = new EiffelArtifactPublishedEvent();
    
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

    @Test public void testUnknownMessage() {
        try {
            File file = new File(getClass().getClassLoader().getResource("input/ArtifactPublished.json").getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();

            String msg = service.generateMsg("unknownmessage",input);
            System.out.println(msg);

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
            System.out.println(msg);

            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Cannot validate given JSON string"));
            Assert.assertTrue(msg.contains("cause"));
           // Assert.assertTrue(msg.contains("missing required properties ([\\\"activityExecution"));
        } catch(FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }
}
