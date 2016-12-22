package com.ericsson.eiffel.semantics.events;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class Event {
	public transient Meta meta;

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes.get("meta"), Meta.class);
        meta.setType(Meta.Type.fromValue(msgType));
        meta.setTime(System.currentTimeMillis());
        meta.setId(UUID.randomUUID().toString());
    }
    public abstract void setMeta(Meta meta);
}