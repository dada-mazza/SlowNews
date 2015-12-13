package slownews.controller;

import slownews.moxy.Moxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;

@WebServlet("/lastNews")
public class LastNews extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
        response.getWriter().println(new Moxy().getLastNewsTitle(url));
        System.out.println(new Moxy().getLastNewsTitle(url) + " " + new Date());

    }
}
