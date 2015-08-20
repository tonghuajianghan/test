/*********************** 以下 校验相关方法 ********************************/

/**
 * 标记校验项
 * 
 * @param expr 校验项筛选表达式
 * @param opt 标记形式
 */
var validateMark = function(expr, opt) {
	var elements = $(expr);
	switch(opt) {
		case "star-outer-aft":
			var star = "<label class='star' rel='validate-mark'>*</label>";
			elements.each(function() {
				$(this).nextAll("label.star").eq(0).remove();
				$(this).after(star);
			});
			break;
		case "clear-outer-aft":
			elements.each(function() {
				$(this).nextAll("label[rel='validate-mark']").eq(0).remove();
			});
			break;
		case "star-inner-pre":
			var star = "<label class='star' rel='validate-mark'>*</label>";
			elements.each(function() {
				$(this).find("label.star").remove();
				$(this).prepend(star);
			});
			break;
		case "star-inner-aft":
			var star = "<label class='star' rel='validate-mark'>*</label>";
			elements.each(function() {
				$(this).find("label.star").remove();
				$(this).append(star);
			});
			break;
		case "clear-inner":
			elements.each(function() {
				$(this).find("label[rel='validate-mark']").remove();
			});
			break;
		default:
			break;
	}
};

/**
 * 设置校验信息格式化模板
 * 
 * @param rep 消息替换标识
 * @param opt 模板类型选项
 */
var validateMessage = function(rep, opt) {
	var template = $.noop;
	
	switch(opt) {
		case "input":
			template = $.validator.format("请输入“{0}”！");
			break;
		case "select":
			template = $.validator.format("请选择“{0}”！");
			break;
		case "format":
			template = $.validator.format("“{0}”格式不正确！");
			break;
		case "balance":
			template = $.validator.format("“{0}”不平衡！");
			break;
		case "integer":
			template = $.validator.format("“{0}”必须为整数！");
			break;
		case "integer-positive":
			template = $.validator.format("“{0}”必须为正整数！");
			break;
		case "integer-nonnegative":
			template = $.validator.format("“{0}”必须为正整数或零！");
			break;
		case "number":
			template = $.validator.format("“{0}”必须为数字！");
			break;
		case "number-positive":
			template = $.validator.format("“{0}”必须为正数！");
			break;
		case "number-nonnegative":
			template = $.validator.format("“{0}”必须为正数或零！");
			break;
		case "number-nonpositive":
			template = $.validator.format("“{0}”必须为负数或零！");
			break;
		case "min":
			template = $.validator.format("“{0}”不能小于{1}！");
			break;
		case "max":
			template = $.validator.format("“{0}”不能大于{1}！");
			break;
		case "minlength":
			template = $.validator.format("“{0}”长度不能小于{1}！");
			break;
		case "maxlength":
			template = $.validator.format("“{0}”长度不能大于{1}！");
			break;
		case "gt":
			template = $.validator.format("“{0}”必须大于“{1}”！");
			break;
		case "ge":
			template = $.validator.format("“{0}”必须大于等于“{1}”！");
			break;
		case "lt":
			template = $.validator.format("“{0}”必须小于“{1}”！");
			break;
		case "le":
			template = $.validator.format("“{0}”必须小于等于“{1}”！");
			break;
		case "eq":
			template = $.validator.format("“{0}”必须等于“{1}”！");
			break;
		default:
			break;
	};
	
	// 返回校验信息
	return template(rep);
};

/**
 * 设置校验信息显示形式
 * 
 * @param errorMap 出错字典 {key:name, value:errorMsg}
 * @param errorList 出错列表 {message, element}
 * @param opt 校验信息显示相关配置
 */
var _showErrors = function(errorMap, errorList, opt) {
	// 默认配置项
	var defaults = {
		type: "",
		form: "form",
		settings: {
			errorClass: "error"
		}
	};
	
	// 继承配置项
	var options = $.extend(true, defaults, opt);

	// 获取配置值
	var type = options.type;
	var form = $(options.form);
	var errorClass = options.settings.errorClass;
	
	for(var i = 0; i < errorList.length; i++) {
		var message = errorList[i].message;
		var element = errorList[i].element;
		
		var label = form.find("label." + errorClass + "[for='" + (element.id ? element.id : element.name) + "']");
		
		// 替换控件默认的默认校验信息显示形式
		switch(type) {
			case "input":
				// 替换为高亮形式
				label.not(".hide-position").addClass("hide-position");
				break;
			case "label":
			default:
				// 默认替换为图片+title形式
				var errorHtml = "<img src='images/error.gif' align='absmiddle'"
					+ " title='" + message + "'"
					+ " />";
				label.html(errorHtml);
				// 移除元素高亮
				if(/radio|checkbox/i.test(element.type) && element.name) {
					form.find("[name='" + element.name + "']").removeClass(errorClass);
				} else {
					$(element).removeClass(errorClass);
				}
				break;
		};
	}
};

/**
 * 设置有出错信息时的操作
 * 
 * @param e 事件对象
 * @param validator 校验控件对象
 */
