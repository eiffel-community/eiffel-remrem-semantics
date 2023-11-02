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
public class CcCompositeIdentifier {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("vobs")
    @Expose
    private List<String> vobs = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("branch")
    @Expose
    private String branch;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("configSpec")
    @Expose
    private String configSpec;

    /**
     * 
     * (Required)
     * 
     */
    public List<String> getVobs() {
        return vobs;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVobs(List<String> vobs) {
        this.vobs = vobs;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getBranch() {
        return branch;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getConfigSpec() {
        return configSpec;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConfigSpec(String configSpec) {
        this.configSpec = configSpec;
    }

}
