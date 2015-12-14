package slownews.controller;

import ch.qos.logback.core.util.Loader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(LastNews.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        URL url = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");
        response.getWriter().print(new Moxy().getLastNewsTitle(url));
        logger.info(new Moxy().getLastNewsTitle(url) + " " + new Date());

    }
}
