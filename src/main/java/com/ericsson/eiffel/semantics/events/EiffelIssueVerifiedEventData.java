
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelIssueVerifiedEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("issues")
    @Expose
    private List<EiffelIssueVerifiedEventIssue> issues = new ArrayList<EiffelIssueVerifiedEventIssue>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public List<EiffelIssueVerifiedEventIssue> getIssues() {
        return issues;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setIssues(List<EiffelIssueVerifiedEventIssue> issues) {
        this.issues = issues;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
