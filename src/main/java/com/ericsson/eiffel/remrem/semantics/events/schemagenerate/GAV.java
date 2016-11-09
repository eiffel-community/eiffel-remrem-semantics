
package com.ericsson.eiffel.remrem.semantics.events.schemagenerate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "groupId",
    "artifactId",
    "version"
})
public class GAV {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("groupId")
    private String groupId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("artifactId")
    private String artifactId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("version")
    private String version;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The groupId
     */
    @JsonProperty("groupId")
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
    @JsonProperty("groupId")
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
    @JsonProperty("artifactId")
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
    @JsonProperty("artifactId")
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
    @JsonProperty("version")
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
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(groupId).append(artifactId).append(version).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GAV) == false) {
            return false;
        }
        GAV rhs = ((GAV) other);
        return new EqualsBuilder().append(groupId, rhs.groupId).append(artifactId, rhs.artifactId).append(version, rhs.version).isEquals();
    }

}
