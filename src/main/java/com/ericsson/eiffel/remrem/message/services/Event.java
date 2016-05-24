package com.ericsson.eiffel.remrem.message.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.UUID;

/**
 * Created by ehenkan on 5/16/16.
 */
abstract class Event {
    public Meta meta;
    public static String  version = "0.1.0";

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes, Meta.class);
        meta.setType(msgType);
        meta.setTime(System.currentTimeMillis());
        meta.setVersion(version);
        meta.setId(UUID.randomUUID().toString());
    }

}

