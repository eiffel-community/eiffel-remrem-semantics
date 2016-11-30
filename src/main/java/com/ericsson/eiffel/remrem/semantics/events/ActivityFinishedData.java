
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "outcome",
    "persistentLogs",
    "customData"
})
public class ActivityFinishedData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("outcome")
    private Outcome outcome;
    @JsonProperty("persistentLogs")
    private List<PersistentLog> persistentLogs = new ArrayList<PersistentLog>();
    @JsonProperty("customData")
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The outcome
     */
    @JsonProperty("outcome")
    public Outcome getOutcome() {
        return outcome;
    }

    /**
     * 
     * (Required)
     * 
     * @param outcome
     *     The outcome
     */
    @JsonProperty("outcome")
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    /**
     * 
     * @return
     *     The persistentLogs
     */
    @JsonProperty("persistentLogs")
    public List<PersistentLog> getPersistentLogs() {
        return persistentLogs;
    }

    /**
     * 
     * @param persistentLogs
     *     The persistentLogs
     */
    @JsonProperty("persistentLogs")
    public void setPersistentLogs(List<PersistentLog> persistentLogs) {
        this.persistentLogs = persistentLogs;
    }

    /**
     * 
     * @return
     *     The customData
     */
    @JsonProperty("customData")
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    @JsonProperty("customData")
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
