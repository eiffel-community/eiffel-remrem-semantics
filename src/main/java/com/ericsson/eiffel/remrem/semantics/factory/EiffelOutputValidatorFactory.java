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
package com.ericsson.eiffel.remrem.semantics.factory;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.*;

import java.util.EnumMap;

import com.ericsson.eiffel.remrem.semantics.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.config.LinksConfiguration;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.OutputValidator;

public class EiffelOutputValidatorFactory {

    private static final LinksConfiguration linksConfiguration = new LinksConfiguration();
    private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);

    static {
        String eventType = ACTIVITY_FINISHED.getEventName();
        validators.put(ACTIVITY_FINISHED,
                new OutputValidator("schemas/input/EiffelActivityFinishedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ARTIFACT_PUBLISHED.getEventName();
        validators.put(ARTIFACT_PUBLISHED,
                new OutputValidator("schemas/input/EiffelArtifactPublishedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ARTIFACT_CREATED.getEventName();
        validators.put(ARTIFACT_CREATED,
                new OutputValidator("schemas/input/EiffelArtifactCreatedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ACTIVITY_STARTED.getEventName();
        validators.put(ACTIVITY_STARTED,
                new OutputValidator("schemas/input/EiffelActivityStartedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ACTIVITY_CANCELED.getEventName();
        validators.put(ACTIVITY_CANCELED,
                new OutputValidator("schemas/input/EiffelActivityCanceledEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ACTIVITY_TRIGGERED.getEventName();
        validators.put(ACTIVITY_TRIGGERED,
                new OutputValidator("schemas/input/EiffelActivityTriggeredEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ANNOUNCEMENT_PUBLISHED.getEventName();
        validators.put(ANNOUNCEMENT_PUBLISHED,
                new OutputValidator("schemas/input/EiffelAnnouncementPublishedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = COMPOSITION_DEFINED.getEventName();
        validators.put(COMPOSITION_DEFINED,
                new OutputValidator("schemas/input/EiffelCompositionDefinedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTCASE_CANCELED.getEventName();
        validators.put(TESTCASE_CANCELED,
                new OutputValidator("schemas/input/EiffelTestCaseCanceledEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTCASE_TRIGGERED.getEventName();
        validators.put(TESTCASE_TRIGGERED,
                new OutputValidator("schemas/input/EiffelTestCaseTriggeredEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = EXECUTION_RECIPE_COLLECTION_CREATED.getEventName();
        validators.put(EXECUTION_RECIPE_COLLECTION_CREATED,
                new OutputValidator("schemas/input/EiffelTestExecutionRecipeCollectionCreatedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ENVIRONMENT_DEFINED.getEventName();
        validators.put(ENVIRONMENT_DEFINED,
                new OutputValidator("schemas/input/EiffelEnvironmentDefinedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = FLOWCONTEXT_DEFINED.getEventName();
        validators.put(FLOWCONTEXT_DEFINED,
                new OutputValidator("schemas/input/EiffelFlowContextDefinedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SOURCECHANGE_CREATED.getEventName();
        validators.put(SOURCECHANGE_CREATED,
                new OutputValidator("schemas/input/EiffelSourceChangeCreatedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SOURCECHANGE_SUBMITTED.getEventName();
        validators.put(SOURCECHANGE_SUBMITTED,
                new OutputValidator("schemas/input/EiffelSourceChangeSubmittedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTCASE_FINISHED.getEventName();
        validators.put(TESTCASE_FINISHED,
                new OutputValidator("schemas/input/EiffelTestCaseFinishedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTCASE_STARTED.getEventName();
        validators.put(TESTCASE_STARTED,
                new OutputValidator("schemas/input/EiffelTestCaseStartedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTSUITE_FINISHED.getEventName();
        validators.put(TESTSUITE_FINISHED,
                new OutputValidator("schemas/input/EiffelTestSuiteFinishedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = TESTSUITE_STARTED.getEventName();
        validators.put(TESTSUITE_STARTED,
                new OutputValidator("schemas/input/EiffelTestSuiteStartedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ISSUE_VERIFIED.getEventName();
        validators.put(ISSUE_VERIFIED,
                new OutputValidator("schemas/input/EiffelIssueVerifiedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ARTIFACT_REUSED.getEventName();
        validators.put(ARTIFACT_REUSED,
                new OutputValidator("schemas/input/EiffelArtifactReusedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = CONFIDENCELEVEL_MODIFIED.getEventName();
        validators.put(CONFIDENCELEVEL_MODIFIED,
                new OutputValidator("schemas/input/EiffelConfidenceLevelModifiedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ALERT_ACKNOWLEDGED.getEventName();
        validators.put(ALERT_ACKNOWLEDGED,
                new OutputValidator("schemas/input/EiffelAlertAcknowledgedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ARTIFACT_DEPLOYED.getEventName();
        validators.put(ARTIFACT_DEPLOYED,
                new OutputValidator("schemas/input/EiffelArtifactDeployedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_ALLOCATED.getEventName();
        validators.put(SERVICE_ALLOCATED,
                new OutputValidator("schemas/input/EiffelServiceAllocatedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_DEPLOYED.getEventName();
        validators.put(SERVICE_DEPLOYED,
                new OutputValidator("schemas/input/EiffelServiceDeployedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_DISCONTINUED.getEventName();
        validators.put(SERVICE_DISCONTINUED,
                new OutputValidator("schemas/input/EiffelServiceDiscontinuedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_RETURNED.getEventName();
        validators.put(SERVICE_RETURNED,
                new OutputValidator("schemas/input/EiffelServiceReturnedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_STARTED.getEventName();
        validators.put(SERVICE_STARTED,
                new OutputValidator("schemas/input/EiffelServiceStartedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = SERVICE_STOPPED.getEventName();
        validators.put(SERVICE_STOPPED,
                new OutputValidator("schemas/input/EiffelServiceStoppedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));

        eventType = ALERT_CEASED.getEventName();
        validators.put(ALERT_CEASED,
                new OutputValidator("schemas/input/EiffelAlertCeasedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));
        eventType = ALERT_RAISED.getEventName();
        validators.put(ALERT_RAISED,
                new OutputValidator("schemas/input/EiffelAlertRaisedEvent.json", eventType,
                        linksConfiguration.getRequiredLinkTypes(eventType), linksConfiguration.getOptionalLinkTypes(eventType),
                        linksConfiguration.getAllLinkTypes()));
        

    }

    public static EiffelValidator getEiffelValidator(EiffelEventType type) {
        EiffelValidator result = validators.get(type);
        if (result != null) {
            return result;
        }

        throw new IllegalArgumentException("Illegal type: " + type);
    }

}
