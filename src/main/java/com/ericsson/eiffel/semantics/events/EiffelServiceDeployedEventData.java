
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelServiceDeployedEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("servicename")
    @Expose
    private String servicename;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("instancename")
    @Expose
    private String instancename;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("owner")
    @Expose
    private String owner;
    @SerializedName("deploymentType")
    @Expose
    private String deploymentType;
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
    public String getServicename() {
        return servicename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getInstancename() {
        return instancename;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setInstancename(String instancename) {
        this.instancename = instancename;
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

    public String getDeploymentType() {
        return deploymentType;
    }

    public void setDeploymentType(String deploymentType) {
        this.deploymentType = deploymentType;
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
