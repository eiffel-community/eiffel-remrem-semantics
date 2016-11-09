
package com.ericsson.eiffel.remrem.semantics.events;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "email", "id", "group" })
public class Issuer {

	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("id")
	private String id;
	@JsonProperty("group")
	private String group;

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
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
	 * @return The email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 *            The email
	 */
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The group
	 */
	@JsonProperty("group")
	public String getGroup() {
		return group;
	}

	/**
	 * 
	 * @param group
	 *            The group
	 */
	@JsonProperty("group")
	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(email).append(id).append(group).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Issuer) == false) {
			return false;
		}
		Issuer rhs = ((Issuer) other);
		return new EqualsBuilder().append(name, rhs.name).append(email, rhs.email).append(id, rhs.id)
				.append(group, rhs.group).isEquals();
	}

}
