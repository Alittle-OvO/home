<%@page import="com.service.Getlists"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Building"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 学生缺寝记录 -->

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
	</style>
	
	<body>
		<%
			List<Building> list = (List<Building>)request.getAttribute("list");
			if(list==null){
				int uid = Integer.parseInt(session.getAttribute("uid").toString()) ;
				list= new Getlists().getBuildingName_ManagerDuty(uid);
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
					<%@include file="Citation_Manager.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">
					<div>
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="6">
									学生缺寝记录
								</td>
							</tr>
							<tr height="20px"></tr>
							<tr>
								<td  colspan="6" align="center" style="font-size: 16px" height="30px">
									请选择楼宇
								</td>													
							</tr>
							
							<%
								for(Building building:list){
							%>
								<tr>
									<td align="center" height="22px">
										<a href="Getlist_Absence_Manager?bid=<%=building.getBuilding_ID()%>">
											<%=building.getBuilding_Name() %>
										</a>										
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
	</body>
</html>