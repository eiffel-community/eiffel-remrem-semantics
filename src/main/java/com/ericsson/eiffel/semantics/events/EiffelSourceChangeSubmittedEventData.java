
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelSourceChangeSubmittedEventData {

    @SerializedName("submitter")
    @Expose
    private Submitter submitter;
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
