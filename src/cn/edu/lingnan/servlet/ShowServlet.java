package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.Score;

public class ShowServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScoreDAO sd = new ScoreDAO();
		Vector<Score> v = sd.findAllScore();
		HttpSession session1 = req.getSession();
		session1.setAttribute("findshow", v);
		resp.sendRedirect(req.getContextPath()+"/admin/allShow.jsp");
	}
}
