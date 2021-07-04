package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.entity.Manager;
import com.service.AddMassage;

/**
 * Servlet implementation class Add_Manager
 */
@WebServlet("/Add_Manager")
public class Add_Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AddMassage addMassage = new AddMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ��ӹ���Ա */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*��ȡ��Ϣ*/
		String manager_Username = request.getParameter("username");
		String manager_Password = request.getParameter("pwd");
		String manager_Name = request.getParameter("name");
		String manager_Sex = request.getParameter("sex");
		String manager_Tel = request.getParameter("tel");
		
		Manager manager = new Manager(0, manager_Username, manager_Password, manager_Name, manager_Sex, manager_Tel);
		
		boolean result = addMassage.AddManager(manager);
		
		if (!result) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "��ӳɹ���");
			response.sendRedirect("Manager.jsp");
		}else {
			request.setAttribute("msg", "���ʧ�ܣ�");
			response.sendRedirect("Manager_Add.jsp");
		}
	}

}
