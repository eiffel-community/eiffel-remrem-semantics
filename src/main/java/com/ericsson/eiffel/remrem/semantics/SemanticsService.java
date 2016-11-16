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

import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;


@Named("eiffel-semantics")
public class SemanticsService implements MsgService{

    public static final Logger log = LoggerFactory.getLogger(SemanticsService.class);

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
            log.error("Unknown message type requested: " + msgType);
            return createErrorResponse("Unknown message type requested", "'" + msgType + "' is not in the vocabulary of this service");
        }
        Class<? extends Event> eventType = eventTypes.get(eiffelType);

        JsonObject msgNodes = bodyJson.get("msgParams").getAsJsonObject();
        JsonObject eventNodes = bodyJson.get("eventParams").getAsJsonObject();

        Event event = createEvent(eventNodes, eventType);
        event.generateMeta(msgType, msgNodes);

        String result = gson.toJson(event);
        try {
            outputValidate(eiffelType, result);
        } catch (EiffelValidationException e) {
            log.error("Could not validate message. Reason:" +  e.getMessage() +"\nCause: " + e.getCause().toString());
            return createErrorResponse(e.getMessage(), e.getCause().toString());
        }
        return result;
    }
    
    private Event createEvent(JsonObject eventNodes, Class<? extends Event> eventType) {
    	return gson.fromJson(eventNodes, eventType);
    }

    private String createErrorResponse(final String message, final String cause){
        JsonObject errorResponse = new JsonObject();
        errorResponse.addProperty("message", message);
        errorResponse.addProperty("cause", cause.replace("\n", ""));
        return errorResponse.toString();
    }
    
    private void outputValidate(EiffelEventType eiffelType, String jsonStringInput) throws EiffelValidationException {
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(eiffelType);
        JsonObject jsonObject = new JsonParser().parse(jsonStringInput).getAsJsonObject();
        validator.validate(jsonObject);
    }

	@Override
	public String getEventId(JsonObject json) {
        if (json.isJsonObject() && json.getAsJsonObject().has(RemremSemanticsConstants.META)
                && json.getAsJsonObject().getAsJsonObject(RemremSemanticsConstants.META).has(RemremSemanticsConstants.ID)) {
            return json.getAsJsonObject().getAsJsonObject(RemremSemanticsConstants.META).get(RemremSemanticsConstants.ID).getAsString();
        }
        return null;}
}
