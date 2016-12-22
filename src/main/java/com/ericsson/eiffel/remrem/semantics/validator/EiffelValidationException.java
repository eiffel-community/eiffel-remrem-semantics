package com.ericsson.eiffel.remrem.semantics.validator;

public class EiffelValidationException extends Exception {
    private static final long serialVersionUID = -1592219688353406690L;

    public EiffelValidationException(String message) {
        super(message);
    }

    public EiffelValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
