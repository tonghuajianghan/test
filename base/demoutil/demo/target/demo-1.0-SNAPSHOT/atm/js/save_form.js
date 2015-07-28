//预加载
$(document).ready(function(){
	$("#inputMoney").focus();
});

function saveMoney(){
	var ipt = $("#inputMoney").val();
	//loading("正在传输数据，请等待。。。");
	var isValid = $('#saveform').form('validate');
	//alert("------"+isValid);
	if (!isValid){
		//$.messager.progress('close');	// hide progress bar while the form is invalid
		return isValid;
	}
	$.messager.confirm("Confirm","您将存入"+ipt+"元;确定吗？",function(flag){
		if(!flag) {
			return ;
			}
		$.messager.progress();	// display the progress bar
		$('#saveform').form('submit', {
			url:'save.action',
			onSubmit: function(){
					return isValid;	// return false will stop the form submission
			},
			success: showResponse
			});
		});
	
}
//表单成功执行后执行的回调函数
function showResponse(responseXML, statusText, xhr, form){
	//alert("success")
	$("#inputMoney").val(null);
	$.messager.progress('close');
	//unloading();
	var datamsg=$(responseXML).find("#msg").text();
	showResult(datamsg.substring(0,5),datamsg);
}
