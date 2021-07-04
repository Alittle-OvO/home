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
 * Servlet implementation class Update_Manager
 */
@WebServlet("/Update_Manager")
public class Update_Manager extends HttpServlet {
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
	
	/* 提交修改宿舍管理员信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		String username = request.getParameter("username");
		String pwd = request.getParameter("repwd");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		
		HttpSession session = request.getSession();
		int result=0;
		
		if (!pwd.equals("")) {
			/* 更改密码 */
			result=updateMassage.Update_Manager_NeedPwd(username, pwd, name, sex, tel, uid);						
		}else {
			/* 不更改密码 */
			result=updateMassage.Update_Manager_NoPwd(username, name, sex, tel, uid);
		}
		
		if (result>0) {
			session.setAttribute("msg", "修改成功");
		}else {
			session.setAttribute("msg", "修改失败");
		}
		response.sendRedirect("Manager.jsp"); 
		
	}

}
