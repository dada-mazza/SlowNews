package slownews.controller;

import slownews.single.NewsSingletone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/news")
public class News extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/").forward(request, response);
        } else {
            request.setAttribute("counterNews", new Random().nextInt(11));
            request.setAttribute("articles", NewsSingletone.getInstance().getArticles());
            request.getRequestDispatcher("/WEB-INF/view/news.jsp").forward(request, response);
        }
    }
}
