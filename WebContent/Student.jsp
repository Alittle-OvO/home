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
			List<Student> list = (List<Student>)request.getAttribute("list");
		
			if(list==null){
				
				if(request.getAttribute("level")!=null && (request.getAttribute("level").toString()).equals("1")){	
					String status= request.getAttribute("status").toString();
					String themsg = request.getAttribute("themsg").toString();
					String txt = request.getAttribute("txt").toString();
										
					if (txt.equals("")) {
						if (status.equals("全部学生")||status=="全部学生") {						
							list = new Getlists().getStudentList();							
						}else {
							list = selectMassage.SelectStudentByStatus(status);
						}
					}else {
						if(status.equals("全部学生")||status=="全部学生"){
							if(themsg=="1"||themsg.equals("1")){
								list = selectMassage.SelectStudentByName(txt);
							}else if(themsg=="2"||themsg.equals("2")){
								list = selectMassage.SelectStudentByUsername1(txt);
							}else{
								list = selectMassage.SelectStudentByClass(txt);
							}
						}else if (themsg=="1"||themsg.equals("1")) {
							list = selectMassage.SelectStudentByStatusAndName(status, txt);
						}else if (themsg=="2"||themsg.equals("2")) {
							list = selectMassage.SelectStudentByStatusAndUsername(status, txt);
						}else{
							list = selectMassage.SelectStudentByStatusAndTel(status, txt);
						}
					}
				}else{
					list = new Getlists().getStudentList();
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
				
				<td bgcolor="#F6F9FE">
					<div>
					<form action="Select_Student" method="post">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="6">
									学生管理
								</td>
							</tr>
							<tr>
								<td  colspan="6">
									<div class="m_top2">功能导航:<a href="Student_Add.jsp">添加学生</a></div>
									<div class="m_top2">
										查询:
										<select name="status">
											<option value="全部学生">全部学生</option>
											<option value="已入住">已入住</option>
											<option value="未入住">未入住</option>
											<option value="已迁出">已迁出</option>										
										</select>
										<span>&nbsp</span>
										<select name="msg">
											<option value="1">姓名</option>
											<option value="2">学号</option>
											<option value="3">班级</option>
										</select>
										<input type="text" id="txt" name="txt">
										<span>&nbsp&nbsp</span>
										<input height="18px" id="m_click" type="submit" value="点击查询">
									</div>																																			
								</td>													
							</tr>
							<tr class="m_th">
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>班级</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
							
							<% 			
								try{
								for(Student student:list){
							%>
							<tr height="18px">
								<td align="center">
									<%= student.getStudent_Username() %>
								</td>
								<td  align="center">
									<%= student.getStudent_Name() %>
								</td>
								<td  align="center">
									<%= student.getStudent_Sex() %>
								</td>
								<td  align="center">
									<%= student.getStudent_Class() %>
								</td>
								<td  align="center">
									<%= student.getStudent_State() %>
								</td>
								<td  align="center">
									<a href="Update_Student_Getlist?id=<%= student.getStudent_ID()%>">
										修改
									</a>
									&nbsp&nbsp
									<a href="Delete_Student?id=<%= student.getStudent_ID() %>" onClick="return confirm('确定要删除该学生吗？')">删除</a>
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