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
		//1��ҳ���ò���
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username+"  ---  "+password);
		//2�������ݣ�������Ҫ�������ݿ�
		HttpSession s = req.getSession();	
		UserDAO ur = new UserDAO();
		int flag = ur.findUserByNameAndPassword(username, password);
		s.setAttribute("usersuper", flag);
		String id = ur.findStudentByNameAndPassword2(username);
		s.setAttribute("uid", id);
		//3���ؿͻ���
		if(flag!=0)
			resp.sendRedirect(req.getContextPath()+"/ok.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
	}
}
