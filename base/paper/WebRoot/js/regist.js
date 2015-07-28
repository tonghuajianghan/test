function checkusername(){
if(document.forms[0].username.value.length>=4&&document.forms[0].username.value.length<=6){
span1.textContent="用户名格式正确";
}
else{
span1.textContent="用户名要在4--6位之间";
}
}
function checkpwd(){
if(document.forms[0].pwd.value.length<=3){
span2.textContent="密码要大于三位";
}
else{
span2.textContent="密码输入正确";
}
}
function recheckpwd(){
if(document.forms[0].pwd.value!=document.forms[0].pwd1.value){
span3.textContent="两次输入的密码不相同";
}
else{
span3.textContent="密码正确";
}
}
function checkemail(){
var content=document.getElementById('email').value;
var str=/^[a-zA-Z0-9]+@([a-zA-Z0-9]+\.)+[a-zA-z]+/gi;
if(str.test(content)){
span4.textContent="邮箱正确";
}else{
span4.textContent="邮箱输入不合法";
}
}// JavaScript Document