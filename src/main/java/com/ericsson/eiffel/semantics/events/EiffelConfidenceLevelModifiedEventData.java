
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EiffelConfidenceLevelModifiedEventData {

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
    private EiffelConfidenceLevelModifiedEventData.Value value;
    @SerializedName("issuer")
    @Expose
    private Issuer issuer;
    @SerializedName("customData")
    @Expose
    private List<CustomData> customData = new ArrayList<CustomData>();

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelConfidenceLevelModifiedEventData.Value getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setValue(EiffelConfidenceLevelModifiedEventData.Value value) {
        this.value = value;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public List<CustomData> getCustomData() {
        return customData;
    }

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
        private final static Map<String, EiffelConfidenceLevelModifiedEventData.Value> CONSTANTS = new HashMap<String, EiffelConfidenceLevelModifiedEventData.Value>();

        static {
            for (EiffelConfidenceLevelModifiedEventData.Value c: values()) {
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

        public static EiffelConfidenceLevelModifiedEventData.Value fromValue(String value) {
            EiffelConfidenceLevelModifiedEventData.Value constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
