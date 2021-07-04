package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Absence_Student;
import com.entity.Student;
import com.service.SelectMassage;

/**
 * Servlet implementation class Getlist_Absence
 */
@WebServlet("/Getlist_Absence")
public class Getlist_Absence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	
	/* 获取缺寝list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String student_username = request.getParameter("sid");
		
		List<Student> list = selectMassage.SelectStudentByUsername(student_username);
		
		HttpSession session = request.getSession();
		
		if (list.size()<=0) {
			session.setAttribute("msg","该学号学生不存在！");
			response.sendRedirect("Absence.jsp");
		}else{
			List<Absence_Student> list_absence= new SelectMassage().SelectAbsence(student_username);
			
			request.setAttribute("list", list_absence);
			request.setAttribute("servletusername", student_username);
			
			request.getRequestDispatcher("Absence_in.jsp").forward(request, response);
		}			
	}

}
