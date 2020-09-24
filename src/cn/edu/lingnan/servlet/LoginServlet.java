package cn.edu.lingnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1从页面拿参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+"  ---  "+password);
		//2处理数据，可能需要访问数据库
		HttpSession s = req.getSession();	
		UserDAO ur = new UserDAO();
		int flag = ur.findUserByNameAndPassword(username, password);
		s.setAttribute("usersuper", flag);
		String id = ur.findStudentByNameAndPassword2(username);
		s.setAttribute("uid", id);
		//3返回客户端
		if(flag!=0)
			resp.sendRedirect(req.getContextPath()+"/ok.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
