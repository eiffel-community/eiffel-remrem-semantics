
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("key")
    @Expose
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("value")
    @Expose
    private Object value;

    /**
     * 
     * (Required)
     * 
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Object getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setValue(Object value) {
        this.value = value;
    }

}
