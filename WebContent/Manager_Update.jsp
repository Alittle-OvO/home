<%@page import="com.service.UpdateMassage"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>校园宿舍管理系统</title>
	</head>
	
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    
    <%
	String msg = (String)request.getAttribute("msg");
	if(msg!=null){
	%>
		<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	request.removeAttribute("msg");
	}
	 %>
    
    <script type="text/javascript">
 	   
	function judge(){		
		
		var username=$("#username1").val();
		var pwd=$("#pwd1").val();
		var repwd=$("#repwd1").val();
		var name=$("#name1").val();
		var sex=$("#sex1").val();
		var tel=$("#tel1").val();
		if(username==""||name==""||sex=="请选择"||tel==""){
		  	alert("请检查是否填写完整！");
			return false;
		}
		if(isNaN(tel)){
		  alert("电话号必须是数字！");
		return false;
		}
		if(tel.length!=11){
			alert("电话号必须是11位数！");
			return false;
		}
		if(pwd!=""&&repwd==""){
			alert("请重复密码！");
			return false;
		}		
		return true;
	}
	
	function checkpwd() {
		var pwd1 = $("#pwd1").val();
		var repwd1 = $("#repwd1").val();
		
		if(pwd1!=repwd1){
			alert("两次密码不一致！");
			var repwd1 = $("#repwd1").val("");
			return false;
		}
		return true;
	}
	
</script>
	
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
		/* ----------------------------- */
		.therow{
			
			height: 35px;
		}
		.word{
			text-align: right;
			padding-right: 10px;
			padding-left: 70px;
		}
		.therow input{
			height: 20px;
			
		}
		#addtd{
			margin-right: 50px;
		}
		.bt{
			text-align: center;
			margin-top: 20px;
		}
		.red{
			color: red;
		}
	</style>
	
	<body>
				
		<%
			 int id = Integer.parseInt(request.getAttribute("manager_id").toString()); 
			
			List<Manager> list = (List<Manager>)request.getAttribute("list");
			if(list==null){
				list = new UpdateMassage().getManagerListByID(id);
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
						<form action="Update_Manager" method="post" onsubmit="return judge()">
							<table class="m_table"  cellspacing="0" cellpadding="0">	
								<tr>
									<td class="m_toptitle" colspan="5">
										修改楼宇管理员
									</td>
								</tr>
								<tr height="40px"></tr>
								<tr class="therow" id="rowtop">
									<td class="word">
										<span class="red">*</span>
										<span>用户名:</span>
									</td>	
									<td>
										<input type="hidden" name="uid" value="<%= list.get(0).getManager_ID()%>">
										<input type="text" id="username1" name="username" value="<%= list.get(0).getManager_Username() %>">
									</td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>密码:</span>
									</td>	
									<td>
										<input type="password" id="pwd1" name="pwd">
										<span style="color: orange">不修改则不填写</span>
									</td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>重复密码:</span>
									</td>	
									<td>
										<input type="password" id="repwd1" name="repwd" onblur="return checkpwd()">
										<span style="color: orange">不修改则不填写</span>
									</td>	
									<td></td>								
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>姓名:</span>
									</td>	
									<td><input type="text" id="name1" name="name" value=<%= list.get(0).getManager_Name() %>></td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>性别:</span>
									</td>	
									<td>
										<select id="sex1" name="sex">
											<option value="<%= list.get(0).getManager_Sex() %>"><%= list.get(0).getManager_Sex() %></option>
											<option value="男">男</option>
											<option value="女">女</option>
										
										</select>
									</td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>联系电话:</span>
									</td>	
									<td><input type="text" id="tel1" name="tel" value="<%= list.get(0).getManager_Tel() %>"></td>									
								</tr>
								<tr height="5px">
									<td></td>
								</tr>
								<tr class="therow">
									<td class="bt"colspan="2">
										<input type="submit"  id="addtd"  name="add" value="修改楼宇管理员">
										<input type="button" value="返回上页" onclick="history.go(-1)">
									</td>
									
								</tr>												
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