
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceChangeCreatedData {

    /**
     * 
     */
    @SerializedName("author")
    @Expose
    private Author author;
    /**
     * 
     */
    @SerializedName("change")
    @Expose
    private Change change;
    /**
     * 
     */
    @SerializedName("issues")
    @Expose
    private List<Issue> issues = new ArrayList<Issue>();
    /**
     * 
     */
    @SerializedName("gitIdentifier")
    @Expose
    private GitIdentifier gitIdentifier;
    /**
     * 
     */
    @SerializedName("svnIdentifier")
    @Expose
    private SVNIdentifier svnIdentifier;
    /**
     * 
     */
    @SerializedName("ccCompositeIdentifier")
    @Expose
    private CCCompositeIdentifier ccCompositeIdentifier;
    /**
     * 
     */
    @SerializedName("hgIdentifier")
    @Expose
    private HGIdentifier hgIdentifier;
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * @return
     *     The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The change
     */
    public Change getChange() {
        return change;
    }

    /**
     * 
     * @param change
     *     The change
     */
    public void setChange(Change change) {
        this.change = change;
    }

    /**
     * 
     * @return
     *     The issues
     */
    public List<Issue> getIssues() {
        return issues;
    }

    /**
     * 
     * @param issues
     *     The issues
     */
    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    /**
     * 
     * @return
     *     The gitIdentifier
     */
    public GitIdentifier getGitIdentifier() {
        return gitIdentifier;
    }

    /**
     * 
     * @param gitIdentifier
     *     The gitIdentifier
     */
    public void setGitIdentifier(GitIdentifier gitIdentifier) {
        this.gitIdentifier = gitIdentifier;
    }

    /**
     * 
     * @return
     *     The svnIdentifier
     */
    public SVNIdentifier getSvnIdentifier() {
        return svnIdentifier;
    }

    /**
     * 
     * @param svnIdentifier
     *     The svnIdentifier
     */
    public void setSvnIdentifier(SVNIdentifier svnIdentifier) {
        this.svnIdentifier = svnIdentifier;
    }

    /**
     * 
     * @return
     *     The ccCompositeIdentifier
     */
    public CCCompositeIdentifier getCcCompositeIdentifier() {
        return ccCompositeIdentifier;
    }

    /**
     * 
     * @param ccCompositeIdentifier
     *     The ccCompositeIdentifier
     */
    public void setCcCompositeIdentifier(CCCompositeIdentifier ccCompositeIdentifier) {
        this.ccCompositeIdentifier = ccCompositeIdentifier;
    }

    /**
     * 
     * @return
     *     The hgIdentifier
     */
    public HGIdentifier getHgIdentifier() {
        return hgIdentifier;
    }

    /**
     * 
     * @param hgIdentifier
     *     The hgIdentifier
     */
    public void setHgIdentifier(HGIdentifier hgIdentifier) {
        this.hgIdentifier = hgIdentifier;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
