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
public class EiffelSourceChangeCreatedEventData {

    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("change")
    @Expose
    private Change change;
    @SerializedName("gitIdentifier")
    @Expose
    private GitIdentifier gitIdentifier;
    @SerializedName("svnIdentifier")
    @Expose
    private SvnIdentifier svnIdentifier;
    @SerializedName("ccCompositeIdentifier")
    @Expose
    private CcCompositeIdentifier ccCompositeIdentifier;
    @SerializedName("hgIdentifier")
    @Expose
    private HgIdentifier hgIdentifier;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    public GitIdentifier getGitIdentifier() {
        return gitIdentifier;
    }

    public void setGitIdentifier(GitIdentifier gitIdentifier) {
        this.gitIdentifier = gitIdentifier;
    }

    public SvnIdentifier getSvnIdentifier() {
        return svnIdentifier;
    }

    public void setSvnIdentifier(SvnIdentifier svnIdentifier) {
        this.svnIdentifier = svnIdentifier;
    }

    public CcCompositeIdentifier getCcCompositeIdentifier() {
        return ccCompositeIdentifier;
    }

    public void setCcCompositeIdentifier(CcCompositeIdentifier ccCompositeIdentifier) {
        this.ccCompositeIdentifier = ccCompositeIdentifier;
    }

    public HgIdentifier getHgIdentifier() {
        return hgIdentifier;
    }

    public void setHgIdentifier(HgIdentifier hgIdentifier) {
        this.hgIdentifier = hgIdentifier;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
