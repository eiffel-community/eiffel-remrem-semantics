
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileInformation {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("classifier")
    @Expose
    private String classifier;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("extension")
    @Expose
    private String extension;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The classifier
     */
    public String getClassifier() {
        return classifier;
    }

    /**
     * 
     * (Required)
     * 
     * @param classifier
     *     The classifier
     */
    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 
     * (Required)
     * 
     * @param extension
     *     The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

}
