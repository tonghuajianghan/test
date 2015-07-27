<!-- 个人中心 -->
<%@page import="com.cust.dew.util.MyProperties"%>
<%@page import="com.cust.dew.dao.impl.CommodityDBDao"%>
<%@page import="com.cust.dew.dao.impl.CommodityteacherDBDao"%>
<%@page import="com.cust.dew.dao.impl.TeacherDBDao"%>
<%@page import="com.cust.dew.vo.*"%>

<%@page import="com.cust.dew.util.Pagination"%>
<%@page import="com.cust.dew.dao.impl.DaoFactory"%>
<%@page import="com.cust.dew.dao.impl.RequirementDBDao"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
  Pagination p = new Pagination();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>css/ddsmoothmenu.css" />
<link rel="stylesheet" href="<%=basePath %>css/personalcenter.css"
	type="text/css" />
<script type="text/javascript">
   



</script>
</head>
<body>

	<% 
	  System.out.println("teacher1:");
	  TeacherDBDao td = new TeacherDBDao();
	  String tename = (String)session.getAttribute("loginauthor");
	  List<Teacher> te = td.queryTeacherByNameAll(tename);
	  Teacher t = new Teacher();
	  for(int i =0;i<te.size();i++){
		  t = (Teacher)te.get(i);
		  System.out.println("teacher:" + t.getTename());
	  }
	%>

	<div class="templatemo_wrapper">
		<div id="templatemo_header1">
			<div class="container">
				<div class="circle">
				  <%-- <img alt="" src="<%=t.getTeimg() %>"> --%>
				  <img alt="" src="<%=basePath%>imageLaction.action?type=<%=MyProperties.te %>&imageLocation=<%=t.getTeimg() %>">	
				</div>
			</div>
			<div class="detail">
				<div class="detail_left">
					<div class="info1"><%=t.getTename() %></div>
					<div class="info"><%=t.getTeschool()%>·<%=t.getTeadress()%>·<%=t.getTetel() %></div>
				</div>
			</div>
		</div>
		<!-- END of templatemo_header -->
	</div>
	<div class="nav">
		<ul>
			<!-- <li><a>首页</a></li> -->
			<li><a href="<%=basePath %>/page/user/personalcenter.jsp">个人主页</a>
			</li>
			<li><a href="<%=basePath %>page/user/accountOptions.jsp">修改资料</a>
			</li>
			<li><a href="<%=basePath %>page/user/personalCommodity.jsp">发布商品</a>
			</li>
			<li><a href="<%=basePath %>page/user/personalRequirement.jsp">发布需求</a>
			</li>
			<li><a href="<%=basePath %>page/user/login.jsp">退出</a>
			</li>
		</ul>
	</div>
	<div class="clas">
		<div class="contain">
			<!-- <div class="clas1">
				<div class="clas_top">
					<span style="margin-left: 15px;">我的收藏</span> <a href="#">更多></a>
				</div>
				<div class="down"></div>
			</div>
			<div class="clas1">
				<div class="clas_top">
					<span style="margin-left: 15px;">交易记录</span> <a href="#">更多></a>
				</div>
				<div class="down">
					<ul>
						<li>和XX交易</li>
						<li>和XX交易</li>
						<li>和XX交易</li>
						<li>和XX交易</li>
					</ul>
				</div>
			</div> -->
			<div class="clas1">
				<div class="clas_top">
					<span style="margin-left: 15px;">发布的商品</span> <a href="#">更多></a>
				</div>
				<div class="down">
					<ul>
					  <%
					       Pagination.setAllSize(5);
						   CommodityteacherDBDao ctd = DaoFactory.getCommodityteacherDBDao();
						   List<Commodity> copeList = ctd.queryCommodityteacherCoidByTeid(t.getTeid());
						   Commodity c = new Commodity();
						   for(int i = 0; i < copeList.size();i++){					    		 					    		 
					    		 c =copeList.get(i);					    		 
					  %>
					             <li><%=c.getCoid()%></li>
					  <%
					       }
					  %>
					</ul>
				</div>
			</div>
			<div class="clas1">
				<div class="clas_top">
					<span style="margin-left: 15px;">发布的需求</span> <a href="#">更多></a>
				</div>
				<div class="down">
					<ul>
						<%					    
					    int teid = t.getTeid();					    
					    Pagination.setAllSize(5);					    
					    RequirementDBDao rd = DaoFactory.getRequirementDBDao();					    
					    List<Requirement> peList;				  			    
					       peList = rd.queryRequirementByTeid(teid);				       			        					       
					       for(int i = 0; i < peList.size();i++){					    		 		    		 
					    		 Requirement r =(Requirement)peList.get(i);
					    		 System.out.println(r.getReconame());
					    		 String rrd = r.getRedetail();
					    		 if(rrd.length() > 5){
					    			rrd = rrd.substring(0,5) + "...";
					    		 }
					  %>
						<li><%=r.getReconame() %></li>
						<%  		 
					    	}
					  %>
					</ul>
				</div>
			</div>



		</div>
		<div class="public">
			<div class="public_top">我的资料</div>
			<ul>
				<li>名字：<%=t.getTename() %></li>
				<li>email：<%=t.getTeemail() %></li>				
				<li>学校：<%=t.getTeschool() %></li>
				<li>院系：<%=t.getTeadress() %></li>
				<li>电话：<%=t.getTetel() %></li>				
			</ul>
		</div>
	</div>
	<div class="footer">©cust 长春理工大学 2014</div>
</body>
</html>