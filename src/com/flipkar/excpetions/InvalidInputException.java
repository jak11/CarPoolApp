package com.flipkar.excpetions;

public class InvalidInputException extends Exception {
    public InvalidInputException(final Throwable t) {
        super(t);
    }

    public InvalidInputException(final String message) {
        super(message);
    }

    public InvalidInputException(final String message, final Throwable t) {
        super(message, t);
    }
}
