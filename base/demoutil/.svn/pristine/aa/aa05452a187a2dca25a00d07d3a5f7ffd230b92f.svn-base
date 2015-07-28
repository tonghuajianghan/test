//选中导航栏具体功能时触发
function addTab(title, href) {
	var tt = $('#main-center');
	var content = '<iframe scrolling="no" frameborder="0"  src="' + href
			+ '" style="width:100%;height:100%;"></iframe>';
	if (tt.tabs('exists', title)) { //如果用户选择的已经存在则执行更新
		tt.tabs('select', title);
		var tab = tt.tabs('getSelected'); // get selected panel
		$('#main-center').tabs('update', {
			tab : tab,
			options : {
				title : title,
				closable : true,
				content : content
			}
		});
	} else {
		tt.tabs('add', {
			title : title,
			closable : true,
			content : content
		});
	}
}