package com.slownews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class Main extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info("service");

        if (request.getSession().getAttribute("user") != null) {
            logger.info("go to news");
            request.getRequestDispatcher("news").forward(request, response);

        } else {
            logger.info("go to signIn");
            request.getRequestDispatcher("signIn").forward(request, response);

        }
    }
}
