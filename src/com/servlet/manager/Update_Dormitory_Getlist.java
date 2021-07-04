package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Building;
import com.entity.Building_Dormitory;
import com.service.Getlists;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Dormitory_Getlist
 */
@WebServlet("/Update_Dormitory_Getlist")
public class Update_Dormitory_Getlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage massage = new UpdateMassage();
	Getlists getlists = new Getlists();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 获取楼宇list-修改宿舍 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 获取信息 */
		int id = Integer.parseInt(request.getParameter("id"));
		
		/* 获取宿舍list ByID */
		List<Building_Dormitory> list = massage.getDormitoryListById(id);
		
		List<Building> blist = getlists.getBuildingList();
		request.setAttribute("list", blist);
		
		request.setAttribute("dormitory_id",id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Dormitory_Update.jsp").forward(request, response);
	}

}
