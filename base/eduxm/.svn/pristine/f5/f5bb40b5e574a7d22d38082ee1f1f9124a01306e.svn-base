$(function() {
	var mytime = new Date().getTime();
	$('#appendFileDlg').dialog('close');
	$('#dg').datagrid({
		iconCls : 'icon-edit',
		singleSelect : true,
		url : 'codelibs.json?time=' + mytime,
		method : 'get',
		autoRowHeight : true,
		rownumbers : true,
		columns : [[{
					field : 'name',
					title : '名称',
					editor : {
						type : 'text',
						options : {
									required : true
								}
					},
					width : fixWidth(0.2),
				},
				{
					field : 'filename',
					title : '文件名',
					editor : {
						type : 'text',
						options : {
							required : true
						}
					},
					width : fixWidth(0.2),
				},
				{
					field : 'editor',
					title : '操作',
					width : fixWidth(0.25),
					align : 'center',
					formatter : function(value, rowData, index) {
						var s = '<a href="javascript:void(0)" onclick="editRow('
												+ index
												+ ');" name="editLink">编辑</a>';
						var g = '<a href="javascript:void(0)" onclick="glRow('
												+ index
												+ ');" name="editLink">管理</a>';
						var c = '<a href="javascript:void(0)" onclick="removeit('
												+ index
												+ ');" name="delLink">删除</a>';
						return s + g + c;
					}
			} ] ],
			toolbar :[{
						text : 'Add',
						iconCls : 'icon-add',
						handler : function(index) {
							append();
						}
				} ],
			onLoadSuccess : function(data) { // 数据加载成功后需要设置linkbutton的样式，
						setLinkbuttonStyle();
				}
	});
});

var flag = "noRow";

function glRow(index) {
	var row = $('#dg').datagrid('selectRow', index);
	var fname = $('#dg').datagrid('getRows')[index]['filename'];
	var mytime = new Date().getTime();
	window.location.href = "codes.jsp?filename=" + fname + "&time=" + mytime;
}

function editRow(index) {
	$('#appendFileDlg').attr('action', "../../codelib/update_codeLib");
	$('#dg').datagrid('selectRow', index);
	var sname = $('#dg').datagrid('getRows')[index]['name'];
	var sfname = $('#dg').datagrid('getRows')[index]['filename'];
	$("#uIndex").val(index);
	$('#appendFileForm').form('load',{
		"obj.name":sname,
		"obj.filename":sfname
	});


	$('#appendFileDlg').dialog('open');
	flag = "updateRow";

}
function append() {
	$('#appendFileDlg').attr('action', "../../codelib/add_codeLib");
	$('#appendFileDlg').dialog('open');
	flag = "addRow";
}
function removeit(index) {
	$.messager.confirm("Confirm", "确认删除？", function(flag) {
		if (!flag) {
			return;
		}
		$.messager.progress(); // display the progress bar
		alert(index);
		$('#dg').datagrid('cancelEdit', index).datagrid('deleteRow', index);
		$.post('../../codelib/delete_codeLib', "updateIndex=" + index,
				callback, "text");
	});
	flag = "deleteRow";
}

function callback(data) {
	data = eval('(' + data + ')')
	if (data.successmsg == undefined) {
		alert("操作失败");
		$('#appendFileDlg').dialog('close')
		$.messager.progress('close');
		return;
	}
	alert(data.successmsg);
	if (flag == "addRow") {
		$('#dg').datagrid('appendRow', {
			name : $("#dataName").val(),
			filename : $("#dataFName").val()
		});

	} else if (flag == "updateRow") {
		$('#dg').datagrid('updateRow', {
			index : $("#uIndex").val(),
			row : {
				name : $("#dataName").val(),
				filename : $("#dataFName").val()
			}
		});

	}
	$("#appendFileDlg").form("clear");
	$("#uIndex").val("0");
	flag = "noRow";
	setLinkbuttonStyle();
	$('#appendFileDlg').dialog('close')
	$.messager.progress('close');
}

function submitAppendFileForm() {
	if (flag == "addRow") {
		var url = '../../codelib/add_codeLib';
	} else if (flag == "updateRow") {
		var url = '../../codelib/update_codeLib';
	}
	var isValid = $('#appendFileForm').form('validate');
	if (!isValid) {
		return isValid;
	}
	$.messager.progress(); // display the progress bar
	$('#appendFileForm').form('submit', {
		url : url,
		onSubmit : function() {
			return isValid; // return false will stop the form submission
		},
		success : callback
	});

}

function setLinkbuttonStyle() {
	$("a[name='addLink']").linkbutton({
		iconCls : 'icon-add'
	});
	$("a[name='delLink']").linkbutton({
		iconCls : 'icon-cancel'
	});
	$("a[name='editLink']").linkbutton({
		iconCls : 'icon-edit'
	});
}