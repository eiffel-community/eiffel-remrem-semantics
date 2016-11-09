
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "key", "value" })
public class CustomData {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("key")
	private String key;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("value")
	private Object value;

	/**
	 * 
	 * (Required)
	 * 
	 * @return The key
	 */
	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param key
	 *            The key
	 */
	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @return The value
	 */
	@JsonProperty("value")
	public Object getValue() {
		return value;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param value
	 *            The value
	 */
	@JsonProperty("value")
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(key).append(value).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof CustomData) == false) {
			return false;
		}
		CustomData rhs = ((CustomData) other);
		return new EqualsBuilder().append(key, rhs.key).append(value, rhs.value).isEquals();
	}

}
