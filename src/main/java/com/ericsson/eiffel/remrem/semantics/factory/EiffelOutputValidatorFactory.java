package com.ericsson.eiffel.remrem.semantics.factory;

import com.ericsson.eiffel.remrem.semantics.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.OutputValidator;

import java.util.EnumMap;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_CANCELED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_TRIGGERED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIDENCELEVEL_MODIFIED;

public class EiffelOutputValidatorFactory {

	private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);

	static {
		validators.put(ACTIVITY_FINISHED, new OutputValidator("schemas/output/EiffelActivityFinishedEvent.json"));
		validators.put(ARTIFACT_PUBLISHED, new OutputValidator("schemas/output/EiffelArtifactPublishedEvent.json"));
		validators.put(ARTIFACT_CREATED, new OutputValidator("schemas/output/EiffelArtifactCreatedEvent.json"));
		validators.put(ACTIVITY_STARTED, new OutputValidator("schemas/output/EiffelActivityStartedEvent.json"));
		validators.put(ACTIVITY_CANCELED, new OutputValidator("schemas/output/EiffelActivityCanceledEvent.json"));
		validators.put(ACTIVITY_TRIGGERED, new OutputValidator("schemas/output/EiffelActivityTriggeredEvent.json"));
		validators.put(CONFIDENCELEVEL_MODIFIED,
				new OutputValidator("schemas/output/EiffelConfidenceLevelModifiedEvent.json"));
	}

    public static EiffelValidator getEiffelValidator(EiffelEventType type) {
        EiffelValidator result = validators.get(type);
        if (result != null) {
            return result;
        }

        throw new IllegalArgumentException("Illegal type: " + type);
    }

}
