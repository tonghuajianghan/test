<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="jquery-1.8.2.js" type="text/javascript"></script>
<script src="jquery.dataTables.js" type="text/javascript"></script>
<script type="text/javascript">
  $(document).ready(function(){
	 //$('.student').dataTable(); 
	 $('#hh').dataTable(); 
	 //alert("成功");
  });
</script>
</head>
<body>
  <table border="4" id="hh" class="student">
    <!-- <tr>
      <th align="center">表格</th>
    </tr> -->
    <tr>
      <td>序号</td>
      <td>名字</td>
      <td>年龄</td>
      <td>籍贯</td>       
    </tr>
    <tr>
      <td>01</td>
      <td>姜晗</td>
      <td>12</td>
      <td>吉林</td>       
    </tr>
    <tr>
      <td>02</td>
      <td>晓晓</td>
      <td>12</td>
      <td>辽宁</td>       
    </tr>
    <tr>
      <td>03</td>
      <td>韩寒</td>
      <td>17</td>
      <td>浙江</td>       
    </tr>
  </table>
</body>
<!-- <script type="text/javascript">
function hh(){
	  //alert("成功");
	  //document.write("有成功了");
	$('.student').dataTable(); 
}
	 
  
</script> -->
</html>
