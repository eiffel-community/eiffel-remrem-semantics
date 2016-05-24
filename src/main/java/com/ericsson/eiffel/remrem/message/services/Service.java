package com.ericsson.eiffel.remrem.message.services;

import com.ericsson.duraci.eiffelmessage.messages.events.EiffelJobStartedEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;


public class Service implements MsgService{

    private Gson gson = new Gson();
    private Map<String, Class<? extends Event>> eventTypes;

    public Service() {
        eventTypes = new HashMap<>();
        eventTypes.put("eiffelartifactpublished", EiffelArtifactPublishedEvent.class);
        eventTypes.put("eiffelactivityfinished", EiffelActivityFinishedEvent.class);
    }

    @Override
    public String generateMsg(String msgType, JsonObject msgNodes, JsonObject eventNodes){

        Class<? extends Event> eventType = eventTypes.get(msgType);
        if(eventType == null) {
            return "Invalid Message Type";
        }
        Event event = gson.fromJson(eventNodes, eventType);
        event.generateMeta(msgType, msgNodes);

        return gson.toJson(event);
    }
}
