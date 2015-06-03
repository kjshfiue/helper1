<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'DanJu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easyui.min.js" type="text/javascript"></script>
<link href="themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="themes/icon.css"  rel="stylesheet"  type="text/css"/>
<style type="text/css">
	ul li{
	list-style:none;
	display:inline;
	}
</style>
<script type="text/javascript">
$(function(){
//绑定数据
var code=$("#code1").val();
//alert(code);
$.ajax({
	url:'/helper/DanJu.do',
	data:{"code":code},
	dataType: "json",
	type:'post',
	success:function(data){
	//alert(data[0].partsCode);
	$("#code").val(data[0].partsCode);
	$("#name").val(data[0].partsName);
	$("#type").val(data[0].partsCategory);
	$("#brand").val(data[0].partsBrand);
	$("#jianhao").val(data[0].partsNo);
	$("#tjianhao").val(data[0].partsGenetalPartsNo);
	$("#new").val(data[0].partsModel);
	$("#old").val(data[0].partsModelOld);
	$("#chicun").val(data[0].partSize);
	$("#weight").val(data[0].partWeight);
	$("#danwei").val(data[0].partsUnit);
	$("#price").val(data[0].salePrice);
	$("#isShow").val(data[0].partsCode);
	$("#remarks").val(data[0].remarks);
	}
})

//绑定按钮1
$("#btn1").bind('click',function(){
$("#code").val();
	$("#name").val();
	$("#type").val();
	$("#brand").val();
	$("#jianhao").val();
	$("#tjianhao").val();
	$("#new").val();
	$("#old").val();
	$("#chicun").val();
	$("#weight").val();
	$("#danwei").val();
	$("#price").val();
	$("#isShow").val();
	$("#remarks").val();
})
})
</script>

  </head>
  
  <body>
   	<table id="tables" class="easyui-panel">
   	<tr>
   		<td>配件编号</td>
   		<td><input type="text" id="code" /></td>
   		<td>配件名称</td>
   		<td><input type="text" id="name" /></td>
   	</tr>
   		<tr>
   		<td>配件类型</td>
   		<td><input type="text" id="type" /></td>
   		<td>配件品牌</td>
   		<td><input type="text" id="brand" /></td>
   	</tr>
   		<tr>
   		<td>件号</td>
   		<td><input type="text" id="jianhao" /></td>
   		<td>通用件号</td>
   		<td><input type="text" id="tjianhao" /></td>
   	</tr>
   		<tr>
   		<td>型号</td>
   		<td><input type="text" id="new" /></td>
   		<td>旧型号</td>
   		<td><input type="text" id="old" /></td>
   	</tr>
   		<tr>
   		<td>配件尺寸</td>
   		<td><input type="text" id="chicun" /></td>
   		<td>配件重量</td>
   		<td><input type="text" id="weight" /></td>
   	</tr>
   		<tr>
   		<td>选择图片</td>
   		<td></td>
   		<td>配件单位</td>
   		<td><input type="text" id="danwei" /></td>
   	</tr>
   		<tr>
   		<td>销售价格</td>
   		<td><input type="text" id="price" /></td>
   		<td>显示状态</td>
   		<td><input type="text" id="isShow" /></td>
   	</tr>
   	<tr>
   		<td>备注</td>
   		<td><input type="text" id="remarks" /></td>
   	</tr>
  
   	</table>
   	 	<ul>
   		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn1">保存</a></li>
   		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn2">提交</a></li>
   		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn3">关闭</a></li>
   		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn4">同步</a></li>
   		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn5">打印</a></li>
   	</ul>
   	<h3><input type="text" value="<%=request.getParameter("code") %>" id="code1" style="display:none"/></h3>
  </body>
</html>
