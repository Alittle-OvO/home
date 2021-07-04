package com.servlet.Login_Register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Admin;
import com.entity.Manager;
import com.entity.Student;
import com.service.ToLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ToLogin toLogin = new ToLogin();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ��¼��֤ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String select = request.getParameter("select");
		
		try {	
			 if (select!=null&&username!=null&&pwd!=null) { 
				if (select.equals("1")) {	
					/* ��������Ա */
					Admin admin = toLogin.adminLogin(username, pwd);
					
					if (admin != null) {
						HttpSession session = request.getSession();
						session.setAttribute("admin", admin);
						session.setAttribute("username", username);
						session.setAttribute("uid", admin.getAdmin_ID());
						
						request.getRequestDispatcher("Backstage.jsp").forward(request, response);
					}else {
						request.setAttribute("error", "�û��������벻��ȷ��");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
									
				}else if (select.equals("2")) {
					/* �������Ա */
					Manager manager = toLogin.managerLogin(username, pwd);	
					
					if (manager != null) {
						HttpSession session = request.getSession();
						session.setAttribute("manager", manager);
						session.setAttribute("username", username);
						session.setAttribute("uid", manager.getManager_ID());
						
						request.getRequestDispatcher("Backstage_Manager.jsp").forward(request, response);
					}else {
						request.setAttribute("error", "�û��������벻��ȷ��");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}					
				
				}else if(select.equals("3")) {
					/* ѧ�� */
					Student student = toLogin.studentLogin(username, pwd);
					
					if (student != null) {
						HttpSession session = request.getSession();
						session.setAttribute("student", student);
						session.setAttribute("username", username);
						session.setAttribute("uid", student.getStudent_ID());
						
						request.getRequestDispatcher("Backstage_Student.jsp").forward(request, response);
					}else {
						request.setAttribute("error", "�û��������벻��ȷ��");
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
					
				}else if (select.equals("0")||select==null){
					
					request.setAttribute("error", "��ѡ���������Ȼ���ٵ�¼��");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}					
			}else if((username.trim()).equals("")||(pwd.trim()).equals("")||(select.trim().equals(""))||username==null||pwd==null||select==null){	
				
				request.setAttribute("error", "�˺Ż����벻��Ϊ�գ�");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "	�����쳣��");
			request.getRequestDispatcher("Login.jsp").forward(request, response); 
		}
		
		
		
	}

}
