<%@page import="com.service.SelectMassage"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Building"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 楼宇管理 -->

	<head>
	<meta charset="UTF-8">
	<title>校园宿舍管理系统</title>
	
	<%
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
	%>
	<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	session.removeAttribute("msg");
	}
	 %>	
	
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
		/* ------------------------------------ */
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
		
		a:hover {
			color: red;
		}
	</style>
	
	<body>
		
		<%
			List<Building> list = (List<Building>)request.getAttribute("list");
			if(list==null){
				
				if(request.getAttribute("level")!=null && (request.getAttribute("level").toString()).equals("1")){
					
					String bname = request.getAttribute("bname").toString();
						
					list = new SelectMassage().getBuildingListByName(bname);

					request.removeAttribute("level");
				}
				else{
					list = new Getlists().getBuildingList();
				}
				
				
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
				
				<td  bgcolor="#F6F9FE">
					<div>
					<form action="Select_Building" method="post">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="3">
									楼宇管理
								</td>
							</tr>
							<tr>
								<td  colspan="3">
									<div class="m_top2">功能导航:<a href="Building_Add.jsp">添加楼宇</a></div>
									<div class="m_top2">名称:<input type="text" name="bname"></div>
									<div class="m_top2">
										<input id="m_click" type="submit" value="点击查询">
									</div>																																				
								</td>													
							</tr>
							<tr class="m_th">
								<th>名称</th>
								<th>简介</th>
								<th>操作</th>
							</tr>
							
							<%
								for(Building building :list){
							%>
							
							<tr height="18px">
								<td align="center">
									<%= building.getBuilding_Name() %>
								</td>
								<td  align="center">
									<%= building.getBuilding_Introduction() %>
								</td>							
								<td  align="center">
									<a href="Building_SetManager?bid=<%= building.getBuilding_ID()%>">管理员</a>
									&nbsp&nbsp
									<a href="Update_Building_Getlist?id=<%=building.getBuilding_ID()%>">
										修改
									</a>
									&nbsp&nbsp
									<a href="Delete_Building?id=<%= building.getBuilding_ID() %>" onClick="return confirm('确定要删除该楼宇吗？')">删除</a>
								</td>
							</tr>	
							
							<%
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