
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityStartedData {

    @SerializedName("executionUri")
    @Expose
    private String executionUri;
    @SerializedName("liveLogs")
    @Expose
    private List<PersistentLog> liveLogs = new ArrayList<PersistentLog>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public String getExecutionUri() {
        return executionUri;
    }

    public void setExecutionUri(String executionUri) {
        this.executionUri = executionUri;
    }

    public List<PersistentLog> getLiveLogs() {
        return liveLogs;
    }

    public void setLiveLogs(List<PersistentLog> liveLogs) {
        this.liveLogs = liveLogs;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
