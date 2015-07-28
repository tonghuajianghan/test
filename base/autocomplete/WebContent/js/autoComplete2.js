//本文件无需修改
//如需修改，推荐只修改本文件中的样式属性（.style属性）和Ajax请求的链接（在最后）
//1. ac_jsonresult_to_html()的注释用于修改填充的数量，可修改
//2. 使用时先初始化ac_set_areaid()，可修改   第一个：触发区域，第二个：显示区域，第三个：隐藏数据域
//3. 修改xmlHttp中的请求

//================系统数据，不要修改===================
//记录返回的table的行数
var ac_tableTotalRow = 0;
//记录当前滚动到的行数
var ac_curTableTotalRow = -2;
//存储更改前的文本框的值，防止重复提交
var ac_previousContent = "";
//json数据
var ac_json_data;

//隐藏区域填值，隐藏区域ID为：
var ac_hidden_area = "";
//触发区域ID：
var ac_trigger_area = "";
//列表区域ID：
var ac_list_area = "";
//是否填充除隐藏区域外其他区域
var ac_fill_other = false;

//是否自定义填写其他区域
var ac_custom_fill = false;
//自定义的其他区域填写方法
var ac_custom_fill_func;
//自定义的其他区域清除方法
var ac_custom_unfill_func;
//================系统数据，不要修改===================



/**
 * 设置个区域id  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!onload初始化   必须调用
 * @param triggerid触发域
 * @param listid列表域
 * @param hiddenid隐藏域
 * @param fillother是否填写其他区域
 * @param fill_func填写其他区域的方法，参数为一个字符串数组，含义为：性别, 出生日期, 学历, 职称, 学位, 所在单位, 身份证号, 工资代号
 * @param unfill_func清除其他区域的方法，无参数
 */
function ac_set_areaid(triggerid, listid, hiddenid, fillother, fill_func, unfill_func)
{
	ac_hidden_area = hiddenid;
	ac_trigger_area = triggerid;
	ac_list_area = listid;
	ac_fill_other = fillother;
	if(fill_func == undefined || unfill_func == undefined)
		return;
	ac_custom_fill = true;
	ac_custom_fill_func = fill_func;
	ac_custom_unfill_func = unfill_func;
}

/**
 * 鼠标移动到td上的变化
 */
function ac_overState(eTd)
{
	for(var i = 0; i < eTd.parentNode.parentNode.childNodes.length; i++){
		eTd.parentNode.parentNode.childNodes[i].style.color = "black";
		eTd.parentNode.parentNode.childNodes[i].style.backgroundColor = "white";
	}
	eTd.parentNode.style.color = "#333333";
	eTd.parentNode.style.backgroundColor = "#E2EAFF";
}

/**
 * 鼠标脱离td的变化
 */
function ac_outState(eTd)
{
	eTd.parentNode.style.color = "black";
	eTd.parentNode.style.backgroundColor = "white";
}

/**
 * 鼠标点击时填充
 */
function ac_textFill(eTd)
{
	document.getElementById(ac_trigger_area).value = eTd.parentNode.childNodes[0].firstChild.firstChild.nodeValue;
	ac_util_clicknum(eTd.parentNode.childNodes[0].getAttribute('name'));
	//使用当前序号的数据更改文本
	ac_content_fill(ac_curTableTotalRow);
	document.getElementById(ac_list_area).style.display = "none";
	ac_previousContent = eTd.parentNode.childNodes[0].firstChild.firstChild.nodeValue;
	//注销鼠标时间捕获
	document.onmouseup=null;
	//注销按键事件捕获
	document.onkeydown = null;
}

/**
 * 输入一个词时调用的方法
 * 控制ID为acBox的div
 */
