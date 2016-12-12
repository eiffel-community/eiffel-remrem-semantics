
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtifactPublishedData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("locations")
    @Expose
    private List<Location> locations = new ArrayList<Location>();
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * 
     * (Required)
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
