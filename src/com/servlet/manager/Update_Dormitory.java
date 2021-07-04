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
 * Servlet implementation class Update_Dormitory
 */
@WebServlet("/Update_Dormitory")
public class Update_Dormitory extends HttpServlet {
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
	
	/* 提交修改宿舍信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		int bid = Integer.parseInt(request.getParameter("building_name"));
		String dname = request.getParameter("did");
		String type = request.getParameter("type");
		String number = request.getParameter("number");
		String tel = request.getParameter("tel");
		
		
		HttpSession session = request.getSession();
		int result=0;

		result=updateMassage.Update_Dormitory(dname, type, number, tel, bid, uid);				

		if (result>0) {
			session.setAttribute("msg", "修改成功");
		}else {
			session.setAttribute("msg", "修改失败");
		}
		response.sendRedirect("Getlist_Dormitory");
	}

}
