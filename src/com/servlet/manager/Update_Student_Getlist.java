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
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Student_Getlist
 */
@WebServlet("/Update_Student_Getlist")
public class Update_Student_Getlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UpdateMassage massage = new UpdateMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* 获取修改的学生信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* 获取信息 */
		int id = Integer.parseInt(request.getParameter("id"));
		
		/* 获取管理员list ByID */
		List<Student> list = massage.getStudentListByID(id);
		request.setAttribute("student_id",id);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Student_Update.jsp").forward(request, response);
	}

}
