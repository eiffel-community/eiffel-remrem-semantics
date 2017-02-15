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
    CONFIGURATION_APPLIED("EiffelConfigurationAppliedEvent"),
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
    
    private String id;

    EiffelEventType(String id) {
        this.id = id;
    }

    static HashMap<String, EiffelEventType> idMap = new HashMap<String, EiffelEventType>();

    public static EiffelEventType fromString(String id) {
        if (idMap.size() == 0) {
            for (EiffelEventType type : values())
                idMap.put(type.id, type);
        }
        return idMap.get(id);
    }
}
