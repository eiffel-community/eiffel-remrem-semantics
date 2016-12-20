
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HGIdentifier {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("commitId")
    @Expose
    private String commitId;
    @SerializedName("branch")
    @Expose
    private String branch;
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
    public String getCommitId() {
        return commitId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
