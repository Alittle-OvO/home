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
import com.entity.Dormitory;
import com.entity.Manager;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_Dormitory
 */
@WebServlet("/Getlist_Dormitory")
public class Getlist_Dormitory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	
	/* 获取宿舍list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 获取宿舍list */
		List<Building_Dormitory> list = getlists.getDormitoryList();
		List<Building> blist = getlists.getBuildingList();
		
		request.setAttribute("list", list);
		request.setAttribute("blist", blist);
		request.getRequestDispatcher("Dormitory.jsp").forward(request, response);
	}

}
