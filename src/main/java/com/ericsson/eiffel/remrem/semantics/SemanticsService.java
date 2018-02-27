/*
    Copyright 2018 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.ericsson.eiffel.remrem.semantics;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.protocol.MsgService;
import com.ericsson.eiffel.remrem.protocol.ValidationResult;
import com.ericsson.eiffel.remrem.semantics.factory.EiffelOutputValidatorFactory;
import com.ericsson.eiffel.remrem.semantics.util.ManifestHandler;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidationException;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.semantics.events.EiffelActivityCanceledEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelActivityTriggeredEvent;
import com.ericsson.eiffel.semantics.events.EiffelAlertAcknowledgedEvent;
import com.ericsson.eiffel.semantics.events.EiffelAlertCeasedEvent;
import com.ericsson.eiffel.semantics.events.EiffelAlertRaisedEvent;
import com.ericsson.eiffel.semantics.events.EiffelAnnouncementPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactDeployedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactPublishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelArtifactReusedEvent;
import com.ericsson.eiffel.semantics.events.EiffelCompositionDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelConfidenceLevelModifiedEvent;
import com.ericsson.eiffel.semantics.events.EiffelEnvironmentDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelFlowContextDefinedEvent;
import com.ericsson.eiffel.semantics.events.EiffelIssueVerifiedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceAllocatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceDeployedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceDiscontinuedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceReturnedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelServiceStoppedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelSourceChangeSubmittedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseCanceledEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseStartedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestCaseTriggeredEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestExecutionRecipeCollectionCreatedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestSuiteFinishedEvent;
import com.ericsson.eiffel.semantics.events.EiffelTestSuiteStartedEvent;
import com.ericsson.eiffel.semantics.events.Event;
import com.ericsson.eiffel.semantics.events.Gav;
import com.ericsson.eiffel.semantics.events.Serializer;
import com.ericsson.eiffel.semantics.events.Source;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Named("eiffel-semantics")
public class SemanticsService implements MsgService {
    private static final String ERROR = "error";
    private static final String SUPPORTED_EVENT_TYPES = "SUPPORTED_EVENT_TYPES";
    private static final String RESULT = "result";
    private static final String UNKNOWN_EVENT_TYPE_REQUESTED = "Unknown event type requested";
    private static final String EVENT_PARAMS = "eventParams";
    private static final String MSG_PARAMS = "msgParams";
    private static final String MESSAGE = "message";
    private static final String CAUSE = "cause";
    private static final String EIFFELSEMANTICS = "eiffelsemantics";
    private static final String ID = "id";
    private static final String META = "meta";
    private static final String TYPE = "type";
    private static final String SOURCE = "source";
    private static final String DOMAIN_ID = "domainId";
    private static final String PROTOCOL = "eiffel";
    private static final String DOT = ".";
    private final ArrayList<String> supportedEventTypes = new ArrayList<String>();
    public static final Logger log = LoggerFactory.getLogger(SemanticsService.class);
    private Event event = new Event();
    public static Gav semanticsGAV;
    private boolean semanticsGavFlag = false;
    private static Gson gson = new Gson();
    private static Map<EiffelEventType, Class<? extends Event>> eventTypes = SemanticsService.eventType();

    public SemanticsService() {
        for (final EiffelEventType msg : EiffelEventType.values()) {
            supportedEventTypes.add(msg.getEventName());
        }
    }

    @PostConstruct
    public void readManifest() {
        ManifestHandler manifastHandler = new ManifestHandler();
        semanticsGAV = manifastHandler.readGavfromManifest();
        if (semanticsGAV == null || semanticsGAV.getArtifactId() == null || semanticsGAV.getGroupId() == null
                || semanticsGAV.getVersion() == null) {
            semanticsGavFlag = true;
        }
    }

    public static Map<EiffelEventType, Class<? extends Event>> eventType() {
        eventTypes = new HashMap<>();
        eventTypes.put(ARTIFACT_PUBLISHED, EiffelArtifactPublishedEvent.class);
        eventTypes.put(ACTIVITY_FINISHED, EiffelActivityFinishedEvent.class);
        eventTypes.put(ARTIFACT_CREATED, EiffelArtifactCreatedEvent.class);
        eventTypes.put(ACTIVITY_CANCELED, EiffelActivityCanceledEvent.class);
        eventTypes.put(ACTIVITY_STARTED, EiffelActivityStartedEvent.class);
        eventTypes.put(ACTIVITY_TRIGGERED, EiffelActivityTriggeredEvent.class);
        eventTypes.put(CONFIDENCELEVEL_MODIFIED, EiffelConfidenceLevelModifiedEvent.class);
        eventTypes.put(ANNOUNCEMENT_PUBLISHED, EiffelAnnouncementPublishedEvent.class);
        eventTypes.put(COMPOSITION_DEFINED, EiffelCompositionDefinedEvent.class);
        eventTypes.put(TESTCASE_CANCELED, EiffelTestCaseCanceledEvent.class);
        eventTypes.put(TESTCASE_TRIGGERED, EiffelTestCaseTriggeredEvent.class);
        eventTypes.put(EXECUTION_RECIPE_COLLECTION_CREATED, EiffelTestExecutionRecipeCollectionCreatedEvent.class);
        eventTypes.put(ENVIRONMENT_DEFINED, EiffelEnvironmentDefinedEvent.class);
        eventTypes.put(FLOWCONTEXT_DEFINED, EiffelFlowContextDefinedEvent.class);
        eventTypes.put(SOURCECHANGE_CREATED, EiffelSourceChangeCreatedEvent.class);
        eventTypes.put(SOURCECHANGE_SUBMITTED, EiffelSourceChangeSubmittedEvent.class);
        eventTypes.put(TESTCASE_FINISHED, EiffelTestCaseFinishedEvent.class);
        eventTypes.put(TESTCASE_STARTED, EiffelTestCaseStartedEvent.class);
        eventTypes.put(TESTSUITE_FINISHED, EiffelTestSuiteFinishedEvent.class);
        eventTypes.put(TESTSUITE_STARTED, EiffelTestSuiteStartedEvent.class);
        eventTypes.put(ISSUE_VERIFIED, EiffelIssueVerifiedEvent.class);
        eventTypes.put(ARTIFACT_REUSED, EiffelArtifactReusedEvent.class);
        eventTypes.put(SERVICE_STOPPED, EiffelServiceStoppedEvent.class);
        eventTypes.put(SERVICE_STARTED, EiffelServiceStartedEvent.class);
        eventTypes.put(SERVICE_RETURNED, EiffelServiceReturnedEvent.class);
        eventTypes.put(SERVICE_DISCONTINUED, EiffelServiceDiscontinuedEvent.class);
        eventTypes.put(SERVICE_DEPLOYED, EiffelServiceDeployedEvent.class);
        eventTypes.put(SERVICE_ALLOCATED, EiffelServiceAllocatedEvent.class);
        eventTypes.put(ARTIFACT_DEPLOYED, EiffelArtifactDeployedEvent.class);
        eventTypes.put(ALERT_ACKNOWLEDGED, EiffelAlertAcknowledgedEvent.class);
        eventTypes.put(ALERT_CEASED, EiffelAlertCeasedEvent.class);
        eventTypes.put(ALERT_RAISED, EiffelAlertRaisedEvent.class);

        return eventTypes;
    }

    @Override
    public String generateMsg(String msgType, JsonObject bodyJson) {
        try {
            if (semanticsGavFlag) {
                return createErrorResponse("GAV info of eiffel-remrem-semantics is missing",
                        "Required Serializer GAV information of eiffel-remrem-semantics is missing in MANIFEST.MF");
            }
            EiffelEventType eiffelType = EiffelEventType.fromString(msgType);
            if (eiffelType == null) {
                log.error("Unknown message type requested: " + msgType);
                return createErrorResponse(msgType, supportedEventTypes);
            }
            Class<? extends Event> eventType = eventTypes.get(eiffelType);

            JsonObject msgNodes = bodyJson.get(MSG_PARAMS).getAsJsonObject();
            JsonObject eventNodes = bodyJson.get(EVENT_PARAMS).getAsJsonObject();

            // Compare the input JSON EventType with query parameter(-t) and also
            // check type exist or not,
            // if input JSON EventType is missing adding query parameter as Type.
            String inputEventType = getInputEventType(bodyJson);
            if (inputEventType == null || inputEventType.isEmpty()) {
                bodyJson.get(MSG_PARAMS).getAsJsonObject().get(META).getAsJsonObject().addProperty(TYPE, eiffelType.getEventName());
            } else if (!(inputEventType.equals(eiffelType.getEventName()))) {
                log.error("check the input json message type : " + inputEventType);
                return createErrorResponse(eiffelType.getEventName(),
                        "Mismatch of eventype in request query parameter with property 'type' in the input json message");
            }

            Event event = eventCreation(eventType, msgNodes, eventNodes);

            String result = gson.toJson(event);
            outputValidate(eiffelType, result);
            return result;
        } catch (EiffelValidationException e) {
            log.error("Could not validate message. Reason:" + e.getMessage() + "\nCause: " + e.getCause().toString());
            return createErrorResponse(e.getMessage(), e.getCause().toString());
        } catch (JsonSyntaxException e) {
            log.error("Json Syntax exception occured. Reason:" + e.getMessage() + "\nCause: " + e.getCause().toString());
            return createErrorResponse("Json Syntax exception occured while processing input schema", e.getCause().toString());
        }

    }

    private static Event eventCreation(Class<? extends Event> eventType, JsonObject msgNodes, JsonObject eventNodes) {
        eventNodes.add("meta", msgNodes.get("meta"));
        Event event = createEvent(eventNodes, eventType);
        event.setMeta(event.generateMeta(event.getMeta()));
        event.getMeta().setSource(setSerializerGav(event.getMeta().getSource()));
        return event;
    }

    private static Event createEvent(JsonObject eventNodes, Class<? extends Event> eventType) {
        return gson.fromJson(eventNodes, eventType);
    }

    private String createErrorResponse(final String message, final String cause) {
        JsonObject errorResponse = new JsonObject();
        errorResponse.addProperty(MESSAGE, message);
        errorResponse.addProperty(CAUSE, cause.replace("\n", ""));
        return errorResponse.toString();
    }

    private String createErrorResponse(final String message, final ArrayList<String> supportedEventTypes) {
        JsonObject errorResponse = new JsonObject();
        errorResponse.addProperty(RESULT, ERROR);
        errorResponse.addProperty(MESSAGE, UNKNOWN_EVENT_TYPE_REQUESTED + "  -  " + message);
        errorResponse.addProperty(SUPPORTED_EVENT_TYPES, supportedEventTypes.toString());
        return errorResponse.toString();
    }

    private void outputValidate(EiffelEventType eiffelType, String jsonStringInput) throws EiffelValidationException {
        EiffelValidator validator = EiffelOutputValidatorFactory.getEiffelValidator(eiffelType);
        JsonObject jsonObject = new JsonParser().parse(jsonStringInput).getAsJsonObject();
        validator.validate(jsonObject);
        // custom validations on an event which is not covered in schema.
        validator.customValidation(jsonObject);
    }

    @Override
    public String getEventId(JsonObject json) {
        if (json.isJsonObject() && json.getAsJsonObject().has(META)
                && json.getAsJsonObject().getAsJsonObject(META).has(ID)) {
            return json.getAsJsonObject().getAsJsonObject(META).get(ID).getAsString();
        }
        return null;
    }

    /*
     * json Input json which we have passed from CLI or Service return eventType
     * will return from inputJson file
     */
    public String getInputEventType(JsonObject json) {
        if (json.isJsonObject() && json.get(MSG_PARAMS).getAsJsonObject().has(META)
                && json.get(MSG_PARAMS).getAsJsonObject().getAsJsonObject(META).has(TYPE)) {
            return json.get(MSG_PARAMS).getAsJsonObject().getAsJsonObject(META).get(TYPE).getAsString();
        }
        return null;
    }

    @Override
    public String getEventType(JsonObject json) {
        if (json.isJsonObject() && json.getAsJsonObject().has(META)
                && json.getAsJsonObject().getAsJsonObject(META).has(TYPE)) {
            return json.getAsJsonObject().getAsJsonObject(META).get(TYPE).getAsString();
        }
        return null;
    }
    
    @Override
    public Collection<String> getSupportedEventTypes() {
    	return supportedEventTypes;
    }
    
    /**
     * Gets the path to an event template file that must be in lowercase
     * and read through a resource stream. Stream is parsed into a
     * JsonElement.
     * 
     * @param String eventType
     * 
     * @return json element containing an event template
     */
    @Override
    public JsonElement getEventTemplate(String eventType) {    
        String path = "templates/"+eventType.toLowerCase()+".json";
        InputStream fileStream = getClass().getClassLoader().getResourceAsStream(path);     
        JsonElement json = null;
        JsonParser parser = new JsonParser();
        try {
            json = parser.parse(new InputStreamReader(fileStream));
        } catch (Exception e) {
            log.error(e.getMessage());
            return json;
        }
        return json;
    }

    /**
     * Returns Family Routing Key Word from the messaging library based on the
     * eiffel message eventType.
     * 
     * @param JsonObject
     *            eiffelMessage
     * @return family routing key word in String format.
     */
    private String getFamily(JsonObject eiffelMessage) {
        if (eiffelMessage.isJsonObject() && eiffelMessage.getAsJsonObject().has(META)
                && eiffelMessage.getAsJsonObject().getAsJsonObject(META).has(TYPE)) {
            return event
                    .getFamilyRoutingKey(eiffelMessage.getAsJsonObject().getAsJsonObject(META).get(TYPE).getAsString());
        }
        return null;
    }

    /**
     * Returns Type Routing Key Word from the messaging library based on the
     * eiffel message eventType.
     * 
     * @param JsonObject
     *            eiffelMessage
     * @return type routing key word in String format.
     */
    private String getType(JsonObject eiffelMessage) {
        if (eiffelMessage.isJsonObject() && eiffelMessage.getAsJsonObject().has(META)
                && eiffelMessage.getAsJsonObject().getAsJsonObject(META).has(TYPE)) {
            return event
                    .getTypeRoutingKey(eiffelMessage.getAsJsonObject().getAsJsonObject(META).get(TYPE).getAsString());
        }
        return null;
    }

    @Override
    public String getServiceName() {
        return EIFFELSEMANTICS;
    }

    @Override
    public ValidationResult validateMsg(String msgType, JsonObject jsonvalidateMessage) {
        ValidationResult validationResult = null;
        EiffelEventType eiffelType = EiffelEventType.fromString(msgType);
        String result = gson.toJson(jsonvalidateMessage);
        try {
            outputValidate(eiffelType, result);
            validationResult = new ValidationResult(true, "");
        } catch (EiffelValidationException e) {
            validationResult = new ValidationResult(false, e.getLocalizedMessage());
        }
        return validationResult;
    }

    /**
     * Returns the domain Id from json formatted eiffel message.
     * 
     * @param eiffelMessage
     *            eiffel message in json format
     * @return the domainId from eiffelMessage if domainId not available then
     *         returns the null value
     */
    private String getDomainId(JsonObject eiffelMessage) {
        if (eiffelMessage.isJsonObject() && eiffelMessage.getAsJsonObject().has(META)
                && eiffelMessage.getAsJsonObject().getAsJsonObject(META).has(SOURCE)
                && eiffelMessage.getAsJsonObject().getAsJsonObject(META).getAsJsonObject(SOURCE).has(DOMAIN_ID)) {
            return eiffelMessage.getAsJsonObject().getAsJsonObject(META).getAsJsonObject(SOURCE).get(DOMAIN_ID)
                    .getAsString();
        }
        return null;
    }

    @Override
    public String generateRoutingKey(JsonObject eiffelMessage, String tag, String domain, String userDomainSuffix) {
        String family = getFamily(eiffelMessage);
        String type = getType(eiffelMessage);
        if (StringUtils.isNotEmpty(family) && StringUtils.isNotEmpty(type)) {
            if (StringUtils.isNotBlank(tag) && (tag.contains(".") || StringUtils.deleteWhitespace(tag).length() > 16)) {
                log.error("tag must not contain any dots and must not exceed 16 characters");
                return null;
            }
            String domainId = getDomainId(eiffelMessage);
            // If domainId from input message is null then configured domain
            // will be considered
            domainId = StringUtils.defaultIfBlank(domainId, domain);
            if (StringUtils.isNotBlank(domainId)) {
                if (StringUtils.isNotBlank(userDomainSuffix)) {
                    domainId = domainId + DOT + userDomainSuffix;
                }
                return StringUtils.deleteWhitespace(PROTOCOL + DOT + family + DOT + type + DOT
                        + StringUtils.defaultIfBlank(tag, "notag") + DOT + domainId);
            }
            log.error(
                    "domain needed for Routing key generation in the format <protocol>.<family>.<type>.<tag>.<domain> is not provided in either input message or configuration");
        }
        return null;
    }

    /**
     * This method is used to override given input meta.source.serializer GAV
     * with semantics GAV or if not exist, generates semantics GAV and set to
     * meta.source.serializer
     * 
     * @param source
     * @return updated source instance with semantics gav information
     */
    public static Source setSerializerGav(Source source) {
        source = source == null ? new Source() : source;
        Serializer serializer = source.getSerializer() == null ? new Serializer() : source.getSerializer();
        serializer.setGroupId(semanticsGAV.getGroupId());
        serializer.setArtifactId(semanticsGAV.getArtifactId());
        serializer.setVersion(semanticsGAV.getVersion());
        source.setSerializer(serializer);
        return source;
    }
}
