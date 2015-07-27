$(document).ready(function() {
	$("#uname").focus();
	$("#tbody").keyup(function(e){  
	    //alert("start");
		//alert(e.keyCode+"======"+e.which);
	    if(e.keyCode==13||e.keyCode==13) {// IE
	    	//alert("end");
			submitForm();
		 }
	  });;
});

function submitForm() {
	$.messager.progress();	// display the progress bar
	$('#loginForm').form('submit', {
		url:'j_security_check',
		onSubmit: function(){
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');	// hide progress bar while the form is invalid
			}
			//alert(isValid);
			return isValid;	// return false will stop the form submission
		},
		success: function(){
			$.messager.progress('close');	// hide progress bar while submit successfully
			window.location = 'index.jsp';
		}
	});
	/*$("#loginForm").form({
		url : 'j_security_check',
		onSubmit : function() {
			//Load("正在提交您的登录请求。。。");
		},
		success : function(data) {
			//dispalyLoad();
			//alert('s');
			window.location = 'index.jsp';
		}
	});*/
	//$('#loginForm').submit();
}

function clearForm() {
	$('#loginForm').form('clear');
}

function enterLogin(e){
	//alert(e.keyCode+"======"+e.which);
	//var asciicode=e.keyCode;
	
	//var strcode=String.fromCharCode(asciicode);
	//alert(strcode);
	//return strcode;
	
}