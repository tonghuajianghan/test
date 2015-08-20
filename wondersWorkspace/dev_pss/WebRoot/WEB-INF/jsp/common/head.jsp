<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="tools" prefix="t"%>

<jsp:include page="../common/constants.jsp" flush="true" />
<script type="text/javascript" src="${base}js/datepicker/WdatePicker.js?t=${t:config('token.script')}"></script>
<base href="${base}" />
<link type="text/css" rel="stylesheet" href="js/ui/skin/smoothness/jquery-ui.css?t=${t:config('token.css')}" />
<link type="text/css" rel="stylesheet" href="css/base.css?t=${t:config('token.css')}" />
<script type="text/javascript" src="js/jquery.min.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/jquery.bgiframe.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/ui/jquery-ui.min.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/validate/jquery.validate.min.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/validate/validate.common.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/datepicker/WdateInit.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/loading/loading.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/loading/loading.bind.ajax.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/security/md5.min.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/common.js?t=${t:config('token.script')}"></script>
<script type="text/javascript" src="js/page/page.js?t=${t:config('token.script')}" ></script>
<script type="text/javascript" src="js/json2.js?t=${t:config('token.script')}"></script>

<!--[if lt IE 7]>
<script type="text/javascript" src="js/DD_belatedPNG.js?t=${t:config('token.script')}"></script> 
<script type="text/javascript">
	DD_belatedPNG.fix("img");
</script> 
<![endif]-->