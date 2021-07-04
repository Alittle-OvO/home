package com.servlet.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Building_Dormitory;
import com.service.Getlists;
import com.service.SelectMassage;

/**
 * Servlet implementation class Select_Dormitory
 */
@WebServlet("/Select_Dormitory")
public class Select_Dormitory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SelectMassage selectMassage = new SelectMassage();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* ≤È—ØÀﬁ…· */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ±‡¬Î…Ë÷√ */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		int msg = Integer.parseInt(request.getParameter("msg"));
		String txt = request.getParameter("txt");
		
//		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
//				
//		if (txt==null) {
//			if (bid==0) {
//				list = new Getlists().getDormitoryList();
//				
//			}else {
//				list = selectMassage.SelectDormitoryByBid(bid);
//			}
//		}else {
//			if (bid==0) {
//				list = selectMassage.SelectDormitoryByMassage(msg, txt);
//			}else{
//				list = selectMassage.SelectDormitoryByBidMsg(msg, bid, txt);
//			}
//		}
		
		request.setAttribute("level", "1");
		request.setAttribute("bid", bid);	
		request.setAttribute("themsg", msg);	
		request.setAttribute("txt", txt);		
//		request.setAttribute("lsit", list);
		
		request.getRequestDispatcher("Dormitory.jsp").forward(request, response);
	}

}
