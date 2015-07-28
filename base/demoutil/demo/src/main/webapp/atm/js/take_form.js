$(document).ready(function(){
	 $("#inputMoney").focus();
});
function takeMoney(){
	var ipt = $("#inputMoney").val();
	var isValid = $('#takeform').form('validate');
	//alert("------"+isValid);
	if (!isValid){
		//$.messager.progress('close');	// hide progress bar while the form is invalid
		return isValid;
	}
	$.messager.confirm("Confirm","您將从账户中取出"+ipt+"元;确定吗？",function(flag){
		if(!flag) {
			return ;
			}
		$.messager.progress();	// display the progress bar
		$('#takeform').form('submit', {
			url:'take.action',
			onSubmit: function(){
					return isValid;	// return false will stop the form submission
			},
			success: showResponse
			});
		});
	/*$.messager.confirm("Confirm","您將从账户中取出"+ipt+"元;确定吗？",function(flag){
		 if(!flag) {
			 return ;
		 } 
		//loading("正在传输数据，请等待。。。");
		var options = {
			success: showResponse,  // 当成功提交表单之后将会执行的函数
			error : showError,
			dataType: "xml"
		}; 
		$("#takeform").ajaxSubmit(options);//用ajax提交表单 
	 });*/
} 
function showResponse(responseXML, statusText, xhr, form){
	$("#inputMoney").val(null);
	$.messager.progress('close');
	//unloading();
	var datamsg=$(responseXML).find("#msg").text();
	showResult(datamsg.substring(0,5),datamsg);
}