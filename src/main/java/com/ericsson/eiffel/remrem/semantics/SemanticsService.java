package com.ericsson.eiffel.remrem.semantics;


import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_CANCELED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_TRIGGERED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIDENCELEVEL_MODIFIED;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityCanceledEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityStartedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelActivityTriggeredEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactCreatedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.remrem.semantics.events.EiffelConfidenceLevelModifiedEvent;
import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.shared.MsgService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Named("eiffel-semantics")
public class SemanticsService implements MsgService{

    private static final String ID = "id";
    private static final String META = "meta";

    public static final Logger log = LoggerFactory.getLogger(SemanticsService.class);

    private Gson gson = new Gson();
    private Map<EiffelEventType, Class<? extends Event>> eventTypes;

    public SemanticsService() {
        eventTypes = new HashMap<>();
        eventTypes.put(ARTIFACT_PUBLISHED, EiffelArtifactPublishedEvent.class);
        eventTypes.put(ACTIVITY_FINISHED, EiffelActivityFinishedEvent.class);
        eventTypes.put(ARTIFACT_CREATED, EiffelArtifactCreatedEvent.class);
        eventTypes.put(ACTIVITY_CANCELED, EiffelActivityCanceledEvent.class);
        eventTypes.put(ACTIVITY_STARTED, EiffelActivityStartedEvent.class);
        eventTypes.put(ACTIVITY_TRIGGERED, EiffelActivityTriggeredEvent.class);
        eventTypes.put(CONFIDENCELEVEL_MODIFIED, EiffelConfidenceLevelModifiedEvent.class);
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
        event.setMeta(event.meta);
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
        if (json.isJsonObject() && json.getAsJsonObject().has(META) && json.getAsJsonObject()
                .getAsJsonObject(META).has(ID)) {
            return json.getAsJsonObject().getAsJsonObject(META)
                    .get(ID).getAsString();
        }
        return null;
    }
}
