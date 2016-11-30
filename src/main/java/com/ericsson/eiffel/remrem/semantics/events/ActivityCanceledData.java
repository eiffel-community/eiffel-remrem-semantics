
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reason",
    "customData"
})
public class ActivityCanceledData {

    @JsonProperty("reason")
    private String reason;
    @JsonProperty("customData")
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * @return
     *     The reason
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * 
     * @param reason
     *     The reason
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
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
