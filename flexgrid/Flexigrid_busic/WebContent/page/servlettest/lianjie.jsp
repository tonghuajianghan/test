<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="register.js"></script>
</head>
<body>
     <form action="../../H_test" method = "post">
      <table>
         <tr><th>登录表</th></tr>
         <tr>
            <td>
               <p>用户名</p>
               <input type ="text" id = "iname"  name = "name"/>
            </td>
         </tr>
         <tr>
            <td>
               <p>密码</p>
               <input type = "password" id ="ipw" name = "npw" />
            </td>         
         </tr>
         <tr>
            <td>
               <input type = "submit"  name = "sub" id = "idcheck"  value = "提交" />
               <input type = "reset"  />
            </td>         
         </tr>
      </table>
   </form>

   

   

</body>
</html>