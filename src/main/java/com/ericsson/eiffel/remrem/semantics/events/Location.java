
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "uri" })
public class Location {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("type")
	private Location.Type type;
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
	 * @return The type
	 */
	@JsonProperty("type")
	public Location.Type getType() {
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
	public void setType(Location.Type type) {
		this.type = type;
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
		return new HashCodeBuilder().append(type).append(uri).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Location) == false) {
			return false;
		}
		Location rhs = ((Location) other);
		return new EqualsBuilder().append(type, rhs.type).append(uri, rhs.uri).isEquals();
	}

	public enum Type {

		ARTIFACTORY("ARTIFACTORY"), NEXUS("NEXUS"), PLAIN("PLAIN"), OTHER("OTHER");
		private final String value;
		private final static Map<String, Location.Type> CONSTANTS = new HashMap<String, Location.Type>();

		static {
			for (Location.Type c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Type(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		@JsonValue
		public String value() {
			return this.value;
		}

		@JsonCreator
		public static Location.Type fromValue(String value) {
			Location.Type constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
