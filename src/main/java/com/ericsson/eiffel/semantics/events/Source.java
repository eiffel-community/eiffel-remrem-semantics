
package com.ericsson.eiffel.semantics.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("domainId")
    @Expose
    private String domainId;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("serializer")
    @Expose
    private GAV serializer;
    @SerializedName("uri")
    @Expose
    private String uri;

    /**
     * 
     * (Required)
     * 
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GAV getSerializer() {
        return serializer;
    }

    public void setSerializer(GAV serializer) {
        this.serializer = serializer;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
