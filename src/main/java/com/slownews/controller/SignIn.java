package com.slownews.controller;

import com.slownews.controller.auth.AuthenticationService;
import com.slownews.controller.auth.AuthenticationServiceImpl;
import com.slownews.controller.auth.exception.AuthenticationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignIn extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SignIn.class);

    private final String signInJsp = "/WEB-INF/view/signIn.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("doPost");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        password = (password == null || password.isEmpty()) ? null : DigestUtils.md5Hex(password);

        try {
            AuthenticationService service = new AuthenticationServiceImpl();
            service.authenticate(login, password);
            service.closeService();
            request.getSession().setAttribute("user", login);
            logger.info("doPost forward to " + "news");
            request.getRequestDispatcher("news").forward(request, response);
        } catch (AuthenticationException e) {
            request.setAttribute("message", e.toString());
            request.setAttribute("login", login);
            logger.info("doPost forward to " + signInJsp);
            request.getRequestDispatcher(signInJsp).forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("doGet");

        if (request.getSession().getAttribute("user") == null) {
            logger.info("doGet forward to " + signInJsp);
            request.getRequestDispatcher(signInJsp).forward(request, response);
        } else {
            logger.info("doGet forward to " + "/");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
