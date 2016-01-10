package com.slownews.controller.auth;

import com.slownews.controller.auth.exception.AuthenticationException;

public interface AuthenticationService {

    boolean authenticate(String login, String password) throws AuthenticationException;

    void closeService();

}
