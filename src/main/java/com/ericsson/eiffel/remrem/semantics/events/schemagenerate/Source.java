
package com.ericsson.eiffel.remrem.semantics.events.schemagenerate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "domainId",
    "host",
    "name",
    "serializer",
    "uri"
})
public class Source {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("domainId")
    private String domainId;
    @JsonProperty("host")
    private String host;
    @JsonProperty("name")
    private String name;
    /**
     * 
     */
    @JsonProperty("serializer")
    private GAV serializer;
    @JsonProperty("uri")
    private String uri;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The domainId
     */
    @JsonProperty("domainId")
    public String getDomainId() {
        return domainId;
    }

    /**
     * 
     * (Required)
     * 
     * @param domainId
     *     The domainId
     */
    @JsonProperty("domainId")
    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    /**
     * 
     * @return
     *     The host
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * 
     * @param host
     *     The host
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The serializer
     */
    @JsonProperty("serializer")
    public GAV getSerializer() {
        return serializer;
    }

    /**
     * 
     * @param serializer
     *     The serializer
     */
    @JsonProperty("serializer")
    public void setSerializer(GAV serializer) {
        this.serializer = serializer;
    }

    /**
     * 
     * @return
     *     The uri
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(domainId).append(host).append(name).append(serializer).append(uri).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Source) == false) {
            return false;
        }
        Source rhs = ((Source) other);
        return new EqualsBuilder().append(domainId, rhs.domainId).append(host, rhs.host).append(name, rhs.name).append(serializer, rhs.serializer).append(uri, rhs.uri).isEquals();
    }

}
