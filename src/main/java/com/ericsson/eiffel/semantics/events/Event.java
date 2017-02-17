package com.ericsson.eiffel.semantics.events;

import java.util.UUID;

import com.ericsson.eiffel.remrem.semantics.RoutingKeyTypes;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class Event {
    public transient Meta meta;
    public static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Event.class);
    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes.get("meta"), Meta.class);
        meta.setType(Meta.Type.fromValue(msgType));
        meta.setTime(System.currentTimeMillis());
        // TO DO unit tests are not working when dynamically read version from manifest file
//        String version = attributes.getValue("Semantics-Version");
        meta.setId(UUID.randomUUID().toString());
    }
    public abstract void setMeta(Meta meta);

    public static String getFamilyRoutingKey(String eventType) {
        RoutingKeyTypes eventtype = null;
        try {
            eventtype = RoutingKeyTypes.valueOf(eventType);
        } catch (Exception e) {
            log.error("Unknown event type requested: " + eventType);
        }
        return eventtype.getFamily();
    }

    public static String getTypeRoutingKey(String eventType) {
        RoutingKeyTypes eventtype = null;
        try {
            eventtype = RoutingKeyTypes.valueOf(eventType);
        } catch (Exception e) {
            log.error("Unknown event type requested: " + eventType);
        }
        return eventtype.getType();
    }
}