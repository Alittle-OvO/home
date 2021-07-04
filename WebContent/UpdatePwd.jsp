<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 修改密码 -->

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

	function checkpwd() {
		var pwd1 = $("#newpwd").val();
		var repwd1 = $("#renewpwd").val();
		
		if(pwd1!=repwd1){
			alert("两次密码不一致！");
			/* var repwd1 = $("#repwd1").val(""); */
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
			width: 716px;
			margin-left:-2px;
 			position: absolute;
			top:93.5px;				
		}
		.m_toptitle{
			font-size:16px;
			font-weight:bolder;
			height:30px;
			padding-left:25px;
			background-image: linear-gradient(to left, #92fe9d 0%, #00c9ff 100%);
		}
		
		.ch_table{
			height:150px;
			margin: 50px auto;			
		}
		.input{
			height: 18px;
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
				<td class="citate" width="191" height="580" align="center" valign="top">
					<%@include file="Citation.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">				
					<div>
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="6">
									修改密码
								</td>
							</tr>
							
							<tr>							
								<td>
								<form action="Update_Admin_Pwd" method="post" onsubmit="return judge()">
									<table class="ch_table">
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>请输入原密码:</span>
											</td>
											<td>
												<input type="password" class="input" name="oldpwd">
											</td>
										</tr>
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>请输入新密码:</span>
											</td>
											<td>
												<input type="password" id="newpwd" class="input" name="newpwd">
											</td>
										</tr>
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>重复新密码:</span>
											</td>
											<td>												
												<input type="password" id="renewpwd" class="input"  name="renewpwd">
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<input type="submit" id="sure" value="修改密码" height="30px" onclick="judge()">								
											</td>
										</tr>
									</table>
								</form>
								</td>																						
							</tr>
						</table>
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