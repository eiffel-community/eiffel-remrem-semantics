
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

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
    private Meta.Type type;
    @SerializedName("version")
    @Expose
    private Meta.Version version = Meta.Version.fromValue("1.0.0");
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
    public Meta.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(Meta.Type type) {
        this.type = type;
    }

    public Meta.Version getVersion() {
        return version;
    }

    public void setVersion(Meta.Version version) {
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

    public enum Type {

        @SerializedName("EiffelActivityCanceledEvent")
        EIFFEL_ACTIVITY_CANCELED_EVENT("EiffelActivityCanceledEvent"),
        @SerializedName("EiffelActivityFinishedEvent")
        EIFFEL_ACTIVITY_FINISHED_EVENT("EiffelActivityFinishedEvent"),
        @SerializedName("EiffelActivityStartedEvent")
        EIFFEL_ACTIVITY_STARTED_EVENT("EiffelActivityStartedEvent"),
        @SerializedName("EiffelActivityTriggeredEvent")
        EIFFEL_ACTIVITY_TRIGGERED_EVENT("EiffelActivityTriggeredEvent"),
        @SerializedName("EiffelAnnouncementPublishedEvent")
        EIFFEL_ANNOUNCEMENT_PUBLISHED_EVENT("EiffelAnnouncementPublishedEvent"),
        @SerializedName("EiffelArtifactCreatedEvent")
        EIFFEL_ARTIFACT_CREATED_EVENT("EiffelArtifactCreatedEvent"),
        @SerializedName("EiffelArtifactPublishedEvent")
        EIFFEL_ARTIFACT_PUBLISHED_EVENT("EiffelArtifactPublishedEvent"),
        @SerializedName("EiffelCompositionDefinedEvent")
        EIFFEL_COMPOSITION_DEFINED_EVENT("EiffelCompositionDefinedEvent"),
        @SerializedName("EiffelConfidenceLevelModifiedEvent")
        EIFFEL_CONFIDENCE_LEVEL_MODIFIED_EVENT("EiffelConfidenceLevelModifiedEvent"),
        @SerializedName("EiffelConfigurationAppliedEvent")
        EIFFEL_CONFIGURATION_APPLIED_EVENT("EiffelConfigurationAppliedEvent"),
        @SerializedName("EiffelEnvironmentDefinedEvent")
        EIFFEL_ENVIRONMENT_DEFINED_EVENT("EiffelEnvironmentDefinedEvent"),
        @SerializedName("EiffelFlowContextDefinedEvent")
        EIFFEL_FLOW_CONTEXT_DEFINED_EVENT("EiffelFlowContextDefinedEvent"),
        @SerializedName("EiffelSourceChangeCreatedEvent")
        EIFFEL_SOURCE_CHANGE_CREATED_EVENT("EiffelSourceChangeCreatedEvent"),
        @SerializedName("EiffelSourceChangeSubmittedEvent")
        EIFFEL_SOURCE_CHANGE_SUBMITTED_EVENT("EiffelSourceChangeSubmittedEvent"),
        @SerializedName("EiffelTestCaseFinishedEvent")
        EIFFEL_TEST_CASE_FINISHED_EVENT("EiffelTestCaseFinishedEvent"),
        @SerializedName("EiffelTestCaseStartedEvent")
        EIFFEL_TEST_CASE_STARTED_EVENT("EiffelTestCaseStartedEvent"),
        @SerializedName("EiffelTestSuiteFinishedEvent")
        EIFFEL_TEST_SUITE_FINISHED_EVENT("EiffelTestSuiteFinishedEvent"),
        @SerializedName("EiffelTestSuiteStartedEvent")
        EIFFEL_TEST_SUITE_STARTED_EVENT("EiffelTestSuiteStartedEvent");
        private final String value;
        private final static Map<String, Meta.Type> CONSTANTS = new HashMap<String, Meta.Type>();

        static {
            for (Meta.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Meta.Type fromValue(String value) {
            Meta.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Version {

        @SerializedName("1.0.0")
        _1_0_0("1.0.0");
        private final String value;
        private final static Map<String, Meta.Version> CONSTANTS = new HashMap<String, Meta.Version>();

        static {
            for (Meta.Version c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Version(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Meta.Version fromValue(String value) {
            Meta.Version constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
