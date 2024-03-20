/**
 *     Copyright 2018 Ericsson AB.
 *     For a full list of individual contributors, please see the commit history.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Location {

    @SerializedName("name")
    @Expose
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    @Generated("jsonschema2pojo")
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

        Type(String value) {
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
