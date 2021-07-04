<%@page import="com.service.UpdateMassage"%>
<%@page import="com.entity.Building_Dormitory"%>
<%@page import="com.entity.Absence_Manager"%>
<%@page import="com.entity.Student_Manager"%>
<%@page import="com.service.SelectMassage"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 学生管理 -->

	<head>
	<meta charset="UTF-8">
	<title>校园宿舍管理系统</title>
	</head>
	
	<%
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
	%>
	<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	session.removeAttribute("msg");
	}
	 %>	
	
	<style>
		*{
			margin: 0px;
			padding: 0px;
		}
		#toptitle{
			height:60px;
			color:#06F;
			font-size:19px;
			font-weight:bolder;
			padding-left:50px;"
		}
		.b_table{
			width:920px ;
			margin: 0px auto;
			background-color: #E6F5FF;
		}
		.citate{
 			border-right: 1px solid black; 
			width: 200px;
		}
		/* ----------------------------- */
		.m_table{
			width: 714px;
			margin-left:-1px;
 			position: absolute;
			top:95px;				
		}
		.m_toptitle{
			font-size:16px;
			font-weight:bolder;
			height:30px;
			padding-left:25px;
			background-image: linear-gradient(to left, #92fe9d 0%, #00c9ff 100%);
		}
		.m_top2{
			
			float: left;
			padding-left: 25px;
			margin:5px 0px;
			font-size: 14px;
		}
		.m_th{
			background-color: skyblue;
			height: 30px;
		}
		#m_click{
			height: 18px;
			margin-top: 2px;
		}
		/* ----------------------------- */
		#txt{
			height: 18px;
		}
		select {
			height: 18px;
		}
	</style>
	
	<body>
	
	<%
			SelectMassage selectMassage = new SelectMassage();
			List<Absence_Manager> list = (List<Absence_Manager>)request.getAttribute("list");
		
			int bid = 0;
			
			if(request.getAttribute("bid")==null){
				bid= Integer.parseInt(session.getAttribute("bid").toString());
			}else{
				bid =Integer.parseInt(request.getAttribute("bid").toString());
			}
			
			if(list==null){
				String level=null;
				try{
					 level = request.getAttribute("level").toString(); 
				}catch(Exception e){
					e.printStackTrace();
				}
				
				if(level!=null&&level.equals("1")){	
					int did = 	Integer.parseInt(request.getParameter("did"));
					int themsg = Integer.parseInt(request.getParameter("msg"));
					String txt = request.getAttribute("txt").toString();
					
					if (txt.equals("")) {
						if (did==0) {
							/* 全部宿舍的学生 空 */
							list = new Getlists().getAbsenceList_Manager(bid);
						}else {
							/* 按宿舍id查询  空 */
							list = new SelectMassage().SelectAbsenceListByDid_Manager(bid, did);
						}
					}else {
						if (did==0) {
							/* 全部宿舍 条件 */
							list = new SelectMassage().SelectAbsenceListByMsg_Manager(bid, themsg, txt);
						}else {
							/* 宿舍id 条件 */
							list = new SelectMassage().SelectAbsenceListByAllMsg_Manager(bid, themsg, txt, did);
						}
					}
				}else{
					list = new Getlists().getAbsenceList_Manager(bid);
				}
			}
		%>
		
 		<%-- <%
 			List<Absence_Manager> list = (List<Absence_Manager>)request.getAttribute("list");
 			
 			int bid=0;
 			if (request.getParameter("bid")==null) {
 				bid =Integer.parseInt(session.getAttribute("bid").toString()) ;
 			}else {
 				bid =Integer.parseInt(request.getParameter("bid"));
 				session.setAttribute("bid", bid);
 			}
 			
 			if(list==null){
 				list = new Getlists().getAbsenceList_Manager(bid);
 			}
 		%> --%>
 			
 		
		<table class="b_table">
			<tr>
				<td id="toptitle" colspan="2">
					校园宿舍管理系统
				</td>
			</tr>
			<tr>
				<td colspan="2" height="30px" background="img/MenuBg.jpg"> 
					
				</td>
			</tr>			
			<tr>
				<!-- 插入引用界面 -->
				<td class="citate" width="191" height="580" align="center" valign="top">
					<%@include file="Citation_Manager.jsp" %>
				</td>
				
				<td bgcolor="#F6F9FE">
					<div>
					<form action="Select_Absence_Manager" method="post">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="8">
									学生缺寝记录
								</td>
							</tr>
							<tr>
								<td  colspan="6">
									<div class="m_top2">功能导航:<a href="JavaScript:history.go(-1)">返回上页</a></div>
									<div class="m_top2">
										查询:
										<select name="did">
											<option value="0" class="thedorm">全部寝室</option>
											
											<%
													
												List<Building_Dormitory> dlist = new UpdateMassage().getDormitoryListByBuilding_Id(bid);
															
												for(Building_Dormitory bd:dlist){
											%>
												<option value="<%=bd.getDormitory_ID() %>" class="thedorm">
													&nbsp<%=bd.getDormitory_Name() %>
												</option>
											<%
												}
											%>
										</select>
										<span>&nbsp</span>
										<select name="msg">
											<option value="1">姓名</option>
											<option value="2">班级</option>
										</select>
										<input type="text" id="txt" name="txt">
										<span>&nbsp&nbsp</span>
										<input height="18px" id="m_click" type="submit" value="点击查询">
									</div>																																			
								</td>													
							</tr>
							<tr class="m_th">
								<th>寝室号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>班级</th>
								<th>日期</th>
								<th>备注</th>
							</tr>
							
							<% 			
								try{
								for(Absence_Manager am:list){
							%>
							<tr height="18px">
								<td align="center">
									<%= am.getDormitory_Name() %>
								</td>
								<td  align="center">
									<%= am.getStudent_Name() %>
								</td>
								<td  align="center">
									<%= am.getStudent_Sex() %>
								</td>
								<td  align="center">
									<%= am.getStudent_Class() %>
								</td>
								<td  align="center">
									<%= am.getAbsence_Date() %>
								</td>
								<td  align="center">
									<%= am.getAbsence_Remark() %>
								</td>
							</tr>	
								
							<%}
								}catch(Exception e2){
									e2.printStackTrace();
								}
							%>
						</table>
						</form>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="30px" background="img/bootBg.jpg" >
				
				</td>
			</tr>
		</table>
	</body>
</html>