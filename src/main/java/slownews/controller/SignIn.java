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

@WebServlet("/signIn")
public class SignIn extends HttpServlet {

    private final String signInJsp = "/WEB-INF/view/signIn.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, User> users = null;
        ServletContext context = request.getSession().getServletContext();
        Object obj = context.getAttribute("users");
        if (obj instanceof Map) {
            users = (Map) obj;
        }

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        if (login == null || login.isEmpty()) {
            request.getRequestDispatcher(signInJsp).forward(request, response);
        }

        if (users.containsKey(login)
                && users.get(login).getPassword().equals(password)) {
            request.getSession().setAttribute("user", login);
            request.setAttribute("user", login);
            request.getRequestDispatcher("news").forward(request, response);
        } else {
            request.setAttribute("message", "incorrect login or password");
            request.getRequestDispatcher(signInJsp).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher(signInJsp).forward(request, response);
        } else {
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
