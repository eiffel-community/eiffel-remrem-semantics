
package com.ericsson.eiffel.remrem.semantics.events;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "executionUri", "liveLogs", "customData" })
public class ActivityStartedData {

	@JsonProperty("executionUri")
	private String executionUri;
	@JsonProperty("liveLogs")
	private List<PersistentLog> liveLogs = new ArrayList<PersistentLog>();
	@JsonProperty("customData")
	private List<CustomData> customData = new ArrayList<CustomData>();

	/**
	 * 
	 * @return The executionUri
	 */
	@JsonProperty("executionUri")
	public String getExecutionUri() {
		return executionUri;
	}

	/**
	 * 
	 * @param executionUri
	 *            The executionUri
	 */
	@JsonProperty("executionUri")
	public void setExecutionUri(String executionUri) {
		this.executionUri = executionUri;
	}

	/**
	 * 
	 * @return The liveLogs
	 */
	@JsonProperty("liveLogs")
	public List<PersistentLog> getLiveLogs() {
		return liveLogs;
	}

	/**
	 * 
	 * @param liveLogs
	 *            The liveLogs
	 */
	@JsonProperty("liveLogs")
	public void setLiveLogs(List<PersistentLog> liveLogs) {
		this.liveLogs = liveLogs;
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
		return new HashCodeBuilder().append(executionUri).append(liveLogs).append(customData).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ActivityStartedData) == false) {
			return false;
		}
		ActivityStartedData rhs = ((ActivityStartedData) other);
		return new EqualsBuilder().append(executionUri, rhs.executionUri).append(liveLogs, rhs.liveLogs)
				.append(customData, rhs.customData).isEquals();
	}

}
