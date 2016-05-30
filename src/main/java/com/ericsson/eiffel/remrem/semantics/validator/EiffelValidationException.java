package com.ericsson.eiffel.remrem.semantics.validator;

public class EiffelValidationException extends Exception {
    public EiffelValidationException(String message) {
        super(message);
    }

    public EiffelValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
