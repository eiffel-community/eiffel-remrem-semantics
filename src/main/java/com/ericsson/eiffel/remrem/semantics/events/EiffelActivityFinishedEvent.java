
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.ericsson.eiffel.remrem.semantics.events.Event;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "meta", "data", "links" })
public class EiffelActivityFinishedEvent extends Event {

	/**
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
	private ActivityFinishedData data;
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
	 * @return The meta
	 */
	@JsonProperty("meta")
	public Meta getMeta() {
		return meta;
	}

	/**
	 * 
	 * @param meta
	 *            The meta
	 */
	@JsonProperty("meta")
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The data
	 */
	@JsonProperty("data")
	public ActivityFinishedData getData() {
		return data;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param data
	 *            The data
	 */
	@JsonProperty("data")
	public void setData(ActivityFinishedData data) {
		this.data = data;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The links
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
	 *            The links
	 */
	@JsonProperty("links")
	public void setLinks(Link links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().appendSuper(super.hashCode()).append(meta).append(data).append(links)
				.append(additionalProperties).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof EiffelActivityFinishedEvent) == false) {
			return false;
		}
		EiffelActivityFinishedEvent rhs = ((EiffelActivityFinishedEvent) other);
		return new EqualsBuilder().appendSuper(super.equals(other)).append(meta, rhs.meta).append(data, rhs.data)
				.append(links, rhs.links).append(additionalProperties, rhs.additionalProperties).isEquals();
	}

}
