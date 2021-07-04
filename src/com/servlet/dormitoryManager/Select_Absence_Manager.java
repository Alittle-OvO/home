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

import com.entity.Absence_Manager;
import com.service.Getlists;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Absence_Manager
 */
@WebServlet("/Select_Absence_Manager")
public class Select_Absence_Manager extends HttpServlet {
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
	
	/* ��ѯѧ��ȱ����Ϣ */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* �������� */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int did = 	Integer.parseInt(request.getParameter("did")) ;
		int msg = Integer.parseInt(request.getParameter("msg"));
		String txt = request.getParameter("txt");
		
		List<Absence_Manager> list = new ArrayList<Absence_Manager>();
				
		HttpSession session = request.getSession();
		int bid= Integer.parseInt(session.getAttribute("bid").toString());
		
		if (txt==null) {
			if (did==0) {
				/* ȫ�������ѧ�� �� */
				list = new Getlists().getAbsenceList_Manager(bid);
			}else {
				/* ������id��ѯ  �� */
				list = new SelectMassage().SelectAbsenceListByDid_Manager(bid, did);
			}
		}else {
			if (did==0) {
				/* ȫ������ ���� */
				list = new SelectMassage().SelectAbsenceListByMsg_Manager(bid, msg, txt);
			}else {
				/* ����id ���� */
				list = new SelectMassage().SelectAbsenceListByAllMsg_Manager(bid, msg, txt, did);
			}
		}
		request.setAttribute("level", "1");
		request.setAttribute("did", did);	
		request.setAttribute("msg", msg);	
		request.setAttribute("txt", txt);		
		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("AbsenceList_Manager.jsp").forward(request, response);
		
	}

}
