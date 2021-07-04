<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 后台首页  学生权限 -->

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
	</style>
	
	<body>
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
					<%@include file="Citation_Student.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">
					<h1  style="font-size: 28px;">欢迎使用校园宿舍管理系统</h1>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="30px" background="img/bootBg.jpg" >
				
				</td>
			</tr>
		</table>
	</body>
</html>