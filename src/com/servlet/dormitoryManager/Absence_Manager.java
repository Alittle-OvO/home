package com.servlet.dormitoryManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Absence_Check;
import com.service.Getlists;
import com.servlet.manager.Update_Building_Getlist;

/**
 * Servlet implementation class Absence_Manager
 */
@WebServlet("/Absence_Manager")
public class Absence_Manager extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ±‡¬Î…Ë÷√ */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		List<Absence_Check> list = new Getlists().getAbsence_Check(sid);
		
		request.setAttribute("list", list);
		request.setAttribute("sid", sid);
		
		request.getRequestDispatcher("Absence_Check_Manager.jsp").forward(request, response);
		
		
	}

}
