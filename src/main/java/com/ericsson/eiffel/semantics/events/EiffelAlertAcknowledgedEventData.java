
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelAlertAcknowledgedEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("acknowledgement")
    @Expose
    private String acknowledgement;
    @SerializedName("entity")
    @Expose
    private String entity;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public String getAcknowledgement() {
        return acknowledgement;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAcknowledgement(String acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
