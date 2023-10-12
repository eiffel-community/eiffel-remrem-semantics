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

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class EiffelTestSuiteFinishedEventOutcome {

    @SerializedName("verdict")
    @Expose
    private EiffelTestSuiteFinishedEventOutcome.Verdict verdict;
    @SerializedName("conclusion")
    @Expose
    private EiffelTestSuiteFinishedEventOutcome.Conclusion conclusion;
    @SerializedName("description")
    @Expose
    private String description;

    public EiffelTestSuiteFinishedEventOutcome.Verdict getVerdict() {
        return verdict;
    }

    public void setVerdict(EiffelTestSuiteFinishedEventOutcome.Verdict verdict) {
        this.verdict = verdict;
    }

    public EiffelTestSuiteFinishedEventOutcome.Conclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(EiffelTestSuiteFinishedEventOutcome.Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        private final static Map<String, EiffelTestSuiteFinishedEventOutcome.Conclusion> CONSTANTS = new HashMap<String, EiffelTestSuiteFinishedEventOutcome.Conclusion>();

        static {
            for (EiffelTestSuiteFinishedEventOutcome.Conclusion c: values()) {
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

        public static EiffelTestSuiteFinishedEventOutcome.Conclusion fromValue(String value) {
            EiffelTestSuiteFinishedEventOutcome.Conclusion constant = CONSTANTS.get(value);
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
        private final static Map<String, EiffelTestSuiteFinishedEventOutcome.Verdict> CONSTANTS = new HashMap<String, EiffelTestSuiteFinishedEventOutcome.Verdict>();

        static {
            for (EiffelTestSuiteFinishedEventOutcome.Verdict c: values()) {
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

        public static EiffelTestSuiteFinishedEventOutcome.Verdict fromValue(String value) {
            EiffelTestSuiteFinishedEventOutcome.Verdict constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
