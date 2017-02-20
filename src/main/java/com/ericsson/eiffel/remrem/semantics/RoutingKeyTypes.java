package com.ericsson.eiffel.remrem.semantics;

import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;

public enum RoutingKeyTypes {    
    
    EiffelActivityCanceledEvent(EiffelConstants.ACTIVITY, "canceled"),
    EiffelActivityFinishedEvent(EiffelConstants.ACTIVITY,"finished"),
    EiffelActivityStartedEvent(EiffelConstants.ACTIVITY,"started"),
    EiffelActivityTriggeredEvent(EiffelConstants.ACTIVITY,"triggered"),
    EiffelAnnouncementPublishedEvent(EiffelConstants.INFO,"announcement"),
    EiffelArtifactCreatedEvent(EiffelConstants.ARTIFACT,"created"),
    EiffelArtifactPublishedEvent(EiffelConstants.ARTIFACT,"published"),
    EiffelArtifactReusedEvent(EiffelConstants.ARTIFACT,"reused"),
    EiffelCompositionDefinedEvent(EiffelConstants.CM,"composition"),
    EiffelConfidenceLevelModifiedEvent(EiffelConstants.ARTIFACT,"modified"),
    EiffelConfigurationAppliedEvent(EiffelConstants.CONFIGURATION,"applied"),
    EiffelEnvironmentDefinedEvent(EiffelConstants.CM,"environment"),
    EiffelFlowContextDefinedEvent(EiffelConstants.FLOWCONTEXT,"defined"),
    EiffelIssueVerifiedEvent(EiffelConstants.TEST,"issueverified"),
    EiffelSourceChangeCreatedEvent(EiffelConstants.CM,"scmchange"),
    EiffelSourceChangeSubmittedEvent(EiffelConstants.CM,"scmproposedchange"),
    EiffelTestCaseFinishedEvent(EiffelConstants.TEST,"casestarted"),
    EiffelTestCaseStartedEvent(EiffelConstants.TEST,"casefinished"),
    EiffelTestSuiteFinishedEvent(EiffelConstants.TEST,"suitefinished"),
    EiffelTestSuiteStartedEvent(EiffelConstants.TEST,"suitestarted"),
    EiffelTestExecutionRecipeCollectionCreatedEvent(EiffelConstants.TEST,"execution");
           
    private final String family;   // family
     private final String type; // type
    
    RoutingKeyTypes(String family, String type) {
        this.family = family;
        this.type = type;
    }
    
    public String getFamily() {
        return family;
    }
    
    public String getType() {
        return type;
    }
}
