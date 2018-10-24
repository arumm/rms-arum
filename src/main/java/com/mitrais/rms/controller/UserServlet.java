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
import java.util.List;
import java.util.Optional;

@WebServlet("/users/*")
public class UserServlet extends AbstractController {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = getTemplatePath(req.getServletPath() + req.getPathInfo());
		try {
			UserDao userDao = UserDaoImpl.getInstance();
			if ("/list".equalsIgnoreCase(req.getPathInfo())) {
				List<User> users = userDao.findAll();
				req.setAttribute("users", users);
			} else if ("/add".equalsIgnoreCase(req.getPathInfo())) {
				path = getTemplatePath(req.getServletPath() + "/form");
			} else if ("/edit".equalsIgnoreCase(req.getPathInfo())) {
				String idTemp = req.getParameter("id");
				if (idTemp == null || idTemp == "") {
					String errMsg = "Id not found";
					req.setAttribute("msg", errMsg);
					List<User> users = userDao.findAll();
					req.setAttribute("users", users);
					path = getTemplatePath(req.getServletPath() + "/list");
				} else {
					Optional<User> userEdit = userDao.find(Long.parseLong(idTemp));
					if (userEdit.isPresent()) {
						User user = userEdit.get();
						req.setAttribute("users", user);
					}
					path = getTemplatePath(req.getServletPath() + "/form");
				}
			} else if ("/del".equalsIgnoreCase(req.getPathInfo())) {
				String idTemp = req.getParameter("id");
				if (idTemp == null || idTemp == "") {
					String errMsg = "Id not found";
					req.setAttribute("msg", errMsg);
				} else {
					Optional<User> userDel = userDao.find(Long.parseLong(idTemp));
					if (userDel.isPresent()) {
						User user = userDel.get();
						userDao.delete(user);
					}
				}
				List<User> userList = userDao.findAll();
				req.setAttribute("users", userList);
				path = getTemplatePath(req.getServletPath() + "/list");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if ("/form".equalsIgnoreCase(req.getPathInfo())) {
				String name = req.getParameter("username");
				String password = req.getParameter("password");
				String id = req.getParameter("id");
				UserDao userDao = UserDaoImpl.getInstance();
				if (id == null || id.equals("")) {
					User user = new User(null, name, password);
					userDao.save(user);
				} else {
					User user = new User(Long.parseLong(id), name, password);
					userDao.update(user);
				}
				resp.sendRedirect("list");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}