package com.slownews.controller;

import com.slownews.controller.auth.AuthorizationService;
import com.slownews.controller.auth.AuthorizationServiceImpl;
import com.slownews.controller.auth.exception.AuthorizationException;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SignUp.class);

    private final String signUpJsp = "/WEB-INF/view/signUp.jsp";
    private final String signInJsp = "/WEB-INF/view/signIn.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("doPost");

        String login = request.getParameter("login");
        String password = DigestUtils.md5Hex(request.getParameter("password"));
        String passwordConfirm = DigestUtils.md5Hex(request.getParameter("passwordConfirm"));
        String email = request.getParameter("email");

        try {
            AuthorizationService service = new AuthorizationServiceImpl();
            service.register(login, email, password, passwordConfirm);
            service.closeService();
            request.setAttribute("login", login);
            logger.info("doPost forward to signIn");
            request.getRequestDispatcher("signIn").forward(request, response);
        } catch (AuthorizationException e) {
            request.setAttribute("message", e.toString());
            request.setAttribute("login", login);
            request.setAttribute("email", email);
            logger.info("doPost forward to " + signUpJsp);
            request.getRequestDispatcher(signUpJsp).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("doGet");

        if (request.getSession().getAttribute("user") == null) {
            logger.info("doGet forward to " + signUpJsp);
            request.getRequestDispatcher(signUpJsp).forward(request, response);
        } else {
            logger.info("doGet forward to /");
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

}
