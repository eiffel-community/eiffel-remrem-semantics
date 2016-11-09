package com.ericsson.eiffel.remrem.semantics.events;

import java.util.UUID;
import java.util.jar.Attributes;

import javax.inject.Inject;

import com.ericsson.eiffel.remrem.semantics.events.schemagenerate.Meta;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class Event {
	public transient Meta meta;
    public static String  version = "0.1.7";

    @Inject
    private Attributes attributes;

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes.get("meta"), Meta.class);
        meta.setType(msgType);
        meta.setTime(System.currentTimeMillis());
        // TO DO unit tests are not working when dynamically read version from manifest file
//        String version = attributes.getValue("Semantics-Version");
        meta.setVersion(version);
        meta.setId(UUID.randomUUID().toString());
    }
    public abstract void setMeta(Meta meta);
}
