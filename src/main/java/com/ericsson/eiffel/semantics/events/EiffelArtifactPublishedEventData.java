
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelArtifactPublishedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("locations")
    @Expose
    private List<Location> locations = new ArrayList<Location>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
