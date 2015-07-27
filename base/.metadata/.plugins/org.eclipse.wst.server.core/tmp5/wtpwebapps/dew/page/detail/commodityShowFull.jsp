<!--
      二级页面
     两个功能
     1.用于显示用户已发布的商品信息
     2.用于显示用户发布的需求信息 
-->

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品详细信息</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/commodityShowFull.css" />



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
                <li><a href="../index.jsp">首页</a></li>
                <li><a href="products.jsp">求购信息</a></li>
                <li><a href="about.jsp">数码产品</a></li>
                <li><a href="faqs.jsp" >书籍</a></li>
                <li><a href="checkout.jsp">单车</a></li>
                <li><a href="contact.jsp">地图</a></li>
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
    	<div id = "commodity_left">
    		<div id = "shopping_guide">
    			<span id="bottom"></span>
				<h3>商品导航</h3>
				<div id="shopping_guide1">
							<ul id="shopping_guide_list">
								<li id="first"><a href="#">服装</a>
								</li>
								<li><a href="#"></a>
								</li>
								<li><a href="#">书籍</a>
								</li>
								<li><a href="#">数码产品</a>
								</li>
								<li><a href="#">生活用品</a>
								</li>
								<li><a href="#">首饰手表</a>
								</li>
								<li><a href="#">运动户外</a>
								</li>
								<li><a href="#">音乐空间</a>
								</li>
								<li><a href="#">杂七杂八</a>
								</li>
							</ul>
				</div>
				<div id = "wanted_information">
				
				</div>
    		</div>
    	</div>
    	<div id = "commodity_right">
    		<div id = "commodity_picture">
			</div>
			<div id = "commodity_fullinformation">
				<div id = "commodity_fullinformation_lr">
					<div id = "commodity_fullinformation_left">
					
					</div>
					<div id = "commodity_fullinformation_right">
					
					</div>
				</div>
				<div id = "commodity_fullinformation_bottom">
				</div>
				
			</div>
    	</div>
        	
    </div> <!-- END of templatemo_main -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>