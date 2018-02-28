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
