<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8s">
<title>Insert title here</title>
<style type="text/css">
  /* .menu ul{list-style:none;} */
  .menu {list-style:none;}
  .menu li {float:left;}
  .minimenu li {float:left;}
  /* .menu ul li ul li{float:right;} */
</style>
</head>
<body>
  <div>菜单的横向排版与子菜单的纵向排版相结合</div>
  <div>未成功</div>
 
  <ul class="menu">
     <li>菜单
      <div>     
        <ul class="minimenu">
          <li>保存</li>
          <li>另为存</li>
          <li>退出</li>
        </ul>
      </div>
     </li>
     <li>编辑
        <ul>
          <li>修改</li>
          <li>撤销</li>
          <li></li>
        </ul>
     </li>
     <li></li>
  </ul>
 
</body>
</html>