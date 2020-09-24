package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ProgramDAO;
import cn.edu.lingnan.dao.UserDAO;
import cn.edu.lingnan.dto.Program;
import cn.edu.lingnan.dto.User;

@WebServlet(urlPatterns= {"/admin/updatePro"})
public class ProgramUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String f = req.getParameter("f");
		boolean flag = false;
		ProgramDAO pro = new ProgramDAO();
		if(f==null) {//修改
			String pid = req.getParameter("pid");
			String name = req.getParameter("name");
			String showtime = req.getParameter("showtime");
			System.out.println(" ### "+pid+"   "+name+"   "+showtime);
			Program _p = new Program();
			_p.setPid(pid);
			_p.setPname(name);
			_p.setShowtime(showtime);
			pro = new ProgramDAO();
			pro.updateStu(_p);
			flag = true;
		}else {//删除
			if(f.equals("delpro")) {//批量删除
				String[] allpid = req.getParameterValues("allpid");
				String[] temp = allpid[0].split(",");
				for(String a : temp) {
					pro.deletePro(a);
				}
				flag = true;
			}else {//删除一条记录
				String pid = req.getParameter("pid");
				flag = pro.deletePro(pid);
			}
		}	
		Vector<Program> v = pro.findAllProgram();
		HttpSession session = req.getSession();
		session.setAttribute("allpro", v);
		if(flag) {
			resp.sendRedirect(req.getContextPath()+"/admin/allPro.jsp");
		}else {
			resp.sendRedirect(req.getContextPath()+"/error3.html");
		}
//		String pid = req.getParameter("pid");
//		String name = req.getParameter("name");
//		String showtime = req.getParameter("showtime");
//		System.out.println(" ### "+pid+"   "+name+"   "+showtime);
//		Program _p = new Program();
//		_p.setPid(pid);
//		_p.setPname(name);
//		_p.setShowtime(showtime);
//		ProgramDAO pro = new ProgramDAO();
//		pro.updateStu(_p);
//		Vector<Program> v = pro.findAllProgram();
//		HttpSession session = req.getSession();
//		session.setAttribute("allpro", v);
//		resp.sendRedirect(req.getContextPath()+"/admin/allPro.jsp");
	}
}
