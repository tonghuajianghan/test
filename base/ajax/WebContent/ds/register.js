function ajaxFunction() {
	var xmlRep = null;
	if (window.XMLHttpRequest) {
		xmlRep = new XMLHttpRequest();
	} else {
		xmlRep = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlRep;
}
window.onload = function() {
	document.getElementById("checkUserName").onclick = function() {
		alert("mark1");
		var username = document.getElementById("username").value;
		var psw = document.getElementById("psw").value;
		var conpsw = document.getElementById("confpsw").value;
		alert("mark2");
		var xmlReq = ajaxFunction();
		xmlReq.onreadystatechange = function() {
			if (xmlReq.readyState == 4 && xmlReq.status == 200) {
				alert("mark3");
				var data = xmlReq.responseText;
				document.getElementById("divcheck").innerHTML = data;
			}
		};
		alert("mark4");
		xmlReq.open("get", "ajax", true);
		alert("mark5");
		xmlReq.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
		alert("mark6");
		xmlReq.send("username=" + username + "&psw=" + psw + "&confpsw="
				+ conpsw);
		alert("mark7");
	};
};