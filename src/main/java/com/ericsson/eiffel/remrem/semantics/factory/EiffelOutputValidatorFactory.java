package com.ericsson.eiffel.remrem.semantics.factory;

import com.ericsson.eiffel.remrem.semantics.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.OutputValidator;

import java.util.EnumMap;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;

public class EiffelOutputValidatorFactory {

    private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);

    static {
        validators.put(ACTIVITY_FINISHED,
                new OutputValidator("inputSchemas/EiffelActivityFinishedEvent.json"));

        validators.put(ARTIFACT_PUBLISHED,
                new OutputValidator("inputSchemas/EiffelArtifactPublishedEvent.json"));
    }

    public static EiffelValidator getEiffelValidator(EiffelEventType type) {
        EiffelValidator result = validators.get(type);
        if (result != null) {
            return result;
        }

        throw new IllegalArgumentException("Illegal type: " + type);
    }

}
