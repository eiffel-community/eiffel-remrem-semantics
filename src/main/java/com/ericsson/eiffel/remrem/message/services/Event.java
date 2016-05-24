package com.ericsson.eiffel.remrem.message.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ehenkan on 5/16/16.
 */
abstract class Event {
    public Meta meta;
    private transient String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes, Meta.class);
        meta.setType(msgType);
        meta.setTime(System.currentTimeMillis());
    }

}
