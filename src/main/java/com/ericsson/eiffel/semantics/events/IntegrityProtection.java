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

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class IntegrityProtection {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("signature")
    @Expose
    private String signature;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("alg")
    @Expose
    private IntegrityProtection.Alg alg;
    @SerializedName("publicKey")
    @Expose
    private String publicKey;

    /**
     * 
     * (Required)
     * 
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 
     * (Required)
     * 
     */
    public IntegrityProtection.Alg getAlg() {
        return alg;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setAlg(IntegrityProtection.Alg alg) {
        this.alg = alg;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    @Generated("jsonschema2pojo")
    public enum Alg {

        @SerializedName("HS256")
        HS_256("HS256"),
        @SerializedName("HS384")
        HS_384("HS384"),
        @SerializedName("HS512")
        HS_512("HS512"),
        @SerializedName("RS256")
        RS_256("RS256"),
        @SerializedName("RS384")
        RS_384("RS384"),
        @SerializedName("RS512")
        RS_512("RS512"),
        @SerializedName("ES256")
        ES_256("ES256"),
        @SerializedName("ES384")
        ES_384("ES384"),
        @SerializedName("ES512")
        ES_512("ES512"),
        @SerializedName("PS256")
        PS_256("PS256"),
        @SerializedName("PS384")
        PS_384("PS384"),
        @SerializedName("PS512")
        PS_512("PS512");
        private final String value;
        private final static Map<String, IntegrityProtection.Alg> CONSTANTS = new HashMap<String, IntegrityProtection.Alg>();

        static {
            for (IntegrityProtection.Alg c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Alg(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static IntegrityProtection.Alg fromValue(String value) {
            IntegrityProtection.Alg constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
