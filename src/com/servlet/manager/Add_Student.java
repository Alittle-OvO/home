package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Manager;
import com.entity.Student;
import com.service.AddMassage;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/Add_Student")
public class Add_Student extends HttpServlet {
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
	
	/* ���ѧ�� */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*��ȡ��Ϣ*/
		String student_Username = request.getParameter("sid");
		String student_Password = request.getParameter("pwd");
		String student_Name = request.getParameter("name");
		String student_Sex = request.getParameter("sex");
		String student_Class = request.getParameter("classes");
		
		Student student = new Student(0, 0, student_Username, student_Password, student_Name, student_Sex, student_Class, null);
		
		boolean result = addMassage.AddStudent(student);
		
		if (!result) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "��ӳɹ���");
			response.sendRedirect("Student.jsp");
		}else {
			request.setAttribute("msg", "���ʧ�ܣ�");
			response.sendRedirect("Student_Add.jsp");
		}
	}

}
