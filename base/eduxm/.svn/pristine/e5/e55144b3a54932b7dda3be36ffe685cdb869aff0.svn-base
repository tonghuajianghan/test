function refreshTree() {
	$('#appendFileDlg').dialog('close');
	var fn = $("#hfilename").val();
	var mytime = new Date().getTime();
	var turl = "../" + fn + '?time=' + mytime;
	$('#tg').treegrid(
		{
			iconCls : 'icon-ok',
			rownumbers : true,
			animate : true,
			autoRowHeight : true,
			fitColumns : true,
			url : turl,// '../ssc.json',
			method : 'get',
			idField : 'id',
			treeField : 'text',
			columns :[[
			             {
							field : 'text',
							title : '名称',
							editor : {
								type : 'text',
								options : {
										required : true
									}
								},
							width : fixWidth(0.12)
						},
						{
							field : 'id',
							title : '代码',
							editor : {
								type : 'text',
								options : {
										required : true
									}
								},
							width : fixWidth(0.1)
						},
						{
							field : 'pinyin',
							title : '汉语拼音',
							editor : {
								type : 'text',
								options : {
										required : true
									}
								},
							width : fixWidth(0.1)
						},
						{
							field : 'editor',
							title : '操作',
							width : fixWidth(0.15),
							align : 'center',
							formatter : function(value, rowData, index) {
									var s = '<a href="#" name="editLink" onclick="edit(\''
												+ rowData.id + '\');">编辑</a> ';
									var g = ' <a href="#" name="addLink" onclick="addChildren(\''
												+ rowData.id
												+ '\');">添加子节点</a> ';
									var c = ' <a href="#" name="delLink" onclick="removeit(\''
												+ rowData.id + '\');">删除</a>';

									return s + g + c;
								}
							}]],
			onLoadSuccess : function(data) { // 数据加载成功后需要设置linkbutton的样式，
					setLinkbuttonStyle();
			}
	});
}
$(function() {
	refreshTree();
});

var editingId;
var flag = "noNode";
var oldID;
function add() {
	// 插入一个新节点到选择的节点之前
	$('#appendFileDlg').attr('action', "../../codelib/add_code");
	$('#appendFileDlg').dialog('open');
	flag = "addNode";
}

function addChildren(indexId) {
	$('#appendFileDlg').attr('action', "../../codelib/add_code");
	$('#tg').treegrid('select', indexId);
	var node = $('#tg').treegrid('getSelected');
	if (node) {
		$('#hpId').val(node.id);
	} else {
	}
	$('#appendFileDlg').dialog('open');

	flag = "addNode";

}

function edit(indexId) {
	$('#tg').treegrid('select', indexId);
	var row = $('#tg').treegrid('getSelected');
	if (row) {
		editingId = row.id
		$('#appendFileDlg').attr('action', "../../codelib/update_code");
		$('#oldId').val(row.id);
		$('#appendFileForm').form('load',{
			"obj.id":row.id,
			"obj.pinyin":row.pinyin,
			"obj.text":row.text
		});
		$('#appendFileDlg').dialog('open');
	}
	flag = "updateNode";
}

function removeit(indexId) {
	$('#tg').treegrid('select', indexId);
	var row = $('#tg').treegrid('getSelected');
	if (row) {
		$.messager.confirm("Confirm", "确认删除及其子节点？",
				function(flag) {
					if (!flag) {
						return;
					}
					$.messager.progress(); // display the progress bar
					$('#tg').treegrid('remove', row.id);
					$.post('../../codelib/delete_code', 'obj.id=' + row.id
							+ '&filename=' + $('#hfilename').val()
							+ '&obj.text=' + row.text + '&obj.pinyin='
							+ row.pinyin, callback, "text");
				});
		editingId = undefined;
	}
}

function callback(data) {
	// alert(data);
	// alert(data);
	data = eval('(' + data + ')')
	if (data.successmsg == undefined) {
		alert("操作失败");
		$('#appendFileDlg').dialog('close')
		$.messager.progress('close');
		return;
	}
	alert(data.successmsg);
	// alert("flaf---"+flag);
	if (flag == "addNode") {
		// alert($('#hpId').val());
		if ($('#hpId').val() != "") {
			// $('#tg').treegrid('refresh',$('#hpId').val());
			$('#tg').treegrid('append', {
				parent : $('#hpId').val(), // the node has a 'id' value that
											// defined through 'idField'
											// property
				data : [ {
					id : data.obj.id,
					text : data.obj.text,
					pinyin : data.obj.pinyin
				} ]
			});
		} else {
			// alert("else");
			$('#tg').treegrid('append', {
				// parent: node.id, // the node has a 'id' value that defined
				// through 'idField' property
				data : [ {
					id : data.obj.id,
					text : data.obj.text,
					pinyin : data.obj.pinyin
				} ]
			});
		}

	} else if (flag == "updateNode") {
		// refreshTree();
		// alert($('#oldId').val());
		$('#tg').treegrid('update', {
			id : $('#oldId').val(),
			row : {
				id : data.obj.id,
				text : data.obj.text,
				pinyin : data.obj.pinyin
			// iconCls: 'icon-save'
			}
		});
		$('tr[node-id="' + $('#oldId').val() + '"]').attr("node-id",
				data.obj.id);
		var children = $('#tg').treegrid('getChildren', data.obj.id);

		if (children && children.length > 0) {
			for ( var i in children) {
				children[i]._parentId = data.obj.id;
			}
		}

	}
	$('#hpId').val("");
	$('#oldId').val("");
	$('#nodeId').val("");
	$('#nodeText').val("");
	$('#nodePinyin').val("");
	flag = "noNode";
	setLinkbuttonStyle();
	$('#appendFileDlg').dialog('close');

	$.messager.progress('close');
}

function submitAppendFileForm() {
	if (flag == "addNode") {
		var url = '../../codelib/add_code';
	} else if (flag == "updateNode") {
		var url = '../../codelib/update_code';
	}
	// alert(url);
	var isValid = $('#appendFileForm').form('validate');
	// alert("------"+isValid);
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
