package com.job_app.autocomplete.Exception;

public class NoResultFoundException extends RuntimeException {
    public NoResultFoundException(String message) {
        super(message);
    }

    public NoResultFoundException() {
        super("No results found for the given prefix.");
    }
}
