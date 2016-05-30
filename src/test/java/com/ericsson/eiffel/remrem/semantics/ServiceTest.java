package com.ericsson.eiffel.remrem.semantics;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ServiceTest {

    private String ACTIVITY_FINISHED = "eiffelactivityfinished";
    private String ARTIFACT_PUBLISHED = "eiffelartifactpublished";

    JsonParser parser = new JsonParser();
    SemanticsService service = new SemanticsService();

    private void testGenerateMsg(String msgType, String fileName) {

        try {
            File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
            JsonObject input = parser.parse(new FileReader(file)).getAsJsonObject();
            System.out.println(input);

/*            JsonObject msgNodes = input.get("meta").getAsJsonObject();
            JsonObject eventNodes = new JsonObject();
            eventNodes.add("data", input.get("data"));
            eventNodes.add("links", input.get("links"));
            JsonObject*/
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
        testGenerateMsg(ACTIVITY_FINISHED, "ActivityFinished.json");
    }

    @Test public void testArtifactPublished() {
        testGenerateMsg(ARTIFACT_PUBLISHED, "ArtifactPublished.json");
    }
}
