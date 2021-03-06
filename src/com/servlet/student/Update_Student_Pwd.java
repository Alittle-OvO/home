package com.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Manager;
import com.entity.Student;
import com.service.ToLogin;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Student_Pwd
 */
@WebServlet("/Update_Student_Pwd")
public class Update_Student_Pwd extends HttpServlet {
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
	
	/* ?޸????? */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ???????? */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String oldpwd = request.getParameter("oldpwd");
		String renewpwd = request.getParameter("renewpwd");
		
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("username").toString();
		
		Student student = new ToLogin().studentLogin(username, oldpwd);
		
		if (student!=null) {
			int result = new UpdateMassage().Update_Student_Pwd(username, renewpwd);
			
			if (result>0) {
				session.setAttribute("msg", "?????޸ĳɹ?");
			}else {
				session.setAttribute("msg", "?????޸?ʧ??");
			}			
		}else {
			session.setAttribute("msg", "ԭ???벻??ȷ");
		}
				
		response.sendRedirect("UpdatePwd_Student.jsp");
	}
	
}
