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
public class Trigger {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private Trigger.Type type;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * 
     * (Required)
     * 
     */
    public Trigger.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Trigger.Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        @SerializedName("MANUAL")
        MANUAL("MANUAL"),
        @SerializedName("EIFFEL_EVENT")
        EIFFEL_EVENT("EIFFEL_EVENT"),
        @SerializedName("SOURCE_CHANGE")
        SOURCE_CHANGE("SOURCE_CHANGE"),
        @SerializedName("TIMER")
        TIMER("TIMER"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, Trigger.Type> CONSTANTS = new HashMap<String, Trigger.Type>();

        static {
            for (Trigger.Type c: values()) {
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

        public static Trigger.Type fromValue(String value) {
            Trigger.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
