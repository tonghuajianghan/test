<!-- 注册页面 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页面</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/register.css" />


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
    <div id="register1">
	             <div id = "login_title">用户注册</div>
					<div id="contact_form1_l">
						<div class="font-h">用户名:</div>
						<div class="font-h1">邮箱:</div>
						<div class="font-h1">密码:</div>
						<div class="font-h1">确认密码:</div>
						<div class="font-h1">验证码:</div>

					</div>
					<div id="contact_form1_r">
						<form method="post" name="register" action="<%=basePath%>register.action">
							<input type="text" id="author" name="author"class="required input_field" /> 
							<input type="text" name="email" id="password1" class="required input_field" >
							<input type="password"name="password2" id="password2" class="input_field" /> 
							<input type="password" name="password3" id="password3"class="input_field" /> 
							<input type="text" name="yanzheng1" id="yanzheng1"class="input_field" /> 
							<input type="text" name="yanzheng2" id="yanzheng2"class="input_field" /> 
							<input type="submit" class="submit_btn"name="submit" id="submit" value="注册" />
						</form>
					</div>
				</div>
				<div id="register2"></div>
				<div class="content_half float_r"></div>
				<div class="cleaner h40"></div>
				<div class="cleaner"></div>
			</div><!-- END of templatemo_main -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>