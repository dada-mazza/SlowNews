package com.slownews.controller;

import com.slownews.moxy.Moxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@WebServlet("/lastNews")
public class LastNews extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(LastNews.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
        File file = new File("d:\\OneDrive\\Projects\\Infopulse\\SlowNews\\garbage\\news.xml");

        String lastNewsTitle = null;
        try {
            lastNewsTitle = new Moxy().getLastNewsTitle(url);
        } catch (JAXBException e) {
            logger.error(e.getMessage());
            lastNewsTitle = new Moxy().getLastNewsTitle(file);
        }
        response.getWriter().print(lastNewsTitle);
    }
}
