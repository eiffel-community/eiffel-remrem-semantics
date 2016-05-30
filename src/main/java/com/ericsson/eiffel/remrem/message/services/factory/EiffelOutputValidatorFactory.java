package com.ericsson.eiffel.remrem.message.services.factory;

import com.ericsson.eiffel.remrem.message.services.EiffelEventType;
import com.ericsson.eiffel.remrem.message.services.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.message.services.validator.OutputValidator;

import java.util.EnumMap;

import static com.ericsson.eiffel.remrem.message.services.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.message.services.EiffelEventType.ARTIFACT_PUBLISHED;

public class EiffelOutputValidatorFactory {

    private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);

    static {
        validators.put(ACTIVITY_FINISHED,
                new OutputValidator("schemas/output/ActivityFinished.json"));

        validators.put(ARTIFACT_PUBLISHED,
                new OutputValidator("schemas/output/ArtifactPublished.json"));
    }

    public static EiffelValidator getEiffelValidator(EiffelEventType type) {
        EiffelValidator result = validators.get(type);
        if (result != null) {
            return result;
        }

        throw new IllegalArgumentException("Illegal type: " + type);
    }

}
