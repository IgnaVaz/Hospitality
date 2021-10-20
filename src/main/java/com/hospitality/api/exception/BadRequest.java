package com.hospitality.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException{
    private static final long serialVersionUID = 7871311139398288215L;
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public BadRequest() {
        super();
    }

    public BadRequest(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BadRequest(final String message) {
        super(message);
        setError(message);
    }

    public BadRequest(final Throwable cause) {
        super(cause);
    }
}
