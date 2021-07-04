<%@page import="com.service.SelectMassage"%>
<%@page import="com.entity.Building"%>
<%@page import="com.entity.Building_Dormitory"%>
<%@page import="com.service.Getlists"%>
<%@page import="com.entity.Dormitory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<!-- 宿舍管理 -->

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
		#txt{
			height: 18px;
		}
		#m_click{
			height: 18px;
		}
	</style>
	
	<body>
	
		<%
			SelectMassage selectMassage = new SelectMassage();
			List<Building_Dormitory> list = (List<Building_Dormitory>)request.getAttribute("list");

			if(list==null){
				String level=null;
				try{
					 level = request.getAttribute("level").toString(); 
				}catch(Exception e){
					e.printStackTrace();
				}
				/* request.getAttribute("level")!=null && (request.getAttribute("level").toString()).equals("1") */
				
				if(level!=null&&level.equals("1")){	
					int bid= Integer.parseInt(request.getAttribute("bid").toString()) ;
					int themsg = Integer.parseInt(request.getAttribute("themsg").toString()) ;
					String txt = request.getAttribute("txt").toString();
										
					if (txt==null||txt.equals("")) {
						if(bid==0) {
							list = new Getlists().getDormitoryList();
							
						}else {
							list = selectMassage.SelectDormitoryByBid(bid);
						}
					}else {
						if (bid==0) {
							list = selectMassage.SelectDormitoryByMassage(themsg, txt);
						}else{
							list = selectMassage.SelectDormitoryByBidMsg(themsg, bid, txt);
						}
					}
				}
			}else{
				list = new Getlists().getDormitoryList();
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
				<td class="citate" width="191" height="580" align="center" valign="top">
					<%@include file="Citation.jsp" %>
				</td>
				
				<td  align="center" valign="middle" bgcolor="#F6F9FE">
					<div>
					<form action="Select_Dormitory" method="post">
						<table class="m_table"  cellspacing="0" cellpadding="0">	
							<tr>
								<td class="m_toptitle" colspan="6">
									宿舍管理
								</td>
							</tr>
							<tr>
								<td  colspan="6">
									<div class="m_top2">
										功能导航:<a href="Dormitory_Add.jsp">添加宿舍</a>
									</div>
									<div class="m_top2">
										查询:
										<select name="bid">
											<option value="0">全部楼宇</option>
											<%
												List<Building> blist = (List<Building>)request.getAttribute("blist");
												if(blist==null){
												blist = new Getlists().getBuildingList();
											}
												for(Building building:blist){
											%>
													<option value="<%=building.getBuilding_ID() %>">
														<%= building.getBuilding_Name() %>
													</option>		
											<%
												}
											%>								
										</select>
										<span>&nbsp</span>
										<select name="msg">
											<option value="1">寝室号</option>
											<option value="2">电话</option>
										</select>
										<input type="text" id="txt" name="txt">
										<span>&nbsp&nbsp</span>
										<input id="m_click" type="submit" value="点击查询">
									</div>																																			
								</td>													
							</tr>
							<tr class="m_th">
								<th>楼宇</th>
								<th>寝室号</th>
								<th>寝室类型</th>
								<th>人数</th>
								<th>电话</th>
								<th>操作</th>
							</tr>
							
							<%
								for(Building_Dormitory dormitory:list){
							%>
							
							<tr height="18px">
								<td align="center">
									<%= dormitory.getBuilding_Name() %>
								</td>
								<td  align="center">
									<%= dormitory.getDormitory_Name() %>
								</td>
								<td  align="center">
									<%= dormitory.getDormitory_Type() %>
								</td>
								<td  align="center">
									<%= dormitory.getDormitory_Number() %>
								</td>
								<td  align="center">
									<%= dormitory.getDormitory_Tel() %>
								</td>
								<td  align="center">
									<a href="Update_Dormitory_Getlist?id=<%= dormitory.getDormitory_ID()%>">
										修改
									</a>
									&nbsp&nbsp
									<a href="Delete_Dormitory?id=<%= dormitory.getDormitory_ID() %>" onClick="return confirm('确定要删除该宿舍吗？')">删除</a>
								</td>
							</tr>								
							<%
								} 
							%>
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