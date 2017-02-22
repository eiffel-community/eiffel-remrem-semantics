
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelSourceChangeSubmittedEventMeta implements Meta
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
    private EiffelSourceChangeSubmittedEventMeta.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("version")
    @Expose
    private EiffelSourceChangeSubmittedEventMeta.Version version = EiffelSourceChangeSubmittedEventMeta.Version.fromValue("1.0.0");
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
    public EiffelSourceChangeSubmittedEventMeta.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setType(EiffelSourceChangeSubmittedEventMeta.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelSourceChangeSubmittedEventMeta.Version getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVersion(EiffelSourceChangeSubmittedEventMeta.Version version) {
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

        @SerializedName("eiffelsourcechangesubmitted")
        EIFFELSOURCECHANGESUBMITTED("eiffelsourcechangesubmitted");
        private final String value;
        private final static Map<String, EiffelSourceChangeSubmittedEventMeta.Type> CONSTANTS = new HashMap<String, EiffelSourceChangeSubmittedEventMeta.Type>();

        static {
            for (EiffelSourceChangeSubmittedEventMeta.Type c: values()) {
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

        public static EiffelSourceChangeSubmittedEventMeta.Type fromValue(String value) {
            EiffelSourceChangeSubmittedEventMeta.Type constant = CONSTANTS.get(value);
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
        private final static Map<String, EiffelSourceChangeSubmittedEventMeta.Version> CONSTANTS = new HashMap<String, EiffelSourceChangeSubmittedEventMeta.Version>();

        static {
            for (EiffelSourceChangeSubmittedEventMeta.Version c: values()) {
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

        public static EiffelSourceChangeSubmittedEventMeta.Version fromValue(String value) {
            EiffelSourceChangeSubmittedEventMeta.Version constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
