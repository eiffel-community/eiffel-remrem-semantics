
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelActivityTriggeredEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("categories")
    @Expose
    private List<String> categories = new ArrayList<String>();
    @SerializedName("triggers")
    @Expose
    private List<Trigger> triggers = new ArrayList<Trigger>();
    @SerializedName("executionType")
    @Expose
    private EiffelActivityTriggeredEventData.ExecutionType executionType;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    public EiffelActivityTriggeredEventData.ExecutionType getExecutionType() {
        return executionType;
    }

    public void setExecutionType(EiffelActivityTriggeredEventData.ExecutionType executionType) {
        this.executionType = executionType;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

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
        private final static Map<String, EiffelActivityTriggeredEventData.ExecutionType> CONSTANTS = new HashMap<String, EiffelActivityTriggeredEventData.ExecutionType>();

        static {
            for (EiffelActivityTriggeredEventData.ExecutionType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ExecutionType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelActivityTriggeredEventData.ExecutionType fromValue(String value) {
            EiffelActivityTriggeredEventData.ExecutionType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
