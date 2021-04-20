/*
    Copyright 2018 Ericsson AB.
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

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelArtifactReusedEvent
    extends Event
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("meta")
    @Expose
    private EiffelArtifactReusedEventMeta meta;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("data")
    @Expose
    private EiffelArtifactReusedEventData data;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();

    /**
     * 
     * (Required)
     * 
     */
    public EiffelArtifactReusedEventMeta getMeta() {
        return meta;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMeta(EiffelArtifactReusedEventMeta meta) {
        this.meta = meta;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelArtifactReusedEventData getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setData(EiffelArtifactReusedEventData data) {
        this.data = data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
