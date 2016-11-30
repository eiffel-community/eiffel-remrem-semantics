
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gav",
    "fileInformation",
    "buildCommand",
    "requiresImplementation",
    "dependsOn",
    "implement",
    "customData"
})
public class ArtifactCreatedData {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("gav")
    private GAV gav;
    @JsonProperty("fileInformation")
    private List<FileInformation> fileInformation = new ArrayList<FileInformation>();
    @JsonProperty("buildCommand")
    private String buildCommand;
    @JsonProperty("requiresImplementation")
    private ArtifactCreatedData.RequiresImplementation requiresImplementation;
    @JsonProperty("dependsOn")
    private List<GAV> dependsOn = new ArrayList<GAV>();
    @JsonProperty("implement")
    private List<GAV> implement = new ArrayList<GAV>();
    @JsonProperty("customData")
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The gav
     */
    @JsonProperty("gav")
    public GAV getGav() {
        return gav;
    }

    /**
     * 
     * (Required)
     * 
     * @param gav
     *     The gav
     */
    @JsonProperty("gav")
    public void setGav(GAV gav) {
        this.gav = gav;
    }

    /**
     * 
     * @return
     *     The fileInformation
     */
    @JsonProperty("fileInformation")
    public List<FileInformation> getFileInformation() {
        return fileInformation;
    }

    /**
     * 
     * @param fileInformation
     *     The fileInformation
     */
    @JsonProperty("fileInformation")
    public void setFileInformation(List<FileInformation> fileInformation) {
        this.fileInformation = fileInformation;
    }

    /**
     * 
     * @return
     *     The buildCommand
     */
    @JsonProperty("buildCommand")
    public String getBuildCommand() {
        return buildCommand;
    }

    /**
     * 
     * @param buildCommand
     *     The buildCommand
     */
    @JsonProperty("buildCommand")
    public void setBuildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
    }

    /**
     * 
     * @return
     *     The requiresImplementation
     */
    @JsonProperty("requiresImplementation")
    public ArtifactCreatedData.RequiresImplementation getRequiresImplementation() {
        return requiresImplementation;
    }

    /**
     * 
     * @param requiresImplementation
     *     The requiresImplementation
     */
    @JsonProperty("requiresImplementation")
    public void setRequiresImplementation(ArtifactCreatedData.RequiresImplementation requiresImplementation) {
        this.requiresImplementation = requiresImplementation;
    }

    /**
     * 
     * @return
     *     The dependsOn
     */
    @JsonProperty("dependsOn")
    public List<GAV> getDependsOn() {
        return dependsOn;
    }

    /**
     * 
     * @param dependsOn
     *     The dependsOn
     */
    @JsonProperty("dependsOn")
    public void setDependsOn(List<GAV> dependsOn) {
        this.dependsOn = dependsOn;
    }

    /**
     * 
     * @return
     *     The implement
     */
    @JsonProperty("implement")
    public List<GAV> getImplement() {
        return implement;
    }

    /**
     * 
     * @param implement
     *     The implement
     */
    @JsonProperty("implement")
    public void setImplement(List<GAV> implement) {
        this.implement = implement;
    }

    /**
     * 
     * @return
     *     The customData
     */
    @JsonProperty("customData")
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    @JsonProperty("customData")
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

    public enum RequiresImplementation {

        NONE("NONE"),
        ANY("ANY"),
        EXACTLY_ONE("EXACTLY_ONE"),
        AT_LEAST_ONE("AT_LEAST_ONE");
        private final String value;
        private final static Map<String, ArtifactCreatedData.RequiresImplementation> CONSTANTS = new HashMap<String, ArtifactCreatedData.RequiresImplementation>();

        static {
            for (ArtifactCreatedData.RequiresImplementation c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private RequiresImplementation(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ArtifactCreatedData.RequiresImplementation fromValue(String value) {
            ArtifactCreatedData.RequiresImplementation constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
