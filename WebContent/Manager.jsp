<%@page import="com.service.SelectMassage"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 楼宇管理员管理 -->

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
			background-color: skyblue;
		}
	</style>
	
	<body>
		
		<%
			List<Manager> list = (List<Manager>)request.getAttribute("list");
		
			if(list==null){
				
				if(request.getAttribute("level")!=null && (request.getAttribute("level").toString()).equals("1")){
					
					String select = request.getAttribute("select").toString();

					if (select.equals("Manager_Name")||select=="Manager_Name") {
						
						list = new SelectMassage().getManagerListByName(request.getAttribute("thevalue").toString());				
					}else if (select.equals("Manager_Tel")||select=="Manager_Tel") {
						
						list = new SelectMassage().getManagerListByTel(request.getAttribute("thevalue").toString());
					}else if(select.equals("Manager_Username")||select=="Manager_Username") {
						
						list = new SelectMassage().getManagerListByUsername(request.getAttribute("thevalue").toString());
					}
					request.removeAttribute("level");
				}else{
					list = new Getlists().getManagerList();
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
				<td class="citate" height="580" align="center" valign="top">
					<%@include file="Citation.jsp" %>
				</td>
				
				<td bgcolor="#F6F9FE">						
					<div>
					<form action="Select_Manager" method="post">
					<table class="m_table"  cellspacing="0" cellpadding="0">	
						<tr>
							<td class="m_toptitle" colspan="5">
								楼宇管理员管理
							</td>
						</tr>
						<tr>
							<td  colspan="5">
								<div class="m_top2">功能导航:<a href="Manager_Add.jsp">添加楼宇管理员</a></div>
								<div class="m_top2">
									查询:
									<select name="select">
										<option value="Manager_Name">姓名</option>
										<option value="Manager_Tel">电话</option>
										<option value="Manager_Username">用户名</option>
									</select>
								</div>
								<div class="m_top2" >
									<input type="text" name="value">
								</div>
								<div class="m_top2">									
										<input id="m_click" type="submit"  value="点击查询">									
								</div>																																				
							</td>													
						</tr>
						<tr class="m_th">
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
							<th>用户名</th>
							<th>操作</th>
						</tr>
						
						<%
							for(Manager manager:list){
															
						%>
							<tr height="18px">
								<td   align="center">
									<%=manager.getManager_Name() %>
								</td>
								<td   align="center">
									<%=manager.getManager_Sex() %>
								</td>
								<td   align="center">
									<%=manager.getManager_Tel() %>
								</td>
								<td   align="center">
									<%=manager.getManager_Username() %>
								</td>
								<td   align="center">
									<a href="Update_Manager_Getlist?id=<%= manager.getManager_ID()%>">
										修改
									</a>
									&nbsp&nbsp
									<a href="Delect_Manager?id=<%= manager.getManager_ID() %>" onClick="return confirm('确定要删除该管理员吗？')">删除</a>
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