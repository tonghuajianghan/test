function imagePreview(fileInput, imgId) {
	var pic = document.getElementById(imgId);
	var file = fileInput;
	var ext = file.value.substring(file.value.lastIndexOf(".") + 1)
			.toLowerCase();
	// gif在IE浏览器暂时无法显示
	if (ext != 'png' && ext != 'jpg' && ext != 'jpeg') {
		alert("文件必须为图片！");
		return;
	}
	// IE浏览器
	if ($.browser.msie) {
		var version = parseInt($.browser.version);
		if(version >= 10){
			html5Reader(file, imgId);
			return;
		}
		file.select();
		$(file).prev().focus();
		/*if(version == 9){
			document.getElementById("bc").focus();
		}*/
		var reallocalpath = document.selection.createRange().text;
		if(version == 6){
			pic.src = reallocalpath;
		}else{
			pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src=\"" + reallocalpath + "\")";
            // 设置img的src为base64编码的透明图片 取消显示浏览器默认图片
            pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';
		}
		document.selection.empty();
	} else {
		html5Reader(file, imgId);
	}
}

function html5Reader(f, imgId) {
	var file = f.files[0];
	var reader = new FileReader();
	reader.onload = function(evt) {
		var pic = document.getElementById(imgId);
		pic.src = evt.target.result;
	};
	reader.readAsDataURL(file);
}