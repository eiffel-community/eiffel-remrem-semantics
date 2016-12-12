
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtifactCreatedData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("gav")
    @Expose
    private GAV gav;
    /**
     * 
     */
    @SerializedName("fileInformation")
    @Expose
    private List<FileInformation> fileInformation = new ArrayList<FileInformation>();
    /**
     * 
     */
    @SerializedName("buildCommand")
    @Expose
    private String buildCommand;
    /**
     * 
     */
    @SerializedName("requiresImplementation")
    @Expose
    private ArtifactCreatedData.RequiresImplementation requiresImplementation;
    /**
     * 
     */
    @SerializedName("dependsOn")
    @Expose
    private List<GAV> dependsOn = new ArrayList<GAV>();
    /**
     * 
     */
    @SerializedName("implement")
    @Expose
    private List<GAV> implement = new ArrayList<GAV>();
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The gav
     */
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
    public void setGav(GAV gav) {
        this.gav = gav;
    }

    /**
     * 
     * @return
     *     The fileInformation
     */
    public List<FileInformation> getFileInformation() {
        return fileInformation;
    }

    /**
     * 
     * @param fileInformation
     *     The fileInformation
     */
    public void setFileInformation(List<FileInformation> fileInformation) {
        this.fileInformation = fileInformation;
    }

    /**
     * 
     * @return
     *     The buildCommand
     */
    public String getBuildCommand() {
        return buildCommand;
    }

    /**
     * 
     * @param buildCommand
     *     The buildCommand
     */
    public void setBuildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
    }

    /**
     * 
     * @return
     *     The requiresImplementation
     */
    public ArtifactCreatedData.RequiresImplementation getRequiresImplementation() {
        return requiresImplementation;
    }

    /**
     * 
     * @param requiresImplementation
     *     The requiresImplementation
     */
    public void setRequiresImplementation(ArtifactCreatedData.RequiresImplementation requiresImplementation) {
        this.requiresImplementation = requiresImplementation;
    }

    /**
     * 
     * @return
     *     The dependsOn
     */
    public List<GAV> getDependsOn() {
        return dependsOn;
    }

    /**
     * 
     * @param dependsOn
     *     The dependsOn
     */
    public void setDependsOn(List<GAV> dependsOn) {
        this.dependsOn = dependsOn;
    }

    /**
     * 
     * @return
     *     The implement
     */
    public List<GAV> getImplement() {
        return implement;
    }

    /**
     * 
     * @param implement
     *     The implement
     */
    public void setImplement(List<GAV> implement) {
        this.implement = implement;
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

    public enum RequiresImplementation {

        @SerializedName("NONE")
        NONE("NONE"),
        @SerializedName("ANY")
        ANY("ANY"),
        @SerializedName("EXACTLY_ONE")
        EXACTLY_ONE("EXACTLY_ONE"),
        @SerializedName("AT_LEAST_ONE")
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

        public String value() {
            return this.value;
        }

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
