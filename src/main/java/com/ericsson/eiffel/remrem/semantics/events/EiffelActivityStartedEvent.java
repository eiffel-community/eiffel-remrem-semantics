
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "meta",
    "data",
    "links"
})
public class EiffelActivityStartedEvent
    extends Event
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meta")
    private Meta meta;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("data")
    private ActivityStartedData data;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("links")
    private Link links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The meta
     */
    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    /**
     * 
     * (Required)
     * 
     * @param meta
     *     The meta
     */
    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public ActivityStartedData getData() {
        return data;
    }

    /**
     * 
     * (Required)
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    public void setData(ActivityStartedData data) {
        this.data = data;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The links
     */
    @JsonProperty("links")
    public Link getLinks() {
        return links;
    }

    /**
     * 
     * (Required)
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(Link links) {
        this.links = links;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