function ac_getAutoComplete(eInput)
{
	//列表区禁止选择
	document.getElementById(ac_list_area).onselectstart = function(event){return false;};
	if(eInput.value.length == 0){
		document.getElementById(ac_list_area).style.display = "none";
		//注销鼠标时间捕获
		document.onmouseup=null;
		//注销按键事件捕获
		document.onkeydown = null;
		//清空原内容
		ac_previousContent = "";
		return;
	}
	if(ac_previousContent.length == eInput.value.length && eInput.value == ac_previousContent){
		return;
	}
	//清空自动填写区域
	ac_clear_fillArea();
	ac_previousContent = eInput.value;
	var xmlHttp;
	try {
		// Firefox, Opera 8.0+, Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return;
			}
		}
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			//注销鼠标时间捕获
			document.onmouseup=null;
			//注销按键事件捕获
			document.onkeydown = null;
			document.getElementById(ac_list_area).style.display = "inline-block";
			document.getElementById(ac_list_area).innerHTML = ac_jsonresult_to_html(xmlHttp.responseText);
			if(document.getElementById("ac_completeBox") == null)
				return;
			tableTotalColumn = document.getElementById("ac_completeBox").childNodes[0].childNodes.length;
			ac_curTableTotalRow = -2;
			//设置鼠标按下事件，关闭下拉框
			document.onmouseup=function() {
				var ev = event || window.event;
				if (!ev) {
					var c = this.getEvent.caller;
					while (c) {
						ev = c.arguments[0];
						if (ev && (Event == ev.constructor || MouseEvent  == ev.constructor)) {
							break;
						}
						c = c.caller; 
					} 
				}
				//以上获取事件ev
				//以下关闭下拉框
				var isOnTD = (ev.srcElement.tagName.length == "td".length
								&& ev.srcElement.tagName.toLowerCase().indexOf("td") == 0);
				//判断是否是在下拉框所在的div或table的边框上点击的，或重复点击输入框
				var isOnDivOrTableOrInput = ev.srcElement.getAttribute("id")!=null
											&&	((ev.srcElement.getAttribute("id").length == ac_list_area.length
													&& ev.srcElement.getAttribute("id").indexOf(ac_list_area) == 0)
												|| (ev.srcElement.getAttribute("id").length == "ac_completeBox".length
													&& ev.srcElement.getAttribute("id").indexOf("ac_completeBox") == 0)
												|| (ev.srcElement.getAttribute("id").length == ac_trigger_area.length
													&& ev.srcElement.getAttribute("id").indexOf(ac_trigger_area) == 0)
												);
				if(!isOnTD){
					if(isOnDivOrTableOrInput)
						return;
					document.getElementById(ac_list_area).style.display = "none";
				}
				ac_previousContent = "";
				//注销鼠标时间捕获
				document.onmouseup=null;
				//注销按键事件捕获
				document.onkeydown = null;
				//控制如果点到其他table的td应该关闭下a拉框
				if(isOnTD
					&& (!ev.srcElement.parentNode.parentNode.parentNode.getAttribute("id").length == "ac_completeBox".length
					|| !ev.srcElement.parentNode.parentNode.parentNode.getAttribute("id").indexOf("ac_completeBox") == 0) )
					document.getElementById(ac_list_area).style.display = "none";
				//如果隐藏区有，则不删除所填
				if(document.getElementById(ac_hidden_area).value == null || document.getElementById(ac_hidden_area).value.length == 0)
					document.getElementById(ac_trigger_area).value = "";
			};
			//设置方向键上下的事件
			document.onkeydown=function(){
				//38上  40下
				switch(event.keyCode){
				case 38:
					if(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow] != null){
						ac_outState(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow]);
					}
					ac_curTableTotalRow--;
					if(ac_curTableTotalRow < 0 || ac_curTableTotalRow >= tableTotalColumn)
						ac_curTableTotalRow = tableTotalColumn - 1;
					ac_overState(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow].firstChild);
					document.getElementById(ac_trigger_area).value = document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow].firstChild.firstChild.firstChild.nodeValue;
					//使用当前序号的数据更改文本
					ac_content_fill(ac_curTableTotalRow);
					ac_previousContent = document.getElementById(ac_trigger_area).value;
					break;
				case 40:
					if(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow] != null){
						ac_outState(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow]);
					}
					ac_curTableTotalRow++;
					if(ac_curTableTotalRow < 0 || ac_curTableTotalRow >= tableTotalColumn)
						ac_curTableTotalRow = 0;
					ac_overState(document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow].firstChild);
					document.getElementById(ac_trigger_area).value = document.getElementById("ac_completeBox").childNodes[0].childNodes[ac_curTableTotalRow].firstChild.firstChild.firstChild.nodeValue;
					//使用当前序号的数据更改文本
					ac_content_fill(ac_curTableTotalRow);
					ac_previousContent = document.getElementById(ac_trigger_area).value;
					break;
				//回车事件
				//13大键盘    108小键盘
				case 13:
				case 108:
					ac_textFill(document.getElementById('ac_elem_num'+ac_curTableTotalRow));
					return false;
					break;
				}
			};
		}
	};
	//Ajax请求的连接
	xmlHttp.open("GET","mMember.action?method=getMembersAjax&mquery="+encodeURI(encodeURI(eInput.value)),true);
	xmlHttp.send(null);
}

/**
 * 将JSON字符串换成HTML  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 此项的编辑：
 * 1.json数据在本函数中读取的次数
 * 2.后台生成的json数据
 * 3.填充函数的填充数量ac_content_fill()
 * 4.清空隐藏区域文本ac_clear_fillArea()
 * 注意：最主要的数据为第一项(td)
 *       隐藏数据放在第一项之后
 */
