/*
    Copyright 2018 Ericsson AB.
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.ericsson.eiffel.remrem.protocol.ValidationResult;
import com.ericsson.eiffel.remrem.semantics.util.ManifestHandler;
import com.ericsson.eiffel.semantics.events.Gav;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ServiceTest {

    private String ACTIVITY_FINISHED = "EiffelActivityFinishedEvent";

    JsonParser parser = new JsonParser();

    @InjectMocks
    SemanticsService service = new SemanticsService();
    
    ManifestHandler manifestHandler;
    static Gav manifestGav = null;

    @BeforeClass
    public static void readManifestGav() {
        manifestGav = new Gav();
        URL url = ServiceTest.class.getClassLoader().getResource("MANIFEST.MF");
        String manifestPath = url.getPath().replace("%20", " ");
        try {
            Manifest manifest = new Manifest(new FileInputStream(manifestPath));
            Attributes attributes1 = manifest.getMainAttributes();
            manifestGav.setGroupId(attributes1.getValue("groupId"));
            manifestGav.setArtifactId(attributes1.getValue("artifactId"));
            manifestGav.setVersion(attributes1.getValue("semanticsVersion"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws Exception {
        Attributes attributes = mock(Attributes.class);
        manifestHandler = mock(ManifestHandler.class);
        MockitoAnnotations.initMocks(this);
        when(attributes.getValue(anyString())).thenReturn("0.2.3");
        SemanticsService.semanticsGAV = manifestGav;
    }

    @Test
    public void testGenerate() {
        try {
            File file = new File("src/test/resources/input");
            if (file.exists()) {
                for (File inputFile : file.listFiles()) {
                    JsonObject object = parser.parse(new FileReader(inputFile)).getAsJsonObject();
                    String msgType=object.get("msgParams").getAsJsonObject().get("meta").getAsJsonObject().get("type").getAsString();
                    System.out.println(msgType);
                    String msg = service.generateMsg(msgType, object);
                    System.out.println(msg+"\n");
                    Assert.assertTrue(msg.contains("data"));
                    Assert.assertTrue(msg.contains("meta"));
                    Assert.assertTrue(msg.contains("links"));
                }
            }
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Exception occured while geneatring event");
            e.printStackTrace();
            Assert.assertFalse(true);
        }
    }
    

    @Test
    public void testUnknownMessage() {
        try {
            URL url = getClass().getClassLoader().getResource("input/ArtifactPublished.json");
            String path = url.getPath().replace("%20", " ");
            File file = new File(path);
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg("unknownmessage", input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Unknown event type requested"));
            Assert.assertTrue(msg.contains("SUPPORTED_EVENT_TYPES"));
        } catch (FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }

    @Test
    public void testInvalidMessage() {
        try {
            URL url = getClass().getClassLoader().getResource("invalid/ActivityFinishedInvalid.json");
            String path = url.getPath().replace("%20", " ");
            File file = new File(path);
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            String msg = service.generateMsg(ACTIVITY_FINISHED, input);
            Assert.assertTrue(msg.contains("message"));
            Assert.assertTrue(msg.contains("Cannot validate given JSON string"));
            Assert.assertTrue(msg.contains("cause"));
            Assert.assertTrue(msg.contains("object has missing required properties"));
        } catch (FileNotFoundException e) {
            Assert.assertFalse(false);
        }
    }

    @Test
    public void validateMessage() {
        URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20", " ");
        File file = new File(path);
        JsonObject input;
        ValidationResult msg = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            msg = service.validateMsg(ACTIVITY_FINISHED, input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(msg);
        Assert.assertTrue(msg.isValid());
    }

    @Test
    public void testGetEventType() {
        URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20", " ");
        File file = new File(path);
        JsonObject input;
        String eventType = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            eventType = service.getEventType(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("EiffelActivityFinishedEvent", eventType);
    }

    @Test
    public void testGenerateRoutingKey() {
        URL url = getClass().getClassLoader().getResource("output/ActivityFinished.json");
        String path = url.getPath().replace("%20", " ");
        File file = new File(path);
        JsonObject input;
        String routingKey = null;
        try {
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            routingKey = service.generateRoutingKey(input, null, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("eiffel.activity.finished.notag.domainID", routingKey);
    }

    @Test
    public void testGetRemremSemanticsGav() {
        when(manifestHandler.readGavfromManifest()).thenReturn(manifestGav);
        Gav gav = manifestHandler.readGavfromManifest();
        Assert.assertEquals(gav.getGroupId(), "com.github.Ericsson");
        Assert.assertEquals(gav.getArtifactId(), "eiffel-remrem-semantics");
        Assert.assertEquals(gav.getVersion(), "0.3.1");
    }

    @Test(expected = FileNotFoundException.class)
    public void testInvalidPathRemremSemanticsGav() throws Exception {
        URL url = ServiceTest.class.getClassLoader().getResource("MANIFEST.MF");
        String manifestPath = url.getPath() + "/InvalidPath";
        Manifest manifest = new Manifest(new FileInputStream(manifestPath));
        Attributes attributes1 = manifest.getMainAttributes();
        manifestGav.setGroupId(attributes1.getValue("groupId"));
        manifestGav.setArtifactId(attributes1.getValue("artifactId"));
        manifestGav.setVersion(attributes1.getValue("semanticsVersion"));

    }
    
    @Test
    public void testGetSupportedEventTypes() {
    	URL url = getClass().getClassLoader().getResource("EventTypes.json");
        String path = url.getPath().replace("%20", " ");
        File file = new File(path);
        JsonObject input = null;
        boolean checkValue = false;        
        try {
            Collection<String> types = service.getSupportedEventTypes();
            input = parser.parse(new FileReader(file)).getAsJsonObject();
            JsonArray eventTypes = input.getAsJsonArray("eventTypes");            
            List<String> matchingCollection = new ArrayList<>();
            if (eventTypes != null) {
            	for (JsonElement event : eventTypes) {
            		matchingCollection.add(event.getAsString());
            	}
            }
            checkValue = types.containsAll(matchingCollection);
        } catch (Exception e) {
            e.printStackTrace();
        }     
        assertEquals(true,checkValue);
    }
    
    @Test
    public void testGetEventTemplateCaseInsensitive() throws FileNotFoundException {
        JsonElement template = service.getEventTemplate("eiffeLartiFactpublisheDevent");
        assertNotNull(template);
    }
    
    @Test
    public void testGetEventTemplateNoFile() throws FileNotFoundException {
        JsonElement template = service.getEventTemplate("EiffelNotAnEvent");
        assertNull(template);
    }

    @Test
    public void testValidateTemplates() {
        try {
            File file = new File("src/main/resources/templates");
            if (file.exists()) {
                for (File inputFile : file.listFiles()) {
                    System.out.println(inputFile.getName());
                    parser.parse(new FileReader(inputFile)).getAsJsonObject();
                }
            }
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Exception occured while validating templates");
            e.printStackTrace();
            Assert.assertFalse(true);
        }
    }
}