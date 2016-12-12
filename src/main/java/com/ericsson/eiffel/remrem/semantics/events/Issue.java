
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issue {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("type")
    @Expose
    private Issue.Type type;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("tracker")
    @Expose
    private String tracker;
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
    @SerializedName("uri")
    @Expose
    private String uri;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("transition")
    @Expose
    private Issue.Transition transition;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The type
     */
    public Issue.Type getType() {
        return type;
    }

    /**
     * 
     * (Required)
     * 
     * @param type
     *     The type
     */
    public void setType(Issue.Type type) {
        this.type = type;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The tracker
     */
    public String getTracker() {
        return tracker;
    }

    /**
     * 
     * (Required)
     * 
     * @param tracker
     *     The tracker
     */
    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * (Required)
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The transition
     */
    public Issue.Transition getTransition() {
        return transition;
    }

    /**
     * 
     * (Required)
     * 
     * @param transition
     *     The transition
     */
    public void setTransition(Issue.Transition transition) {
        this.transition = transition;
    }

    public enum Transition {

        @SerializedName("RESOLVED")
        RESOLVED("RESOLVED"),
        @SerializedName("PARTIAL")
        PARTIAL("PARTIAL"),
        @SerializedName("REMOVED")
        REMOVED("REMOVED");
        private final String value;
        private final static Map<String, Issue.Transition> CONSTANTS = new HashMap<String, Issue.Transition>();

        static {
            for (Issue.Transition c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Transition(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Issue.Transition fromValue(String value) {
            Issue.Transition constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        @SerializedName("BUG")
        BUG("BUG"),
        @SerializedName("IMPROVEMENT")
        IMPROVEMENT("IMPROVEMENT"),
        @SerializedName("FEATURE")
        FEATURE("FEATURE"),
        @SerializedName("WORK_ITEM")
        WORK_ITEM("WORK_ITEM"),
        @SerializedName("REQUIREMENT")
        REQUIREMENT("REQUIREMENT"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, Issue.Type> CONSTANTS = new HashMap<String, Issue.Type>();

        static {
            for (Issue.Type c: values()) {
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

        public static Issue.Type fromValue(String value) {
            Issue.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