function ac_jsonresult_to_html(jsonstr)
{
	ac_json_data = eval('('+jsonstr+')');
	if(ac_json_data[0].id===undefined)
		return "";
	var htmlFill = "<table id='ac_completeBox' style='background-color:white;'>";
	var i = 0;
	while(i < ac_json_data.length){
		htmlFill += "<tr>";
		htmlFill += "<td width='15%' id='ac_elem_num"+i+"' name='ac_elem_num"+i+"' width='30%' onmouseover='ac_overState(this)' onmouseout='ac_outState(this)' onmouseup='ac_textFill(this)'>";
		htmlFill += "<span>";
		htmlFill += ac_json_data[i].xm;
		htmlFill += "</span>";
		htmlFill += "</td>";
		//-----------自定义添加,按照格式-----------
		htmlFill += "<td width='30%' onmouseover='ac_overState(this)' onmouseout='ac_outState(this)' onmouseup='ac_textFill(this)'>";
		htmlFill += "<span>";
		htmlFill += ac_json_data[i].idcardno;
		htmlFill += "</span>";
		htmlFill += "</td>";
		htmlFill += "<td width='55%' onmouseover='ac_overState(this)' onmouseout='ac_outState(this)' onmouseup='ac_textFill(this)'>";
		htmlFill += "<span>";
		htmlFill += ac_json_data[i].szdw_val;
		htmlFill += "</span>";
		htmlFill += "</td>";
		//----------------------------------------
		htmlFill += "</tr>";
		i++;
	}
	htmlFill += "</table>";
	
	return htmlFill;
}
/**
 * 设置隐藏区域文本  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * @param str
 */
function ac_content_fill(ac_curTableTotalRow)
{
	document.getElementById(ac_hidden_area).value = ac_json_data[ac_curTableTotalRow].id;
	if(!ac_fill_other)
		return;
	if(ac_custom_fill){
		var list = [];
		list[0] = ac_json_data[ac_curTableTotalRow].xb;
		list[1] = ac_json_data[ac_curTableTotalRow].csrq;
		list[2] = ac_json_data[ac_curTableTotalRow].xl_val;
		list[3] = ac_json_data[ac_curTableTotalRow].zc_val;
		list[4] = ac_json_data[ac_curTableTotalRow].xw;
		list[5] = ac_json_data[ac_curTableTotalRow].szdw_val;
		list[6] = ac_json_data[ac_curTableTotalRow].idcardno;
		list[7] = ac_json_data[ac_curTableTotalRow].paycode;
		ac_custom_fill_func(list);
		return;
	}
	if(ac_json_data[ac_curTableTotalRow].xb == '男')
		document.getElementById("sexmale").checked = true;
	else if(ac_json_data[ac_curTableTotalRow].xb == '女')
		document.getElementById("sexfemale").checked = true;
	theForm.birth.value = ac_json_data[ac_curTableTotalRow].csrq;
	theForm.diploma.value = ac_json_data[ac_curTableTotalRow].xl_val;
	theForm.professionalTitle.value = ac_json_data[ac_curTableTotalRow].zc_val;
	theForm.degree.value = ac_json_data[ac_curTableTotalRow].xw;
	theForm.organization.value = ac_json_data[ac_curTableTotalRow].szdw_val;
	theForm.idCardNo.value = ac_json_data[ac_curTableTotalRow].idcardno;
	theForm.payCode.value = ac_json_data[ac_curTableTotalRow].paycode;
}
/**
 * 清空隐藏区域文本
 */
function ac_clear_fillArea()
{
	document.getElementById(ac_hidden_area).value = "";
	if(!ac_fill_other)
		return;
	if(ac_custom_fill){
		ac_custom_unfill_func();
		return;
	}
	document.getElementById("sexmale").checked = false;
	document.getElementById("sexfemale").checked = false;
	theForm.birth.value = "";
	theForm.diploma.value = "";
	theForm.professionalTitle.value = "";
	theForm.degree.value = "";
	theForm.organization.value = "";
	theForm.idCardNo.value = "";
	theForm.payCode.value = "";
}



//===============util==========
/**
 * 用于鼠标点击后统计其在列表中的位置
 */
function ac_util_clicknum(tdname)
{
	var elems = document.getElementById("ac_completeBox").childNodes[0].childNodes;
	var i = 0;
	while(i < tableTotalColumn){
		if(elems[i++].firstChild.getAttribute('name')==tdname){
			ac_curTableTotalRow = i-1;
			return;
		}
	}
}