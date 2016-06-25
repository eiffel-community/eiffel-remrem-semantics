package com.ericsson.eiffel.remrem.semantics.factory;

import com.ericsson.eiffel.remrem.semantics.models.Models.Meta.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.OutputValidator;

import java.util.EnumMap;

public class EiffelOutputValidatorFactory {

    private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);

    static {
        validators.put(EiffelEventType.EiffelActivityFinishedEvent,
                new OutputValidator("schemas/output/ActivityFinished.json"));

        validators.put(EiffelEventType.EiffelArtifactPublishedEvent,
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
