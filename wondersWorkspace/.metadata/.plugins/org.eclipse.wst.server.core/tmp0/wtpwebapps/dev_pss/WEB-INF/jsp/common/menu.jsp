<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c"%>

<ul>
    <c:if test="${user.userType eq USER_TYPE_SYS}">
	    <li rel="${MODUAL_USER_MANA}" onclick="menu('${base}user/list');">用户管理</li>
    </c:if>
    <c:if test="${user.userType eq USER_TYPE_PROD}">
		<li rel="${MODUAL_QA_MANA}" onclick="menu('${base}qa/qa_list')">问题管理</li>
    </c:if>
</ul>

<script type="text/javascript">
	$(function() {
		// 初始化菜单背景
		$(".la-l .menu li").each(function() {
			if($(this).attr("rel") == "${sessionScope[SESSION_MODUAL]}") {
				$(this).addClass("sel");
			} else {
				$(this).removeClass("sel");
			}
		})
	});

	// 菜单跳转
	function menu(to) {
		window.location = to;
	}
</script>