package dadamazza.slownews.controller;

import dadamazza.slownews.single.NewsSingletone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/archive")
public class Archive extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/").forward(request, response);
        } else {
            request.setAttribute("articles", NewsSingletone.getInstance().getArticles());
            request.getRequestDispatcher("jsp/archive.jsp").forward(request, response);
        }
    }
}
