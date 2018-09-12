
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestExecutionRecipeCollectionCreatedEventData implements Data
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("selectionStrategy")
    @Expose
    private SelectionStrategy selectionStrategy;
    @SerializedName("batchesUri")
    @Expose
    private String batchesUri;
    @SerializedName("batches")
    @Expose
    private List<Batch> batches = new ArrayList<Batch>();
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public SelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSelectionStrategy(SelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    public String getBatchesUri() {
        return batchesUri;
    }

    public void setBatchesUri(String batchesUri) {
        this.batchesUri = batchesUri;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
