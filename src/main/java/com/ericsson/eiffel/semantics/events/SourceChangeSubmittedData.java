
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceChangeSubmittedData {

    @SerializedName("submitter")
    @Expose
    private Submitter submitter;
    @SerializedName("gitIdentifier")
    @Expose
    private GitIdentifier gitIdentifier;
    @SerializedName("svnIdentifier")
    @Expose
    private SVNIdentifier svnIdentifier;
    @SerializedName("ccCompositeIdentifier")
    @Expose
    private CCCompositeIdentifier ccCompositeIdentifier;
    @SerializedName("hgIdentifier")
    @Expose
    private HGIdentifier hgIdentifier;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
    }

    public GitIdentifier getGitIdentifier() {
        return gitIdentifier;
    }

    public void setGitIdentifier(GitIdentifier gitIdentifier) {
        this.gitIdentifier = gitIdentifier;
    }

    public SVNIdentifier getSvnIdentifier() {
        return svnIdentifier;
    }

    public void setSvnIdentifier(SVNIdentifier svnIdentifier) {
        this.svnIdentifier = svnIdentifier;
    }

    public CCCompositeIdentifier getCcCompositeIdentifier() {
        return ccCompositeIdentifier;
    }

    public void setCcCompositeIdentifier(CCCompositeIdentifier ccCompositeIdentifier) {
        this.ccCompositeIdentifier = ccCompositeIdentifier;
    }

    public HGIdentifier getHgIdentifier() {
        return hgIdentifier;
    }

    public void setHgIdentifier(HGIdentifier hgIdentifier) {
        this.hgIdentifier = hgIdentifier;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

}
