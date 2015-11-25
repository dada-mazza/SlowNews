package slownews.controller;

import slownews.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {

    private final String signUpJsp = "/WEB-INF/view/signUp.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setNumber(request.getParameter("number"));

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("users");
        if (obj instanceof Map) {
            users = (Map) obj;
        }

        if (!users.containsKey(user.getLogin())) {
            users.put(user.getLogin(), user);
            request.getRequestDispatcher(signUpJsp).forward(request, response);
        } else {
            request.setAttribute("message", "user with that name already registered");
            request.getRequestDispatcher(signUpJsp).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher(signUpJsp).forward(request, response);
        } else {
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
