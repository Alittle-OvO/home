<%@page import="com.service.UpdateMassage"%>
<%@page import="com.entity.Building_Dormitory"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Building"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 学生入住登记 -->

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
		#sid{
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
				
				<td bgcolor="#F6F9FE">
					<div>
						<table class="m_table">	
							<tr>
								<td class="m_toptitle">
									学生入住登记
								</td>
							</tr>
							<tr>							
								<td>
								<form action="Check_in_" method="post">
									<table class="ch_table">
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>楼宇:</span>
											</td>
											<td>
												<select name="bname">
												
													<%
													List<Building_Dormitory> dlist = (List<Building_Dormitory>)request.getAttribute("listbybid");													
													%>
												
													<option value=<%=request.getAttribute("bname")==null?"请选择":dlist.get(0).getBuilding_Name()%> >
														<%=request.getAttribute("bname")==null?"请输入":dlist.get(0).getBuilding_Name()%>
													</option>																										
													
													<%				
													List<Building> blist = (List<Building>)request.getAttribute("blist");
													if(blist==null){
														blist = new Getlists().getBuildingList();
													}
													
													for(Building building:blist){
												%>
													<option value=<%= building.getBuilding_ID() %> onclick="window.location.href='Check_in?bid=<%=building.getBuilding_ID() %>'">
														<%= building.getBuilding_Name() %>														
													</option>
												
												<%
													
													} 
												%>																										
												</select>
											</td>
										</tr>
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>寝室号:</span>
											</td>
											<td>
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
										<tr>
											<td  align="right">
												<span style="color: red">*</span>
												<span>学生学号:</span>
											</td>
											<td>												
												<input type="text" id="sid" name="sid">
											</td>
										</tr>
										<tr>
											<td colspan="2" align="center">
												<input type="submit" id="sure" value="确认入住" height="30px">								
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