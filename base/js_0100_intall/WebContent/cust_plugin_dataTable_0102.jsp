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
  $(document).ready(function(){
	  //alert("rrr");
	  $('#hh').dataTable();	  
  });
</script>
</head>
<body>
  <table id="hh" border="1">
     <thead>
	    <tr>
	      <th>Roll</th><th>Name</th>
	    </tr>
     </thead>
     <tbody>
       <tr>
         <td>01</td>
         <td>姜晗</td>
       </tr>
     </tbody>
  </table>
</body>
</html>