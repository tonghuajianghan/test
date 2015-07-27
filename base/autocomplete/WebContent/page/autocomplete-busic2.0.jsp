<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='js/jqm.autoComplete-1.5.2.js'></script>
<script type='text/javascript' src='js/jquery-1.3.2.min.js'></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script>
$("#tags").autocomplete(["c++","java", "php", "coldfusion","javascript"], { 
	width: 1020, 
	max: 4, 
	highlight: false, 
	multiple: true, 
	multipleSeparator: "", 
	scroll: true, 
	scrollHeight: 300 
	}); 
</script>
</head>
<body>
  <input name="tags" class="tags" id="tags" />
</body>
</html>