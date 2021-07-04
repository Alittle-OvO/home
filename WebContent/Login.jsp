<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<%
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
	%>
	<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	session.removeAttribute("msg");
	}
 %>

<style type="text/css">
	body {
		margin: 0px;
		padding: 0px;
		background-image: url("img/loginBackground.jpg");
		background-repeat: no-repeat;
		background-size: 100% auto;
	}
	#maxbox{
		margin: 0 auto;
		margin-top: 200px;
		padding: 20px ,50px;
		background-color: #00000090;
		text-align: center;
		width: 600px;
		height: 400px;
		border-radius: 10px;
	}
	#maxbox h1{
		padding: 0;
		padding-top: 40px;
		color: white;
		font-size: 30px;
	}
	#maxbox .inputbox{
		margin-top: 50px;
	}
	#maxbox .btn-group{
		padding: 0;
		padding-top: 15px; 
		color: #ecf0f1;
		font-weight: bold;
		
	}
	#maxbox .btn-group select{
		background-color: #FFFFFF00;
		border: none;
		border-bottom: 1px solid white;
		
	}
	#maxbox .btn-group select option{
		color: black;
	}
	
	
	#maxbox .inputtText{
		margin-top: 20px;
	}
	#maxbox .inputtText span{
		color: white;
		font-size: 20px;
		opacity: 0.6;
	}
	#maxbox .inputtText input {
		border: 0;
		padding: 6px;
		border-bottom: 1px solid white;
		background-color: #FFFFFF00;
		color: white;
	}
	#maxbox .inputbox .inputSubmit{
		margin: 0;
		border: 0;
		margin-top: 30px;
		width: 180px;
		height: 35px;
		border-radius: 100px;
		color: white;
		background-image: linear-gradient(120deg, #a6c0fe 0%, #f68084 100%);
	}
	#maxbox .maxbox_a{
		margin-top: 10px;
		font-weight: bold;
		color: #c7ecee;
		font-size: 15px;
	}
	#maxbox .maxbox_a a{
		font-size: 13px;
		color: #00a8ff;
	}
	#tip{
		margin-top:10px;
		color:white;
	}
</style>
</head>
<body>
	<div id="maxbox">
		<form action="Login"  method="post">
			<h1>学生宿舍管理系统</h1>
			<div class="btn-group">
				<select name="select">
					<option value="0">请选择身份</option>
					<option value="1">超级管理员</option>
					<option value="2">宿舍管理员</option>					
					<option value="3">学生</option>
				</select>
			</div>
			<div class="inputbox">
				<div class="inputtText">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					<input type="text" name="username" placeholder="用户名"/>
				</div>
				<div class="inputtText">
					<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
					<input type="password" name="pwd" placeholder="密码"/>
				</div>
				<div id="tip">
					<%=
						request.getAttribute("error")==null?"":request.getAttribute("error")
					%>
				</div>				
				<input class="inputSubmit" type="submit" value="登录"/>
			</div>
			<div class="maxbox_a">
				还没有账号？<a href="Register_Student.jsp">学生注册</a>
			</div>
		</form>
	</div>
</body>
</html>