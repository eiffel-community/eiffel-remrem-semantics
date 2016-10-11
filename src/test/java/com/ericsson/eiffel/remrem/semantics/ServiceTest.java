package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(FakeConfig.class)
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
        MockitoAnnotations.initMocks(this);
        Attributes attributes = mock(Attributes.class);
        Event event = mock(Event.class,  Mockito.CALLS_REAL_METHODS);
//        when(service.createEvent(an, anyObject())).thenReturn(event);        
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
}
