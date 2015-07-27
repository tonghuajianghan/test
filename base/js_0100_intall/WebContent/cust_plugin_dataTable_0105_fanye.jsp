<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="jquery-1.8.2.js" type="text/javascript"></script>
<script src="jquery.dataTables.js" type="text/javascript"></script>
<script type="text/javascript" >
	$(document).ready(function() {
		 alert("wwww");
	    $('#hh').dataTable( {	     
	        "bPaginate": false, //翻页功能
	        "bLengthChange": false, //改变每页显示数据数量
	        "bFilter": true, //过滤功能,search窗口显示，隐藏 
	        "bSort": false, //排序功能
	        "bInfo": true,//页脚信息
	        "bAutoWidth": true//自动宽度
	    } );
	    alert("wwww");
	} );
</script>
</head>
<body>
  <table id="hh" border="1">
    <thead>
      <tr>
        <th>Roll</th>
        <th>Name</th>
        <th>Age</th>
      </tr>
    </thead>
    <tbody>
	  <% 
	    int i;
	    for(i = 0;i < 45;i++){
	  %>
	    <tr>
	      <td><%=i %></td>
	      <td>hh</td>
	      <td><%=i + 15 %></td>
	    </tr>
	  <% 	
	    }
	  %>
	</tbody>  
  </table>
</body>
</html>