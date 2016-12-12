
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestSuiteFinishedData {

    /**
     * 
     */
    @SerializedName("outcome")
    @Expose
    private DataOutcome outcome;
    /**
     * 
     */
    @SerializedName("persistentLogs")
    @Expose
    private List<PersistentLog> persistentLogs = new ArrayList<PersistentLog>();
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CusomData> customData = new ArrayList<CusomData>();

    /**
     * 
     * @return
     *     The outcome
     */
    public DataOutcome getOutcome() {
        return outcome;
    }

    /**
     * 
     * @param outcome
     *     The outcome
     */
    public void setOutcome(DataOutcome outcome) {
        this.outcome = outcome;
    }

    /**
     * 
     * @return
     *     The persistentLogs
     */
    public List<PersistentLog> getPersistentLogs() {
        return persistentLogs;
    }

    /**
     * 
     * @param persistentLogs
     *     The persistentLogs
     */
    public void setPersistentLogs(List<PersistentLog> persistentLogs) {
        this.persistentLogs = persistentLogs;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CusomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CusomData> customData) {
        this.customData = customData;
    }

}
