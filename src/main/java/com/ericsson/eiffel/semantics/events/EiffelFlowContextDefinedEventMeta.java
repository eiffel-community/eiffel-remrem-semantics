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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EiffelFlowContextDefinedEventMeta implements Meta
{

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("id")
    @Expose
    private String id;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private EiffelFlowContextDefinedEventMeta.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("version")
    @Expose
    private EiffelFlowContextDefinedEventMeta.Version version = EiffelFlowContextDefinedEventMeta.Version.fromValue("3.2.0");
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<String>();
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("security")
    @Expose
    private Security security;
    @SerializedName("schemaUri")
    @Expose
    private String schemaUri;

    /**
     * 
     * (Required)
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelFlowContextDefinedEventMeta.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(EiffelFlowContextDefinedEventMeta.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelFlowContextDefinedEventMeta.Version getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVersion(EiffelFlowContextDefinedEventMeta.Version version) {
        this.version = version;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Long getTime() {
        return time;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTime(Long time) {
        this.time = time;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public String getSchemaUri() {
        return schemaUri;
    }

    public void setSchemaUri(String schemaUri) {
        this.schemaUri = schemaUri;
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        @SerializedName("EiffelFlowContextDefinedEvent")
        EIFFEL_FLOW_CONTEXT_DEFINED_EVENT("EiffelFlowContextDefinedEvent");
        private final String value;
        private final static Map<String, EiffelFlowContextDefinedEventMeta.Type> CONSTANTS = new HashMap<String, EiffelFlowContextDefinedEventMeta.Type>();

        static {
            for (EiffelFlowContextDefinedEventMeta.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelFlowContextDefinedEventMeta.Type fromValue(String value) {
            EiffelFlowContextDefinedEventMeta.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Version {

        @SerializedName("3.2.0")
        _3_2_0("3.2.0");
        private final String value;
        private final static Map<String, EiffelFlowContextDefinedEventMeta.Version> CONSTANTS = new HashMap<String, EiffelFlowContextDefinedEventMeta.Version>();

        static {
            for (EiffelFlowContextDefinedEventMeta.Version c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Version(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelFlowContextDefinedEventMeta.Version fromValue(String value) {
            EiffelFlowContextDefinedEventMeta.Version constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
