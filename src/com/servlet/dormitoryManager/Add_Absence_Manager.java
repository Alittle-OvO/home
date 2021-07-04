package com.servlet.dormitoryManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AddMassage;

/**
 * Servlet implementation class Add_Absence_Manager
 */
@WebServlet("/Add_Absence_Manager")
public class Add_Absence_Manager extends HttpServlet {
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
	
	/* ���ȱ�޼�¼ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int sid = Integer.parseInt(request.getParameter("sid"));
		int mid = Integer.parseInt(request.getParameter("mid"));
		String date = request.getParameter("date");
		String area = request.getParameter("area");
		
		boolean result = new AddMassage().AddAbsence(sid, mid, date, area);
		
		HttpSession session = request.getSession();
		
		if (!result) {
			session.setAttribute("msg", "�ύ�ɹ���");
		}else {
			session.setAttribute("msg", "�ύʧ�ܣ�");
		}
		
		response.sendRedirect("Getlist_Student_Manager");
	}

}
