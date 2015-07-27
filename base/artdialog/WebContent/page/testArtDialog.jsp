<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>artdialog</title>

<script type="text/javascript" src="../js/artDialog/artDialog.js"></script> 
<link href="../js/artDialog/doc/demo.css" rel="stylesheet" type="text/css" />
<script src="../js/jquery-1.3.2.min.js"></script>  
<!--代码高亮-->
<link rel="stylesheet" href="../js/artDialog/doc/highlight/styles/magula.css">
<script src="../js/artDialog/doc/highlight/highlight.pack.js"></script>
<script src="../js/artDialog/doc/highlight/languages/javascript.js"></script>
<script>
hljs.tabReplace = '    ';
hljs.initHighlightingOnLoad();
</script>

<script>  
	// 设置对话框全局默认配置  
	(function(){  
	    var d = art.dialog.defaults;  
	      
	    // 按需加载要用到的皮肤，数组第一个为默认皮肤  
	    // 如果只使用默认皮肤，可以不填写skin  
	    d.skin = ['default', 'chrome', 'facebook', 'aero'];  
	      
	    // 支持拖动  
	    d.drag = true;  
	      
	    // 超过此面积大小的对话框使用替身拖动  
	    d.showTemp = 100000;  
	})();  
</script> 
</head>
<body>
	<script type="text/javascript">
		  function test(){  
			  art.dialog('简单愉悦的接口，强大的表现力，优雅的内部实现', function(){alert('yes');});
		  
		  } 
	</script>
	<p class="buttons"><button class="test" id="btn1" title="btn1" name="demoCode01">运行&raquo;</button></p>
</body>
</html>