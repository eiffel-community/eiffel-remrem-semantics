
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dependency {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("dependent")
    @Expose
    private String dependent;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("dependency")
    @Expose
    private String dependency;

    /**
     * 
     * (Required)
     * 
     */
    public String getDependent() {
        return dependent;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDependent(String dependent) {
        this.dependent = dependent;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getDependency() {
        return dependency;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

}
