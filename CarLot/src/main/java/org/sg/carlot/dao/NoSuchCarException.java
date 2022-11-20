package org.sg.carlot.dao;

public class NoSuchCarException extends Exception {
    public NoSuchCarException(String message) {
        super(message);
    }

    public NoSuchCarException(String message, Throwable cause) {
        super(message, cause);
    }
}
