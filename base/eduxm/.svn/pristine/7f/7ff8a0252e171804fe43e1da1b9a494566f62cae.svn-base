var autoId = 0; // 这个autoId可以用来生成tr的id

function Match(key, val, typefunction, url, combobox) {
	this.key = key;
	this.val = val;
	this.typefunction = typefunction;
	if(arguments.length > 3){
		this.url = url;
		this.combobox = combobox;
	}
}

function textfunction(tableid) {
	return '<input name="search.values" type="text"/>';
}

function selectfunction(tableid) {
	//return '<input name="search.values" id="'+tableid+'_com_'+rowIndex+'" type="text"/>';
	return '<input name="search.values" type="text"/>';
}

function datefunction(tableid) {
	return  '<input type="text" name="search.values" onclick="WdatePicker({dateFmt:\'yyyy年MM月dd日\'})"/>';
}

function getSearchRowIndex(target){
	var tr = $(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}

function getSearchRow(target){
	return $(target).closest('tr.datagrid-row');
}

function loadSearchTable(tableid, arrMatch){
	var arrMatchString = arrMatchToString(arrMatch);
	$("#" + tableid).datagrid({
		data:[{way:'',target:'',method:'',content:'',sort:'',dos:'add'}],
 		title:'项目检索',
 		singleSelect:true,
 		fitColumns:true,
 		columns:[[
			{
				field:'way',title:'连接方式',width:fixWidth(0.1),
				formatter:function(value, row, index){
					if(index == 0)
						return '<input type="hidden" name="search.logicalopts" value="" />';
					return '<select name="search.logicalopts"><option value="and">AND</option><option value="or">OR</option></select>';
				}
			},
 		    {
				field:'target',title:'检索项',width:fixWidth(0.2),
				formatter:function(value, row, index){
					return arrMatchToHtml(arrMatch, arrMatchString, tableid);
				}
 		    },
 		    {
 		    	field:'method',title:'运算',width:fixWidth(0.1),
 		    	formatter:function(value, row, index){
 		    		var str2 = '<select name="search.operators">';
 		    		str2 = str2 + '<option value="eq">=</option>';
 		    		str2 = str2 + '<option value="ne">&ne;</option>';
 		    		str2 = str2 + '<option value="gt">&gt;</option>';
 		    		str2 = str2 + '<option value="ge">&ge;</option>';
 		    		str2 = str2 + '<option value="lt">&lt;</option>';
 		    		str2 = str2 + '<option value="le">&le;</option>';
 		    		str2 = str2 + '<option value="like">like</option></select>';
					return str2;
				}
 		    },
 		    {
 		    	field:'content',title:'内容',width:fixWidth(0.23),
 		    	formatter:function(value, row, index){
 		    		return value == '' ? '<input name="search.values" type="text"/>' : value;
				}
 		    },
 		    {
 		    	field:'sort',title:'排序',width:fixWidth(0.15),
 		    	formatter:function(value, row, index){
					return '<select name="search.orders"><option value="none">不排序</option><option value="asc">升序</option><option value="desc">降序</option></select>';
				}
 		    },
 		    {
 		    	field:'dos',title:'操作',width:fixWidth(0.2),
 		    	formatter:function(value, row, index){
 		    		if(value == 'add'){
 		    			return '<a name="addLink" href="#" onclick="addSearchRow(\''+tableid+'\');">添加检索项</a>';
 		    		}
					//return '<a name="delLink" href="#" onclick="removeSearchRow(\'' + tableid + '\', ' + index + ');">删除检索项</a>';
					return '<a name="delLink" href="#" onclick="removeSearchRow(\'' + tableid + '\', this);">删除检索项</a>';
				}
 		    }
 		]],
 		
 		onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
 			setLinkbuttonStyle();
		}
 	});
	//alert("ok");
}

