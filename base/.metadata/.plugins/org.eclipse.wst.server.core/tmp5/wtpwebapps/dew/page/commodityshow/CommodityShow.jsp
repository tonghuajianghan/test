<!--
      二级页面
     1.用于显示用户已发布的商品信息的公共页面
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.cust.dew.util.Pagination"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("basePath",basePath);
%>



<script type="text/javascript">
  function page(){
	<%
	  Pagination.setPage(0);
	%>
  }
</script>
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品信息</title>
<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/ddsmoothmenu.css" />
</head>

<body>

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">
 
	<div id="templatemo_header">
    	
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
						<li><a href="<%=basePath%>index.jsp">首页</a>
						</li>
						<li><a href="<%=basePath%>requirement.action" onclick="page()">求购信息</a>
						</li>
						<li><a href="<%=basePath%>commodity!IT.action">数码产品</a>
						</li>
						<li><a href="<%=basePath%>commodity!book.action">书籍</a>
						</li>
						<li><a href="<%=basePath%>commodity!bycycle.action">单车</a>
						</li>
						<li><a href="<%=basePath%>map.action">地图</a>
						</li>
					</ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        <div id="templatemo_search">
            <form action="#" method="get">
              <input type="text" value=" " name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
              <input type="submit" name="Search" value=" " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
            </form>
        </div>
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        </div>
        <div id="content" class="float_r faqs">
        	
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>