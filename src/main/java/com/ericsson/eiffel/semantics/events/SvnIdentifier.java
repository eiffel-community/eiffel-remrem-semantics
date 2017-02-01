
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
