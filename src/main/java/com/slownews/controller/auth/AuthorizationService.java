package com.slownews.controller.auth;

import com.slownews.controller.auth.exception.AuthorizationException;

public interface AuthorizationService {

    boolean register(String login, String email, String password, String passwordConfirm) throws AuthorizationException;

    void closeService();

}
