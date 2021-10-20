package com.hospitality.api.exception;

public class InternalServerError extends RuntimeException {
    private static final long serialVersionUID = 7871311139398288214L;
    private String error;

    public InternalServerError() {
        super();
    }

    public InternalServerError(final String message, final Throwable cause) {
        super(message, cause);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public InternalServerError(final String message) {
        super(message);
        setError(message);
    }

    public InternalServerError(final Throwable cause) {
        super(cause);
    }
}
