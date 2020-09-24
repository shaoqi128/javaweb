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

@WebServlet(urlPatterns= "/admin/findallpro")
public class ProgramFindAllServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ProgramDAO pro = new ProgramDAO();
		Vector<Program> v = pro.findAllProgram();
		HttpSession session = req.getSession();
		session.setAttribute("allpro", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allPro.jsp");
	}
}
