package com.ericsson.eiffel.remrem.semantics.factory;

import com.ericsson.eiffel.remrem.semantics.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import com.ericsson.eiffel.remrem.semantics.validator.OutputValidator;

import java.util.EnumMap;

import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_CANCELED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ACTIVITY_TRIGGERED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ANNOUNCEMENT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ARTIFACT_PUBLISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIDENCELEVEL_MODIFIED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTCASE_STARTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTCASE_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.SOURCECHANGE_SUBMITTED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.SOURCECHANGE_CREATED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.FLOWCONTEXT_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.ENVIRONMENT_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.CONFIGURATION_APPLIED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.COMPOSITION_DEFINED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTSUITE_FINISHED;
import static com.ericsson.eiffel.remrem.semantics.EiffelEventType.TESTSUITE_STARTED;

public class EiffelOutputValidatorFactory {

    private static final EnumMap<EiffelEventType, EiffelValidator> validators = new EnumMap<>(EiffelEventType.class);


    static {
        validators.put(ACTIVITY_FINISHED, new OutputValidator("schemas/output/EiffelActivityFinishedEvent.json"));
        validators.put(ARTIFACT_PUBLISHED, new OutputValidator("schemas/output/EiffelArtifactPublishedEvent.json"));
        validators.put(ARTIFACT_CREATED, new OutputValidator("schemas/output/EiffelArtifactCreatedEvent.json"));
        validators.put(ACTIVITY_STARTED, new OutputValidator("schemas/output/EiffelActivityStartedEvent.json"));
        validators.put(ACTIVITY_CANCELED, new OutputValidator("schemas/output/EiffelActivityCanceledEvent.json"));
        validators.put(ACTIVITY_TRIGGERED, new OutputValidator("schemas/output/EiffelActivityTriggeredEvent.json"));
        validators.put(ANNOUNCEMENT_PUBLISHED, new OutputValidator("schemas/output/EiffelAnnouncementPublishedEvent.json"));
        validators.put(COMPOSITION_DEFINED, new OutputValidator("schemas/output/EiffelCompositionDefinedEvent.json"));
        validators.put(CONFIGURATION_APPLIED, new OutputValidator("schemas/output/EiffelConfigurationAppliedEvent.json"));
        validators.put(ENVIRONMENT_DEFINED, new OutputValidator("schemas/output/EiffelEnvironmentDefinedEvent.json"));
        validators.put(FLOWCONTEXT_DEFINED, new OutputValidator("schemas/output/EiffelFlowContextDefinedEvent.json"));        
        validators.put(SOURCECHANGE_CREATED, new OutputValidator("schemas/output/EiffelSourceChangeCreatedEvent.json"));
        validators.put(SOURCECHANGE_SUBMITTED, new OutputValidator("schemas/output/EiffelSourceChangeSubmittedEvent.json"));
        validators.put(TESTCASE_FINISHED, new OutputValidator("schemas/output/EiffelTestCaseFinishedEvent.json"));
        validators.put(TESTCASE_STARTED, new OutputValidator("schemas/output/EiffelTestCaseStartedEvent.json"));
        validators.put(TESTSUITE_FINISHED, new OutputValidator("schemas/output/EiffelTestSuiteFinishedEvent.json"));
        validators.put(TESTSUITE_STARTED, new OutputValidator("schemas/output/EiffelTestSuiteStartedEvent.json"));
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
