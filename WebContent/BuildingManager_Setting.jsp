<%@page import="com.entity.Manager"%>
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
	</style>
	
	<body>
	
	<%
		List<Manager> list = (List<Manager>)request.getAttribute("list");

		if(list==null){
			int bid = Integer.parseInt(session.getAttribute("bid").toString());
			list = new Getlists().getManagerDutyList(bid);
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
					<form action="Add_ManagerDuty">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="5">
									楼宇管理员设置
								</td>
							</tr>
							<tr height="25px">
								<td colspan="5">
									<div class="m_top2">功能导航:<a href="Getlist_Building">返回上页</a></div>
									
									<div class="m_top2">
									<span>添加管理员:</span>
									<select name="mid">
											<option value="0">请选择</option>																										
										<%				
											List<Manager> mlist = (List<Manager>)request.getAttribute("listbybid");	
											if(mlist==null){
												mlist = new Getlists().getManagerList();
											}
											
											for(Manager manager:mlist){
										%>
											<option value=<%= manager.getManager_ID() %>>
												<%= manager.getManager_Name() %>														
											</option>
										<%
											} 
										%>																										
									</select>
									<input type="hidden" name="bid" value="<%=session.getAttribute("bid")%>">
									<input id="m_click" type="submit" value="点击添加">
								</td>
							</tr>
							<tr class="m_th">
								<th>姓名</th>
								<th>性别</th>
								<th>联系电话</th>
								<th>用户名</th>
								<th>操作</th>
							</tr>
							
							<%
								for(Manager manager:list){
							%>
							
							<tr height="18px">
								<td align="center">
									<%=manager.getManager_Name() %>
								</td>
								<td  align="center">
									<%=manager.getManager_Sex() %>
								</td>
								<td  align="center">
									<%=manager.getManager_Tel() %>
								</td>
								<td  align="center">
									<%=manager.getManager_Username() %>
								</td>
								<td  align="center">
									<a href="Delete_ManagerDuty?mid=<%=manager.getManager_ID() %>" onClick="return confirm('确定要删除该舍管的职责吗？')">移除</a>
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