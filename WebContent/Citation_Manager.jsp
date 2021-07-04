<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 引用页面 -->
	
	<head>
	<meta charset="UTF-8">
	<title>引用页面</title>
	</head>
	<style>
		*{
			padding: 0px;
			margin: 0px;
			font-family: 宋体;
			font-size: 12px;
		}
		a{
		text-decoration: none;
		}
		.c_td{
			width: 180px;
			background: url("img/left2.jpg") no-repeat;
			background-size:100%;			
		}
		.c_th{
			width: 180px;
			background: url("img/left1.jpg") no-repeat;
			background-size:100%;
			font-size: 16px;
		}
	</style>
	
	<body>
			<table cellspacing="8" class="c_table">
				<tr>
					<th class="c_th" height="30" align="center">
						系统选项
					</th>
				<tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Backstage_Manager.jsp">后台首页</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_ManagerDuty_Student">学生管理</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_ManagerDuty_Absence">学生缺寝记录</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="UpdatePwd_Manager.jsp">修改密码</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="ExitSystem_Manager" onclick="return confirm('确定要退出系统吗？')">退出登录</a>
					</td>
				</tr>
			</table>
	</body>
</html>