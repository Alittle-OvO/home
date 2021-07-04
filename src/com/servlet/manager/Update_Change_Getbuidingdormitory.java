package com.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Building_Dormitory;
import com.service.UpdateMassage;

/**
 * Servlet implementation class Update_Change_Getbuidingdormitory
 */
@WebServlet("/Update_Change_Getbuidingdormitory")
public class Update_Change_Getbuidingdormitory extends HttpServlet {
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
	
	/* —ß…˙ªªÀﬁ…·-ªÒ»°Àﬁ…·list */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* ±‡¬Î…Ë÷√ */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		HttpSession session = request.getSession();
		List<Building_Dormitory> list = updateMassage.getDormitoryListByBuilding_Id(bid);
		request.setAttribute("listbybid", list);
		request.setAttribute("servletbid", bid);
		request.setAttribute("bname", session.getAttribute("bname"));
		request.setAttribute("dname", session.getAttribute("dname"));
		request.setAttribute("sid", session.getAttribute("sid"));
		request.setAttribute("list", session.getAttribute("listbyusername"));
		
		request.getRequestDispatcher("Change_Update.jsp").forward(request, response);
	}

}
