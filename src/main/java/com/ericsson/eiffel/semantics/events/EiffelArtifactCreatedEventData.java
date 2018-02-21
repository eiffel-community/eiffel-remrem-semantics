/*
    Copyright 2018 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelArtifactCreatedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("gav")
    @Expose
    private Gav gav;
    @SerializedName("fileInformation")
    @Expose
    private List<FileInformation> fileInformation = new ArrayList<FileInformation>();
    @SerializedName("buildCommand")
    @Expose
    private String buildCommand;
    @SerializedName("requiresImplementation")
    @Expose
    private EiffelArtifactCreatedEventData.RequiresImplementation requiresImplementation;
    @SerializedName("dependsOn")
    @Expose
    private List<DependsOn> dependsOn = new ArrayList<DependsOn>();
    @SerializedName("implements")
    @Expose
    private List<Implement> _implements = new ArrayList<Implement>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public Gav getGav() {
        return gav;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setGav(Gav gav) {
        this.gav = gav;
    }

    public List<FileInformation> getFileInformation() {
        return fileInformation;
    }

    public void setFileInformation(List<FileInformation> fileInformation) {
        this.fileInformation = fileInformation;
    }

    public String getBuildCommand() {
        return buildCommand;
    }

    public void setBuildCommand(String buildCommand) {
        this.buildCommand = buildCommand;
    }

    public EiffelArtifactCreatedEventData.RequiresImplementation getRequiresImplementation() {
        return requiresImplementation;
    }

    public void setRequiresImplementation(EiffelArtifactCreatedEventData.RequiresImplementation requiresImplementation) {
        this.requiresImplementation = requiresImplementation;
    }

    public List<DependsOn> getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(List<DependsOn> dependsOn) {
        this.dependsOn = dependsOn;
    }

    public List<Implement> getImplements() {
        return _implements;
    }

    public void setImplements(List<Implement> _implements) {
        this._implements = _implements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

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
        private final static Map<String, EiffelArtifactCreatedEventData.RequiresImplementation> CONSTANTS = new HashMap<String, EiffelArtifactCreatedEventData.RequiresImplementation>();

        static {
            for (EiffelArtifactCreatedEventData.RequiresImplementation c: values()) {
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

        public static EiffelArtifactCreatedEventData.RequiresImplementation fromValue(String value) {
            EiffelArtifactCreatedEventData.RequiresImplementation constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
