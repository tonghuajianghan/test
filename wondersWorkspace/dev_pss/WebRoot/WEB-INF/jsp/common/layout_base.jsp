<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="tools" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<title><tiles:insertAttribute name="title" /></title>
    <tiles:insertAttribute name="head" />
</head>

<body>
	<script type="text/javascript" src="js/loading/loading.bind.js?t=${t:config('token.script')}"></script>
	<tiles:insertAttribute name="main" />
</body>
</html>