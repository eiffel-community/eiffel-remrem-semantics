
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnnouncementPublishedData {

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
    private AnnouncementPublishedData.Severity severity;
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
    public AnnouncementPublishedData.Severity getSeverity() {
        return severity;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSeverity(AnnouncementPublishedData.Severity severity) {
        this.severity = severity;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

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
        private final static Map<String, AnnouncementPublishedData.Severity> CONSTANTS = new HashMap<String, AnnouncementPublishedData.Severity>();

        static {
            for (AnnouncementPublishedData.Severity c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Severity(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static AnnouncementPublishedData.Severity fromValue(String value) {
            AnnouncementPublishedData.Severity constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
