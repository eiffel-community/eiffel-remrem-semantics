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

public class EiffelActivityStartedEventData {

    @SerializedName("executionUri")
    @Expose
    private String executionUri;
    @SerializedName("liveLogs")
    @Expose
    private List<LiveLog> liveLogs = new ArrayList<LiveLog>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public String getExecutionUri() {
        return executionUri;
    }

    public void setExecutionUri(String executionUri) {
        this.executionUri = executionUri;
    }

    public List<LiveLog> getLiveLogs() {
        return liveLogs;
    }

    public void setLiveLogs(List<LiveLog> liveLogs) {
        this.liveLogs = liveLogs;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
