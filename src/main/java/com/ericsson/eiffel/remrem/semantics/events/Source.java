
package com.ericsson.eiffel.remrem.semantics.events;

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
    /**
     * 
     */
    @SerializedName("host")
    @Expose
    private String host;
    /**
     * 
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * 
     */
    @SerializedName("serializer")
    @Expose
    private GAV serializer;
    /**
     * 
     */
    @SerializedName("uri")
    @Expose
    private String uri;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The domainId
     */
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
    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    /**
     * 
     * @return
     *     The host
     */
    public String getHost() {
        return host;
    }

    /**
     * 
     * @param host
     *     The host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The serializer
     */
    public GAV getSerializer() {
        return serializer;
    }

    /**
     * 
     * @param serializer
     *     The serializer
     */
    public void setSerializer(GAV serializer) {
        this.serializer = serializer;
    }

    /**
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

}
