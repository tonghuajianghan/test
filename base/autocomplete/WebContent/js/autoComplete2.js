//���ļ������޸�
//�����޸ģ��Ƽ�ֻ�޸ı��ļ��е���ʽ���ԣ�.style���ԣ���Ajax��������ӣ������
//1. ac_jsonresult_to_html()��ע�������޸��������������޸�
//2. ʹ��ʱ�ȳ�ʼ��ac_set_areaid()�����޸�   ��һ�����������򣬵ڶ�������ʾ���򣬵�����������������
//3. �޸�xmlHttp�е�����

//================ϵͳ���ݣ���Ҫ�޸�===================
//��¼���ص�table������
var ac_tableTotalRow = 0;
//��¼��ǰ������������
var ac_curTableTotalRow = -2;
//�洢����ǰ���ı����ֵ����ֹ�ظ��ύ
var ac_previousContent = "";
//json����
var ac_json_data;

//����������ֵ����������IDΪ��
var ac_hidden_area = "";
//��������ID��
var ac_trigger_area = "";
//�б�����ID��
var ac_list_area = "";
//�Ƿ�����������������������
var ac_fill_other = false;

//�Ƿ��Զ�����д��������
var ac_custom_fill = false;
//�Զ��������������д����
var ac_custom_fill_func;
//�Զ�������������������
var ac_custom_unfill_func;
//================ϵͳ���ݣ���Ҫ�޸�===================



/**
 * ���ø�����id  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!onload��ʼ��   �������
 * @param triggerid������
 * @param listid�б���
 * @param hiddenid������
 * @param fillother�Ƿ���д��������
 * @param fill_func��д��������ķ���������Ϊһ���ַ������飬����Ϊ���Ա�, ��������, ѧ��, ְ��, ѧλ, ���ڵ�λ, ���֤��, ���ʴ���
 * @param unfill_func�����������ķ������޲���
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
 * ����ƶ���td�ϵı仯
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
 * �������td�ı仯
 */
function ac_outState(eTd)
{
	eTd.parentNode.style.color = "black";
	eTd.parentNode.style.backgroundColor = "white";
}

/**
 * �����ʱ���
 */
function ac_textFill(eTd)
{
	document.getElementById(ac_trigger_area).value = eTd.parentNode.childNodes[0].firstChild.firstChild.nodeValue;
	ac_util_clicknum(eTd.parentNode.childNodes[0].getAttribute('name'));
	//ʹ�õ�ǰ��ŵ����ݸ����ı�
	ac_content_fill(ac_curTableTotalRow);
	document.getElementById(ac_list_area).style.display = "none";
	ac_previousContent = eTd.parentNode.childNodes[0].firstChild.firstChild.nodeValue;
	//ע�����ʱ�䲶��
	document.onmouseup=null;
	//ע�������¼�����
	document.onkeydown = null;
}

/**
 * ����һ����ʱ���õķ���
 * ����IDΪacBox��div
 */
function ac_getAutoComplete(eInput)
{
	//�б�����ֹѡ��
	document.getElementById(ac_list_area).onselectstart = function(event){return false;};
	if(eInput.value.length == 0){
		document.getElementById(ac_list_area).style.display = "none";
		//ע�����ʱ�䲶��
		document.onmouseup=null;
		//ע�������¼�����
		document.onkeydown = null;
		//���ԭ����
		ac_previousContent = "";
		return;
	}
	if(ac_previousContent.length == eInput.value.length && eInput.value == ac_previousContent){
		return;
	}
	//����Զ���д����
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
				alert("�����������֧��AJAX��");
				return;
			}
		}
	}
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			//ע�����ʱ�䲶��
			document.onmouseup=null;
			//ע�������¼�����
			document.onkeydown = null;
			document.getElementById(ac_list_area).style.display = "inline-block";
			document.getElementById(ac_list_area).innerHTML = ac_jsonresult_to_html(xmlHttp.responseText);
			if(document.getElementById("ac_completeBox") == null)
				return;
			tableTotalColumn = document.getElementById("ac_completeBox").childNodes[0].childNodes.length;
			ac_curTableTotalRow = -2;
			//������갴���¼����ر�������
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
				//���ϻ�ȡ�¼�ev
				//���¹ر�������
				var isOnTD = (ev.srcElement.tagName.length == "td".length
								&& ev.srcElement.tagName.toLowerCase().indexOf("td") == 0);
				//�ж��Ƿ��������������ڵ�div��table�ı߿��ϵ���ģ����ظ���������
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
				//ע�����ʱ�䲶��
				document.onmouseup=null;
				//ע�������¼�����
				document.onkeydown = null;
				//��������㵽����table��tdӦ�ùر���a����
				if(isOnTD
					&& (!ev.srcElement.parentNode.parentNode.parentNode.getAttribute("id").length == "ac_completeBox".length
					|| !ev.srcElement.parentNode.parentNode.parentNode.getAttribute("id").indexOf("ac_completeBox") == 0) )
					document.getElementById(ac_list_area).style.display = "none";
				//����������У���ɾ������
				if(document.getElementById(ac_hidden_area).value == null || document.getElementById(ac_hidden_area).value.length == 0)
					document.getElementById(ac_trigger_area).value = "";
			};
			//���÷�������µ��¼�
			document.onkeydown=function(){
				//38��  40��
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
					//ʹ�õ�ǰ��ŵ����ݸ����ı�
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
					//ʹ�õ�ǰ��ŵ����ݸ����ı�
					ac_content_fill(ac_curTableTotalRow);
					ac_previousContent = document.getElementById(ac_trigger_area).value;
					break;
				//�س��¼�
				//13�����    108С����
				case 13:
				case 108:
					ac_textFill(document.getElementById('ac_elem_num'+ac_curTableTotalRow));
					return false;
					break;
				}
			};
		}
	};
	//Ajax���������
	xmlHttp.open("GET","mMember.action?method=getMembersAjax&mquery="+encodeURI(encodeURI(eInput.value)),true);
	xmlHttp.send(null);
}

/**
 * ��JSON�ַ�������HTML  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * ����ı༭��
 * 1.json�����ڱ������ж�ȡ�Ĵ���
 * 2.��̨���ɵ�json����
 * 3.��亯�����������ac_content_fill()
 * 4.������������ı�ac_clear_fillArea()
 * ע�⣺����Ҫ������Ϊ��һ��(td)
 *       �������ݷ��ڵ�һ��֮��
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
		//-----------�Զ������,���ո�ʽ-----------
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
 * �������������ı�  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
	if(ac_json_data[ac_curTableTotalRow].xb == '��')
		document.getElementById("sexmale").checked = true;
	else if(ac_json_data[ac_curTableTotalRow].xb == 'Ů')
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
 * ������������ı�
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
 * �����������ͳ�������б��е�λ��
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