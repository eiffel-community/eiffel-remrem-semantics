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
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EiffelTestExecutionRecipeCollectionCreatedEventData {

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
