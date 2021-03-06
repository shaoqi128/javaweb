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
import cn.edu.lingnan.dto.Program;

@WebServlet("/admin/addpro")
public class ProgramInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		String name = req.getParameter("pname");
		String showtime = req.getParameter("showtime");
		System.out.println(pid+"   "+name+"   "+showtime);
		Program p = new Program();
		p.setPid(pid);
		p.setPname(name);
		p.setShowtime(showtime);
		ProgramDAO pro = new ProgramDAO();
		boolean flag = pro.insertInfoToProgram(p);
		Vector<Program> v = pro.findAllProgram();
		HttpSession session = req.getSession();
		session.setAttribute("allpro", v);
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/admin/allPro.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/admin/addPro.jsp");
	}
}
