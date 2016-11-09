
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "uri" })
public class PersistentLog {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("name")
	private String name;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("uri")
	private String uri;

	/**
	 * 
	 * (Required)
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The uri
	 */
	@JsonProperty("uri")
	public String getUri() {
		return uri;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param uri
	 *            The uri
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
		return new HashCodeBuilder().append(name).append(uri).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof PersistentLog) == false) {
			return false;
		}
		PersistentLog rhs = ((PersistentLog) other);
		return new EqualsBuilder().append(name, rhs.name).append(uri, rhs.uri).isEquals();
	}

}
