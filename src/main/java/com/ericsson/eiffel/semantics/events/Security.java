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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Security {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("authorIdentity")
    @Expose
    private String authorIdentity;
    @SerializedName("integrityProtection")
    @Expose
    private IntegrityProtection integrityProtection;
    @SerializedName("sequenceProtection")
    @Expose
    private List<SequenceProtection> sequenceProtection = new ArrayList<SequenceProtection>();

    /**
     * 
     * (Required)
     * 
     */
    public String getAuthorIdentity() {
        return authorIdentity;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAuthorIdentity(String authorIdentity) {
        this.authorIdentity = authorIdentity;
    }

    public IntegrityProtection getIntegrityProtection() {
        return integrityProtection;
    }

    public void setIntegrityProtection(IntegrityProtection integrityProtection) {
        this.integrityProtection = integrityProtection;
    }

    public List<SequenceProtection> getSequenceProtection() {
        return sequenceProtection;
    }

    public void setSequenceProtection(List<SequenceProtection> sequenceProtection) {
        this.sequenceProtection = sequenceProtection;
    }

}
