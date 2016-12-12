
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitIdentifier {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("commitId")
    @Expose
    private String commitId;
    /**
     * 
     */
    @SerializedName("branch")
    @Expose
    private String branch;
    /**
     * 
     */
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
     * @return
     *     The commitId
     */
    public String getCommitId() {
        return commitId;
    }

    /**
     * 
     * (Required)
     * 
     * @param commitId
     *     The commitId
     */
    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    /**
     * 
     * @return
     *     The branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * 
     * @param branch
     *     The branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * 
     * @return
     *     The repoName
     */
    public String getRepoName() {
        return repoName;
    }

    /**
     * 
     * @param repoName
     *     The repoName
     */
    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The repoUri
     */
    public String getRepoUri() {
        return repoUri;
    }

    /**
     * 
     * (Required)
     * 
     * @param repoUri
     *     The repoUri
     */
    public void setRepoUri(String repoUri) {
        this.repoUri = repoUri;
    }

}
