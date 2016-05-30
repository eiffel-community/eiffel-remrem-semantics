package com.ericsson.eiffel.remrem.message.services.validator;

public class EiffelValidationException extends Exception {
    public EiffelValidationException(String message) {
        super(message);
    }

    public EiffelValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
