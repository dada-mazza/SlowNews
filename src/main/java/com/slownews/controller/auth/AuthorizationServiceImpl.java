package com.slownews.controller.auth;

import com.slownews.controller.Role;
import com.slownews.controller.auth.exception.AuthorizationException;
import com.slownews.dao.UserDAO;
import com.slownews.entity.UserEntity;

import java.util.Date;

public class AuthorizationServiceImpl implements AuthorizationService {

    private UserDAO dao;

    public AuthorizationServiceImpl() {
        dao = new UserDAO();
    }

    @Override
    public boolean register(String login, String email, String password, String passwordConfirm) throws AuthorizationException {

        StringBuilder error = new StringBuilder();

        addErrorMessage(login.length() < 4, error, "Логін має бути не менше 4 символів");

        addErrorMessage(login.contains(" "), error, "Логін не має містити пробілів");

        addErrorMessage(getUserByLogin(login) != null, error, "Логін зайнятий");

        addErrorMessage(getUserByEmail(email) != null, error, "Email зайнятий");

        addErrorMessage(password.length() < 6, error, "Пароль має бути не менше 6 символів");

        addErrorMessage(!hasUpperCase(password), error, "Пароль має містити символи верхнього регістру");

        addErrorMessage(!hasLowerCase(password), error, "Пароль має містити символи нижнього регістру");

        addErrorMessage(!hasDigit(password), error, "Пароль має містити числа");

        addErrorMessage(!password.equals(passwordConfirm), error, "Підтвердження має співпадати з паролем");

        if (error.length() == 0) {
            UserEntity user = new UserEntity();
            user.setLogin(login);
            user.setEmail(email);
            user.setPassword(password);
            user.setDateRegistration(new Date());
            user.setRole(Role.USER);
            create(user);
            return true;
        } else {
            throw new AuthorizationException(error.toString());
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

    // має символ верхнього регістру
    private boolean hasUpperCase(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // має символ нижнього регістру
    private boolean hasLowerCase(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    // має число
    private boolean hasDigit(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private UserEntity getUserByLogin(String login) {
        return dao.getUserByLogin(login);
    }

    private UserEntity getUserByEmail(String email) {
        return dao.getUserByEmail(email);
    }

    private Long create(UserEntity user) {
        return dao.create(user);
    }


}
