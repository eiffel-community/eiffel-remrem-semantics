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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EiffelTestCaseTriggeredEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("testCase")
    @Expose
    private TestCase testCase;
    @SerializedName("recipeId")
    @Expose
    private String recipeId;
    @SerializedName("triggers")
    @Expose
    private List<Trigger> triggers = new ArrayList<Trigger>();
    @SerializedName("executionType")
    @Expose
    private EiffelTestCaseTriggeredEventData.ExecutionType executionType;
    @SerializedName("parameters")
    @Expose
    private List<Parameter> parameters = new ArrayList<Parameter>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public TestCase getTestCase() {
        return testCase;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    public EiffelTestCaseTriggeredEventData.ExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(EiffelTestCaseTriggeredEventData.ExecutionType executionType) {
        this.executionType = executionType;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

    @Generated("jsonschema2pojo")
    public enum ExecutionType {

        @SerializedName("MANUAL")
        MANUAL("MANUAL"),
        @SerializedName("SEMI_AUTOMATED")
        SEMI_AUTOMATED("SEMI_AUTOMATED"),
        @SerializedName("AUTOMATED")
        AUTOMATED("AUTOMATED"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, EiffelTestCaseTriggeredEventData.ExecutionType> CONSTANTS = new HashMap<String, EiffelTestCaseTriggeredEventData.ExecutionType>();

        static {
            for (EiffelTestCaseTriggeredEventData.ExecutionType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ExecutionType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelTestCaseTriggeredEventData.ExecutionType fromValue(String value) {
            EiffelTestCaseTriggeredEventData.ExecutionType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
