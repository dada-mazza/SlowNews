package com.slownews.controller.auth.exception;

public class AuthorizationException extends Exception {

    private String error;

    public AuthorizationException() {
    }

    public AuthorizationException(String message) {
        error = message;
    }

    @Override
    public String toString() {
        return error;
    }
}
