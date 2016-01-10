package com.slownews.controller.auth;

import com.slownews.controller.auth.exception.AuthenticationException;
import com.slownews.dao.UserDAO;
import com.slownews.entity.UserEntity;

public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDAO dao;

    public AuthenticationServiceImpl() {
        dao = new UserDAO();
    }

    @Override
    public boolean authenticate(String login, String password) throws AuthenticationException {

        StringBuilder error = new StringBuilder();

        UserEntity user = getUserByLogin(login);

        addErrorMessage(user == null || !user.getPassword().equals(password), error, "Невірний логін чи пароль");

        if (error.length() == 0) {
            return true;
        } else {
            throw new AuthenticationException(error.toString());
        }
    }

    @Override
    public void closeService() {
        if (dao != null) {
            dao.close();
        }
    }

    private void addErrorMessage(boolean condition, StringBuilder error, String errorMessage) {
        if (condition) {
            if (error.length() > 0) {
                error.append("<br>");
            }
            error.append(errorMessage);
        }
    }

    private UserEntity getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }


}
