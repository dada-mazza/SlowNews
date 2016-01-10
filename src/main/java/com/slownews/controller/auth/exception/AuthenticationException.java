package com.slownews.controller.auth.exception;

public class AuthenticationException extends Exception {

    private String error;

    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        error = message;
    }

    @Override
    public String toString() {
        return error;
    }
}
