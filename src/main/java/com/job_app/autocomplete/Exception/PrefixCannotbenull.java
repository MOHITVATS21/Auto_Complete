package com.job_app.autocomplete.Exception;

public class PrefixCannotbenull extends RuntimeException {
    public PrefixCannotbenull(String message) {
        super(message);
    }

    public PrefixCannotbenull() {
        super("Prefix cannot be null or empty.");
    }
}
