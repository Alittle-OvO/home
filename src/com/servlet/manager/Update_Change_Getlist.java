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
 * Servlet implementation class Update_Change_Getlist
 */
@WebServlet("/Update_Change_Getlist")
public class Update_Change_Getlist extends HttpServlet {
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
	
	/* 获取换宿舍的学生信息 */
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
			response.sendRedirect("Change.jsp");
		}else{
			request.setAttribute("sid", list.get(0).getStudent_ID());
			
			int sd = list.get(0).getStudent_Dormitory();
			String bname=updateMassage.getDormitoryListById(sd).get(0).getBuilding_Name();
			String dname=updateMassage.getDormitoryListById(sd).get(0).getDormitory_Name();
			request.setAttribute("bname", bname);
			request.setAttribute("dname", dname);
			
			request.getRequestDispatcher("Change_Update.jsp").forward(request, response);
		}							
	}

}
