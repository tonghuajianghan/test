/**
* 正在加载时显示loading图层
* @param text loading图层显示信息
* @param key loading图层校验码，用于关闭图层时进行匹配
*/
var loading = function(text, key) {
	LoadHelper.getInstance().loading(text, key);
};

/**
* 加载完成时隐藏loading图层
* @param key loading图层校验码
*/
var loaded = function(key) {
	LoadHelper.getInstance().loaded(key);
};

/**
* loading图层帮助单例类
*/
var LoadHelper = function(){
    var _loading = function(text, key) {
		// loading图层显示信息
		var text = arguments[0] ? arguments[0] : "服务器正在响应请求，请稍候...";
	
    	if($(".loading").size() != 0) {
			// 当前页面已包含loading图层页面元素，仅改变显示信息
    		$(".loading p").html(text);
    	} else {
    		// 添加loading图层页面元素
			$("body").append("<div class='loading'><p>" + text + "</p></div><div class='overlay'></div>");
    	}
    	
    	// 指定loading图层校验码
    	var key = arguments[1] ? arguments[1] : "";
    	$(".loading").attr("loading_key", key);
    	
		// loading图层显示前，禁止页面滚动动作，并隐藏页面滚动条
		$("body, html").attr("disabled", "disabled").addClass("no_scroll");
		// 显示loading图层
		$(".loading").show();
		// 设置遮挡背景尺寸并显示
		$(".overlay").width(_width()).height(_height()).show();
		// 恢复页面滚动动作
		$("body, html").removeAttr("disabled");
		
		// 利用iframe遮挡IE6下拉框，需要jquery.bgiframe.js
		if(typeof $.fn.bgiframe == "function") {
			$(".overlay").bgiframe();
		}
	};
	var _loaded = function(key) {
    	var key = arguments[0] ? arguments[0] : "";
    	
    	// 匹配loading图层校验码，仅当匹配成功时隐藏图层
    	if($(".loading").attr("loading_key") == key) {
    		// 重置校验码
	    	$(".loading").attr("loading_key", "");
			// 隐藏loading图层及遮挡层	
			$(".loading, .overlay").hide();
			// 恢复页面初始滚动条设置
			$("body, html").removeClass("no_scroll");
    	}
	};
	// 计算遮挡层高度
    var _height = function() {
		var scrollHeight, offsetHeight;
		if ($.browser.msie && $.browser.version < 7) { // IE6
			scrollHeight = Math.max(document.documentElement.scrollHeight, document.body.scrollHeight);
			offsetHeight = Math.max(document.documentElement.offsetHeight, document.body.offsetHeight);

			if (scrollHeight < offsetHeight) {
				return $(window).height() + "px";
			} else {
				return scrollHeight + "px";
			}
		} else {
			return $(document).height() + "px";
		}
	};
	// 计算遮挡层宽度
	var _width = function() {
		var scrollWidth, offsetWidth;
		if ($.browser.msie) { // IE
			scrollWidth = Math.max(document.documentElement.scrollWidth, document.body.scrollWidth);
			offsetWidth = Math.max(document.documentElement.offsetWidth, document.body.offsetWidth);

			if (scrollWidth < offsetWidth) {
				return $(window).width() + "px";
			} else {
				return scrollWidth + "px";
			}
		} else {
			return $(document).width() + "px";
		}
	};
	
    var instance = { 
    	loading: _loading,
    	loaded: _loaded  
    };
    
    function init() {
    	// 窗口大小改变时更新遮挡层尺寸
    	$(window).resize(function() {
			$(".overlay").width(0).height(0).width(_width()).height(_height());
		});
		
        return instance;
    };
    
    return {getInstance: init};
}();