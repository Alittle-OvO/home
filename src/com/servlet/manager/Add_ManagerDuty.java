package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AddMassage;

/**
 * Servlet implementation class Add_ManagerDuty
 */
@WebServlet("/Add_ManagerDuty")
public class Add_ManagerDuty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 添加宿舍管理员职务 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		session.setAttribute("bid", bid);
		if (mid==0) {
			session.setAttribute("msg", "请添加的选择管理员！");
		}else {
			boolean result = new AddMassage().AddManagerDuty(bid, mid);
			if (!result) {
				session.setAttribute("msg", "添加成功！");
			}else {
				session.setAttribute("msg", "添加失败！");
			}
		}
		response.sendRedirect("Building_SetManager");
		
	}

}
