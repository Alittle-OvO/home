<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 学生寝室调换 -->

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
	
	 <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
	
	 <script type="text/javascript">
 	   
		function judge(){		
		
		var sid=$("#sid1").val();
		
		if(sid==""){
		  	alert("请输入学生学号！");
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
		.m_th{
			background-color: skyblue;
			height: 30px;
		}
		/* ----------------------------- */		
		.therow{			
			height: 40px;
		}
		.word{
			text-align: right;
			padding-right: 10px;
			/* padding-left: 70px; */
		}
		#sid1{
			height: 20px;
			width:160px;
			margin-right: 80px;
			
		}
		#addtd{
			height: 20px;
			width: 50px;
			margin-right: 80px;
		}
		.bt{
			text-align: center;	
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
				<td class="citate" width="191" height="580" align="center" valign="top">
					<%@include file="Citation.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">
					<div>
						<form action="Update_Change_Getlist" method="post" onsubmit="return judge()">
							<table class="m_table"  cellspacing="0" cellpadding="0">	
								<tr>
									<td class="m_toptitle" colspan="5">
										学生寝室调换
									</td>
								</tr>
								<tr height="60px"></tr>
								<tr class="therow" id="rowtop">
									<td class="word">
										<span class="red">*</span>
										<span>请输入调换寝室学生的学号:</span>
									</td>	
									<td id="tdsid">
										<input type="text" id="sid1" name="sid" >
									</td>									
								</tr>														
								<tr class="therow">
									<td class="bt"colspan="2">
										<input type="submit"  id="addtd"  name="sure" value="确定">
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