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

@WebServlet(urlPatterns="/admin/findall")
public class UserFindAllServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1获取信息(不用做)
		//2处理信息(找出所有的用户信息)
		UserDAO ur = new UserDAO();
		Vector<User> v = ur.findAllUser();
		HttpSession session = req.getSession();
		session.setAttribute("alluser", v);
		//3返回页面
		resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");
	}
	
}
