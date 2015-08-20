// 绑定事件，使当页面中出现Ajax请求，请求即将开始前在顶端页面显示loading图层，Ajax请求结束时隐藏loading图层
$("html").ajaxStart(function() {
	window.top.loading(undefined, "AJAX_LOADING");
}).ajaxStop(function() {
	window.top.loaded("AJAX_LOADING");
}).ajaxError(function(event) {
	// alert("系统出现异常，请稍候重试");
	window.top.loaded("AJAX_LOADING");
});