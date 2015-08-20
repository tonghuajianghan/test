$(function() {
	/**
	* 字数统计/显示，用于输入控件的最大长度限制
	* @param obj 输入控件对象
	*/
	function _stat(obj) {
		// 字符串最大长度限制
		var maxlen = $(obj).attr("maxlen");
		// 字符串当前字符长度
		var len = strlen($(obj).val());
		// 统计字数
		if(len > maxlen) {
			$("#" + $(obj).attr("stat")).html("—— 已经超过 <b>" + Math.ceil((len - maxlen) / 2) + "</b> 字 ——");
		} else {
			$("#" + $(obj).attr("stat")).html("—— 还可以输入 <b>" + Math.floor((maxlen - len) / 2) + "</b> 字 ——");
		}
	}
	
	// 为设置了最大长度限制的控件绑定事件，使超过最大长度限制时截断字符串
	$("[maxlen]").change(function() {
		// 当前字符串内容
		var text = $(this).val();
		// 字符串最大长度限制
		var maxlen = $(this).attr("maxlen");
		// 截断后的字符串内容
		var textcut = cutstr(text, maxlen);
		// 如果字符串被截断，则弹出提示，并更新页面内容
		if(text != textcut) {
			window.top.dialogMessage("超过最大长度，最多允许输入" + maxlen + "个字符！", function(content) {
				// 截取字符串
				$(this).val(textcut);
				// 更新统计字数
				_stat(this);
				// 关闭弹出框
				content.dialog("destroy").remove();
			});
		}
	}).keyup(function() {
		_stat(this);
	}).each(function() {
		_stat(this);
	});
	
	// 重写window.alert方法，优化显示
	window.alert = function(msg) {
		// 弹出消息
		window.top.dialogMessage(msg);
	};
});

/** 
 * 根据html生成并返回页面元素对象
 * @param html 页面元素代码
 */
var elem = (function() {
    var div = document.createElement('div');
    return function(html) {
        div.innerHTML = html;
        var element = div.firstChild;
        div.removeChild(element);
        return $(element);
    };
})();

/** 
 * 根据最大长度限制返回截断后的字符串
 * @param str 原字符串
 * @param maxlen 字符串最大长度
 * @param suffix 如果有截断，则返回字符串含后缀（可选）
 */
var cutstr = function(str, maxlen, suffix) {
	// 后缀默认为空字符串
	if(typeof suffix == "undefined") {
		suffix = "";
	}
	
	// 字符串真实长度
	var len = strlen(str);
	if(len > maxlen) {
		// 当前双字节字符数
		var count = str.replace(/[\x00-\xff]/g, "").length;
		// 当前至少还需截断的长度
		var cutlen = Math.max(Math.floor((count + str.length - maxlen) / 2), 1);
		// 递归截取字符串
		return cutstr(str.substring(0, str.length - cutlen), maxlen) + suffix;
	} else {
		return str;
	}
};

/** 
 * 字符串真实长度
 * @param str 字符串
 */
var strlen = function(str) {
	// 将双字节字符替换成“**”后获取字符串真实长度
	return str.replace(/[^\x00-\xff]/g, "**").length;
};

/**
 * 生成下拉框选项
 * @param data json对象
 * @param expr 下拉框对象表达式
 * @param emptyOpt 空值（可选）
 * @param defaultVal 默认选中项的value值（可选）
 */
