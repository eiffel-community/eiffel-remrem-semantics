
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelSourceChangeCreatedEventData implements Data
{

    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("change")
    @Expose
    private Change change;
    @SerializedName("issues")
    @Expose
    private List<Issue> issues = new ArrayList<Issue>();
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

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
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
