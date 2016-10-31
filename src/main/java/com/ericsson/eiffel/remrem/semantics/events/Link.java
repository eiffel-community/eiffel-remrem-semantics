
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "target" })
public class Link {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	private String type;
	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("target")
	private String target;

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
	 * (Required)
	 * 
	 * @return The target
	 */
	@JsonProperty("target")
	public String getTarget() {
		return target;
	}

	/**
	 * 
	 * (Required)
	 * 
	 * @param target
	 *            The target
	 */
	@JsonProperty("target")
	public void setTarget(String target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(type).append(target).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Link) == false) {
			return false;
		}
		Link rhs = ((Link) other);
		return new EqualsBuilder().append(type, rhs.type).append(target, rhs.target).isEquals();
	}

}
