/**
 * 分页相关函数集
 */
var paging = paging || {};

/**
 * 表单分页
 */
paging.form = {
	/**
	 * 分页设置初始化
	 * 
	 * @param opt 设置选项
	 */
	init: function(opt) {
		// 分页容器
		var cont = $(opt.container);
		
		// 分页容器不存在，则不作分页处理
		if(cont.size() == 0) {
			return false;
		}
		
		// 分页表单
		var form = $(opt.form);
		// 分页页码
		var numb = $(opt.numb);
		// 总计页数
		var page = opt.page;
		// 总计条数
		var total = opt.total;
		// 自定义分页操作栏翻页函数
		var turn = opt.turn;
		// 自定义分页操作栏生成函数
		var generator = opt.generator;

		// 将分页设置存于分页容器中

		// 分页表单
		cont.data("form", form);
		// 分页页码
		cont.data("numb", numb);
		// 总计页数
		cont.data("page", Number(page));
		// 总计条数
		cont.data("total", Number(total));
		// 分页操作栏翻页函数
		cont.data("turn", typeof turn == "function" ? turn : this.turn);
		// 分页操作栏生成函数
		cont.data("generator", typeof generator == "function" ? generator : this.generator);

		// 生成分页操作栏
		(cont.data("generator"))(opt.container);
	},
	
	/**
	 * 翻页函数
	 * 
	 * @param container 分页容器选择器
	 * @param to 跳转至页码
	 */
	turn: function(container, to) {
		// 分页容器
		var cont = $(container);
		// 分页表单
		var form = cont.data("form");
		// 分页页码
		var numb = cont.data("numb");
		// 总计页数
		var page = cont.data("page");

		// 翻页页码
		to = $.isNumeric(to) ? (page == 0 ? 1 : to > page ? page : to < 1 ? 1 : to) : 1;

		// 设置翻页页码
		numb.val(to);
		// 提交分页表单
		form.submit();
	},
	
	/**
	 * 分页操作栏生成函数
	 * 
	 * @param container 分页容器选择器
	 */
	generator: function(container) {
		// 分页容器
		var cont = $(container);
		// 分页页码
		var numb = cont.data("numb");
		// 总计页数
		var page = cont.data("page");
		// 翻页函数
		var turn = cont.data("turn");
		// 当前页码
		var cur = Number(numb.val());

		// 总计页数小于1，无需显示分页操作栏
		if(page <= 1) {
			return false;
		}
		
		var html = "<ul>";
		
		if(cur != 1) {
			html += "<li><a href='javascript:' rel='1'>首页</a></li>";
		} else {
			html += "<li><label>首页</label></li>";
		}
		
		if(cur > 1) {
			html += "<li><a href='javascript:' rel='" + (cur - 1) + "'>上一页</a></li>";
		} else {
			html += "<li><label>上一页</label></li>";
		}
		
		if(cur > 10) {
			html += "<li><a href='javascript:' rel='" + (Math.floor((cur - 1) / 10) * 10) + "'>...</a></li>";
		}
		
		for(var i = Math.floor((cur - 1) / 10) * 10 + 1; i <= Math.min(page, Math.floor((cur - 1) / 10) * 10 + 10); i++) {
			if(cur == i) {
				html += "<li><label>" + i + "</label></li>";
			} else {
				html += "<li><a href='javascript:' rel='" + i + "'>" + i + "</a></li>";
			}
		}
		
		if(page > Math.min(page, Math.floor((cur - 1) / 10) * 10 + 10)) {
			html += "<li><a href='javascript:' rel='" + (Math.min(page, Math.floor((cur - 1) / 10) * 10 + 10) + 1) + "'>...</a></li>";
		}
		
		if(cur < page) {
			html += "<li><a href='javascript:' rel='" + (cur + 1) + "'>下一页</a></li>";
		} else {
			html += "<li><label>下一页</label></li>";
		}
		
		if(cur != page) {
			html += "<li><a href='javascript:' rel='" + page + "'>尾页</a></li>";
		} else {
			html += "<li><label>尾页</label></li>";
		}
		
		html += "<li><input type='text' rel='page-go' /><a href='javascript:' class='page-go'>跳转</a></li>";
		
		html += "</ul>";
		
		cont.html(html);
		
		// 点击链接将触发翻页事件
		cont.find("a[rel]").unbind("click").click(function() {
			// 触发翻页动作
			turn(container, $(this).attr("rel"));
			// 禁止浏览器默认行为
			return false;
		});
		
		// 点击跳转链接触发跳转事件
		cont.find(".page-go").unbind("click").click(function() {
			// 触发翻页动作
			turn(container, $("[rel='page-go']").val());
			// 禁止浏览器默认行为
			return false;
		});
	}
};

/**
 * 模拟分页
 */
