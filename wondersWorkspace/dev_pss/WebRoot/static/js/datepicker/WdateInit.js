$(document).ready(function() {
	initWdatePicker($(".Wdate, .WdateImportant"));
});

/**
 * 配置时间控件参数
 */
var _wpsetting = function() {
	// 获取当前日期
	var current = new Date();
	var cy = current.getFullYear();
	var cm = current.getMonth() + 1;
	var cd = current.getDate();
	
	WdatePicker({
		startDate: $(this).attr("dateOffset") ? [cy + Number($(this).attr("dateOffset")), cm, cd].join("-") : "",
		oncleared: function() { $(this).blur(); },
		onpicked: function() { $(this).blur(); },
		readOnly: true,
		skin: "whyGreen"
	});
};

/**
 * 初始化时间控件
 * @param obj 页面日期展示对象
 */
function initWdatePicker(obj) {
	// 初始化时间控件
	obj.unbind("focus", _wpsetting).focus(_wpsetting);
}