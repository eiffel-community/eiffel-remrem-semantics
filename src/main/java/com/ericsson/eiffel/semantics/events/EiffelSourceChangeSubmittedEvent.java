/*
    Copyright 2017 Ericsson AB.
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

public class EiffelSourceChangeSubmittedEvent
    extends Event
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("meta")
    @Expose
    private EiffelSourceChangeSubmittedEventMeta meta;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("data")
    @Expose
    private EiffelSourceChangeSubmittedEventData data;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("links")
    @Expose
    private List<EiffelSourceChangeSubmittedEventLink> links = new ArrayList<EiffelSourceChangeSubmittedEventLink>();

    /**
     * 
     * (Required)
     * 
     */
    public EiffelSourceChangeSubmittedEventMeta getMeta() {
        return meta;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMeta(EiffelSourceChangeSubmittedEventMeta meta) {
        this.meta = meta;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelSourceChangeSubmittedEventData getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setData(EiffelSourceChangeSubmittedEventData data) {
        this.data = data;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<EiffelSourceChangeSubmittedEventLink> getLinks() {
        return links;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLinks(List<EiffelSourceChangeSubmittedEventLink> links) {
        this.links = links;
    }

}
