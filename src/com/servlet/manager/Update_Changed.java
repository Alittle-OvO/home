package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Changed
 */
@WebServlet("/Update_Changed")
public class Update_Changed extends HttpServlet {
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
	
	/* �ύѧ������������Ϣ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("sid");
		int did = Integer.parseInt(request.getParameter("dname")) ;
		
		int result = new UpdateMassage().Update_Student_Change(username, did);
		
		HttpSession session = request.getSession();
		
		if (result>0) {
			session.setAttribute("msg", "���ҵ����ɹ���");
		}else {
			session.setAttribute("msg", "���ҵ���ʧ�ܣ�");
		}
		response.sendRedirect("Change.jsp");
		
		
	}

}
