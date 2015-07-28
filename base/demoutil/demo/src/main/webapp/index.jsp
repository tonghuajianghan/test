<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.edu.cust.demo.MyDetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<%-- ((MyDetails)((CasAuthenticationToken)request.getUserPrincipal()).getUserDetails()).getEmail() --%>	
	<title>银行取款机</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	
	<style type="text/css">
		ul {
		  list-style-type:none;
		  margin: 0;
		  padding: 0;
		}
		
		ul a {
		  display: block;
		  text-decoration: none;	
		}
		
		ul li {
		  margin-top: -13px;
		}
		
		ul li a {
		  background: #99CCCC;
		  color: #000;
		  padding-left: 0px;
		}
		
		ul li a:hover {
		  background: #aaa;
		  border-left: 5px #000 solid;
		  padding-left: 20px;
		}
	</style>
	
</head>

<body class="easyui-layout">

	<div data-options="region:'north',split:false" style="height:100px;">
		<h1>
			欢迎：<%=request.getRemoteUser() %>
			<!-- request.isUserInRole("ROLE_i")  -->
		</h1>
	</div>
	
    <div data-options="region:'west',title:'导航',split:true" style="width:220px;">
    	<div class="easyui-accordion" fit="true" border="false"> 
    		<div title="业务操作" selected="true" style="overflow:auto;"> 
    			<ul>
    				<li><a href="javascript:addTab('存款','atm/save_form.action')"><h2>存&nbsp;&nbsp;款</h2></a></li>
    				<li><a href="javascript:addTab('取款','atm/take_form.action')"><h2>取&nbsp;&nbsp;款</h2></a></li>
    				<li><a href="javascript:addTab('转账','atm/tran_form.action')"><h2>转&nbsp;&nbsp;账</h2></a></li>
    			</ul>
    		</div>
    		
    		<div title="其他操作" selected="true" style="overflow:auto;"> 
    			<ul>
    				<li><a href="javascript:addTab('日志','atm/logs.jsp')"><h2>操作日志</h2></a></li>
    				<li><a href="javascript:addTab('余额查询','atm/welcome.action')"><h2>余额查询</h2></a></li>
    				<li><a href="javascript:void(0);" onclick="top.location='/demo/logoff.jsp';return false;"><h2>退出系统</h2></a></li>
    			</ul>
    		</div>
    	</div>
    </div>
    
    <div data-options="region:'center',split:false">
		 <div id="main-center" class="easyui-tabs" fit="true" border="false">  
	        <div title="首页" style="padding:20px;" closable="false">  
	             
	           		<p><h2>欢迎使用ATM自助提款机</h2></p>  
	           
	        </div>  
	    </div>      
    </div>
    
    <div data-options="region:'east',title:'通知',split:true" style="width:200px;"></div>
    
    <div data-options="region:'south',split:false" style="height:45px;" align="center">
    	<label>版权所有：长春理工大学</label>
    </div>
    
</body>
</html>
