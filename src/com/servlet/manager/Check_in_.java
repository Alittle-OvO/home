package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.SelectMassage;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Check_in_
 */
@WebServlet("/Check_in_")
public class Check_in_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage updateMassage = new UpdateMassage();
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
	
	/* ѧ����ס */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String sid = request.getParameter("sid");
		String bname = request.getParameter("bname");
		
		int did= Integer.parseInt( request.getParameter("dname"));
		
		int result = updateMassage.Student_check_in(sid, did);
		HttpSession session = request.getSession();
		
		if (result>0) {		
			session.setAttribute("msg","ѧ����ס�ɹ�");					
		}else {
			session.setAttribute("msg","ѧ�������ڻ�����ס");			
		}
		response.sendRedirect("Check_in.jsp");
		
		
	}

}
