package com.ericsson.eiffel.remrem.message.services;

import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ServiceTest {

    @Test public void testSomeLibraryMethod() {
        Service service = new Service();
        JsonObject msgNodes = new JsonObject();
        msgNodes.addProperty("domainId", "my domain");
        Map<String, String> eventParams = new HashMap<>();
        eventParams.put("type", "EiffelActivityQueuedEvent");
        String msg = service.generateMsg(null,msgNodes,eventParams);
        System.out.println(msg);
    }
}
