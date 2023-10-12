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
public class EiffelServiceStartedEventMeta implements Meta
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
    private EiffelServiceStartedEventMeta.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("version")
    @Expose
    private EiffelServiceStartedEventMeta.Version version = EiffelServiceStartedEventMeta.Version.fromValue("2.0.0");
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
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("security")
    @Expose
    private Security security;

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
    public EiffelServiceStartedEventMeta.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(EiffelServiceStartedEventMeta.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelServiceStartedEventMeta.Version getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVersion(EiffelServiceStartedEventMeta.Version version) {
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

    /**
     * 
     * (Required)
     * 
     */
    public Source getSource() {
        return source;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSource(Source source) {
        this.source = source;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    @Generated("jsonschema2pojo")
    public enum Type {

        @SerializedName("EiffelServiceStartedEvent")
        EIFFEL_SERVICE_STARTED_EVENT("EiffelServiceStartedEvent");
        private final String value;
        private final static Map<String, EiffelServiceStartedEventMeta.Type> CONSTANTS = new HashMap<String, EiffelServiceStartedEventMeta.Type>();

        static {
            for (EiffelServiceStartedEventMeta.Type c: values()) {
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

        public static EiffelServiceStartedEventMeta.Type fromValue(String value) {
            EiffelServiceStartedEventMeta.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Version {

        @SerializedName("2.0.0")
        _2_0_0("2.0.0");
        private final String value;
        private final static Map<String, EiffelServiceStartedEventMeta.Version> CONSTANTS = new HashMap<String, EiffelServiceStartedEventMeta.Version>();

        static {
            for (EiffelServiceStartedEventMeta.Version c: values()) {
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

        public static EiffelServiceStartedEventMeta.Version fromValue(String value) {
            EiffelServiceStartedEventMeta.Version constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
