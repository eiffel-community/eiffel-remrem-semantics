/*
    Copyright 2018 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue_ {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private Issue_.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("tracker")
    @Expose
    private String tracker;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("transition")
    @Expose
    private Issue_.Transition transition;

    /**
     * 
     * (Required)
     * 
     */
    public Issue_.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Issue_.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getTracker() {
        return tracker;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setId(String id) {
        this.id = id;
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

    /**
     * 
     * (Required)
     * 
     */
    public Issue_.Transition getTransition() {
        return transition;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTransition(Issue_.Transition transition) {
        this.transition = transition;
    }

    public enum Transition {

        @SerializedName("RESOLVED")
        RESOLVED("RESOLVED"),
        @SerializedName("PARTIAL")
        PARTIAL("PARTIAL"),
        @SerializedName("REMOVED")
        REMOVED("REMOVED");
        private final String value;
        private final static Map<String, Issue_.Transition> CONSTANTS = new HashMap<String, Issue_.Transition>();

        static {
            for (Issue_.Transition c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Transition(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Issue_.Transition fromValue(String value) {
            Issue_.Transition constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        @SerializedName("BUG")
        BUG("BUG"),
        @SerializedName("IMPROVEMENT")
        IMPROVEMENT("IMPROVEMENT"),
        @SerializedName("FEATURE")
        FEATURE("FEATURE"),
        @SerializedName("WORK_ITEM")
        WORK_ITEM("WORK_ITEM"),
        @SerializedName("REQUIREMENT")
        REQUIREMENT("REQUIREMENT"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, Issue_.Type> CONSTANTS = new HashMap<String, Issue_.Type>();

        static {
            for (Issue_.Type c: values()) {
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

        public static Issue_.Type fromValue(String value) {
            Issue_.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
