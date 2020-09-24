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

@WebServlet(urlPatterns="/admin/updateUser")
public class UserUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f = req.getParameter("f");
		boolean flag = false;
		UserDAO ur = new UserDAO();
		if(f==null) {//修改
			String uid = req.getParameter("uid");
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String superuser = req.getParameter("superuser");
			System.out.println(" ### "+uid+"   "+name+"   "+password+"   "+superuser);
			User _u = new User();
			_u.setUid(uid);
			_u.setUname(name);
			_u.setPassword(password);
			_u.setSuperuser(Integer.parseInt(superuser));
			ur = new UserDAO();
			flag = ur.updateUser(_u);
		}else {//删除
			if(f.equals("delall")) {//批量删除
				String[] alluid = req.getParameterValues("alluid");
				String[] temp = alluid[0].split(",");
				for(String a : temp) {
					ur.deleteUser(a);
				}
				flag = true;
			}else {//删除一条记录
				String uid = req.getParameter("uid");
				flag = ur.deleteUser(uid);
			}
		}	
		Vector<User> v = ur.findAllUser();
		HttpSession session = req.getSession();
		session.setAttribute("alluser", v);
		if(flag) {
			resp.sendRedirect(req.getContextPath()+"/admin/allUser.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error3.html");
		}
	}

}
