
package com.ericsson.eiffel.remrem.semantics.events;

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
    /**
     * 
     */
    @SerializedName("categories")
    @Expose
    private List<String> categories = new ArrayList<String>();
    /**
     * 
     */
    @SerializedName("triggers")
    @Expose
    private List<Trigger> triggers = new ArrayList<Trigger>();
    /**
     * 
     */
    @SerializedName("executionType")
    @Expose
    private String executionType;
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The triggers
     */
    public List<Trigger> getTriggers() {
        return triggers;
    }

    /**
     * 
     * @param triggers
     *     The triggers
     */
    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    /**
     * 
     * @return
     *     The executionType
     */
    public String getExecutionType() {
        return executionType;
    }

    /**
     * 
     * @param executionType
     *     The executionType
     */
    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
