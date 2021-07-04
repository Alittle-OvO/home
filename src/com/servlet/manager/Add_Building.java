package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Building;
import com.entity.Student;
import com.service.AddMassage;

/**
 * Servlet implementation class Add_Building
 */
@WebServlet("/Add_Building")
public class Add_Building extends HttpServlet {
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
	
	/* 添加楼宇 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*获取信息*/
		String building_Name = request.getParameter("building_name");
		String building_Introduction = request.getParameter("area");
		
		Building building = new Building(0, building_Name, building_Introduction);
		
		boolean result = addMassage.AddBuilding(building);
		
		if (!result) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "添加成功！");
			response.sendRedirect("Building.jsp");
		}else {
			request.setAttribute("msg", "添加失败！");
			response.sendRedirect("Student_Add.jsp");
		}
	}

}
