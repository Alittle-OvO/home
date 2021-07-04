<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Building"%>
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
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
	%>
	<script type="text/javascript">alert("<%=msg%>")</script>
	<%
	session.removeAttribute("msg");
	}
	 %>
		
	    <script type="text/javascript">
	      function check(){
	        var bId = $("#building_name").val();
	        var hName = $("#did").val();
	        var hType = $("#type").val();
	        var hTel = $("#tel").val();
	        
			if(bId=="choice"){
				alert("请选择楼宇");
				return false;
			}
			if(hName==""){
				alert("请输入寝室号");
				return false;
			}
			if(hType==""){
				alert("请输入寝室类型（限住人数）");
				return false;
			}
			if(isNaN(hType)){
				alert("寝室类型输入错误（数字）");
				return false;
			}
			if(hTel==""){
				alert("请输入寝室电话");
				return false;
			}
			if(isNaN(hTel)){
				alert("寝室类型输入错误（数字）");
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
						<form action="Add_Dormitory"  method="post" onsubmit="return check()">
							<table class="m_table"  cellspacing="0" cellpadding="0">	
								<tr>
									<td class="m_toptitle" colspan="5">
										添加宿舍
									</td>
								</tr>
								<tr height="40px"></tr>
								<tr class="therow" id="rowtop">
									<td class="word">
										<span class="red">*</span>
										<span>楼宇:</span>
									</td>	
									<td>
										<select  id="building_name" name="building_name">
											<option value="请选择">请选择</option>
											
												<%
													List<Building> list = (List<Building>)request.getAttribute("list");
													if(list==null){
														list = new Getlists().getBuildingList();
													}
													
													for(Building building:list){
												%>
													<option value=<%= building.getBuilding_ID() %>><%= building.getBuilding_Name() %></option>
												
												<%
													} 
												%>
											
										</select>
									</td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>寝室号:</span>
									</td>	
									<td><input type="text" id="did" name="did"></td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>宿舍类型:</span>
									</td>	
									<td><input type="text" id="type" name="type"></td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>人数:</span>
									</td>	
									<td><input type="text" id="number" name="number"></td>									
								</tr>
								<tr  class="therow">
									<td class="word">
										<span class="red">*</span>
										<span>电话:</span>
									</td>	
									<td><input type="text" id="tel" name="tel"></td>									
								</tr>
								<tr height="5px">
									<td></td>
								</tr>
								<tr class="therow">
									<td class="bt"colspan="2">
										<input type="submit"  id="addtd"  name="add" value="添加宿舍">
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