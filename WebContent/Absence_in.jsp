<%@page import="com.entity.Absence_Student"%>
<%@page import="com.service.SelectMassage"%>
<%@page import="com.entity.Graduation_Student"%>
<%@page import="java.util.List"%>
<%@page import="com.service.Getlists"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<!-- 迁出记录 -->

	<html>
	<head>
	<meta charset="UTF-8">
	<title>校园宿舍管理系统</title>
	</head>
	
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
	</style>
	
	<body>
	
	<%
		List<Absence_Student> list = (List<Absence_Student>)request.getAttribute("list");

		if(list==null){
			String username = request.getAttribute("servletusername").toString();
			list = new SelectMassage().SelectAbsence(username);
		}
	%>
		
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
					<%@include file="Citation.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">
					<div>
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="6">
									学生缺寝记录
								</td>
							</tr>
							<tr height="25px">
								<td colspan="6">
									<div class="m_top2">功能导航:<a href="Absence.jsp">返回上页</a></div>
								</td>
							</tr>
							<tr class="m_th">
								<th>寝室号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>日期</th>
								<th>备注</th>
								<th>登记人</th>
							</tr>
							
							<%
								for(Absence_Student as:list){
							%>
							
							<tr height="18px">
								<td align="center">
									<%=as.getDormitory_Name() %>
								</td>
								<td  align="center">
									<%=as.getStudent_Name() %>
								</td>
								<td  align="center">
									<%=as.getStudent_Sex() %>
								</td>
								<td  align="center">
									<%=as.getAbsence_Date() %>
								</td>
								<td  align="center">
									<%=as.getAbsence_Remark() %>
								</td>
								<td  align="center">
									<%=as.getManager_Name() %>
								</td>
								
							</tr>	
							
							<%
								}
							%>
							
						</table>
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