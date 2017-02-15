
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
