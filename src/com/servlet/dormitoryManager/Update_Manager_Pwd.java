package com.servlet.dormitoryManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.entity.Manager;
import com.service.ToLogin;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Manager_Pwd
 */
@WebServlet("/Update_Manager_Pwd")
public class Update_Manager_Pwd extends HttpServlet {
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
	
	/* 修改密码 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String oldpwd = request.getParameter("oldpwd");
		String renewpwd = request.getParameter("renewpwd");
		
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("username").toString();
		
		Manager manager = new ToLogin().managerLogin(username, oldpwd);
		
		if (manager!=null) {
			int result = new UpdateMassage().Update_Manager_Pwd(username, renewpwd);
			
			if (result>0) {
				session.setAttribute("msg", "密码修改成功");
			}else {
				session.setAttribute("msg", "密码修改失败");
			}			
		}else {
			session.setAttribute("msg", "原密码不正确");
		}
				
		response.sendRedirect("UpdatePwd_Manager.jsp");
	}

}
