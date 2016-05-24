package com.ericsson.eiffel.remrem.message.services;

import com.ericsson.eiffel.remrem.message.services.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.message.services.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.message.services.events.Event;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("eiffel-semantics") @Slf4j
public class SemanticsService implements MsgService{

    private Gson gson = new Gson();
    private Map<String, Class<? extends Event>> eventTypes;

    public SemanticsService() {
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
