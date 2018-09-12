
package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private Location.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("uri")
    @Expose
    private String uri;

    /**
     * 
     * (Required)
     * 
     */
    public Location.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Location.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    public enum Type {

        @SerializedName("ARTIFACTORY")
        ARTIFACTORY("ARTIFACTORY"),
        @SerializedName("NEXUS")
        NEXUS("NEXUS"),
        @SerializedName("PLAIN")
        PLAIN("PLAIN"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, Location.Type> CONSTANTS = new HashMap<String, Location.Type>();

        static {
            for (Location.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Location.Type fromValue(String value) {
            Location.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
