<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<dl class="banner">
    <dd class="back">
        <a href="javascript:" onclick="window.history.go(-1);return false;"></a>
	</dd>
	<dt class="title">${empty pssQa.qaId ? "新增问题" : "修改问题" }</dt>
</dl>
    
<form id="qaForm" method="post">
    <table cellspace="0" cellpadding="0" class="edit">
        <col width="20%" /><col width="80%" />
        <tr>
            <th>
            	<div>问题标题:</div>
            </th>
            <td>
                <input class="textCont" type="text" id="qaDesc" name="qaDesc" value="${pssQa.qaDesc}" />
            </td>
        </tr>
        <tr>
            <th>
             	<div>问题标签:</div>
            </th>
            <td style="height:60px">
                <input class="buttonCont" type="button" onclick="showTagDiv()" value="+" />
                <span id="tagEditDiv" style="display: none;height: 20px">
                    <input class="tagInputCont" id="tagContentInput" type="text"/>
                    <input class="buttonCont" type="button" onclick="addTag()" value="添加"/>
                </span>
                <div id="tagDiv" style="padding-top: 2px">
                    <c:forEach var="qa" items="${pssQa.pssQaTagSet}">
                        <input type='button' class='tagCont' name='tagInput' id='${qa.tagDesc}' value='${qa.tagDesc}' style='background:url(images/admin/delTag.png) no-repeat;' onclick='removeTag(this)'/>
                    </c:forEach>
                </div>
            </td>
        </tr>
        <tr>
            <th>
             	<div>问题所属产品：</div>
            </th>
            <td>
                <select id="prodSel" onchange="prodChg($(this).val())">
                	<option value="">请选择问题所属产品</option>
                    <c:forEach var="dic" items="${dicProd}">
                        <option value="${dic.key}"
                            ${pssQa.prodId eq dic.key ? 'selected' : ''}>${dic.value}</option>
                    </c:forEach>
                </select>
                <input type="hidden" id="prodId" name="prodId" value="${pssQa.prodId}"/>
            </td>
        </tr>
        <tr>
            <th>
				<div>问题答案:</div>
            </th>
            <td>
                <textarea class="textareaCont" id="qaCont" name="qaCont" >${pssQa.qaCont}</textarea>
            </td>
        </tr>
    </table>
    
	<div class="center m-top" style="margin-top:40px">
		<input class="btn-03" type="button" onclick="save()" value="保存">
		<input class="btn-03" type="reset" value="重置">
	</div>
</form>
<script type="text/javascript">
    $(function() {
    	
		// 页面校验
		$("#qaForm").validate({
			// 提交时不自动校验
			onsubmit: false,
			// 设置校验规则
			rules: {				
				"qaDesc": "required",
				"prodId":"required",
				"qaCont": "required"
			},
	   		// 设置校验信息
	   		messages: {
	   			"prodId": {
	   				required: validateMessage("相关产品", "select")
	   			},
	   			"qaDesc":{
	   				required: validateMessage("问题描述", "input")
	   			},
	   			"qaCont":{
	   				required: validateMessage("问题答案", "input")
	   			}
	   		},
			// 设置校验信息显示形式
			showErrors: function(errorMap, errorList) {
				// 执行默认操作
				this.defaultShowErrors();

				// 自定义校验信息显示形式
				_showErrors(errorMap, errorList, {
					type: "label",
					form: this.currentForm,
					settings: this.settings
				});
			},
			// 设置有出错信息时的操作
			invalidHandler: function(e, validator) {
				// 自定义出错反馈
				_invalidHandler(e, validator);
	   		}
	   	});       
    });

	function save() {	
		//录入校验信息
		if($("#qaForm").validate().form()) {
			// 拼接问题对象
			var pssQa = new Object();
	        pssQa.qaId = '${pssQa.qaId}';
			pssQa.qaDesc = $("#qaDesc").val();
			pssQa.qaCont = $("#qaCont").val();
			pssQa.prodId = $("#prodId").val();
	
			var tagArr = new Array();
			$("input[name='tagInput']").each(function() {
				var obj = new Object();
				obj.tagDesc = $(this).val();
				tagArr.push(obj);
			});
	
			pssQa.pssQaTagSet = tagArr;
			
			// 新增问题不设置用户ID
			if(${not empty pssQa.qaId}) {
				pssQa.qaId = "${pssQa.qaId}";
			}
	
			dialogMessage("${empty pssQa.qaId ?'确定新增问题信息吗？':'确定要修改问题信息吗？'}",function(content) {			
				content.dialog("destroy").remove();
					
				ajaxCommon({
					url : "qa/save",
					contentType : "application/json",
					data : JSON.stringify(pssQa)
				}, function(message) {
					if (message == "success") {
						// 返回信息为空，表示保存成功，弹出提示信息
						dialogMessage("保存成功！", function(content) {
							// 关闭提示窗口
							content.dialog("destroy").remove();
							parent.dialogIframeClose('dialog-iframe-uploader', false);
							window.location = "qa/qa_list";
						});
					} else {
						// 返回信息，则表示保存失败，弹出失败信息
						dialogMessage(message);
					}
				});
			},true);			
		}
	}
    // 点击新增按钮显示标签输入框
	function showTagDiv() {
		$("#tagEditDiv").show();
	}
    // 点击确认添加标签,新增标签按钮
	function addTag(tagDesc) {
		if($("#tagContentInput").val() == ''){
			dialogMessage("请编写标签",function(content) {			
				content.dialog("destroy").remove();
			})
			return false;
		}
		$("#tagDiv").after("<input type='button' class='tagCont' name='tagInput' id='"
				+ $("#tagContentInput").val() + "' value='"
				+ $("#tagContentInput").val() + "'style='background:url(images/admin/delTag.png) no-repeat;' onclick='removeTag(this)'/>");
		$("#tagContentInput").val("");
		$("#tagEditDiv").hide();
	}
    // 移除标签
	function removeTag(button) {
		$(button).remove();
	}
    // 产品下拉框变更传递到隐藏输入框
    function prodChg(sel){
        $("#prodId").val(sel);
    }
</script>