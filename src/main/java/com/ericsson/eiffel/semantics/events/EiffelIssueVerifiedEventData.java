
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelIssueVerifiedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("issues")
    @Expose
    private List<Issue> issues = new ArrayList<Issue>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public List<Issue> getIssues() {
        return issues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
