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
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestCaseFinishedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("outcome")
    @Expose
    private EiffelTestCaseFinishedEventOutcome outcome;
    @SerializedName("persistentLogs")
    @Expose
    private List<PersistentLog> persistentLogs = new ArrayList<PersistentLog>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public EiffelTestCaseFinishedEventOutcome getOutcome() {
        return outcome;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setOutcome(EiffelTestCaseFinishedEventOutcome outcome) {
        this.outcome = outcome;
    }

    public List<PersistentLog> getPersistentLogs() {
        return persistentLogs;
    }

    public void setPersistentLogs(List<PersistentLog> persistentLogs) {
        this.persistentLogs = persistentLogs;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
