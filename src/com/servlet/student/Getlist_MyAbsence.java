package com.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Absence_Student;
import com.entity.Graduation_Student;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_MyAbsence
 */
@WebServlet("/Getlist_MyAbsence")
public class Getlist_MyAbsence extends HttpServlet {
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
	
	/* ��ȡ�ҵ�ȱ�޼�¼list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* ��ȡѧ��list */
		HttpSession session = request.getSession();
		int uid = Integer.parseInt(session.getAttribute("uid").toString()) ;
		List<Absence_Student> list = new Getlists().GetMyAbsenceList(uid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("Absence_Student.jsp").forward(request, response);
	}

}
