
package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GAV {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("groupId")
    @Expose
    private String groupId;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("artifactId")
    @Expose
    private String artifactId;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("version")
    @Expose
    private String version;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 
     * (Required)
     * 
     * @param groupId
     *     The groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The artifactId
     */
    public String getArtifactId() {
        return artifactId;
    }

    /**
     * 
     * (Required)
     * 
     * @param artifactId
     *     The artifactId
     */
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The version
     */
    public String getVersion() {
        return version;
    }

    /**
     * 
     * (Required)
     * 
     * @param version
     *     The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
