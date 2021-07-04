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
 * Servlet implementation class Delete_Dormitory
 */
@WebServlet("/Delete_Dormitory")
public class Delete_Dormitory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DelectMassage delectMassage = new DelectMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ɾ������ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*��ȡ��Ϣ*/
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean result = delectMassage.DeleteDormitory(id);
		HttpSession session = request.getSession();
		
		if (!result) {			
			session.setAttribute("msg", "ɾ���ɹ���");
			
		}else {
			session.setAttribute("msg", "ɾ��ʧ�ܣ�");
		}
		response.sendRedirect("Getlist_Dormitory");
	}

}
