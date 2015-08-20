<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="tools" prefix="t" %>

<link type="text/css" rel="stylesheet" href="css/robot.css?t=${t:config('token.css')}" />

<script type="text/javascript">
	$(function() {
		// 初始化对话显示框高度
		$(window).resize(function() {
			var wh = $(window).height();
			var xh = 620;
			var disp = $(".robot .disp");
			var talk = $(".robot .talk");
			disp.height(parseInt(disp.css("min-height")) + (wh > xh ? (wh - xh) : 0));
			$(".robot .rb-r").height(disp.height() + parseInt(disp.css("margin-bottom")) + parseInt(disp.css("margin-top")) + talk.height());
		}).resize();
		
		// 初始化对显示框内容
		respMsg("您好，请问有什么可以帮助您的？");
	})
	
	// 发送信息
	function sendMsg() {
		// 信息框对象
		var textarea = $(".robot .talk textarea");
		// 信息框内容
		var text = $.trim(textarea.val());

		// 信息为空，则不发送
		if(text == "") {
			return false;
		}
		
		// 对话显示框对象
		var disp = $(".robot .disp");
		// 拼接信息内容
		var html = '<table class="say-i"><tr><td>' + text + '</td><th></th></table>';
		// 发送信息至对话显示框
		disp.append(html);
		// 清空信息框内容
		textarea.val("");
		// 滚动对话显示框至底部
		disp.scrollTop(disp.scrollTop() + disp.height());
		// 发送信息至后台
		ajaxCommon({
			url: "qa/searchRobot",
			data: {
				searchRobot: text
			}
		}, function(result) {
			var list = eval(result);
			
			if(list.length == 0) {
				respMsg("我答不上来，要不你问点别的？");
			} else {
				var msg = "<p>你想要问的是下面这些问题吗？</p>";
				for(var i in list) {
					var qa = list[i];
					msg += '<p>' + (Number(i) + 1) + '、<a href="javascript:" onclick=\'respMsg("' + qa.qaCont + '");return false;\'>' + qa.qaDesc + '</a></p>';
				}
				respMsg(msg);
			}
		});
	}
	
	// 智能回复
	function respMsg(msg) {
		// 对话显示框对象
		var disp = $(".robot .disp");
		// 拼接信息内容
		var html = '<table class="say-r"><tr><th></th><td>' + msg + '</td></table>';
		// 显示回复信息至对话显示框
		disp.append(html);
		// 滚动对话显示框至底部
		disp.scrollTop(disp.scrollTop() + disp.height());
	}
</script>

<div class="robot">
	<div class="rb-t">
		<div class="logo"></div>
	</div>
	<div class="rb-m clearfix">
		<div class="rb-l">
			<div class="disp clearfix"></div>
			<div class="talk">
				<textarea></textarea>
				<a href="javascript:" onclick="sendMsg();return false;">发送</a>
			</div>
		</div>
		<div class="rb-r"></div>
	</div>
</div>