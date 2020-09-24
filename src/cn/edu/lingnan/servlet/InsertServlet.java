package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.Program;
import cn.edu.lingnan.dto.Score;

public class InsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String uid = null;
		String pid = req.getParameter("pid");
		ScoreDAO sc = new ScoreDAO();
		HttpSession session = req.getSession();
		uid = (String)session.getAttribute("uid");
		System.out.println(uid+"  "+pid);
		Score _s = new Score();
		_s.setUid(uid);
		_s.setPid(pid);
		sc.insertInfoToScore(_s);
		resp.sendRedirect(req.getContextPath()+"/findProgram.jsp");
	}
}
