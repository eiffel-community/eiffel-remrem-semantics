
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityStartedData {

    /**
     * 
     */
    @SerializedName("executionUri")
    @Expose
    private String executionUri;
    /**
     * 
     */
    @SerializedName("liveLogs")
    @Expose
    private List<PersistentLog> liveLogs = new ArrayList<PersistentLog>();
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * @return
     *     The executionUri
     */
    public String getExecutionUri() {
        return executionUri;
    }

    /**
     * 
     * @param executionUri
     *     The executionUri
     */
    public void setExecutionUri(String executionUri) {
        this.executionUri = executionUri;
    }

    /**
     * 
     * @return
     *     The liveLogs
     */
    public List<PersistentLog> getLiveLogs() {
        return liveLogs;
    }

    /**
     * 
     * @param liveLogs
     *     The liveLogs
     */
    public void setLiveLogs(List<PersistentLog> liveLogs) {
        this.liveLogs = liveLogs;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
