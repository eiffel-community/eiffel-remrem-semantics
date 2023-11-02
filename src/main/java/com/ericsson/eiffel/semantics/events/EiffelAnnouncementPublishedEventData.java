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
public class EiffelAnnouncementPublishedEventData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("heading")
    @Expose
    private String heading;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("uri")
    @Expose
    private String uri;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("severity")
    @Expose
    private EiffelAnnouncementPublishedEventData.Severity severity;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public String getHeading() {
        return heading;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getBody() {
        return body;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setBody(String body) {
        this.body = body;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelAnnouncementPublishedEventData.Severity getSeverity() {
        return severity;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSeverity(EiffelAnnouncementPublishedEventData.Severity severity) {
        this.severity = severity;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

    @Generated("jsonschema2pojo")
    public enum Severity {

        @SerializedName("MINOR")
        MINOR("MINOR"),
        @SerializedName("MAJOR")
        MAJOR("MAJOR"),
        @SerializedName("CRITICAL")
        CRITICAL("CRITICAL"),
        @SerializedName("BLOCKER")
        BLOCKER("BLOCKER"),
        @SerializedName("CLOSED")
        CLOSED("CLOSED"),
        @SerializedName("CANCELED")
        CANCELED("CANCELED");
        private final String value;
        private final static Map<String, EiffelAnnouncementPublishedEventData.Severity> CONSTANTS = new HashMap<String, EiffelAnnouncementPublishedEventData.Severity>();

        static {
            for (EiffelAnnouncementPublishedEventData.Severity c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Severity(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelAnnouncementPublishedEventData.Severity fromValue(String value) {
            EiffelAnnouncementPublishedEventData.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
