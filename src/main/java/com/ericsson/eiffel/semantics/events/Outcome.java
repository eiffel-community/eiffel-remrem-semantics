
package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outcome {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("conclusion")
    @Expose
    private Outcome.Conclusion conclusion;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * 
     * (Required)
     * 
     */
    public Outcome.Conclusion getConclusion() {
        return conclusion;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConclusion(Outcome.Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Conclusion {

        @SerializedName("SUCCESSFUL")
        SUCCESSFUL("SUCCESSFUL"),
        @SerializedName("UNSUCCESSFUL")
        UNSUCCESSFUL("UNSUCCESSFUL"),
        @SerializedName("FAILED")
        FAILED("FAILED"),
        @SerializedName("ABORTED")
        ABORTED("ABORTED"),
        @SerializedName("TIMED_OUT")
        TIMED_OUT("TIMED_OUT"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, Outcome.Conclusion> CONSTANTS = new HashMap<String, Outcome.Conclusion>();

        static {
            for (Outcome.Conclusion c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Conclusion(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static Outcome.Conclusion fromValue(String value) {
            Outcome.Conclusion constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
