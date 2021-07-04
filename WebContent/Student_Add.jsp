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
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
	%>
	<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	session.removeAttribute("msg");
	}
	 %>
    
    <script type="text/javascript">
 
	function judge(){		
		
		var sid=$("#sid1").val();
		var pwd=$("#pwd1").val();
		var repwd=$("#repwd1").val();
		var name=$("#name1").val();
		var sex=$("#sex1").val();
		var classes=$("#classes1").val();
		if(sid==""||pwd==""||repwd==""||name==""||sex=="请选择"||classes==""){
		  	alert("请检查是否填写完整！");
			return false;
		}
		if(sex=="请选择"){
			alert("请选择性别！");
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
						<form action="Add_Student" method="post" onsubmit="return judge()">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="5">
									添加学生
								</td>
							</tr>
							<tr height="40px"></tr>
							<tr class="therow" id="rowtop">
								<td class="word">
									<span class="red">*</span>
									<span>学号:</span>
								</td>	
								<td><input type="text" id="sid1" name="sid"></td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>密码:</span>
								</td>	
								<td><input type="password" id="pwd1" name="pwd"></td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>重复密码:</span>
								</td>	
								<td><input type="password" id="repwd1" name="repwd" onblur="return checkpwd()"></td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>姓名:</span>
								</td>	
								<td><input type="text" id="name1" name="name"></td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>性别:</span>
								</td>	
								<td>
									<select id="sex1" name="sex">
										<option value="请选择">请选择</option>
										<option value="男">男</option>
										<option value="女">女</option>
									
									</select>
								</td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>班级:</span>
								</td>	
								<td><input type="text" id="classes" name="classes"></td>									
							</tr>
							<tr height="5px">
								<td></td>
							</tr>
							<tr class="therow">
								<td class="bt"colspan="2">
									<input type="submit"  id="addtd"  name="add" value="添加学生">
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