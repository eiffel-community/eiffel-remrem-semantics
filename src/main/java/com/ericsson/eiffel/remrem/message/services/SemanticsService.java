package com.ericsson.eiffel.remrem.message.services;

import com.ericsson.eiffel.remrem.message.services.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.message.services.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.message.services.events.Event;
import com.ericsson.eiffel.remrem.message.services.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.message.services.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.message.services.validator.EiffelValidator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.HashMap;
import java.util.Map;

import static com.ericsson.eiffel.remrem.message.services.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.message.services.EiffelEventType.ARTIFACT_PUBLISHED;

@Service("eiffel-semantics") @Slf4j
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

        Event event = gson.fromJson(eventNodes, eventType);
        event.generateMeta(msgType, msgNodes);

        String result = gson.toJson(event);
        System.out.println(result);
        try {
            outputValidate(eiffelType, result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            System.out.println(e);
            return e.getMessage();
        }
        return result;
    }

    private void outputValidate(EiffelEventType eiffelType, String jsonStringInput) throws EiffelValidationException {
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(eiffelType);
        JsonObject jsonObject = new JsonParser().parse(jsonStringInput).getAsJsonObject();
        validator.validate(jsonObject);
    }
}
