
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SVNIdentifier {

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
     *     The revision
     */
    public Integer getRevision() {
        return revision;
    }

    /**
     * 
     * (Required)
     * 
     * @param revision
     *     The revision
     */
    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The directory
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * 
     * (Required)
     * 
     * @param directory
     *     The directory
     */
    public void setDirectory(String directory) {
        this.directory = directory;
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
