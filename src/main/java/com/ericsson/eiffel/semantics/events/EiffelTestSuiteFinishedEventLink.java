/*
    Copyright 2017 Ericsson AB.
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

public class EiffelTestSuiteFinishedEventLink {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private EiffelTestSuiteFinishedEventLink.Type type;
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
     */
    public EiffelTestSuiteFinishedEventLink.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(EiffelTestSuiteFinishedEventLink.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getTarget() {
        return target;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTarget(String target) {
        this.target = target;
    }

    public enum Type {

        @SerializedName("TEST_SUITE_EXECUTION")
        TEST_SUITE_EXECUTION("TEST_SUITE_EXECUTION"),
        @SerializedName("CAUSE")
        CAUSE("CAUSE"),
        @SerializedName("CONTEXT")
        CONTEXT("CONTEXT"),
        @SerializedName("FLOW_CONTEXT")
        FLOW_CONTEXT("FLOW_CONTEXT");
        private final String value;
        private final static Map<String, EiffelTestSuiteFinishedEventLink.Type> CONSTANTS = new HashMap<String, EiffelTestSuiteFinishedEventLink.Type>();

        static {
            for (EiffelTestSuiteFinishedEventLink.Type c: values()) {
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

        public static EiffelTestSuiteFinishedEventLink.Type fromValue(String value) {
            EiffelTestSuiteFinishedEventLink.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}