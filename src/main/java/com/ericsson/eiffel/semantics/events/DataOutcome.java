
package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataOutcome {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("verdict")
    @Expose
    private DataOutcome.Verdict verdict;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("conclusion")
    @Expose
    private DataOutcome.Conclusion conclusion;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * 
     * (Required)
     * 
     */
    public DataOutcome.Verdict getVerdict() {
        return verdict;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVerdict(DataOutcome.Verdict verdict) {
        this.verdict = verdict;
    }

    /**
     * 
     * (Required)
     * 
     */
    public DataOutcome.Conclusion getConclusion() {
        return conclusion;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConclusion(DataOutcome.Conclusion conclusion) {
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
        @SerializedName("FAILED")
        FAILED("FAILED"),
        @SerializedName("ABORTED")
        ABORTED("ABORTED"),
        @SerializedName("TIMED_OUT")
        TIMED_OUT("TIMED_OUT"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, DataOutcome.Conclusion> CONSTANTS = new HashMap<String, DataOutcome.Conclusion>();

        static {
            for (DataOutcome.Conclusion c: values()) {
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

        public static DataOutcome.Conclusion fromValue(String value) {
            DataOutcome.Conclusion constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Verdict {

        @SerializedName("PASSED")
        PASSED("PASSED"),
        @SerializedName("FAILED")
        FAILED("FAILED"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, DataOutcome.Verdict> CONSTANTS = new HashMap<String, DataOutcome.Verdict>();

        static {
            for (DataOutcome.Verdict c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Verdict(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static DataOutcome.Verdict fromValue(String value) {
            DataOutcome.Verdict constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
