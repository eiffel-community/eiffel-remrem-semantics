package com.ericsson.eiffel.semantics.events;

import java.util.UUID;
import java.util.jar.Attributes;

import javax.inject.Inject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import sun.font.Type1Font;

public abstract class Event {
	public transient Meta meta;
    public static String  version = "1.0.0";

    @Inject
    private Attributes attributes;

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes.get("meta"), Meta.class);
        meta.setType(Meta.Type.fromValue(msgType));
        meta.setTime(System.currentTimeMillis());
        // TO DO unit tests are not working when dynamically read version from manifest file
//        String version = attributes.getValue("Semantics-Version");
        meta.setVersion(meta.getVersion().fromValue(version));
        meta.setId(UUID.randomUUID().toString());
    }
    public abstract void setMeta(Meta meta);
}