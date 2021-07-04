package com.servlet.dormitoryManager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Building;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_ManagerDuty_Student
 */
@WebServlet("/Getlist_ManagerDuty_Student")
public class Getlist_ManagerDuty_Student extends HttpServlet {
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
	
	/* ��ȡ����Ա�����¥��list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		/* ��¼�˺�ʱ��������id */
		int uid =Integer.parseInt(session.getAttribute("uid").toString());
		
		List<Building> list = new Getlists().getBuildingName_ManagerDuty(uid);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("Student_Manager.jsp").forward(request, response);
	}

}
