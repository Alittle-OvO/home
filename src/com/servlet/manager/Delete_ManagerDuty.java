package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DelectMassage;

/**
 * Servlet implementation class Delete_ManagerDuty
 */
@WebServlet("/Delete_ManagerDuty")
public class Delete_ManagerDuty extends HttpServlet {
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
	
	/* 删除宿舍管理员职务 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		int bid = Integer.parseInt(session.getAttribute("bid").toString());
		
		boolean result = new DelectMassage().DeleteManagerDuty(mid,bid);
		
		if (!result) {
			session.setAttribute("msg", "移除成功！");
		}else {
			session.setAttribute("msg", "移除失败！");
		}
		response.sendRedirect("Building_SetManager");
		
	}

}