var select = function(data, expr, emptyOpt, defaultVal) {
	// 为键值添加排序前缀
	if(typeof data == "string") {
		data = data.replace(/{\s*"/g, "{\"@");
		data = data.replace(/,\s*"/g, ",\"@");
		var index = 1;
		while(data.indexOf("@") != -1) {
			data = data.replace(/@/, index++ + "#");
		}
	}
	
	// 解析json对象
	var map;
	try {
		map = JSON.parse(data);
	} catch(err) {
		map = new Object();
	}
	
	try {
		$(expr).each(function() {
			var options = this.options;
			// 清空原选项
			options.length = 0;
			// 添加空值
			if(emptyOpt) {
				options.add(new Option(emptyOpt, ""));
			}
			// 添加选项，同时清除排序前缀
			for(var key in map) {
				options.add(new Option(map[key], key.substring(key.indexOf("#") + 1)));
			}
			// 选中默认值
			if(defaultVal) {
				this.value = defaultVal;
			}
		});
	} catch(err) {
		window.top.dialogMessage(constants.config["err.default"]);
	}
};

/**
 * 切换表格行显示或隐藏
 * 
 * @param expr 表格行筛选表达式
 * @param opt 显示或隐藏
 * 
 * @return 返回表格行对象
 */
var toggleTR = function(expr, opt) {
	var elements = $(expr);
	switch(opt) {
		case "show":
			if($.browser.msie) {
				elements.find("td, th").andSelf().show();
			} else {
				elements.show();
			}
			break;
		case "hide":
			if($.browser.msie) {
				elements.not(":last-child").find("td, th").andSelf().hide();
				elements.filter(":last-child").find("td, th").hide();
			} else {
				elements.hide();
			}
			break;
		default:
			break;
	}
	
	return elements;
};

/**
 * 级联加载下拉框选项通用方法
 * @param opt 级联配置项
 */
var loadChain = function(opt) {
	var p = $(opt.prev);
	var c = $(opt.cur);
	var n = $(opt.next);
	var l = $(opt.left);
	var h = $(opt.code);
	
	// 设置代码域
	h.val(c.val() == "" ?  (p.val() || "") : c.val());
	
	// 当前下拉框为最后一级，直接返回
	if(n.size() == 0) {
		return;
	}
	
	// 当前选择为空，置空并隐藏相关下拉框
	if(c.val() == "") {
		n.html("").hide();
		l.html("").hide();
		return;
	}
	
	// 级联加载次级字典
	ajaxCommon({
		url: opt.url,
		data: opt.data,
		dataType: "json"
	}, function(dic) {
		// 清空并隐藏相关联下拉框
		l.html("").hide();
		// 生成次级下拉框内容
		select(dic, opt.next, "--");
		// 当次级下拉框内容不为空时，显示次级下拉框，否则隐藏
		if(n.find("option[value!='']").size() > 0) {
			n.show();
		} else {
			n.hide();
		}
		// 如果定义了回调函数，则执行
		if(typeof opt.callback == "function") {
			opt.callback();
		}
	});
};

/** 
 * ajax通用调用
 * 
 * @param opt ajax选项
 * @param callback ajax回调函数
 */
var ajaxCommon = function(opt, callback) {
	// 默认ajax选项
	var options = {
		dataType: "text",
		data: {},
		ansyc: true,
		type: "POST",
		contentType: "application/x-www-form-urlencoded",
		cache: true
	};
	
	// 获取ajax选项
	$.extend(options, opt);
	
	$.ajax({
		url: options.url,
		data: options.data,
		dataType: options.dataType,
		ansyc: options.ansyc,
		type: options.type,
		contentType: options.contentType,
		cache: options.cache,
		complete: function(jqXHR, textStatus) {
			// 获取ajax返回的信息
			var result = jqXHR.responseText;

			// 获取信息时系统出现意外错误
			if(typeof result == "undefined" || jqXHR.state() != "resolved") {
				// 弹出错误提示
				window.top.dialogMessage(constants.config["err.default"], function(content) {
					// 刷新页面
					window.location.reload(true);
					// 关闭弹出框
					content.dialog("destroy").remove();
				});
				// 结束调用
				return false;
			}

			// 调用回调函数，以ajax返回的信息为参数
			if(typeof callback == "function") {
				callback(result);
			}
		}
	});
};

/** 
 * 提示信息通用调用
 * 
 * @param message 提示信息
 * @param callback 点击确定后的回调函数（可选）
 * @param confirm 是否确认提示（可选）
 * @param opt 弹出框选项（可选）
 */
var dialogMessage = function(message, callback, confirm, opt) {
	var content = $(document.createElement("div"));
	var buttons = {
		"确定": function() {
			if(typeof callback == "function") {
				callback(content);
			} else {
				content.dialog("destroy").remove();
			}
		}
	};
	
	if(typeof confirm != "undefined" && confirm == true) {
		buttons["取消"] = function() {
			content.dialog("destroy").remove();
		};
	}
	
	// 默认dialog选项
	var options = {
		resizable: false,
		modal: true,
		title: "提示",
		width: 300,
		height: "auto",
		buttons: buttons,
		css: {
			"margin": "5px 5px 0 0",
			"overflow-x": "hidden",
			"overflow-y": "auto",
			"max-height": "200px"
		}
	};
	
	// 获取dialog选项
	$.extend(options, opt);

	// 返回dialog对象
	return content.dialog({
		resizable: options.resizable,
		modal: options.modal,
		title: options.title,
		width: options.width,
		height: options.height,
		buttons: options.buttons,
		open: function() {
			// 将js回车换行换成html换行
			message = ("" + message).replace(/[\n|\r]/g, "<br/>");
			
			$(this).css({padding: "0.5em", wordBreak: "break-all", overflow: "hidden"}).css(options.css).append(message).prev().find("a.ui-dialog-titlebar-close").remove();
			
			if(!$.support.maxHeight) {
				var maxHeight = options.css["max-height"] || options.css["maxHeight"] || this.scrollHeight;
				$(this).css("height", Math.min(parseInt(maxHeight), parseInt(this.scrollHeight)));
			}
		}
	});
};

/** 
 * iframe弹出框通用关闭
 * 
 * @param fid 框架页面ID
 * @param b 是否保留弹出框数据
 */
var dialogIframeClose = function(fid, b) {
	var content = $("#" + fid).parent();
	if(b) {
		content.dialog("close");
	} else {
		$("#" + fid).remove();
		content.dialog("destroy").remove();
	}
};

/** 
 * iframe弹出框通用调用
 * 
 * @param opt 弹出框选项
 */
var dialogIframe = function(opt) {
	// 内部方法：调用Iframe页面中定义的函数
	var _callInframe = function(func) {
		window.frames[options.id][func].call(this, options.id);
	};
	
	// 内部方法：关闭dialog并清除资源
	var _close = function() {
		window.top.dialogMessage("确定关闭当前窗口？", function(content) {
			window.top.$(content).dialog("destroy").remove();
			dialogIframeClose(options.id);
		}, true);
	};
	
	// 默认dialog选项
	var options = {
		url: "",
		id: "dialog-iframe-" + (new Date()).getTime(),
		resizable: false,
		modal: true,
		height: 400,
		width: 500,
		title: "",
		titlebar: true,
		wrapper: true,
		loading: true,
		scrolling: "auto",
		buttons: {
			"确定": opt.forward,
			"关闭": opt.close
		},
		dialogbeforeclose: null
	};
	
	// 获取dialog选项
	$.extend(options, opt);
	
	// 定义dialog按钮操作
	(function() {
		options._buttons = {};
		for(var text in options.buttons) {
			if(typeof options.buttons[text] == "function") {
				options._buttons[text] = options.buttons[text];
				options.buttons[text] = function(e) {
					options._buttons[$(e.srcElement || e.target).text()].call(this, options.id);
				};
			} else if(typeof options.buttons[text] == "string") {
				options._buttons[text] = options.buttons[text];
				options.buttons[text] = function(e) {
					_callInframe(options._buttons[$(e.srcElement || e.target).text()]);
				};
			} else {
				options.buttons[text] = _close;
			}
		}
	})();
	
	// 返回dialog对象
	return $(document.createElement("div")).dialog({
		resizable: options.resizable,
		height: options.height,
		width: options.width,
		modal: options.modal,
		title: options.title,
		buttons: options.buttons,
		open: function() {
			var iframe = document.createElement("iframe");
			iframe.id = options.id;
			iframe.name = options.id;
			iframe.src = options.url;
			iframe.scrolling = options.scrolling;
			iframe.style.width = "100%";
			iframe.style.height = "100%";
			iframe.style.border = 0;
			$(iframe).attr("frameborder", "0");
			
			// 自定义iframe样式
			if(options.framecss) {
				$(iframe).css(options.framecss);
			}
			
			// 显示loading图层
			if(options.loading && typeof window.top.loading == "function") {
				window.top.loading();
			}

			// 初始化iframe
			var content = $(this).css({padding: "0.5em", overflow: "hidden"}).append(iframe);
			
			// 自定义样式
			if(options.css) {
				$(this).css(options.css);
			}
			
			// 自定义遮挡层样式
			if(options.overlaycss) {
				$(this).parent(".ui-dialog").next(".ui-widget-overlay").css(options.overlaycss);
			}
			
			// 如果未定义dialog按钮，则删除按钮区
			if(!options.buttons || options.buttons.length == 0) {
				content.next(".ui-dialog-buttonpane").remove();
			}
			
			// 根据预设判断是否删除标题区
			if(!options.titlebar) {
				content.prev(".ui-dialog-titlebar").remove();
			}

			// 根据预设判断是否删除包裹层
			if(!options.wrapper) {
				content.parent(".ui-dialog").css({border: "none", background: "none"});
			}
			
			// 复写dialog关闭方法
			$(this).on("dialogbeforeclose", function() {
				if(typeof options.dialogbeforeclose == "function") {
					options.dialogbeforeclose.call(this);
				} else {
					_close();
				}
				
				return false;
			});
		}
	});
};