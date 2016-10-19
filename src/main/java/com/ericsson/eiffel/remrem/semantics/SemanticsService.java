package com.ericsson.eiffel.remrem.semantics;


import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.ericsson.eiffel.remrem.shared.MsgService;

import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;

@Named("eiffel-semantics") @Slf4j
public class SemanticsService implements MsgService{

    private Gson gson = new Gson();
    private Map<EiffelEventType, Class<? extends Event>> eventTypes;

    public SemanticsService() {
        eventTypes = new HashMap<>();
        eventTypes.put(ARTIFACT_PUBLISHED, EiffelArtifactPublishedEvent.class);
        eventTypes.put(ACTIVITY_FINISHED, EiffelActivityFinishedEvent.class);
    }

    @Override
    public String generateMsg(String msgType, JsonObject bodyJson){
        EiffelEventType eiffelType = EiffelEventType.fromString(msgType);
        if (eiffelType == null) {
            throw new IllegalArgumentException("Unknown message type requested: " + msgType);
        }
        Class<? extends Event> eventType = eventTypes.get(eiffelType);

        JsonObject msgNodes = bodyJson.get("msgParams").getAsJsonObject();
        JsonObject eventNodes = bodyJson.get("eventParams").getAsJsonObject();

        Event event = createEvent(eventNodes, eventType);
        event.generateMeta(msgType, msgNodes);

        String result = gson.toJson(event);
        try {
            outputValidate(eiffelType, result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            JsonObject errorResponse = new JsonObject();
            errorResponse.addProperty("message", e.getMessage());
            errorResponse.addProperty("cause", e.getCause().toString().replace("\n", ""));
            return errorResponse.toString();
        }
        return result;
    }
    
    private Event createEvent(JsonObject eventNodes, Class<? extends Event> eventType) {
    	return gson.fromJson(eventNodes, eventType);
    }

    private void outputValidate(EiffelEventType eiffelType, String jsonStringInput) throws EiffelValidationException {
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(eiffelType);
        JsonObject jsonObject = new JsonParser().parse(jsonStringInput).getAsJsonObject();
        validator.validate(jsonObject);
    }
}
