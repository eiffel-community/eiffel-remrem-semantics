
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityTriggeredData {

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
    private String executionType;
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

    public String getExecutionType() {
        return executionType;
    }

    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
