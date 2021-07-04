package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Building;
import com.entity.Manager;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Building
 */
@WebServlet("/Select_Building")
public class Select_Building extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SelectMassage selectMassage = new SelectMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ≤È—Ø¬•”Ó */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ±‡¬Î…Ë÷√ */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String bname = request.getParameter("bname");		
				
		if (bname==null) {
			request.getRequestDispatcher("Getlist_Building").forward(request, response);
		}
		
		List<Building> list = selectMassage.getBuildingListByName(bname);
		
		request.setAttribute("level", "1");
		request.setAttribute("bname", bname);		
		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("Building.jsp").forward(request, response);
		
	}

}
