package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class ServiceTest {

    private String ACTIVITY_FINISHED = "eiffelactivityfinished";
    private String ARTIFACT_PUBLISHED = "eiffelartifactpublished";

    JsonParser parser = new JsonParser();
    
    @InjectMocks
    SemanticsService service = new SemanticsService();

    
    private Event event;
        
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        event = mock(Event.class);
        when(event.getCurrentVersion()).thenReturn("0.1.0");
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
}
