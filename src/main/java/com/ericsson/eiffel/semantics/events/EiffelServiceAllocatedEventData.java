
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelServiceAllocatedEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("serviceinstance")
    @Expose
    private String serviceinstance;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public String getServiceinstance() {
        return serviceinstance;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setServiceinstance(String serviceinstance) {
        this.serviceinstance = serviceinstance;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
