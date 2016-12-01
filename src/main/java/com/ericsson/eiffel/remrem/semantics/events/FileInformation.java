
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "classifier",
    "extension"
})
public class FileInformation {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("classifier")
    private String classifier;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("extension")
    private String extension;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The classifier
     */
    @JsonProperty("classifier")
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
    @JsonProperty("classifier")
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
    @JsonProperty("extension")
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
    @JsonProperty("extension")
    public void setExtension(String extension) {
        this.extension = extension;
    }

}
