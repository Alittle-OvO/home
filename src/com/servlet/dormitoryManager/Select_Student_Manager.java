package com.servlet.dormitoryManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Student;
import com.entity.Student_Manager;
import com.service.Getlists;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Student_Manager
 */
@WebServlet("/Select_Student_Manager")
public class Select_Student_Manager extends HttpServlet {
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
	
	/* 查询学生信息 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 编码设置 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int did = 	Integer.parseInt(request.getParameter("did")) ;
		int msg = Integer.parseInt(request.getParameter("msg"));
		String txt = request.getParameter("txt");
		
		List<Student_Manager> list = new ArrayList<Student_Manager>();
				
		HttpSession session = request.getSession();
		int bid= Integer.parseInt(session.getAttribute("bid").toString());
		
		if (txt==null) {
			if (did==0) {
				/* 全部宿舍的学生 空 */
				list = new Getlists().getStudentList_Manager(bid);
			}else {
				/* 按宿舍id查询  空 */
				list = new SelectMassage().SelectStudentList_Manager(bid,did);
			}
		}else {
			if (did==0) {
				/* 全部宿舍 条件 */
				list = new SelectMassage().SelectStudentListByAllMsg_Manager(bid, msg, txt);
			}else {
				/* 宿舍id 条件 */
				list = new SelectMassage().SelectStudentListByMsg_Manager(bid, msg, txt, did);
			}
		}
		
		request.setAttribute("level", "1");
		request.setAttribute("did", did);	
		request.setAttribute("msg", msg);	
		request.setAttribute("txt", txt);		
		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("StudentList_Manager.jsp").forward(request, response);
		
	}

}
