package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Manager
 */
@WebServlet("/Select_Manager")
public class Select_Manager extends HttpServlet {
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
	
	/* 查询管理员 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String select = request.getParameter("select");
		String thevalue = request.getParameter("value");
		
		List<Manager> list = new ArrayList<Manager>();
				
		if (thevalue==null) {
			request.getRequestDispatcher("Getlist_Manager").forward(request, response);
		}
		
		if (select.equals("Manager_Name")||select=="Manager_Name") {
			
			list = selectMassage.getManagerListByName(thevalue);				
		}else if (select.equals("Manager_Tel")||select=="Manager_Tel") {
			
			list = selectMassage.getManagerListByTel(thevalue);
		}else if(select.equals("Manager_Username")||select=="Manager_Username") {
			
			list = selectMassage.getManagerListByUsername(thevalue);
		}

		
		request.setAttribute("level", "1");
		request.setAttribute("select", select);	
		request.setAttribute("thevalue", thevalue);		
		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("Manager.jsp").forward(request, response);
		
		
	}

}
