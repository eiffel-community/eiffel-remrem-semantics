
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestSuiteFinishedEventData {

    @SerializedName("outcome")
    @Expose
    private EiffelTestSuiteFinishedEventOutcome outcome;
    @SerializedName("persistentLogs")
    @Expose
    private List<PersistentLog> persistentLogs = new ArrayList<PersistentLog>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public EiffelTestSuiteFinishedEventOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(EiffelTestSuiteFinishedEventOutcome outcome) {
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
