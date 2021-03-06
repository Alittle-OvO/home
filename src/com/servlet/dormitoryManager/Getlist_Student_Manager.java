package com.servlet.dormitoryManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;
import com.entity.Student_Manager;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_Student_Manager
 */
@WebServlet("/Getlist_Student_Manager")
public class Getlist_Student_Manager extends HttpServlet {
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
	
	/* 获取学生list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		int bid=0;
		if (request.getParameter("bid")==null) {
			bid =Integer.parseInt(session.getAttribute("bid").toString()) ;
		}else {
			bid =Integer.parseInt(request.getParameter("bid"));
			session.setAttribute("bid", bid);
		}
		
		List<Student_Manager> list = new Getlists().getStudentList_Manager(bid);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("StudentList_Manager.jsp").forward(request, response);
		
		
	}

}
