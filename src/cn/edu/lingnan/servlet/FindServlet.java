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

public class FindServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uid = null;
		ScoreDAO sc = new ScoreDAO();
		HttpSession session = req.getSession();
		uid = (String)session.getAttribute("uid");
		System.out.println(uid);
		Vector<Score> v = sc.findScore(uid);
		HttpSession session1 = req.getSession();
		session1.setAttribute("findpro1", v);
		resp.sendRedirect(req.getContextPath()+"/joinProgram.jsp");
	}
}
