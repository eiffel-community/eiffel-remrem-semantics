
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestCaseFinishedEventData implements Data
{

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
