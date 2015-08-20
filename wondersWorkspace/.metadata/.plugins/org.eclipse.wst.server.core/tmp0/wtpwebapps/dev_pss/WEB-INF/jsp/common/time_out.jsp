<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="tools" prefix="t" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>登录超时</title>
	<script type="text/javascript">
		window.top.location = "${t:config('timeout.url')}";
	</script>
</head>
</html>