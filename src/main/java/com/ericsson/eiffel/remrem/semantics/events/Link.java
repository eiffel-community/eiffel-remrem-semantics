
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private String type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("target")
    @Expose
    private String target;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The target
     */
    public String getTarget() {
        return target;
    }

    /**
     * 
     * (Required)
     * 
     * @param target
     *     The target
     */
    public void setTarget(String target) {
        this.target = target;
    }

}
