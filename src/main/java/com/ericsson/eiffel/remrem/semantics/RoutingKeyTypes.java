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
    EiffelEnvironmentDefinedEvent(EiffelConstants.CM,"environment"),
    EiffelFlowContextDefinedEvent(EiffelConstants.FLOWCONTEXT,"defined"),
    EiffelIssueVerifiedEvent(EiffelConstants.TEST,"issueverified"),
    EiffelSourceChangeCreatedEvent(EiffelConstants.CM,"scmchange"),
    EiffelSourceChangeSubmittedEvent(EiffelConstants.CM,"scmproposedchange"),
    EiffelTestCaseCanceledEvent(EiffelConstants.TEST,"casecanceled"),
    EiffelTestCaseTriggeredEvent(EiffelConstants.TEST,"casetriggered"),
    EiffelTestCaseFinishedEvent(EiffelConstants.TEST,"casefinished"),
    EiffelTestCaseStartedEvent(EiffelConstants.TEST,"casestarted"),
    EiffelTestSuiteFinishedEvent(EiffelConstants.TEST,"suitefinished"),
    EiffelTestSuiteStartedEvent(EiffelConstants.TEST,"suitestarted"),
    EiffelTestExecutionRecipeCollectionCreatedEvent(EiffelConstants.TEST,"execution"),
    EiffelAlertAcknowledgedEvent(EiffelConstants.ALERT,"alertack"),
    EiffelArtifactDeployedEvent(EiffelConstants.ARTIFACT,"deployed"),
    EiffelServiceAllocatedEvent(EiffelConstants.SERVICE,"allocated"),
    EiffelServiceDeployedEvent(EiffelConstants.SERVICE,"deployed"),
    EiffelServiceDiscontinuedEvent(EiffelConstants.SERVICE,"discontinued"),
    EiffelServiceReturnedEvent(EiffelConstants.SERVICE,"returned"),
    EiffelServiceStartedEvent(EiffelConstants.SERVICE,"started"),
    EiffelServiceStoppedEvent(EiffelConstants.SERVICE,"stopped"),
    EiffelAlertRaisedEvent(EiffelConstants.ALERT,"raised"),
    EiffelAlertCeasedEvent(EiffelConstants.ALERT,"ceased");
    

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
