/**
 * 
 */
function getText(value, data) {
	if (data) {// 在数据有效的情况下才执行
		var len = data.length;
		for (var i = 0; i < len; i++) {
			if (value == data[i].id) {
				return data[i].text;
			}
			var t = getText(value, data[i].children);
			if(t != ""){
				return t;
			}
		}
	}
	return "";
}

function getJSON(data, attr, url) {
	$.ajax({
		url : url,
		async : false,
		dataType : "json",
		success : function(d) {
			data[attr] = d;
		}
	});
}