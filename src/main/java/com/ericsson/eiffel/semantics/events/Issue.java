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

public class Issue {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private Issue.Type type;
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
    @SerializedName("value")
    @Expose
    private Issue.Value value;

    /**
     * 
     * (Required)
     * 
     */
    public Issue.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Issue.Type type) {
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
    public Issue.Value getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setValue(Issue.Value value) {
        this.value = value;
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
        private final static Map<String, Issue.Type> CONSTANTS = new HashMap<String, Issue.Type>();

        static {
            for (Issue.Type c: values()) {
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

        public static Issue.Type fromValue(String value) {
            Issue.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Value {

        @SerializedName("SUCCESS")
        SUCCESS("SUCCESS"),
        @SerializedName("FAILURE")
        FAILURE("FAILURE"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, Issue.Value> CONSTANTS = new HashMap<String, Issue.Value>();

        static {
            for (Issue.Value c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Value(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Issue.Value fromValue(String value) {
            Issue.Value constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
