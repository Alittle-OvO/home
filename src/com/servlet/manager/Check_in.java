package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Building_Dormitory;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Check_in
 */
@WebServlet("/Check_in")
public class Check_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage updateMassage = new UpdateMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 学生入住-获取楼宇相对应的宿舍list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		
		List<Building_Dormitory> list = updateMassage.getDormitoryListByBuilding_Id(bid);
		request.setAttribute("listbybid", list);
		request.setAttribute("servletbid", bid);
		request.setAttribute("bname", list.get(0).getBuilding_Name());
		
		request.getRequestDispatcher("Check_in.jsp").forward(request, response);
	
	}
}
