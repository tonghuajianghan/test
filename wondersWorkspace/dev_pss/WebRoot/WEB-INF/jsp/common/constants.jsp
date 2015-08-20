<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="com.wondersgroup.core.constant.GlobalConstants"%>
<%@ page import="com.wondersgroup.core.constant.DicConstants"%>
<%@ page import="com.wondersgroup.pss.constant.BusinessConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="tools" prefix="t" %>

<c:set var="YES_VALUE" value="<%=GlobalConstants.YES_VALUE%>" scope="request" />
<c:set var="NO_VALUE" value="<%=GlobalConstants.NO_VALUE%>" scope="request" />

<!-- 根路径信息 -->
<c:set var="base" value="<%=session.getAttribute(GlobalConstants.SESSION_BASE)%>" scope="request" />
<!-- 用户会话信息 -->
<c:set var="user" value="<%=session.getAttribute(GlobalConstants.SESSION_USER)%>" scope="request" />
<!-- 会话信息索引 -->
<c:set var="SESSION_TOKEN" value="<%=GlobalConstants.SESSION_TOKEN%>" scope="request" />
<c:set var="SESSION_MODUAL" value="<%=BusinessConstants.SESSION_MODUAL%>" scope="request" />

<!-- 用户类型 -->
<c:set var="USER_TYPE_SYS" value="<%=BusinessConstants.USER_TYPE_SYS%>" scope="request" />
<c:set var="USER_TYPE_PROD" value="<%=BusinessConstants.USER_TYPE_PROD%>" scope="request" />

<!-- 功能模块 -->
<c:set var="MODUAL_P_CENTER" value="<%=BusinessConstants.MODUAL_P_CENTER%>" scope="request" />
<c:set var="MODUAL_USER_MANA" value="<%=BusinessConstants.MODUAL_USER_MANA%>" scope="request" />
<c:set var="MODUAL_QA_MANA" value="<%=BusinessConstants.MODUAL_QA_MANA%>" scope="request" />
    
<!-- 字典：用户类型 -->
<c:set var="dicUserType" value="<%=DicConstants.getInstance().getDicUserType()%>" scope="request" />
<!-- 字典：产品 -->
<c:set var="dicProd" value="<%=DicConstants.getInstance().getDicProd()%>" scope="request" />

<script type="text/javascript">
	// 常量类
	var constants = constants || {};
	
	// 是或否
	constants.yes = "${YES_VALUE}";
	constants.no = "${NO_VALUE}";
	
	// 配置常量
	constants.config = {
		// 默认错误描述
		"err.default": "${t:config('err.default')}"
	};
	
	// 全局变量类
	var global = global || {};
	
	// 当前服务器时间
	global.current = '<fmt:formatDate value="${t:datetime()}" pattern="yyyy-MM-dd"/>';
	
	// 当前令牌对象
	global.token = {
		name: "${SESSION_TOKEN}",
		code: "${sessionScope[SESSION_TOKEN]}",
		data: {
			"${SESSION_TOKEN}": "${sessionScope[SESSION_TOKEN]}"
		}
	};
</script>