package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DelectMassage;

/**
 * Servlet implementation class Delete_ManagerDuty
 */
@WebServlet("/Delete_ManagerDuty")
public class Delete_ManagerDuty extends HttpServlet {
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
	
	/* ɾ���������Աְ�� */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		int mid = Integer.parseInt(request.getParameter("mid"));
		int bid = Integer.parseInt(session.getAttribute("bid").toString());
		
		boolean result = new DelectMassage().DeleteManagerDuty(mid,bid);
		
		if (!result) {
			session.setAttribute("msg", "�Ƴ��ɹ���");
		}else {
			session.setAttribute("msg", "�Ƴ�ʧ�ܣ�");
		}
		response.sendRedirect("Building_SetManager");
		
	}

}