paging.simulate = {
	/**
	 * 分页设置初始化
	 * 
	 * @param opt 设置选项
	 */
	init: function(opt) {
		// 分页容器
		var cont = $(opt.container);
		
		// 分页容器不存在，则不作分页处理
		if(cont.size() == 0) {
			return false;
		}
		
		// 待分页数据
		var data = $(opt.items);
		// 每页条数
		var size = opt.size;
		// 自定义分页操作栏翻页函数
		var turn = opt.turn;
		// 自定义分页操作栏生成函数
		var generator = opt.generator;

		// 将分页设置存于分页容器中
		
		// 分页数据
		cont.data("items", data);
		// 每页条数
		cont.data("size", size);
		// 总计条数
		cont.data("total", data.size());
		// 总计页数
		cont.data("page", Math.ceil(data.size() / size));
		// 分页操作栏翻页函数
		cont.data("turn", typeof turn == "function" ? turn : this.turn);
		// 分页操作栏生成函数
		cont.data("generator", typeof generator == "function" ? generator : this.generator);
		// 初始化标识
		cont.data("initialized", 0);
		
		// 跳转至首页
		(cont.data("turn"))(opt.container, 1);
	},
	
	/**
	 * 翻页函数
	 * 
	 * @param container 分页容器选择器
	 * @param to 跳转至页码
	 */
	turn: function(container, to) {
		// 分页容器
		var cont = $(container);
		// 分页数据
		var data = cont.data("items");
		// 每页条数
		var size = cont.data("size");
		// 总计页数
		var page = cont.data("page");
		// 初始化标识
		var initialized = cont.data("initialized");
		
		// 翻页页码
		to = page == 0 ? 1 : to > page ? page : to < 1 ? 1 : to;
		
		// 前页数据
		var prev = data.filter(":lt(" + size * (to - 1) + ")");
		// 后页数据
		var post = data.filter(":gt(" + (size * to - 1) + ")");
		
		// 获取分页关联数据
		var _ref = function(items) {
			var r = $();
			items.each(function() {
				r = $("[rel='" + this.id + "']").add(r);
			});
			return r;
		};
		
		// 待隐藏页数据
		var _hide = prev.add(post);
		// 待显示页数据
		var _show = data.not(prev).not(post);
		
		// 如果分页已初始化，则仅需处理可见的待隐藏页数据
		if(initialized == 0) {
			cont.data("initialized", 1);
		} else {
			_hide = _hide.filter(":visible");
		}

		// 分页数据为表格行时，调用专用函数控制显示
		if(data.is("tr")) {
			// 隐藏非当前页数据
			toggleTR(_hide.add(_ref(_hide)), "hide");
			// 显示当前页数据
			toggleTR(_show.add(_ref(_show)), "show");
		} else {
			// 隐藏非当前页数据
			_hide.add(_ref(_hide)).hide();
			// 显示当前页数据
			_show.add(_ref(_show)).show();
		}

		// 生成分页操作栏
		(cont.data("generator"))(container, to);
	},
	
	/**
	 * 分页操作栏生成函数
	 * 
	 * @param container 分页容器选择器
	 * @param cur 当前页码
	 */
	generator: function(container, cur) {
		// 分页容器
		var cont = $(container);
		// 总计页数
		var page = cont.data("page");
		// 翻页函数
		var turn = cont.data("turn");

		// 总计页数小于1，无需显示分页操作栏
		if(page <= 1) {
			return false;
		}
		
		var html = "<ul>";
		
		if(cur != 1) {
			html += "<li><a href='javascript:' rel='1'>首页</a></li>";
		} else {
			html += "<li><label>首页</label></li>";
		}
		
		if(cur > 1) {
			html += "<li><a href='javascript:' rel='" + (Number(cur) - 1) + "'>上一页</a></li>";
		} else {
			html += "<li><label>上一页</label></li>";
		}
		
		if(cur > 10) {
			html += "<li><a href='javascript:' rel='" + (Math.floor((Number(cur) - 1) / 10) * 10) + "'>...</a></li>";
		}
		
		for(var i = Math.floor((Number(cur) - 1) / 10) * 10 + 1; i <= Math.min(page, Math.floor((Number(cur) - 1) / 10) * 10 + 10); i++) {
			if(cur == i) {
				html += "<li><label>" + i + "</label></li>";
			} else {
				html += "<li><a href='javascript:' rel='" + Number(i) + "'>" + i + "</a></li>";
			}
		}
		
		if(page > Math.min(page, Math.floor((Number(cur) - 1) / 10) * 10 + 10)) {
			html += "<li><a href='javascript:' rel='" + (Math.min(page, Math.floor((Number(cur) - 1) / 10) * 10 + 10) + 1) + "'>...</a></li>";
		}
		
		if(cur < page) {
			html += "<li><a href='javascript:' rel='" + (Number(cur) + 1) + "'>下一页</a></li>";
		} else {
			html += "<li><label>下一页</label></li>";
		}
		
		if(cur != page) {
			html += "<li><a href='javascript:' rel='" + Number(page) + "'>尾页</a></li>";
		} else {
			html += "<li><label>尾页</label></li>";
		}
		
		html += "</ul>";
		
		cont.html(html);
		
		// 点击链接将触发翻页事件
		cont.find("a[rel]").unbind("click").click(function() {
			// 触发翻页动作
			turn(container, $(this).attr("rel"));
			// 禁止浏览器默认行为
			return false;
		});
	}
};