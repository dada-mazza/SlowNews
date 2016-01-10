package com.slownews.controller;

import com.slownews.moxy.Moxy;
import com.slownews.moxy.model.NewsItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;


@WebServlet("/news")
public class News extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(News.class);

    private final String newsJsp = "/WEB-INF/view/news.jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("service");

        if (request.getSession().getAttribute("user") == null) {
            logger.info("service forward to " + "/");
            request.getRequestDispatcher("/").forward(request, response);
        } else {
            request.setAttribute("counterNews", new Random().nextInt(11));
            URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
            File file = new File("d:\\OneDrive\\Projects\\Infopulse\\SlowNews\\garbage\\news.xml");

            List<NewsItem> articles;
            try {
                articles = new Moxy().getNewsItems(url);
            } catch (JAXBException e) {
                articles = new Moxy().getNewsItems(file);
            }

            ServletContext context = request.getSession().getServletContext();
            context.setAttribute("articles", articles);

            logger.info("service forward to " + newsJsp);
            request.getRequestDispatcher(newsJsp).forward(request, response);
        }
    }
}
