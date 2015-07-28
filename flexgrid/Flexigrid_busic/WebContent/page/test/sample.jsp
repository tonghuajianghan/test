<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Conent-Type" content="text/html; charset=utf-8" />
<title>Flexigrid</title>


<link rel="stylesheet" type="text/css" href="../css/flexigrid.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/flexigrid.js"></script>
</head>

<body>
        <!-- 这是第一个简单的demo，如何加载flexigrid -->
		<table id="flexme1">
			<thead>
				<tr>
					<th width="100">Col 1</th>
					<th width="100">Col 2</th>
					<th width="200">Col 3 is a long header name</th>
					<th width="300">Col 4</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>This is data 1 with overflowing content</td>
					<td>This is data 2</td>
					<td>This is data 3</td>
					<td>This is data 4</td>
				</tr>
				<tr>
					<td>This is data 1</td>
					<td>This is data 2</td>
					<td>This is data 3</td>
					<td>This is data 4</td>
				</tr>
				<tr>
				  <td>
				    <%
				      
				    %>
				    
				  </td>
				
				</tr>
			</tbody>
		</table>
		<script type="text/javascript">
		//<![CDATA[
		jQuery(document).ready(function($) {  //页面打开时加载flexigird
			$('#flexme1').flexigrid({
				
			});
		});
		//]]>
		</script>
</body>
</html>