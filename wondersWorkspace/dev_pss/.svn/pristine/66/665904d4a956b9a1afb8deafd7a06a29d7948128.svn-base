<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="tools" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title><tiles:insertAttribute name="title" /></title>
    <tiles:insertAttribute name="head" />
	<link type="text/css" rel="stylesheet" href="css/admin.css?t=${t:config('token.css')}" />
    
	<script type="text/javascript">
		$(function() {
			// 初始化对话显示框高度
			$(window).resize(function() {
				var wh = $(window).height();
				var nh = $(".la-r .nav").height();
				var mh = $(".la-r .main").height();
				var r = $(".la-r");
				r.height(nh + mh > wh ? (nh + mh) : wh);
				$(".la-l").height(r.height() + parseInt(r.css("border-top-width")) + parseInt(r.css("border-bottom-width")) + parseInt(r.css("padding-top")) + parseInt(r.css("padding-bottom")));
			}).load(function() {
				$(".layout-admin").css("visibility", "visible");
			}).resize();
		})
	</script>
</head>

<body class="layout-admin">
	<script type="text/javascript" src="js/loading/loading.bind.js?t=${t:config('token.script')}"></script>
	
	<div class="la-l">
		<div class="logo"></div>
		<div class="menu"><tiles:insertAttribute name="menu" /></div>
	</div>
	
	<div class="la-r">
		<div class="nav">
			<ul>
				<li>${empty user.nickName ? user.userName : user.nickName}</li>
				<li><a href="${base}passport/center">个人中心</a></li>
				<li><a href="${base}passport/logout">退出</a></li>
			</ul>
		</div>
		<div class="main clearfix"><tiles:insertAttribute name="main" /></div>
	</div>
</body>
</html>