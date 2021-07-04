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
 * Servlet implementation class Update_Student
 */
@WebServlet("/Update_Student")
public class Update_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage updateMassage = new UpdateMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* �ύ�޸�ѧ����Ϣ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("sid");
		String pwd = request.getParameter("repwd");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String classes = request.getParameter("classes");
		
		HttpSession session = request.getSession();
		int result=0;
		if (!"".equals(pwd)) {
			result=updateMassage.Update_Student_NeedPwd(username, pwd, name, sex, classes, uid);		
		}else {
			result=updateMassage.Update_Student_NoPwd(username, pwd, name, sex, classes, uid);		
		}
		
		if (result>0) {
			session.setAttribute("msg", "�޸ĳɹ�");
		}else {
			session.setAttribute("msg", "�޸�ʧ��");
		}
		
		response.sendRedirect("Student.jsp");
	}

}
