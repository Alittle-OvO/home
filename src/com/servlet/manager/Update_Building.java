package com.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Building
 */
@WebServlet("/Update_Building")
public class Update_Building extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
	
	/* 提交楼宇修改信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String bname = request.getParameter("building_name");
		String area = request.getParameter("area");
		
		HttpSession session = request.getSession();
		int result=0;

		result=updateMassage.Update_Building(bname, area, uid);				

		if (result>0) {
			session.setAttribute("msg", "修改成功");
		}else {
			session.setAttribute("msg", "修改失败");
		}
		response.sendRedirect("Building.jsp");
		
	}

}
