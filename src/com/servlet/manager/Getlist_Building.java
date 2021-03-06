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

/**
 * Servlet implementation class Getlist_Building
 */
@WebServlet("/Getlist_Building")
public class Getlist_Building extends HttpServlet {
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
	
	/* ??ȡ¥??list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ???????? */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* ??ȡ¥??list */
		List<Building> list = getlists.getBuildingList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Building.jsp").forward(request, response);
	}

}
