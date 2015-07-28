<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cust.dew.dao.impl.*,com.cust.dew.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公共界面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

</head>

<body>

	<div id="templatemo_body_wrapper">
		<div id="templatemo_wrapper">

			<div id="templatemo_header">

				<div class="cleaner"></div>
			</div>
			<!-- END of templatemo_header -->

			<div id="templatemo_menubar">
				<div id="top_nav" class="ddsmoothmenu">
					<ul>
						<li><a href="<%=basePath%>index.jsp">首页</a>
						</li>
						<li><a href="<%=basePath%>requirement.action">求购信息</a>
						</li>
						<li><a href="<%=basePath%>commodity.action?method=IT">数码产品</a>
						</li>
						<li><a href="<%=basePath%>commodity.action?method=book">书籍</a>
						</li>
						<li><a href="<%=basePath%>commodity.action?method=bycycle">单车</a>
						</li>
						<li><a href="<%=basePath%>map.action">地图</a>
						</li>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of ddsmoothmenu -->
				<div id="templatemo_search">
					<form action="#" method="get">
						<input type="text" value=" " name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END of templatemo_menubar -->
			<!-- 主页 -->
			<div id="templatemo_main">
				<div id="sidebar" class="float_l">
					<table border="1">
						<tr>
							<th>coid</th>
							<th>coname</th>
						</tr>
						<%
						  CommodityDBDao cd = DaoFactory.getCommodityDBDao();
						  List<Commodity>  peList = cd.queryCommodity();
						  System.out.println("mark:"+peList.size());
						
						  for(int i = 0; i < peList.size();i++){
								 System.out.println("mark "+i);
								 //Student stu =(Student)peList.get(i);
								 Commodity com =(Commodity)peList.get(i);
						%>
												<tr>
													<td>
														<%
						             out.print(com.getCoid());
						%>
													</td>
													<td>
														<%
						             out.print(com.getConame());
						%>
													</td>
												</tr>
												<%
							}
						%>
						</table>
				</div>
				<div id="content" class="float_r faqs"></div>
				<!-- END of templatemo_main -->

				<div id="templatemo_footer"></div>
				<!-- END of templatemo_footer -->

			</div>
			<!-- END of templatemo_wrapper -->
		</div>
		<!-- END of templatemo_body_wrapper -->
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>