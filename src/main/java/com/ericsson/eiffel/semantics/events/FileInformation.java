
package com.ericsson.eiffel.semantics.events;

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
     */
    public String getClassifier() {
        return classifier;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

}
