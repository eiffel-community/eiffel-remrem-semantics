package com.ericsson.eiffel.remrem.semantics;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.ericsson.eiffel.remrem.shared.MsgService;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("eiffel-semantics")
public class SemanticsService implements MsgService {

    private Gson gson = new Gson();
    private Map<String, Class<? extends Event>> eventTypes;

    public SemanticsService() {
        eventTypes = new HashMap<>();
        eventTypes.put("eiffelartifactpublished", EiffelArtifactPublishedEvent.class);
        eventTypes.put("eiffelactivityfinished", EiffelActivityFinishedEvent.class);
    }

    @Override
    public String generateMsg(String msgType, JsonObject bodyJson){

        Class<? extends Event> eventType = eventTypes.get(msgType);
        if(eventType == null) {
            return "Invalid Message Type";
        }

        JsonObject msgNodes = bodyJson.get("msgParams").getAsJsonObject();
        JsonObject eventNodes = bodyJson.get("eventParams").getAsJsonObject();

        Event event = gson.fromJson(eventNodes, eventType);
        event.generateMeta(msgType, msgNodes);

        return gson.toJson(event);
    }
}
