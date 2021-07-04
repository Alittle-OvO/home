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
						<a href="Backstage.jsp">后台首页</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_Manager">楼宇管理员管理</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_Student">学生管理</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_Building">楼宇管理</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_Dormitory">宿舍管理</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Check_in.jsp">学生入住登记</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Change.jsp">学生寝室调换</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Graduation.jsp">学生迁出登记</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Absence.jsp">学生缺寝记录</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="Getlist_Graduation">迁出记录</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="UpdatePwd.jsp">修改密码</a>
					</td>
				</tr>
				<tr>
					<td class="c_td" height="30" align="center" valign="middle">
						<a href="ExitSystem" onclick="return confirm('确定要退出系统吗？')">退出登录</a>
					</td>
				</tr>
			</table>
	</body>
</html>