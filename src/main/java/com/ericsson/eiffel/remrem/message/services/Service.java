package com.ericsson.eiffel.remrem.message.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Service implements MsgService{

    private Gson gson = new Gson();

    @Override
    public String generateMsg(String msgType, JsonObject msgNodes, JsonObject eventNodes){

        EiffelActivityFinishedEvent event;

        event = gson.fromJson(eventNodes, EiffelActivityFinishedEvent.class);
        event.generateMeta(msgType, msgNodes);

        return gson.toJson(event);
    }
}
