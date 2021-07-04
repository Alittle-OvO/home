package com.servlet.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.AddMassage;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Graduated
 */
@WebServlet("/Graduated")
public class Graduated extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AddMassage addMassage = new AddMassage();
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
	
	/* 提交学生毕业信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String thedate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String username = request.getParameter("username");
		int sid = Integer.parseInt(request.getParameter("sid")) ;
		String remark = request.getParameter("area");
		
		boolean result = addMassage.AddGraduation(sid, thedate, remark);
		int flag = updateMassage.Update_Student_Graduate(username);
		
		HttpSession session = request.getSession();
		
		if (!result) {		
			session.setAttribute("msg","学生迁出成功");					
		}else {
			session.setAttribute("msg","学生不存在或已入迁出");			
		}
		response.sendRedirect("Graduation.jsp");
		
		
	}

}
