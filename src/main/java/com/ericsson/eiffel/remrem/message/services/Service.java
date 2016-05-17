package com.ericsson.eiffel.remrem.message.services;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Service implements MsgService{

    final String JSON_DOMAIN_ID = "domainId";
    final String JSON_TYPE = "type";
    private Gson gson = new Gson();
    private static final String FILLER = "filler";

    @Override
    public String generateMsg(String msgType, JsonObject msgNodes, Map<String, String> eventParams){

        String domainId = msgNodes.get(JSON_DOMAIN_ID).getAsString();
        String type = eventParams.get(JSON_TYPE);

        Message.Meta meta = new Message.Meta(domainId, FILLER, type, FILLER, FILLER);
        Message.Data data = new Message.Data(FILLER, FILLER, new Message.Trigger(FILLER, FILLER),FILLER);
        Message message = new Message(meta, data, null);
        return gson.toJson(message);
    }
}
