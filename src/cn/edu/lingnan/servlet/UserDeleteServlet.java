package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.User;

public class UserDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//1
//		String uid = req.getParameter("uid");
//		//2
//		UserDAO ur = new UserDAO();
//		boolean flag = ur.deleteUser(uid);
//		Vector<User> v = ur.findAllUser();
//		HttpSession session = req.getSession();
//		session.setAttribute("alluser", v);
//		//3
//		if(flag) {
//			resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");
//		}else {
//			resp.sendRedirect(req.getContextPath()+"/error.html");
//		}
	}

}
