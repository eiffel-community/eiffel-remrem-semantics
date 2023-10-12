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

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SvnIdentifier {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("revision")
    @Expose
    private Integer revision;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("directory")
    @Expose
    private String directory;
    @SerializedName("repoName")
    @Expose
    private String repoName;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("repoUri")
    @Expose
    private String repoUri;

    /**
     * 
     * (Required)
     * 
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getRepoUri() {
        return repoUri;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setRepoUri(String repoUri) {
        this.repoUri = repoUri;
    }

}
