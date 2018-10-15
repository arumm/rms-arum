package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getTemplatePath(req.getServletPath());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getTemplatePath(req.getServletPath() + req.getPathInfo());

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao userDao = UserDaoImpl.getInstance();
        Optional<User> users = userDao.loginUser(name, password);

        if (users.isPresent()) {
            req.setAttribute("users", users);
            HttpSession session = req.getSession();
            session.setAttribute("name", name);
            resp.sendRedirect("users/list");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
