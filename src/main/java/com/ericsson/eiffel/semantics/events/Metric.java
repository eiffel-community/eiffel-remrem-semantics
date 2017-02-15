
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metric {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setValue(String value) {
        this.value = value;
    }

}
