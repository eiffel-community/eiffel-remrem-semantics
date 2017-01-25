
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe {

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
    @SerializedName("testCase")
    @Expose
    private TestCase testCase;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("constraints")
    @Expose
    private Constraint constraints;

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
    public TestCase getTestCase() {
        return testCase;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Constraint getConstraints() {
        return constraints;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setConstraints(Constraint constraints) {
        this.constraints = constraints;
    }

}
