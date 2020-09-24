package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.ScoreDAO;

public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ScoreDAO sc = new ScoreDAO();
		String uid = req.getParameter("uid");
		String pid = req.getParameter("pid");
		System.out.println(uid+"  "+pid);
		boolean flag = sc.deleteScore(uid, pid);
//		if(flag)
//			System.out.println("ok");
//		else
//			System.out.println("asd");
		resp.sendRedirect(req.getContextPath()+"/joinProgram.jsp");
	}

}
