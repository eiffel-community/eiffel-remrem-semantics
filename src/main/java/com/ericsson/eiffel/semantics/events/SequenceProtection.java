/**
 *     Copyright 2018 Ericsson AB.
 *     For a full list of individual contributors, please see the commit history.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ericsson.eiffel.semantics.events;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SequenceProtection {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("sequenceName")
    @Expose
    private String sequenceName;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("position")
    @Expose
    private Integer position;

    /**
     * 
     * (Required)
     * 
     */
    public String getSequenceName() {
        return sequenceName;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

}
