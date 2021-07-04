package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Building;
import com.entity.Student;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Building_Getlist
 */
@WebServlet("/Update_Building_Getlist")
public class Update_Building_Getlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage massage = new UpdateMassage();

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 获取修改的楼宇信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 获取信息 */
		int id = Integer.parseInt(request.getParameter("id"));
		
		/* 获取楼宇list ByID */
		List<Building> list = massage.getBuildingListById(id);
		request.setAttribute("building_id",id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Building_Update.jsp").forward(request, response);
	}

}
