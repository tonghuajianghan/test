// 当页面加载时，在顶端页面显示loading图层
window.top.loading("页面正在加载中，请稍候...");
// 绑定事件，使页面跳转或关闭前在顶端页面显示loading图层，支持IE6+、Firefox、Chrome12+
window.onbeforeunload = function () {
	window.top.loading();
};
// 绑定事件，使页面加载完成后隐藏loading图层
window.onload = function () {
	window.top.loaded();
};