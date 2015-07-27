<!--
  求购详细信息展示
  向用户展示详细的求购信息！
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>求购信息</title>
<link href="../../css/common.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../../css/ddsmoothmenu.css" />
<link rel="stylesheet" href="../../css/requirementShowFull.css"
	type="text/css"></link>
<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	var mod_menu=$(".mod-menu");//导航模块区
	var menu=function(){
		var menuItem=$(".menu-item li");//选择导航列表
		menuItem.each(function(){
			var _index=$(this).index();//获取当前选择菜单列表的索引
			$(this).mouseenter(function(){
				var y = $(this).position().top+1;//获取当前鼠标滑过的列表的顶部坐标
				$(".menu-cont").show();
				$(".menu-cont").css("top",y);//需要显示的对应索引内容
				$(this).addClass("mouse-bg").siblings().removeClass("mouse-bg");
				$(".menu-cont>div").eq(_index).show().siblings().hide();
			});
		});/*导航菜单菜单*/
		$(".mod-menu").mouseleave(function(){
			$(".menu-cont").hide();
			menuItem.removeClass("mouse-bg");
		});
	};//展开二级菜单	
	menu();//执行展开二级菜单函
});
</script>
</head>
<body>

	<div id="templatemo_body_wrapper">
		<div id="templatemo_wrapper">
			<div id="templatemo_header">
				<div class="cleaner"></div>
			</div>
			<!-- END of templatemo_header -->
			<div id="templatemo_menubar">
				<div id="top_nav" class="ddsmoothmenu">
					<ul>
						<li><a href="../index.jsp">首页</a></li>
						<li><a href="products.jsp">求购信息</a></li>
						<li><a href="about.jsp">数码产品</a></li>
						<li><a href="faqs.jsp">书籍</a></li>
						<li><a href="checkout.jsp">单车</a></li>
						<li><a href="contact.jsp">地图</a></li>
					</ul>
					<br style="clear: left" />
				</div>
				<!-- end of ddsmoothmenu -->
				<div id="templatemo_search">
					<form action="#" method="get">
						<input type="text" value=" " name="keyword" id="keyword"
							title="keyword" onfocus="clearText(this)"
							onblur="clearText(this)" class="txt_field" /> <input
							type="submit" name="Search" value=" " alt="Search"
							id="searchbutton" title="Search" class="sub_btn" />
					</form>
				</div>
			</div>
			<!-- END of templatemo_menubar -->

			<div id="templatemo_main">
				<div class="mod-menu">
				   <ul class="menu-item">
				      <li>电脑专区</li>
				      <li>手机通讯</li>
				      <li>书籍资料</li>
				      <li>服装服饰</li>
				      <li>数码产品</li>
				      <li>生活电器</li>
				   </ul>
				   <div class="menu-cont" style="display:none;">
		     <div class="menu-cont-list" style="display:none;">
			<ul>
			 	<li>
					<h3><a href="#">笔记本</a></h3>
					<div class="menu-list-link">
					  <a href="#">14寸</a>
					  <span class="long-string">|</span>
					  <a>15寸</a>
					  <span class="long-string">|</span>
					 <a href="#">14寸</a>
					 <span class="long-string">|</span>
					  <a>15寸</a>
					</div>
				</li>
				<li>
					<h3><a href="#">台式机</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">电脑配件</a></h3>
					<div class="menu-list-link">
						<a href="#">内存条</a>
						<span class="long-string">|</span>
						<a href="#">显卡</a>
						<span class="long-string">|</span>
						<a href="#">cpu</a>
					</div>
				</li>
				<li>
					<h3><a href="#">平板电脑</a></h3>
					<div class="menu-list-link">
						<a href="#">九成新</a>
						<span class="long-string">|</span>
						<a href="#">八成新</a>
						<span class="long-string">|</span>
					</div>
				</li>
			</ul>
		</div>
		
		<div class="menu-cont-list" style="display:none;">
			<ul>
				<li>
					<h3><a href="#">智能手机</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">普通手机 </a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">电池/充电器/移动电源 </a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">贴膜/保护套</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">手机底座</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">存储卡/耳机</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">手机挂件/饰品 </a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">对讲机</a></h3>
					<div class="menu-list-link"></div>
				</li>
			</ul>
		</div>
		
		<div class="menu-cont-list" style="display:none;">
			<ul>
				<li>
					<h3><a href="#">小说</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">外语_雅思托福</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">考研资料</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">计算机</a></h3>
					<div class="menu-list-link">
						<a href="#">操作系统</a>
						<span class="long-string">|</span>
						<a href="#">数据结构</a>
						<span class="long-string">|</span>
						<a href="#">离散数学</a>
						<span class="long-string">|</span>
						<a href="#">编程</a>
						<span class="long-string">|</span>
						<a href="#">组成原理</a>
					</div>
				</li>
				<li>
					<h3><a href="#">教材</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">动漫</a></h3>
					<div class="menu-list-link">
						<a href="#"></a>
						<span class="long-string">|</span>
						<a href="#">漫画</a>
						<span class="long-string">|</span>
						<a href="#">海贼王</a>
						<span class="long-string">|</span>
						<a href="#">葫芦娃</a>
						<span class="long-string">|</span>
						<a href="#">死神</a>
					</div>
				</li>
				<li>
					<h3><a href="#">青春文学</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">培训相关</a></h3>
					<div class="menu-list-link"></div>
				</li>
			</ul>
		</div>
		
		<div class="menu-cont-list" style="display:none;">
			<ul>
				<li>
					<h3><a href="#">运动服</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">运动鞋</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">男装</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">女装</a></h3>
					<div class="menu-list-link"></div>
				</li>
			</ul>
		</div>
		
		<div class="menu-cont-list" style="display: none;">
			<ul>
				<li>
					<h3><a href="#">ipad/ipod touch</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">MP3/MP4/电子词典</a></h3>
					<div class="menu-list-link">
						<a href="#">Womens Hats</a>
						<span class="long-string">|</span>
						<a href="#">Womens Scarves</a>
					</div>
				</li>
				<li>
					<h3><a href="#">CD/DV</a></h3>
					<div class="menu-list-link">
						<a href="#">Earrings</a>
						<span class="long-string">|</span>
						<a href="#">Necklaces</a>
						<span class="long-string">|</span>
						<a href="#">Rings</a>
					</div>
				</li>
				<li>
					<h3><a href="#">数码相机 </a></h3>
					<div class="menu-list-link"></div>
				</li>
			</ul>
		</div>
		
		<div class="menu-cont-list" style="display: none;">
			<ul>
				<li>
					<h3><a href="#">电风扇</a></h3>
					<div class="menu-list-link"></div>
				</li>
				<li>
					<h3><a href="#">电饭煲</a></h3>
					<div class="menu-list-link">
						<a href="#">Womens Hats</a>
						<span class="long-string">|</span>
						<a href="#">Womens Scarves</a>
					</div>
				</li>
				<li>
					<h3><a href="#">电磁炉</a></h3>
					<div class="menu-list-link">
						<a href="#">Earrings</a>
						<span class="long-string">|</span>
						<a href="#">Necklaces</a>
						<span class="long-string">|</span>
						<a href="#">Rings</a>
					</div>
				</li>
				<li>
					<h3><a href="#">电热壶</a></h3>
					<div class="menu-list-link"></div>
				</li>
			</ul>
		</div>
	   </div>
	     
			</div>
			<!-- 中间显示信息 -->
			 <div class="cen">
			 <div class="cen-top">
			 <div class="cen-top-left">电脑专区</div>
			  <div class="cen-top-right"></div>
			 </div>
			 <div class="infor-list-first">
			   <div class="infor-list-left"></div>
			  <a href="#">[成新] 国四多利卡散装饲料车多少钱15997851277 </a><br>
			  <a href="#">步步高语言复读机，配送说明书，（全新）步步高磁带两盒... </a>
			  </div>
			  <div class="infor-list">
			   <div class="infor-list-left"></div>
			  <a href="#">[成新] 国四多利卡散装饲料车多少钱15997851277 </a><br>
			  <a href="#">步步高语言复读机，配送说明书，（全新）步步高磁带两盒... </a>
			  </div>
			  <div class="infor-list">
			   <div class="infor-list-left"></div>
			  <a href="#">[成新] 国四多利卡散装饲料车多少钱15997851277 </a><br>
			  <a href="#">步步高语言复读机，配送说明书，（全新）步步高磁带两盒... </a>
			  </div>
			 </div>
		</div>
		<!-- END of templatemo_main -->
		<!-- END of templatemo_wrapper -->
	</div>
	</div>
	<!-- END of templatemo_body_wrapper -->
</body>
</html>