
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestCaseStartedData {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("testCase")
    @Expose
    private TestCase testCase;
    /**
     * 
     */
    @SerializedName("executor")
    @Expose
    private String executor;
    /**
     * 
     */
    @SerializedName("parameters")
    @Expose
    private List<Parameter> parameters = new ArrayList<Parameter>();
    /**
     * 
     */
    @SerializedName("executionType")
    @Expose
    private TestCaseStartedData.ExecutionType executionType;
    /**
     * 
     */
    @SerializedName("liveLogs")
    @Expose
    private List<PersistentLog> liveLogs = new ArrayList<PersistentLog>();
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
     *     The testCase
     */
    public TestCase getTestCase() {
        return testCase;
    }

    /**
     * 
     * (Required)
     * 
     * @param testCase
     *     The testCase
     */
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    /**
     * 
     * @return
     *     The executor
     */
    public String getExecutor() {
        return executor;
    }

    /**
     * 
     * @param executor
     *     The executor
     */
    public void setExecutor(String executor) {
        this.executor = executor;
    }

    /**
     * 
     * @return
     *     The parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The executionType
     */
    public TestCaseStartedData.ExecutionType getExecutionType() {
        return executionType;
    }

    /**
     * 
     * @param executionType
     *     The executionType
     */
    public void setExecutionType(TestCaseStartedData.ExecutionType executionType) {
        this.executionType = executionType;
    }

    /**
     * 
     * @return
     *     The liveLogs
     */
    public List<PersistentLog> getLiveLogs() {
        return liveLogs;
    }

    /**
     * 
     * @param liveLogs
     *     The liveLogs
     */
    public void setLiveLogs(List<PersistentLog> liveLogs) {
        this.liveLogs = liveLogs;
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

    public enum ExecutionType {

        @SerializedName("MANUAL")
        MANUAL("MANUAL"),
        @SerializedName("SEMI_AUTOMATED")
        SEMI_AUTOMATED("SEMI_AUTOMATED"),
        @SerializedName("AUTOMATED")
        AUTOMATED("AUTOMATED"),
        @SerializedName("OTHER")
        OTHER("OTHER");
        private final String value;
        private final static Map<String, TestCaseStartedData.ExecutionType> CONSTANTS = new HashMap<String, TestCaseStartedData.ExecutionType>();

        static {
            for (TestCaseStartedData.ExecutionType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ExecutionType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static TestCaseStartedData.ExecutionType fromValue(String value) {
            TestCaseStartedData.ExecutionType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
