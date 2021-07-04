package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Building_Dormitory;
import com.entity.Dormitory;
import com.entity.Student;
import com.service.AddMassage;

/**
 * Servlet implementation class Add_Dormitory
 */
@WebServlet("/Add_Dormitory")
public class Add_Dormitory extends HttpServlet {
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
	
	/* 添加宿舍 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*获取信息*/
		int dormitory_BuildingID = Integer.parseInt(request.getParameter("building_name"));
		String dormitory_Name = request.getParameter("did");
		String dormitory_Type = request.getParameter("type");
		String dormitory_Number = request.getParameter("number");
		String dormitory_Tel = request.getParameter("tel");
		
		Dormitory dormitory = new Dormitory(0, dormitory_BuildingID, dormitory_Name, dormitory_Type, dormitory_Number, dormitory_Tel);
				
		boolean result = addMassage.AddDormitory(dormitory);
		
		if (!result) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "添加成功！");
			response.sendRedirect("Getlist_Dormitory");
		}else {
			request.setAttribute("msg", "添加失败！");
			response.sendRedirect("Dormitory_Add.jsp");
		}
	}

}
