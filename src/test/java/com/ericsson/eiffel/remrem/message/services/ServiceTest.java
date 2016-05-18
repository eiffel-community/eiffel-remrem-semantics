package com.ericsson.eiffel.remrem.message.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServiceTest {

    private String EVENT_NODES = "{\"data\": {\"outcome\": {\"verdict\": \"TIMEOUT\",\"description\": \"Compilation timed out.\"}," +
            "\"persistentLogs\": [{\"name\": \"firstLog\",\"uri\": \"http://myHost.com/firstLog\"}, {\"name\": \"otherLog\",\"uri\": " +
            "\"isbn:0-486-27557-4\"}]},\"links\": {\"activityExecution\": \"aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeee1\"}}";
    private String MSG_TYPE = "EiffelActivityFinishedEvent";
    private String MSG_NODES = "{\"version\": \"1.0\",\"domainId\": \"example.domain\",\"id\": \"aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeee0\"}";

    JsonParser parser = new JsonParser();

    @Test public void testGenerateMsg() {
        Service service = new Service();

        JsonObject msgNodes = parser.parse(MSG_NODES).getAsJsonObject();
        JsonObject eventNodes = parser.parse(EVENT_NODES).getAsJsonObject();

        String msg = service.generateMsg(MSG_TYPE,msgNodes,eventNodes);
        System.out.println(msg);

        Assert.assertTrue(msg.contains("data"));
        Assert.assertTrue(msg.contains("meta"));
        Assert.assertTrue(msg.contains("links"));
    }
}
