<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="..\css\main.css" type="text/css" />
<script language="javascript" src="..\js\main.js"></script>

<title>Ext 做的后台管理系统</title>
</head>
<body>
<div class="little_navi">
 <ul>
  <li ><a href="#">注册</a></li>
  <li ><a href="#">登陆</a></li>
  <li ><a href="#">加为收藏</a></li>
  <li ><a href="#">返回首页</a></li>
 </ul>
</div>
<div class="head"></div>
<div class="content">
<div class="left">
   <div class="border"> 
   </div>
  <input id="geren"  type="button"  onmouseover="cursorChange('geren')" onclick="create('geren')" value="个人信息" />
  <input id="lunwen"  type="button"  onmouseover="cursorChange('lunwen')" onclick="create('lunwen')" value="论文管理" />
   <input id="liuyan"  type="button" onmouseover="cursorChange('liuyan')" onclick="create('liuyan')" value="留言管理" />
   <input id="xitong" type="button" onmouseover="cursorChange('xitong')" onclick="create('xitong')"  value="系统管理" />
   <input id="bangzhu"  type="button" onmouseover="cursorChange('bangzhu')" onclick="create('bangzhu')"  value="帮助信息" />
   
</div>
<div class="right">
   <div class="right_border">
      <div onclick="divOnclick('w1')" onmouseover="cursorChange('w1')" class="h_navi" id="w1"><span>个人信息</span><input id="ww1"   onclick="deleteDiv('ww1')" type="button" /></div>
      <div onclick="divOnclick('w5')" onmouseover="cursorChange('w5')" class="h_navi" id="w5"><span>论文管理</span><input id="ww5"   onclick="deleteDiv('ww5')" type="button" /></div>
      <div onclick="divOnclick('w2')" onmouseover="cursorChange('w2')" class="h_navi" id="w2"><span>留言管理</span><input id="ww2"  onclick="deleteDiv('ww2')" type="button" /></div>
      <div onclick="divOnclick('w3')" onmouseover="cursorChange('w3')" class="h_navi" id="w3"><span>系统管理</span><input id="ww3" onclick="deleteDiv('ww3')"  type="button" /></div>
      <div onclick="divOnclick('w4')" onmouseover="cursorChange('w4')" class="h_navi" id="w4"><span>帮助信息</span><input id="ww4"  onclick="deleteDiv('ww4')" type="button" /></div>
   </div>
   <div id="content0" class="right_content">
    <p class="welcom">欢迎来到长春理工大学论文管理系统</p>
     <div class="lastNews">
      <div class="lastNavi"><p>最新信息</p></div>
      <div class="lastContent">
       <ul>
        <li><a href="#">1.我校将举办ＸＸＸ</a></li>
        <li><a href="#">1.我校将举办ＸＸＸ</a></li>
        <li><a href="#">1.我校将举办ＸＸＸ</a></li>
        <li><a href="#">1.我校将举办ＸＸＸ</a></li>
        <li><a href="#">1.我校将举办ＸＸＸ</a></li>
       </ul>
      </div>
     </div>
   </div>
   <div id="content1" class="right_content">
   <div class="search"><input class="searchBtn" type="button" /> <input class="searchText" type="text" /></div>
   <div class="usersInf">
    <div class="newUser"><!--新用户信息-->
     <div class="naviNew"><div class="newDiv"> <p>本人信息</p></div></div>
     <div class="userContent">
      <div class="picInf">
       <img src="img/people.jpg" /><p>资深教师</p>
      </div>
     <table>
     <tr> <td>姓名</td><td>性别</td><td>籍贯</td><td>论文篇数</td><td>获奖情况</td></tr>
     <tr> <td>abc</td><td>abc</td><td>abc</td><td>abc</td><td>abc</td></tr>
     </table>
     </div>
    </div>
   </div>
   <div class="othersInf">
   <div class="otherNavi"><p>更多热点</p></div>
    <div  class="otherContent">
     <div class="news">
      <ul><li><a href="#">1.最新消息</a></li><li><a href="#">2.最新消息</a></li><li><a href="#">3.最新消息</a></li><li><a href="#">4.最新消息</a></li><li><a href="#">5.最新消息</a></li><li><a href="#">6.最新消息</a></li></ul>
     </div>
     <div class="relative">
     <div class="naviNew"><div class="newDiv"> <p>友情链接</p></div></div>
     <div class="reCon">
      <ul><li><a href="#">吉林大学</a></li><li><a href="#">吉林大学</a></li><li><a href="#">吉林大学</a></li><li><a href="#">吉林大学</a></li></ul>
     </div>
     </div>
    </div>
   </div>
   </div>
   <div id="content2" class="right_content">
     <div class="message"><p>留言板</p></div>
      <div class="messageShow">
       <ul>
        <li>
         <p>XXX:AAAAAAAAA</p>
         <span><a class="returna" href="#">回复</a></span> <span><a class="delea" href="#">删除</a></span>
        </li>
        <li>
         <p>XXX:AAAAAAAAA</p>
         <span><a class="returna" href="#">回复</a></span><span><a class="delea" href="#">删除</a></span>
        </li>
        <li>
         <p>XXX:AAAAAAAAA</p>
         <span><a class="returna" href="#">回复</a></span><span><a class="delea" href="#">删除</a></span>
        </li>
        <li>
         <p>XXX:AAAAAAAAA</p>
        <span><a class="returna" href="#">回复</a></span><span><a class="delea" href="#">删除</a></span>
        </li>
        <li>
         <p>XXX:AAAAAAAAA</p>
        <span><a class="returna" href="#">回复</a></span><span><a class="delea" href="#">删除</a></span>
        </li>
       </ul>
      </div>
   </div>
   <div id="content3" class="right_content">
    <a class="content3_a" href="#">重置密码</a>
    <textarea>论文提交区</textarea>
    <form action="">
    <input class="right_contentinput" type="submit" value="提交" />
    <input class="right_contentinput" type="button" value="重置" />
    </form>
   </div>
   <div id="content4" class="right_content">
    <ul class="right_contentul">
    <li>1.网站的主要作用</li>
    <li>&nbsp;&nbsp;&nbsp;网站的主要作用是网站的主要作用是。。。。。。。。</li>
    <li>2.如何提交论文</li>
    <li>&nbsp;&nbsp;&nbsp;如何如何如何如何如何如何如何。。。。。。。。</li>
    </ul>
   </div>
   <div id="content5" class="right_content">
   <form action="">
   <span> 要查找的论文题目：</span>
   <select>
   <option>aaaaaaa</option>
   <option>bbbbbbb</option>
   <option>ccccccc</option>
   <option>ddddddd</option>
   <option>fffffff</option>
   <option>ggggggg</option>
   <option>hhhhhhh</option>
   </select>
   <input class="seek" type="button" value="查找" />
   </form>
   <!--<form action="">
   <span> 要删除的论文题目：</span>
   <select>
   <option>aaaaaaa</option>
   <option>bbbbbbb</option>
   <option>ccccccc</option>
   <option>ddddddd</option>
   <option>fffffff</option>
   <option>ggggggg</option>
   <option>hhhhhhh</option>
   </select>
   <input class="seek" type="button" value="删除" />
   </form>-->
   <form action="">
   <input class="showarticle" type="button" value="显示全部论文" />
   </form>
   <table>
   <tr><td>作者</td><td>著作</td><td>何时发表 <span id="tdSpan"><input type="button" value="删除" /></span></td></tr>
   <tr><td>作者</td><td>著作</td><td>何时发表  <span id="tdSpan"><input type="button" value="删除" /></td></tr>
   <tr><td>作者</td><td>著作</td><td>何时发表  <span id="tdSpan"><input type="button" value="删除" /></td></tr>
   <tr><td>作者</td><td>著作</td><td>何时发表  <span id="tdSpan"><input type="button" value="删除" /></td></tr>
   <tr><td>作者</td><td>著作</td><td>何时发表  <span id="tdSpan"><input type="button" value="删除" /></td></tr>
   <tr><td>作者</td><td>著作</td><td>何时发表  <span id="tdSpan"><input type="button" value="删除" /></td></tr>
   </table>
   </div>
</div>
</div>
<div class="bottom"></div>
</body>
</html>