var _invalidHandler = function(e, validator) {
	// 错误列表
	var errorList = validator.errorList;
	// 错误信息
	var alertMessage = "";
	// 拼接错误消息
	for(var i in errorList) {
		var idx = Number(i) + 1;
		var message = errorList[i].message;
		alertMessage += (errorList.length == 1 ? "" : (idx + "、")) + message + (errorList.length == idx ? "" : "\n");
	}
	// 弹出错误信息
	if(typeof dialogMessage == "function") {
		window.top.dialogMessage(alertMessage);
	} else {
		alert(alertMessage);
	}
};

/**
 * 校验身份证号码有效性
 * 
 * @param cardNo 身份证号码
 * @param b （可选）出生日期，格式为：YYYY-MM-DD
 * @param g （可选）性别，1为男，2为女
 */
var _validIdCard = function(cardNo, b, g) {
	var date, Ai;
	var verify = "10X98765432";
	var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
	var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
	var re = cardNo.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})((\d{3})[X\d])))$/i);
	if(re == null) return false;
	if(re[1] >= area.length || area[re[1]] == "") return false;
	if(re[2].length == 12) {
		Ai = cardNo.substr(0, 17);
		birthday = [re[9], re[10], re[11]].join("-");
		gender = re[13];
	} else {
		Ai = cardNo.substr(0, 6) + "19" + cardNo.substr(6);
		birthday = ["19" + re[4], re[5], re[6]].join("-");
		gender = re[7];
	}
	if(g && g != "" && (gender % 2 != g % 2)) return false;
	if(b && b != "" && b != birthday) return false;
	re = birthday.match(/^((19|20)\d{2})[-](\d{2})[-](\d{2})$/);
	var year = re[1];
	var month = re[3] * 1 - 1;
	var day = re[4];
	var date = new Date(year, month, day);
	if(typeof date != "object" || date.getFullYear() != year || date.getMonth() != month || date.getDate() != day) return false;
	var sum = 0;
	for(var i = 0; i <= 16; i++) {
		sum += Ai.charAt(i) * Wi[i];
	}
	Ai += verify.charAt(sum%11);
	return (cardNo.length == 15 || cardNo.length == 18 && cardNo == Ai);
};

/*********************** 以上 校验相关方法 ********************************/
	
$(document).ready(function() {

	/*********************** 以下 增加页面公用校验规则 ********************************/
	
	// 元素非隐藏时判断必输
	$.validator.addMethod("needed", function(value, element) {
		if($(element).is(":hidden") || $(element).parents().is(":hidden")) {
			return true;
		}
		
		if($(element).is(":checkbox, :radio")) {
			return $(element).filter(":checked").size() > 0;
		}
		
		return $(element).is(":filled");
	});
	
	// 判断邮政编码是否正确
	$.validator.addMethod("postcode", function(value, element) {
		return $(element).is(":filled") ? /^\d{6}$/.test(value) : true;
	});
	
	// 判断身份证号是否正确
	$.validator.addMethod("idcard", function(value, element, param) {
		value = $.trim(value);
		if(typeof param[0] != "undefined") {
			var cetfType = $("#" + param[0] + " option:selected").val();
			if(cetfType != "1") return true; // 仅当证件类型为身份证时进行校验
		}
		var birthday = $("#" + param[1]).val();
		var gender = $("#" + param[2] + " option:selected").val();
		return $(element).is(":filled") ? _validIdCard(value, birthday, gender) : true;
	});
	
	// 判断手机号是否正确
	$.validator.addMethod("mobile", function(value, element) { 
		return this.optional(element) || /^(1|00861|(\+861))+\d{10}$/.test(value); 
	}); 

	// 判断是否为整数
	$.validator.addMethod("int", function(value, element) {
		return $(element).is(":filled") ? /^-?\d+$/.test(value) : true;
	});
	
	// 判断两个日期数据（格式为“yyyy-mm-dd”）
	$.validator.addMethod("dateCompare", function(value, element, param) {
		if($(element).is(":blank")) {
			return true;
		}
		
		// 默认对比时间为当前时间
		var opt = param, dt = global.current;
		
		// 通过页面元素获取对比时间数据
		if(typeof param == "object" && (param.length || 0) == 2) {
			opt = param[0];
			dt = $(param[1]).val();
		}

		// 根据对比方式返回结果
		switch(opt) {
			case "gt": // 大于
				return value > dt;
			case "ge": // 大于等于
				return value >= dt;
			case "lt": // 小于
				return value < dt;
			case "le": // 小于等于
				return value <= dt;
			case "eq": // 等于
				return value == dt;
			default:
				return true;
		};
	});
	
	/*********************** 以上 增加页面公用校验规则 ********************************/
	
	/*********************** 以下 修改控件默认高亮函数 ********************************/
	
	$.validator.setDefaults({
		highlight: function(element, errorClass, validClass) {
			if (this.checkable(element)) {
				// 对于单选框或多选框，同时设置相关元素高亮
				this.findByName(element.name).addClass(errorClass).removeClass(validClass);
			} else {
				$(element).addClass(errorClass).removeClass(validClass);
			}
		},
		unhighlight: function(element, errorClass, validClass) {
			if (this.checkable(element)) {
				// 对于单选框或多选框，同时取消相关元素高亮
				this.findByName(element.name).removeClass(errorClass).addClass(validClass);
			} else {
				$(element).removeClass(errorClass).addClass(validClass);
			}
		}
	});
	
	/*********************** 以上 修改控件默认高亮函数 ********************************/
});