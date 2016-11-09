
package com.ericsson.eiffel.remrem.semantics.events.schemagenerate;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conclusion",
    "description"
})
public class Outcome {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("conclusion")
    private Outcome.Conclusion conclusion;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The conclusion
     */
    @JsonProperty("conclusion")
    public Outcome.Conclusion getConclusion() {
        return conclusion;
    }

    /**
     * 
     * (Required)
     * 
     * @param conclusion
     *     The conclusion
     */
    @JsonProperty("conclusion")
    public void setConclusion(Outcome.Conclusion conclusion) {
        this.conclusion = conclusion;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
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
        return new HashCodeBuilder().append(conclusion).append(description).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Outcome) == false) {
            return false;
        }
        Outcome rhs = ((Outcome) other);
        return new EqualsBuilder().append(conclusion, rhs.conclusion).append(description, rhs.description).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    public enum Conclusion {

        SUCCESSFUL("SUCCESSFUL"),
        UNSUCCESSFUL("UNSUCCESSFUL"),
        FAILED("FAILED"),
        ABORTED("ABORTED"),
        TIMED_OUT("TIMED_OUT"),
        INCONCLUSIVE("INCONCLUSIVE");
        private final String value;
        private final static Map<String, Outcome.Conclusion> CONSTANTS = new HashMap<String, Outcome.Conclusion>();

        static {
            for (Outcome.Conclusion c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Conclusion(String value) {
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
        public static Outcome.Conclusion fromValue(String value) {
            Outcome.Conclusion constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
