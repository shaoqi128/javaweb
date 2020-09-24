package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.ScoreDAO;
import cn.edu.lingnan.dto.Score;

public class ScoreDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ScoreDAO sd = new ScoreDAO();
		String uid = req.getParameter("uid");
		String pid = req.getParameter("pid");
		boolean flag = sd.deleteScore(uid, pid);
		if(flag)
			resp.sendRedirect(req.getContextPath()+"/admin/allShow.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error3.html");
		
	}
}
