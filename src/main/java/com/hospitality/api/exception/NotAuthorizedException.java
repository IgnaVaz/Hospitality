package com.hospitality.api.exception;

public class NotAuthorizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public NotAuthorizedException() {
        super();
    }

    public NotAuthorizedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotAuthorizedException(final String message) {
        super(message);
        setError(message);
    }

    public NotAuthorizedException(final Throwable cause) {
        super(cause);
    }
}
