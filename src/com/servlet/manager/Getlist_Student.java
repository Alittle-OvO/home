package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.entity.Student;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_Student
 */
@WebServlet("/Getlist_Student")
public class Getlist_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Getlists getlists = new Getlists();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 获取学生list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 获取学生list */
		List<Student> list = getlists.getStudentList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Student.jsp").forward(request, response);
	}

}
