
package com.ericsson.eiffel.remrem.semantics.events.schemagenerate;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locations",
    "customData"
})
public class ArtifactPublishedData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("locations")
    private List<Location> locations = new ArrayList<Location>();
    @JsonProperty("customData")
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The locations
     */
    @JsonProperty("locations")
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
    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The customData
     */
    @JsonProperty("customData")
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    @JsonProperty("customData")
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locations).append(customData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ArtifactPublishedData) == false) {
            return false;
        }
        ArtifactPublishedData rhs = ((ArtifactPublishedData) other);
        return new EqualsBuilder().append(locations, rhs.locations).append(customData, rhs.customData).isEquals();
    }

}
