
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelConfigurationAppliedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("items")
    @Expose
    private List<Property> items = new ArrayList<Property>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public List<Property> getItems() {
        return items;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setItems(List<Property> items) {
        this.items = items;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
