<%@page import="com.cust.dew.util.MyProperties"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.cust.dew.dao.impl.*,com.cust.dew.vo.*"%>

<%@page import="com.cust.dew.util.Pagination"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公共界面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="css/commodity.css">
<!-- 显示商品 -->
<script type="text/javascript"
	src="<%=basePath %>mb611/slider/scripts/jquery-1.7.1.min.js"></script>

<script type="text/javascript">
	
</script>

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
						<li><a href="<%=basePath%>commodity!index.action" >首页</a>
						</li>
						<li><a
							href="<%=basePath%>requirement.action?mypage=first&jhpage=0">求购信息</a>
						</li>
						<li><a
							href="<%=basePath%>commodity!IT.action?mypage=first&jhpage=0">数码产品</a>
						</li>
						<li><a
							href="<%=basePath%>commodity!book.action?mypage=first&jhpage=0">书籍</a>
						</li>
						<li><a
							href="<%=basePath%>commodity!bycycle.action?mypage=first&jhpage=0">单车</a>
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
							title="keyword" onFocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END of templatemo_menubar -->
			<!-- 主页 -->
			<div id="templatemo_main">
			    <div id="main_left">
			       <h3 align="center" id="lh">商品分类</h3>
			       <ul>
			          <!-- <li>&nbsp;</li> -->
			          <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电脑专区</a></li>
				      <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机通讯</a></li>
				      <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;书籍资料</a></li>
				      <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服装服饰</a></li>
				      <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数码产品</a></li>
				      <li><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生活电器</a></li>
			       </ul>
			    </div>
			    <div id="main_middle"></div>
			    <div id="main_right">
				<table id="commoditytable">
					<%					    
						//分页
						String mypage = null;//分页   
						int jhpage = 0; 
						if(session.getAttribute("mypage") != null){
							 mypage = (String)session.getAttribute("mypage");
						}else{
							mypage = "first";
						}
						System.out.println("mypage:" + mypage);
						
					    Pagination p = new Pagination();
					    if(mypage.equals("next")){		
					    	Pagination.setAllSize(16);    							    	
						    Pagination.setPage( Integer.parseInt(request.getAttribute("jhpage").toString())+ Pagination.getAllSize());		
						    jhpage =  Pagination.getPage();//第三次用的	    
					        
					    }else if(mypage.equals("past")){
					    	Pagination.setAllSize(16);    
					    	System.out.println(Integer.parseInt(request.getAttribute("jhpage").toString()));
						    Pagination.setPage( Integer.parseInt(request.getAttribute("jhpage").toString())- Pagination.getAllSize());		
						    jhpage =  Pagination.getPage();//第三次用的	
						    System.out.println("jhpage" + jhpage);
					    }else if(mypage.equals("first")){
					    	Pagination.setPage(0);
					    	Pagination.setAllSize(16);
					    } 					    					   
					    
						  CommodityDBDao cd = DaoFactory.getCommodityDBDao();
						  List<Commodity>  peList = cd.queryCommodity();						  
						  System.out.println("mark:"+peList.size());	  												  											      
					      
					      for(int i = 0;i <peList.size();i = i + MyProperties.CommodityWightAcount){	 
						%>
					                <tr id="commoditytr" >
						<%
									for(int j = 0 ;j < MyProperties.CommodityWightAcount; j++){
							        	Commodity com ;
							        	if(j < peList.size() ){
							        	    if(peList.size() < 16){
							        			if(j < peList.size() - i){
							        				com =(Commodity)peList.get(i + j);
							        				%>
														 <td id="commoditytd">																			
														    <div id="commoditydiv">																
																	<a href="#">
																	    <img alt="" src="<%=basePath%>imageLaction.action?type=<%=MyProperties.co %>&imageLocation=<%=com.getCoimg()%>"> 
																		 <% 
																	      String coname = com.getConame();
																	      if(coname.length() > 4 ){
																	    	  
																	    	  coname = coname.substring(0,4) + "...";
																	      }
																	    %>
																		<span id="cspan1">商品名：<%=coname%></span><br>
																		<span id="cspan2">价格：<%=com.getCoprise()%></span>
																     </a>											
															</div>
														
													     </td>
													<%
															        			}
							        		}else{
								        		 com =(Commodity)peList.get(i + j);
															        		 %>
													<td id="commoditytd">					
														
														<div id="commoditydiv">																
																	<a href="#">
																	    <img alt="" src="<%=basePath%>imageLaction.action?type=<%=MyProperties.co %>&imageLocation=<%=com.getCoimg()%>"> 
																	    <% 
																	      String coname = com.getConame();
																	      if(coname.length() > 4 ){
																	    	  
																	    	  coname = coname.substring(0,4) + "...";
																	      }
																	    %>
																		<span id="cspan1">商品名：<%=coname%></span><br>
																		<span id="cspan2">价格：<%=com.getCoprise()%></span>
																     </a>																
															</div>
														
													</td>
						<%
								        	}							        								        	 						        	  
							        	}							        	
							        }
						%>
					</tr>
					<%
						    
							}
						%>

				</table>
				</div>
				<br><br>

				<div id="pagination">
					<a
						href="<%=basePath%>commodity!index.action?mypage=past&jhpage=<%=jhpage %>">上一页</a>
					<a
						href="<%=basePath%>commodity!index.action?mypage=next&jhpage=<%=jhpage %>">下一页</a>
				</div>

			</div>			
			<div id="sidebar" class="float_l"></div>
		</div>
		<div id="content" class="float_r faqs"></div>

		<div id="templatemo_footer"></div>

	</div>	
	</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>