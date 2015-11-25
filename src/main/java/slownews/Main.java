package slownews;

import slownews.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class Main extends HttpServlet {

    private Map<String, User> users;

    @Override
    public void init() {
        users = new HashMap<>();
        User user = new User();
        user.setLogin("qqq");
        user.setPassword("qqq");
        users.put(user.getLogin(), user);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = request.getSession().getServletContext();
        context.setAttribute("users", users);

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("signIn").forward(request, response);
        } else {
            request.getRequestDispatcher("news").forward(request, response);
        }
    }
}
