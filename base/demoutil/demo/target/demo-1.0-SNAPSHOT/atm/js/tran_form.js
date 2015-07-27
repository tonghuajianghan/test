 $(document).ready(function(){
	 $("#inputMoney").focus();
 });

//执行转账业务
function doTran() {
	var ipt = $("#inputMoney").val();
	var isValid = $('#tranform').form('validate');
	//alert("------"+isValid);
	if (!isValid){
		//$.messager.progress('close');	// hide progress bar while the form is invalid
		return isValid;
	}
	$.messager.confirm("Confirm","您将转账给："+$("#desID").val()+"账户,转账金额为:"+ipt+"元;确定吗？",function (flag) {
		if(!flag) {
			return ;
			}
		$.messager.progress();	// display the progress bar
		$('#tranform').form('submit', {
			url:'tran.action',
			onSubmit: function(){
					return isValid;	// return false will stop the form submission
			},
			success: showResponse
			});
		});
	/*$.messager.confirm("Confirm","您将转账给："+$("#desID").val()+"账户,转账金额为:"+ipt+"元;确定吗？",function (flag) {
		if(!flag) {
			return false;
		}
		loading("正在传输数据，请等待。。。");
		var options = {
			success: showResponse,  // 当成功提交表单之后将会执行的函数
			error : showError,
			dataType: "html"	
		};
		$("#tranform").ajaxSubmit(options);
	});*/
} 
 
 
function showResponse(responseXML, statusText, xhr, form){
	$("#inputMoney").val(null);
	$.messager.progress('close');
	//unloading();
	showResult(obtainTextInTag(responseXML,"<title>") === "success" ? "操作成功" : "操作失败",$(responseXML).find("#msg").text());
}
	

function showError(responseXML, statusText, xhr, form) {
	alert("error");
	alert(responseXML);
}
