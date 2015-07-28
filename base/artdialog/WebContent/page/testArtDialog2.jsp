<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>art2</title>

<link id="artDialogSkin" href="../js/artDialog/skin/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/artDialog/artDialog.js"></script>
<!-- <script type="text/javascript" src="../js/artDialog/artDialog.iframeTools.js"></script> 对iframe的新工具 -->

</head>
<body >
<script type="text/javascript">
    function a(){     
               art.dialog({content:'hello world!历史'})
              }
    function b(){  
       art.dialog(
        {
            content:'欢迎你来到对话框世界！',
            lock:true,
            style:'succeed noClose'
        },
        function(){
            alert('你点了确定'); //不管点了确定还是取消默认都会关闭artdialog，除非在这里面返回false
        },
        function(){
            alert('你点了取消');
        }
                 );
               }
    function c(){
    art.dialog(
    {
    title:'图片查看',
    fixed:true,
      content:'<img width="817" height="479" src="butterfly.jpg" />'
                 });
    //return false;
   };
    function d(){
   // art.dialog({title:'dialog内嵌iframe', iframe:'http://www.baidu.com', width:'900', height:'500'});

   //已经没有了直接的iframe属性  通过下面的方式内嵌iframe  第二种效果不佳
   art.dialog.open("http://www.baidu.com", {width: 320, height: 400});
   // art.dialog({title:'dialog内嵌iframe', width:'900px',height:'500px', content:"<iframe align='right' src='http://www.baidu.com' width:'100%' height:'100%' />"});
    return false;
   };
    function e(){
    art.dialog(
    {
    title:'动画',
    fixed:true,
      content:'<embed src="ddd.rm" type="audio/x-pn-realaudio-plugin" autostart="true" width="420" height="363"></embed>'
                 });
   
   }; //播放avi总是只有声音，没有画面，哎！
function f(){
    art.dialog({content:'你人品稳定么？', fixed:true, yesText:'我很稳定', style:'confirm', id:'bnt4_test'},
    function(){
           art.dialog({id:'bnt4_test'}).content('你骗人！');
          return false;//这样对话框才不会关闭
        },
     function(){alert('你是坏人');}//按右上角的叉关闭对话框也会执行这个函数
     );
   };
   function g(){
    art.dialog({mouse:true, id:'dg_test34243', content:'您收到 <strong>2</strong> 条消息',left:'right',width:'15em', top:'bottom', fixed:true});
   };
   function h(){
    art.dialog({id:'dg_test34243'}).close();
   };
   function i(){
          var _this = document.getElementById('btn7');
          if (document.getElementById('menu_4834783')) {//如果已经打开了对话框，按这个按钮还能把它关闭
                                                        art.dialog({id:'menu_4834783'}).close();
                                                        _this.innerHTML = '弹出菜单'; //button上显示的内容
                                                        return;
                                                       };
    art.dialog({id:'menu_4834783', title:'菜单', content:'请输入：<input style="width:200px;" id="M_dfd" type="text" value="hello world!" />',
               button:[{name:'确定',callback:function(){  
                                                      var a=document.getElementById('M_dfd').value;
                                                      art.dialog({content:a, lock:true, time:1});
                                                     }
                        },
                       {name:'关闭我',callback:function(){_this.innerHTML = '弹出菜单';}}
                       ]
              }
              );  
    _this.innerHTML = '关闭菜单';
    return false;
    };                      
    </script>
<input type="button" style="width: 100px" onClick="a()" value="最简单的对话框"/><br/>
<button id="btn0" onClick="b()">基本示例</button><br/>
<button id="btn1" onClick="c()">显示图片</button><br/>
<button id="btn2" onClick="d()">外部页面</button><br/>
<button id="btn3" onClick="e()">视频</button><br/>
<button id="btn4" onClick="f()">询问</button><br/>
<button id="btn5" onClick="g()">广告</button>
<button id="btn6" onClick="h()">关闭</button><br/>
<button id="btn7" onClick="i()">弹出菜单</button><br/>
</body>
</html>