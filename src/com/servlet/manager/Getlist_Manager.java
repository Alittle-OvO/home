package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Manager;
import com.service.Getlists;

/**
 * Servlet implementation class Getlist_Manager
 */
@WebServlet("/Getlist_Manager")
public class Getlist_Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Getlists getlists = new Getlists();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ��ȡ����Աlist */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/* ��ȡ����Աlist */
		List<Manager> list = getlists.getManagerList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("Manager.jsp").forward(request, response);
		
	}

}
