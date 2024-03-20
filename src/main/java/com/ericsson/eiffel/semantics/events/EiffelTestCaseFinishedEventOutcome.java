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
public class EiffelTestCaseFinishedEventOutcome {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("verdict")
    @Expose
    private EiffelTestCaseFinishedEventOutcome.Verdict verdict;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("conclusion")
    @Expose
    private EiffelTestCaseFinishedEventOutcome.Conclusion conclusion;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("metrics")
    @Expose
    private List<Metric> metrics = new ArrayList<Metric>();

    /**
     * 
     * (Required)
     * 
     */
    public EiffelTestCaseFinishedEventOutcome.Verdict getVerdict() {
        return verdict;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setVerdict(EiffelTestCaseFinishedEventOutcome.Verdict verdict) {
        this.verdict = verdict;
    }

    /**
     * 
     * (Required)
     * 
     */
    public EiffelTestCaseFinishedEventOutcome.Conclusion getConclusion() {
        return conclusion;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConclusion(EiffelTestCaseFinishedEventOutcome.Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    @Generated("jsonschema2pojo")
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
        private final static Map<String, EiffelTestCaseFinishedEventOutcome.Conclusion> CONSTANTS = new HashMap<String, EiffelTestCaseFinishedEventOutcome.Conclusion>();

        static {
            for (EiffelTestCaseFinishedEventOutcome.Conclusion c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Conclusion(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelTestCaseFinishedEventOutcome.Conclusion fromValue(String value) {
            EiffelTestCaseFinishedEventOutcome.Conclusion constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Verdict {

        @SerializedName("PASSED")
        PASSED("PASSED"),
        @SerializedName("FAILED")
        FAILED("FAILED"),
        @SerializedName("INCONCLUSIVE")
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, EiffelTestCaseFinishedEventOutcome.Verdict> CONSTANTS = new HashMap<String, EiffelTestCaseFinishedEventOutcome.Verdict>();

        static {
            for (EiffelTestCaseFinishedEventOutcome.Verdict c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Verdict(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static EiffelTestCaseFinishedEventOutcome.Verdict fromValue(String value) {
            EiffelTestCaseFinishedEventOutcome.Verdict constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
