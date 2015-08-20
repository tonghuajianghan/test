<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="tools" prefix="t" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <tiles:insertAttribute name="head" />
    <style type="text/css">
    	body, html { overflow:auto; }
    </style>
    <script type="text/javascript">
		$(function() {
			// 窗体加载完成后显示页面内容
			$(window).load(function() {
				$(".popup").css("visibility", "visible");
			});
		});
	</script>
</head>
<body class="popup">
	<script type="text/javascript" src="js/loading/loading.bind.js?t=${t:config('token.script')}"></script>
	<tiles:insertAttribute name="main" />
	 
	<script type="text/javascript">
		$(function() {
			// 初始化必输项校验标记
			validateMark(".important", "star-outer-aft");
		});
	</script>
</body>
</html>