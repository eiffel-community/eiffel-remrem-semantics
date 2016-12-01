
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "categories",
    "triggers",
    "executionType",
    "customData"
})
public class ActivityTriggeredData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    @JsonProperty("categories")
    private List<String> categories = new ArrayList<String>();
    @JsonProperty("triggers")
    private List<Trigger> triggers = new ArrayList<Trigger>();
    @JsonProperty("executionType")
    private String executionType;
    @JsonProperty("customData")
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
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
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The categories
     */
    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The triggers
     */
    @JsonProperty("triggers")
    public List<Trigger> getTriggers() {
        return triggers;
    }

    /**
     * 
     * @param triggers
     *     The triggers
     */
    @JsonProperty("triggers")
    public void setTriggers(List<Trigger> triggers) {
        this.triggers = triggers;
    }

    /**
     * 
     * @return
     *     The executionType
     */
    @JsonProperty("executionType")
    public String getExecutionType() {
        return executionType;
    }

    /**
     * 
     * @param executionType
     *     The executionType
     */
    @JsonProperty("executionType")
    public void setExecutionType(String executionType) {
        this.executionType = executionType;
    }

    /**
     * 
     * @return
     *     The customData
     */
    @JsonProperty("customData")
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    @JsonProperty("customData")
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
