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
    ARTIFACT_PUBLISHED("eiffelartifactpublished"),
    ACTIVITY_FINISHED("eiffelactivityfinished"),
    ACTIVITY_CANCELED("eiffelactivitycanceled"),
    ARTIFACT_CREATED("eiffelartifactcreated"),
    ACTIVITY_TRIGGERED("eiffelactivitytriggered"),
    CONFIDENCELEVEL_MODIFIED("eiffelconfidencelevelmodified"),
    ACTIVITY_STARTED("eiffelactivitystarted"),
    ANNOUNCEMENT_PUBLISHED("eiffelannouncementpublished"),
    COMPOSITION_DEFINED("eiffelcompositiondefined"),
    TESTCASE_CANCELED("eiffeltestcasecanceled"),
    TESTCASE_TRIGGERED("eiffeltestcasetriggered"),
    EXECUTION_RECIPE_COLLECTION_CREATED("eiffeltestexecutionrecipecollectioncreated"),
    ENVIRONMENT_DEFINED("eiffelenvironmentdefined"),
    FLOWCONTEXT_DEFINED("eiffelflowcontextdefined"),
    SOURCECHANGE_CREATED("eiffelsourcechangecreated"),
    SOURCECHANGE_SUBMITTED("eiffelsourcechangesubmitted"),
    TESTCASE_FINISHED("eiffeltestcasefinished"),
    TESTCASE_STARTED("eiffeltestcasestarted"),
    TESTSUITE_FINISHED("eiffeltestsuitefinished"),
    TESTSUITE_STARTED("eiffeltestsuitestarted"),
    ISSUE_VERIFIED("eiffelissueverified"),
    ARTIFACT_REUSED("eiffelartifactreused");
    
    private String eventName;

    EiffelEventType(String eventName) {
        this.eventName = eventName;
    }

    static HashMap<String, EiffelEventType> eventNameMap = new HashMap<String, EiffelEventType>();

    /**
     * This method used to get EiffelEventType Enum constant based on event name
     * @param eventName of an eiffel event
     * @return Enum constant of EiffelEventType
     */
    public static EiffelEventType fromString(String eventName) {
        if (eventNameMap.size() == 0) {
            for (EiffelEventType type : values())
                eventNameMap.put(type.eventName, type);
        }
        return eventNameMap.get(eventName);
    }

    /**
     * This method used to get event name of an eiffel event based on Enum constant
     * @return event name of an eiffel event
     */
    public String getEventName() {
        return eventName;
    }
}
