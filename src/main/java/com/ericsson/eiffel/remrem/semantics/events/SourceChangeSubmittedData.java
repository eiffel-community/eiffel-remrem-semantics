
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceChangeSubmittedData {

    /**
     * 
     */
    @SerializedName("submitter")
    @Expose
    private Submitter submitter;
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
     *     The submitter
     */
    public Submitter getSubmitter() {
        return submitter;
    }

    /**
     * 
     * @param submitter
     *     The submitter
     */
    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
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
