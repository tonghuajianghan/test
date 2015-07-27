
function ajaxFunction(){
	var xmlRep=null;
	if (window.XMLHttpRequest){
	    xmlRep=new XMLHttpRequest();
    }else{
	    xmlRep=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlRep;	
}
window.onload=function(){
	document.getElementById("checkUserName").onclick=function(){		
		var username = document.getElementById("username").value;
		var psw = document.getElementById("psw").value;
		var conpsw = document.getElementById("confpsw").value;		
		var xmlReq=ajaxFunction();		
		xmlReq.onreadystatechange=function(){			
			if(xmlReq.readyState==4 && xmlReq.status==200){				
					//获取服务器的值					
					var data=xmlReq.responseText;					
					//显示在div层中
					document.getElementById("divcheck").innerHTML=data;			
			}
		};
		xmlReq.open("post","ajax",true);//连接		
		xmlReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");		
		xmlReq.send("username="+username+"&psw="+psw+"&confpsw="+conpsw);
	};
};