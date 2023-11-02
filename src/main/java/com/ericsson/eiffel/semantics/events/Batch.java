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
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
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
