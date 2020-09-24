package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.Program;

public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ScoreDAO sc = new ScoreDAO();
		Vector<Program> v = sc.findAllProgram();
		HttpSession session = req.getSession();
		session.setAttribute("allprog", v);
		resp.sendRedirect(req.getContextPath()+"/findProgram.jsp");
	}
}
