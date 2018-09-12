
package com.ericsson.eiffel.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batch {

    @SerializedName("name")
    @Expose
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("priority")
    @Expose
    private Integer priority;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("recipes")
    @Expose
    private List<Recipe> recipes = new ArrayList<Recipe>();
    @SerializedName("dependencies")
    @Expose
    private List<Dependency> dependencies = new ArrayList<Dependency>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

}
