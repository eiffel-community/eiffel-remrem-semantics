
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "name", "value", "issuer", "customData" })
public class ActivityCLMEData {

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
	@JsonProperty("value")
	private ActivityCLMEData.Value value;
	@JsonProperty("issuer")
	private Issuer issuer;
	@JsonProperty("customData")
	private List<CustomData> customData = new ArrayList<CustomData>();

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
	 * @return The value
	 */
	@JsonProperty("value")
	public ActivityCLMEData.Value getValue() {
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
	public void setValue(ActivityCLMEData.Value value) {
		this.value = value;
	}

	/**
	 * 
	 * @return The issuer
	 */
	@JsonProperty("issuer")
	public Issuer getIssuer() {
		return issuer;
	}

	/**
	 * 
	 * @param issuer
	 *            The issuer
	 */
	@JsonProperty("issuer")
	public void setIssuer(Issuer issuer) {
		this.issuer = issuer;
	}

	/**
	 * 
	 * @return The customData
	 */
	@JsonProperty("customData")
	public List<CustomData> getCustomData() {
		return customData;
	}

	/**
	 * 
	 * @param customData
	 *            The customData
	 */
	@JsonProperty("customData")
	public void setCustomData(List<CustomData> customData) {
		this.customData = customData;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(value).append(issuer).append(customData).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ActivityCLMEData) == false) {
			return false;
		}
		ActivityCLMEData rhs = ((ActivityCLMEData) other);
		return new EqualsBuilder().append(name, rhs.name).append(value, rhs.value).append(issuer, rhs.issuer)
				.append(customData, rhs.customData).isEquals();
	}

	public enum Value {

		SUCCESS("SUCCESS"), FAILURE("FAILURE"), INCONCLUSIVE("INCONCLUSIVE");
		private final String value;
		private final static Map<String, ActivityCLMEData.Value> CONSTANTS = new HashMap<String, ActivityCLMEData.Value>();

		static {
			for (ActivityCLMEData.Value c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Value(String value) {
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
		public static ActivityCLMEData.Value fromValue(String value) {
			ActivityCLMEData.Value constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
