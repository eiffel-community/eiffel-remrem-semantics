
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityCLMEData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("value")
    @Expose
    private ActivityCLMEData.Value value;
    /**
     * 
     */
    @SerializedName("issuer")
    @Expose
    private Issuer issuer;
    /**
     * 
     */
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The value
     */
    public ActivityCLMEData.Value getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     * @param value
     *     The value
     */
    public void setValue(ActivityCLMEData.Value value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The issuer
     */
    public Issuer getIssuer() {
        return issuer;
    }

    /**
     * 
     * @param issuer
     *     The issuer
     */
    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    /**
     * 
     * @return
     *     The customData
     */
    public List<CustomData> getCustomData() {
        return customData;
    }

    /**
     * 
     * @param customData
     *     The customData
     */
    public void setCustomData(List<CustomData> customData) {
        this.customData = customData;
    }

    public enum Value {

        @SerializedName("SUCCESS")
        SUCCESS("SUCCESS"),
        @SerializedName("FAILURE")
        FAILURE("FAILURE"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, ActivityCLMEData.Value> CONSTANTS = new HashMap<String, ActivityCLMEData.Value>();

        static {
            for (ActivityCLMEData.Value c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Value(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static ActivityCLMEData.Value fromValue(String value) {
            ActivityCLMEData.Value constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
