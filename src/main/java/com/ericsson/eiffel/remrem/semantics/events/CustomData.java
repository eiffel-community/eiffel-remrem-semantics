
package com.ericsson.eiffel.remrem.semantics.events;

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
    private String value;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The key
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     * @param key
     *     The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
