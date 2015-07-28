<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='js/autoComplete2.js'></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script>
  $(function(){
	  var availableTags = [
	                       "c",
	                       "asp",
	                       "c++",
	                       "c#",	                     	                       
	                       ];
	  $("#tags").autocomplete({
		  source: availableTags,
		  select: function(event,ui){
			  this.value = ui.item.value;
			  alert(ui.item.value);
		  }
	  });
  });
</script>
</head>
<body>

</body>
</html>