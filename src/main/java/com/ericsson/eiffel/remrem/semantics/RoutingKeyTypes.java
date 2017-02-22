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
