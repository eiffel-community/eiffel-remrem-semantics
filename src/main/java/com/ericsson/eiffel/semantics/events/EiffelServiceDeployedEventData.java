/**
 *     Copyright 2018 Ericsson AB.
 *     For a full list of individual contributors, please see the commit history.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EiffelServiceDeployedEventData {

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