function arrMatchToString(arrMatch){
	var result = '[';
	for (i = 0; i < arrMatch.length; i++) {
		var m = arrMatch[i];
		if(i > 0){
			result = result + ',';
		}
		result = result + '{key:\'' + m.key + '\',val:\'' + m.val + '\','
				+ 'typefunction:\'' + m.typefunction + '\'';
		if(m.url){
			result = result + ','
			+ 'url:\'' + m.url + '\','
			+ 'combobox:\'' + m.combobox + '\'}';
		}else {
			result = result + '}';
		}
	}
	result = result + ']';
	return result;
}

function arrMatchToHtml(arrMatch, arrMatchString, tableid){
	var str1 = '<select name="search.columns" onchange="columnChanged(this,' + arrMatchString + ',\''+tableid+'\');">'
			+ '<option value="-">---请选择要检索的单元---</option>';
	for (i = 0; i < arrMatch.length; i++) {
		str1 = str1 + '<option value="' + arrMatch[i].key + '">'
				+ arrMatch[i].val + '</option>';
	}
	str1 = str1 + "</select>";
	return str1;
}

//在Student——list的添加检索项中
function addSearchRow(tableid) {
	$('#' + tableid).datagrid('appendRow', {
		way			:	'',
		target		:	'',
		method		:	'',
		content		:	'',
		sort		:	'',
		dos			:	''
	});
	setLinkbuttonStyle();
}

function setLinkbuttonStyle() {
	$("a[name='filesLink']").linkbutton({
		iconCls: 'icon-files'
	});
	$("a[name='detailsLink']").linkbutton({
		iconCls: 'icon-details'
	});
	$("a[name='delLink']").linkbutton({
		iconCls: 'icon-cancel'
	});
	$("a[name='addLink']").linkbutton({
		iconCls: 'icon-add'
	});
	$("a[name='editLink']").linkbutton({
		iconCls: 'icon-edit'
	});
	
}

function columnChanged(target, arrMatch, tableid){
	var tr = getSearchRow(target);
	var checkIndex = target.selectedIndex;
	if(checkIndex > 0){
		var am = arrMatch[checkIndex - 1];
		var ct = window[am.typefunction](tableid);
		$('#' + tableid).datagrid("updateRow",{
			index:getSearchRowIndex(target),
			row:{
				content:ct
			}
		});
		if(am.combobox){
			window[am.combobox](tr.find('input[name="search.values"]'), am.url);
		}
	}else{
		$('#' + tableid).datagrid("updateRow",{
			index:getSearchRowIndex(target),
			row:{
				content:''
			}
		});
	}
	tr.find('select[name="search.columns"]')[0].selectedIndex = checkIndex;
	setLinkbuttonStyle();
}

function removeSearchRow(tableid, target) {
	$('#' + tableid).datagrid('deleteRow', getSearchRowIndex(target));
}

function replace(type) {
	$('td[id^="' + type + '_"]').each(function(){
		$(this).text(getKeyByVal($(this).text(), type));
	  });
}
function replace1(id,key,val) {
	$('td[id^="' + id + '_"]').each(function() {
		$(this).text(getKeyByVal(val,key));
	});
}
function toPage(pageNumber) {
	$("#pagenum").val(pageNumber);
	searchSubmit();
}

function searchChange(search) {
	var searchIndex = search.selectedIndex + 1;
	toPage(searchIndex);
}

function combobox(target, url){
	target.combobox({    
	    url:url,    
	    valueField:'id',    
	    textField:'text',
	 	filter: function(q, row){
	 		if(row["pinyin"].indexOf(q) >= 0||row["text"].indexOf(q) >= 0){
	 			return true;
	 		}
	 		return false;
	 	}
	});
}

function combotree(target, url){
	target.combotree({    
	    url: url,    
	    required: true,
	    onLoadSuccess: function(node, data){
	    	var t = $('#' + id).combotree('tree');
	    	t.tree('collapseAll');
	    }
	});
}
