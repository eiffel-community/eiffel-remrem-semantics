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

public enum RoutingKeyFamilies {

    EiffelActivityCanceledEvent(EiffelConstants.ACTIVITY),
    EiffelActivityFinishedEvent(EiffelConstants.ACTIVITY),
    EiffelActivityStartedEvent(EiffelConstants.ACTIVITY),
    EiffelActivityTriggeredEvent(EiffelConstants.ACTIVITY),
    EiffelAnnouncementPublishedEvent(EiffelConstants.ANNOUNCEMENT),
    EiffelArtifactCreatedEvent(EiffelConstants.ARTIFACT),
    EiffelArtifactPublishedEvent(EiffelConstants.ARTIFACT),
    EiffelArtifactReusedEvent(EiffelConstants.ARTIFACT),
    EiffelCompositionDefinedEvent(EiffelConstants.CM),
    EiffelConfidenceLevelModifiedEvent(EiffelConstants.ARTIFACT),
    EiffelEnvironmentDefinedEvent(EiffelConstants.CM),
    EiffelFlowContextDefinedEvent(EiffelConstants.FLOWCONTEXT),
    EiffelIssueVerifiedEvent(EiffelConstants.TEST),
    EiffelSourceChangeCreatedEvent(EiffelConstants.CM),
    EiffelSourceChangeSubmittedEvent(EiffelConstants.CM),
    EiffelTestCaseCanceledEvent(EiffelConstants.TEST),
    EiffelTestCaseTriggeredEvent(EiffelConstants.TEST),
    EiffelTestCaseFinishedEvent(EiffelConstants.TEST),
    EiffelTestCaseStartedEvent(EiffelConstants.TEST),
    EiffelTestSuiteFinishedEvent(EiffelConstants.TEST),
    EiffelTestSuiteStartedEvent(EiffelConstants.TEST),
    EiffelTestExecutionRecipeCollectionCreatedEvent(EiffelConstants.TEST),
    EiffelAlertAcknowledgedEvent(EiffelConstants.ALERT),
    EiffelArtifactDeployedEvent(EiffelConstants.ARTIFACT),
    EiffelServiceAllocatedEvent(EiffelConstants.SERVICE),
    EiffelServiceDeployedEvent(EiffelConstants.SERVICE),
    EiffelServiceDiscontinuedEvent(EiffelConstants.SERVICE),
    EiffelServiceReturnedEvent(EiffelConstants.SERVICE),
    EiffelServiceStartedEvent(EiffelConstants.SERVICE),
    EiffelServiceStoppedEvent(EiffelConstants.SERVICE),
    EiffelAlertRaisedEvent(EiffelConstants.ALERT),
    EiffelAlertCeasedEvent(EiffelConstants.ALERT),
    EiffelIssueDefinedEvent(EiffelConstants.TEST);


    private final String family;   // family

    RoutingKeyFamilies(String family) {
        this.family = family;
    }

    public String getFamily() {
        return family;
    }
}
