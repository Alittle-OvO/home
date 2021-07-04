package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Manager;
import com.service.Getlists;

/**
 * Servlet implementation class Building_SetManager
 */
@WebServlet("/Building_SetManager")
public class Building_SetManager extends HttpServlet {
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
	
	/* 楼宇设置宿舍管理员 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		int bid=0;
		if (request.getParameter("bid")==null) {
			bid = Integer.parseInt(session.getAttribute("bid").toString());
			session.setAttribute("bid", bid);
		}else {
			bid = Integer.parseInt(request.getParameter("bid"));
			session.setAttribute("bid", bid);
		}
		
		List<Manager> list = new Getlists().getManagerDutyList(bid);
		
		request.setAttribute("bid", bid);
		request.getRequestDispatcher("BuildingManager_Setting.jsp").forward(request, response);
	}

}
