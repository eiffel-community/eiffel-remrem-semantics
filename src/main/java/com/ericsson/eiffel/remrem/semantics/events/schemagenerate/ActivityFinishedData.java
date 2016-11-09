
package com.ericsson.eiffel.remrem.semantics.events.schemagenerate;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(outcome).append(persistentLogs).append(customData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ActivityFinishedData) == false) {
            return false;
        }
        ActivityFinishedData rhs = ((ActivityFinishedData) other);
        return new EqualsBuilder().append(outcome, rhs.outcome).append(persistentLogs, rhs.persistentLogs).append(customData, rhs.customData).isEquals();
    }

}
