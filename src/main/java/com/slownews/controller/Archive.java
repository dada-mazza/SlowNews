package com.slownews.controller;

import com.slownews.dao.ArchiveNewsDao;
import com.slownews.dao.UserDAO;
import com.slownews.entity.ArchiveNewsEntity;
import com.slownews.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/archive")
public class Archive extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("/").forward(request, response);
        } else {
            UserDAO userDAO = new UserDAO();
            String login = (String) request.getSession().getAttribute("user");
            UserEntity user = userDAO.getUserByLogin(login);
            ArchiveNewsDao dao = new ArchiveNewsDao();
            List<ArchiveNewsEntity> articles = dao.getAllArchiveNewsesForUser(user.getId());
            request.setAttribute("articles", articles);
            userDAO.close();
            dao.close();
            request.getRequestDispatcher("/WEB-INF/view/archive.jsp").forward(request, response);
        }
    }
}
