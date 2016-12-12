
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CCCompositeIdentifier {

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
     * @return
     *     The vobs
     */
    public List<String> getVobs() {
        return vobs;
    }

    /**
     * 
     * (Required)
     * 
     * @param vobs
     *     The vobs
     */
    public void setVobs(List<String> vobs) {
        this.vobs = vobs;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * 
     * (Required)
     * 
     * @param branch
     *     The branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The configSpec
     */
    public String getConfigSpec() {
        return configSpec;
    }

    /**
     * 
     * (Required)
     * 
     * @param configSpec
     *     The configSpec
     */
    public void setConfigSpec(String configSpec) {
        this.configSpec = configSpec;
    }

}
