<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Building_Dormitory"%>
<%@page import="com.entity.Building"%>
<%@page import="com.service.UpdateMassage"%>
<%@page import="com.entity.Student"%>
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
 
	function judge(){		
		
		var sid=$("#sid1").val();
		var pwd=$("#pwd1").val();
		var repwd=$("#repwd1").val();
		var name=$("#name1").val();
		var sex=$("#sex1").val();
		var classes=$("#classes1").val();
		if(sid==""||name==""||sex=="请选择"||classes==""){
		  	alert("请检查是否填写完整！");
			return false;
		}
		if(sex=="请选择"){
			alert("请选择性别！");
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
			margin-right: 200px;
			
		}
		.therow input{
			height: 20px;
			
		}
		.msg{
			padding-right: 28px;
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
			int id = Integer.parseInt(request.getAttribute("sid").toString()); 			
			
			List<Student> list = (List<Student>)request.getAttribute("listbyusername");
						
			session.setAttribute("sid", id);
			session.setAttribute("listbyusername", list);
			
			if(list==null){
				list = new UpdateMassage().getStudentListByID(id);
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
						<form action="Update_Changed" method="post" onsubmit="return judge()">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="5">
									学生寝室调换
								</td>
							</tr>
							<tr height="40px"></tr>
							<tr class="therow" id="rowtop">
								<td class="word">
									<span>学号:</span>
								</td>	
								<td class="msg">
									<input type="hidden" name="sid" value="<%= list.get(0).getStudent_Username() %>">
									<input type="hidden" name="uid" value="<%=list.get(0).getStudent_ID()%>">
									<%= list.get(0).getStudent_Username() %>
								</td>									
							</tr>							
							<tr  class="therow">
								<td class="word">
									<span>姓名:</span>
								</td>	
								<td class="msg">
									<%= list.get(0).getStudent_Name()%>
								</td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span>性别:</span>
								</td>	
								<td class="msg">
									<%= list.get(0).getStudent_Sex()%>
								</td>									
							</tr>
							
													
							<tr  class="therow">
								<td class="word">
									<span>目前楼宇:</span>
								</td>	
								<td class="msg">
									<%=request.getAttribute("bname") %>
									<%session.setAttribute("bname", request.getAttribute("bname")); %>
								</td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span>目前宿舍:</span>
								</td>	
								<td class="msg">
									<%=request.getAttribute("dname") %>
									<%session.setAttribute("dname", request.getAttribute("dname")); %>
								</td>									
							</tr>
														
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>调换到楼宇:</span>
								</td>	
								<td class="msg">
									<select name="bname">												
										<%
										List<Building_Dormitory> dlist=null;	
										if(request.getAttribute("listbybid")!=null){
											dlist = (List<Building_Dormitory>)request.getAttribute("listbybid");
										}
										%>
									
										<option value=<%=dlist==null?"请选择":dlist.get(0).getBuilding_Name()%> >
											<%=dlist==null?"请输入":dlist.get(0).getBuilding_Name()%>
										</option>																										
										
										<%				
										List<Building> blist = (List<Building>)request.getAttribute("blist");
										if(blist==null){
											blist = new Getlists().getBuildingList();
										}
										
										for(Building building:blist){
											request.setAttribute("limit", "Change_Update");
									%>
										<option value=<%= building.getBuilding_ID() %> onclick="window.location.href='Update_Change_Getbuidingdormitory?bid=<%=building.getBuilding_ID() %>'">
											<%= building.getBuilding_Name() %>														
										</option>
									
									<%										
										} 
									%>																										
									</select>
								</td>									
							</tr>
							<tr  class="therow">
								<td class="word">
									<span class="red">*</span>
									<span>调换到楼宇:</span>
								</td>	
								<td class="msg">									
									<select name="dname">
										<option>请选择</option>
										
										<%
											int servletbid=0;
											if(request.getAttribute("bname")!=null){
												try {
													servletbid = Integer.parseInt(request.getAttribute("servletbid").toString());
												} catch (Exception e) {
													e.printStackTrace();
												}																																																			
												if(dlist==null){
													dlist = new UpdateMassage().getDormitoryListByBuilding_Id(servletbid);
												}
												
												for(Building_Dormitory bd:dlist){
										%>
										
											<option value="<%=bd.getDormitory_ID() %>">
												<%=bd.getDormitory_Name() %>
											</option>
										<%	
												}
											}
										%>										
									</select>
								</td>									
							</tr>
							
							<tr height="10px">
								<td></td>
							</tr>
							
							<tr class="therow">
								<td class="bt"colspan="2">
									<input type="submit"  id="addtd"  name="add" value="确定调换">
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