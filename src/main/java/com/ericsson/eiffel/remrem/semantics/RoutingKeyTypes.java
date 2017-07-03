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

import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;

public enum RoutingKeyTypes {    
    
    eiffelactivitycanceled(EiffelConstants.ACTIVITY, "canceled"),
    eiffelactivityfinished(EiffelConstants.ACTIVITY,"finished"),
    eiffelactivitystarted(EiffelConstants.ACTIVITY,"started"),
    eiffelactivitytriggered(EiffelConstants.ACTIVITY,"triggered"),
    eiffelannouncementpublished(EiffelConstants.INFO,"announcement"),
    eiffelartifactcreated(EiffelConstants.ARTIFACT,"created"),
    eiffelartifactpublished(EiffelConstants.ARTIFACT,"published"),
    eiffelartifactreused(EiffelConstants.ARTIFACT,"reused"),
    eiffelcompositiondefined(EiffelConstants.CM,"composition"),
    eiffelconfidencelevelmodified(EiffelConstants.ARTIFACT,"modified"),
    eiffelconfigurationapplied(EiffelConstants.CONFIGURATION,"applied"),
    eiffelenvironmentdefined(EiffelConstants.CM,"environment"),
    eiffelflowcontextdefined(EiffelConstants.FLOWCONTEXT,"defined"),
    eiffelissueverified(EiffelConstants.TEST,"issueverified"),
    eiffelsourcechangecreated(EiffelConstants.CM,"scmchange"),
    eiffelsourcechangesubmitted(EiffelConstants.CM,"scmproposedchange"),
    eiffeltestcasefinished(EiffelConstants.TEST,"casefinished"),
    eiffeltestcasestarted(EiffelConstants.TEST,"casestarted"),
    eiffeltestsuitefinished(EiffelConstants.TEST,"suitefinished"),
    eiffeltestsuitestarted(EiffelConstants.TEST,"suitestarted"),
    eiffeltestexecutionrecipecollectioncreated(EiffelConstants.TEST,"execution");
           
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
