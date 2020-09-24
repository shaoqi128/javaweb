package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.User;

public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ArrayList<String> usernamelist = new ArrayList<String>();
		String uid = req.getParameter("uid");
		String username = req.getParameter("username");
		String password = req.getParameter("password1");
		String superuser = req.getParameter("superuser");
		User u = new User();
		UserDAO ur = new UserDAO();
		usernamelist = ur.findAllUserName();
		if(usernamelist.contains(username)) {
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}else {
			u.setUid(uid);
			u.setUname(username);
			u.setPassword(password);
			u.setSuperuser(Integer.parseInt(superuser));
			boolean flag = ur.insertInfoToUser(u);
			if(flag)
				resp.sendRedirect(req.getContextPath()+"/index.html");
			else
				resp.sendRedirect(req.getContextPath()+"/register.html");
		}
	}

}
