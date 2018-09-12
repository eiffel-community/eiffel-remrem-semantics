
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelTestExecutionRecipeCollectionCreatedEventMeta implements Meta
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
    private EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("version")
    @Expose
    private EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version version = EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version.fromValue("2.1.0");
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
    public EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVersion(EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version version) {
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

    public enum Type {

        @SerializedName("EiffelTestExecutionRecipeCollectionCreatedEvent")
        EIFFEL_TEST_EXECUTION_RECIPE_COLLECTION_CREATED_EVENT("EiffelTestExecutionRecipeCollectionCreatedEvent");
        private final String value;
        private final static Map<String, EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type> CONSTANTS = new HashMap<String, EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type>();

        static {
            for (EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type c: values()) {
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

        public static EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type fromValue(String value) {
            EiffelTestExecutionRecipeCollectionCreatedEventMeta.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Version {

        @SerializedName("2.1.0")
        _2_1_0("2.1.0");
        private final String value;
        private final static Map<String, EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version> CONSTANTS = new HashMap<String, EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version>();

        static {
            for (EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version c: values()) {
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

        public static EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version fromValue(String value) {
            EiffelTestExecutionRecipeCollectionCreatedEventMeta.Version constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
