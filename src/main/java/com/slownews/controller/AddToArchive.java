package com.slownews.controller;

import com.slownews.converter.ArchiveNewsEntityConverter;
import com.slownews.dao.ArchiveNewsDao;
import com.slownews.dao.UserDAO;
import com.slownews.entity.ArchiveNewsEntity;
import com.slownews.entity.UserEntity;
import com.slownews.moxy.model.NewsItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addToArchive")
public class AddToArchive extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(AddToArchive.class);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getSession().getServletContext();
        List<NewsItem> newsItemList = (List<NewsItem>) context.getAttribute("articles");
        Integer index = Integer.parseInt(request.getParameter("index"));
        NewsItem newsItem = newsItemList.get(index);
        ArchiveNewsEntity news = new ArchiveNewsEntityConverter().covertNewsItemToArchiveNewsEntity(newsItem);
        ArchiveNewsDao archiveNewsDao = new ArchiveNewsDao();
        ArchiveNewsEntity newsDB = archiveNewsDao.getArchiveNewsEntityByTitle(news.getTitle());
        String login = (String) request.getSession().getAttribute("user");
        UserDAO userDAO = new UserDAO();
        UserEntity userEntity = userDAO.getUserByLogin(login);
        if (newsDB == null) {
            news.getUserEntities().add(userEntity);
            archiveNewsDao.create(news);
        } else {
            newsDB.getUserEntities().add(userEntity);
            archiveNewsDao.update(newsDB);
        }
        archiveNewsDao.close();
        userDAO.close();
        logger.info("service forward to " + "/");
        request.getRequestDispatcher("/").forward(request, response);
    }
}
