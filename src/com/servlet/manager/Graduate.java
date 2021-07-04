package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;
import com.service.SelectMassage;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Graduate
 */
@WebServlet("/Graduate")
public class Graduate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SelectMassage selectMassage = new SelectMassage();
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
	
	/* 获取学生信息-学生毕业 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String student_username = request.getParameter("sid");
		
		List<Student> list = selectMassage.SelectStudentByUsername(student_username);
		request.setAttribute("listbyusername", list);
		request.setAttribute("servletusername", student_username);
		
		HttpSession session = request.getSession();
		
		if (list.size()<=0) {
			session.setAttribute("msg","该学号学生不存在！");
			response.sendRedirect("Graduation.jsp");
		}else{
			request.setAttribute("sid", list.get(0).getStudent_ID());
			
			String bname=updateMassage.getDormitoryListById(list.get(0).getStudent_Dormitory()).get(0).getBuilding_Name();
			String dname=updateMassage.getDormitoryListById(list.get(0).getStudent_Dormitory()).get(0).getDormitory_Name();
			
			request.setAttribute("student_id", list.get(0).getStudent_ID());
			request.setAttribute("student_username", list.get(0).getStudent_Username());
			request.setAttribute("student_name", list.get(0).getStudent_Name());
			request.setAttribute("student_sex", list.get(0).getStudent_Sex());
			request.setAttribute("bname", bname);
			request.setAttribute("dname", dname);
			
			request.getRequestDispatcher("Graduate.jsp").forward(request, response);
		}			
		
		
		
	}

}
