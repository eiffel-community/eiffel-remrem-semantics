/*
    Copyright 2017 Ericsson AB.
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

import java.util.HashMap;


public enum EiffelEventType {
    ARTIFACT_PUBLISHED("EiffelArtifactPublishedEvent"),
    ACTIVITY_FINISHED("EiffelActivityFinishedEvent"),
    ACTIVITY_CANCELED("EiffelActivityCanceledEvent"),
    ARTIFACT_CREATED("EiffelArtifactCreatedEvent"),
    ACTIVITY_TRIGGERED("EiffelActivityTriggeredEvent"),
    CONFIDENCELEVEL_MODIFIED("EiffelConfidenceLevelModifiedEvent"),
    ACTIVITY_STARTED("EiffelActivityStartedEvent"),
    ANNOUNCEMENT_PUBLISHED("EiffelAnnouncementPublishedEvent"),
    COMPOSITION_DEFINED("EiffelCompositionDefinedEvent"),
    TESTCASE_CANCELED("EiffelTestCaseCanceledEvent"),
    TESTCASE_TRIGGERED("EiffelTestCaseTriggeredEvent"),
    EXECUTION_RECIPE_COLLECTION_CREATED("EiffelTestExecutionRecipeCollectionCreatedEvent"),
    ENVIRONMENT_DEFINED("EiffelEnvironmentDefinedEvent"),
    FLOWCONTEXT_DEFINED("EiffelFlowContextDefinedEvent"),
    SOURCECHANGE_CREATED("EiffelSourceChangeCreatedEvent"),
    SOURCECHANGE_SUBMITTED("EiffelSourceChangeSubmittedEvent"),
    TESTCASE_FINISHED("EiffelTestCaseFinishedEvent"),
    TESTCASE_STARTED("EiffelTestCaseStartedEvent"),
    TESTSUITE_FINISHED("EiffelTestSuiteFinishedEvent"),
    TESTSUITE_STARTED("EiffelTestSuiteStartedEvent"),
    ISSUE_VERIFIED("EiffelIssueVerifiedEvent"),
    ARTIFACT_REUSED("EiffelArtifactReusedEvent");
    
    private String eventType;

    EiffelEventType(String eventType) {
        this.eventType = eventType;
    }

    static HashMap<String, EiffelEventType> eventTypeMap = new HashMap<String, EiffelEventType>();

    /**
     * This method used to get EiffelEventType Enum constant based on event type
     * Supports eventType, if we passed as lower case from cli and service and also check eventType is valid or not
     * @param eventType of an eiffel event
     * @return Enum constant of EiffelEventType
     */
    public static EiffelEventType fromString(String eventType) {
        if (eventTypeMap.size() == 0) {
            for (EiffelEventType type : values())
                eventTypeMap.put(type.eventType.toLowerCase(), type);
        }
        return eventTypeMap.get(eventType.toLowerCase().replace("event", "") + "event");
    }

    /**
     * This method used to get event type of an eiffel event based on Enum constant
     * @return event type of an eiffel event
     */
    public String getEventName() {
        return eventType;
    }
}
