package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.entity.Student;
import com.service.Getlists;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Student
 */
@WebServlet("/Select_Student")
public class Select_Student extends HttpServlet {
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
	
	/* 查询学生 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String status = request.getParameter("status");
		int msg = Integer.parseInt(request.getParameter("msg"));
		String txt = request.getParameter("txt");
		
		List<Student> list = new ArrayList<Student>();
				
		if (txt==null) {
			if (status.equals("全部学生")||status=="全部学生") {
				list = new Getlists().getStudentList();;
				
			}else {
				list = selectMassage.SelectStudentByStatus(status);
			}
		}else {
			if (msg==1) {
				list = selectMassage.SelectStudentByStatusAndName(status, txt);
			}else if (msg==2) {
				list = selectMassage.SelectStudentByStatusAndUsername(status, txt);
			}else{
				list = selectMassage.SelectStudentByStatusAndTel(status, txt);
			}
		}
		
		request.setAttribute("level", "1");
		request.setAttribute("status", status);	
		request.setAttribute("themsg", msg);	
		request.setAttribute("txt", txt);		
		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("Student.jsp").forward(request, response);
	}

}
