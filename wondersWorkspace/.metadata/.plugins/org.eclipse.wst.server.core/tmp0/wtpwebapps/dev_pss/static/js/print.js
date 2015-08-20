/**
 * 网页打印工具类
 */
var prt = prt || {};

/**
 * 工具函数，自动收缩文字以匹配框架
 * 
 * @param o 配置项
 */
prt.fontfit = function(o) {
	// 函数对象引用
	var _self = this;
	// 函数默认配置
	this._options = {
		// 页面元素前缀，用于定义锚点
		prefix: "print-fontfit-",
		// 文字最小收缩尺寸
		min: 5,
		// 框架对象表达式
		cont: "body",
		// 待处理的文字节点对象表达式
		todo: "*",
		// 是否匹配框架高度
		fitheight: true,
		// 是否匹配框架宽度
		fitwidth: false
	};
	
	// 继承配置项
	$.extend(this._options, o);
	
	// 临时数组，暂存页面文字内容
	this._temp = new Array();
	// 待处理的文字节点对象
	this._todo = $(this._options.cont).find(this._options.todo);
	
	this._todo.each(function(i) {
		// 暂存节点所含文字内容
		_self._temp[i] = $(this).html();
		// 清空节点以获取其初始化尺寸
		$(this).attr(_self._options.prefix + "ref", i).html("&nbsp;");
		
		var s = $(this).css("font-size");
		// 记录文字初始尺寸
		$(this).attr(_self._options.prefix + "size", parseFloat(s));
		// 记录文字尺寸单位
		$(this).attr(_self._options.prefix + "unit", s.replace(/(\.|\d)*/, ""));
	}).each(function() {
		// 记录节点初始化高度
		$(this).attr(_self._options.prefix + "fitheight", $(this).outerHeight());
		// 记录节点初始化宽度
		$(this).attr(_self._options.prefix + "fitwidth", $(this).outerWidth());
		// 暂时将文字收缩为最小尺寸，待后续处理
		$(this).css("font-size", _self._options.min + $(this).attr(_self._options.prefix + "unit"));
	});
	
	// 还原节点所含文字内容
	for(i in this._temp) {
		this._todo.filter("[" + this._options.prefix + "ref=" + i + "]").html(this._temp[i]);
	}
	
	this._todo.each(function() {
		// 将当前节点文字恢复为初始尺寸
		$(this).css("font-size", $(this).attr(_self._options.prefix + "size") + $(this).attr(_self._options.prefix + "unit"));
		
		// 判断是否匹配框架高度
		if(_self._options.fitheight) {
			while(true) {
				// 如果当前节点文字已经达到最小收缩尺寸，则不再处理
				if(parseFloat($(this).css("font-size")) <= _self._options.min) {
					break;
				}
				
				// 如果当前节点高度未超过其初始化高度，则不再处理
				if($(this).outerHeight() > $(this).attr(_self._options.prefix + "fitheight")) {
					var _cur = $(this).outerHeight();
					// 逐步收缩文字尺寸
					$(this).css("font-size", (parseFloat($(this).css("font-size")) - 1) + $(this).attr(_self._options.prefix + "unit"));
					
					// 如果收缩文字尺寸后，节点高度未发生变化，则不再处理，同时取消此次收缩操作
					if(_cur == $(this).outerHeight()) {
						$(this).css("font-size", (parseFloat($(this).css("font-size")) + 1) + $(this).attr(_self._options.prefix + "unit"));
						break;
					}
				} else {
					break;
				}
			}
		}
		
		// 判断是否匹配框架宽度
		if(_self._options.fitwidth) {
			while(true) {
				// 如果当前节点文字已经达到最小收缩尺寸，则不再处理
				if(parseFloat($(this).css("font-size")) <= _self._options.min) {
					break;
				}

				// 如果当前节点宽度未超过其初始化宽度，则不再处理
				if($(this).outerWidth() > $(this).attr(_self._options.prefix + "fitwidth")) {
					var _cur = $(this).outerWidth();
					// 逐步收缩文字尺寸
					$(this).css("font-size", (parseFloat($(this).css("font-size")) - 1) + $(this).attr(_self._options.prefix + "unit"));

					// 如果收缩文字尺寸后，节点宽度未发生变化，则不再处理，同时取消此次收缩操作
					if(_cur == $(this).outerWidth()) {
						$(this).css("font-size", (parseFloat($(this).css("font-size")) + 1) + $(this).attr(_self._options.prefix + "unit"));
						break;
					}
				} else {
					break;
				}
			}
		}
	});
	
	// 清除锚点属性
	this._todo.removeAttr(_self._options.prefix + "ref")
			.removeAttr(_self._options.prefix + "size")
			.removeAttr(_self._options.prefix + "unit")
			.removeAttr(_self._options.prefix + "fitheight")
			.removeAttr(_self._options.prefix + "fitwidth");
	
	// 清除临时数组
	this._temp = null;
};