
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "description" })
public class Trigger {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	private String type;
	@JsonProperty("description")
	private String description;

	/**
	 * 
	 * (Required)
	 * 
	 * @return The type
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param type
	 *            The type
	 */
	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(type).append(description).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Trigger) == false) {
			return false;
		}
		Trigger rhs = ((Trigger) other);
		return new EqualsBuilder().append(type, rhs.type).append(description, rhs.description).isEquals();
	}

}
