<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp" ></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'sale_order.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
	<link href="themes/default/easyui.css" rel="stylesheet" type="text/css" />
  	<link href="themes/icon.css" rel="stylesheet" type="text/css" />
	<style>
	#sale_order,#toolbar{
		width:1366px;
	}
	</style>
	<script type="text/javascript">
	$(function(){
		$("#sale_order").datagrid({
			url:'sale/GetSaleOrderJSONServlet',
			dataType:'json',
			type:'post',
			columns:[[
				{field:'id',checkbox:true},
				{field:'code',title:'订单编号',width:200},
				{field:'orderDate',title:'订单日期',width:200},
				{field:'customerCode',title:'客户名称',width:100},
				{field:'nums',title:'数量',width:100},
				{field:'numSprice',title:'总货值',width:100},
				{field:'contacter',title:'联系人',width:100},
				{field:'telPhone',title:'联系方式',width:100},
				{field:'state',title:'审核状态',width:100,formatter:function(val,row,idx){
					if(val.state==1){
						return "已审核";
					}else{
						return "未审核";
					}
				}},
				{field:'addUserName',title:'操作员',width:100},
				{field:'opt',title:'操作',fit:true,formatter:function(val,row,idx){
					var content = "<input type='button' value ='删 除' onClick=\"('"+row.code+"')\" />";
						content += "<input type='button' value='修 改' onClick=\"('"+row.code+"')\" />";
					return content;
				}},
			]],
			fit:true,
			toolbar:"#toolbar",
			pagination:true,
			pageList:[3,5,10,20],
		});
	});
	function searchSaleOrder(){
		var code = $("#search_form").find("input[name='code']").val();
		var startDate = $("#search_form").find("input[name='startDate']").val();
		var endDate = $("#search_form").find("input[name='endDate']").val();
		var customerName = $("#search_form").find("input[name='customerCode']").val();
		var obj={'code':code,'customerName':customerName,'startDate':startDate,'endDate':endDate};
		alert(code);
		$("#sale_order").datagrid("reload",obj);
	}
	function resetSearchBox(){
		$("#search_form").form("reset");
	}
	</script>

  </head>
  
  <body>
    <div id="sale_order" ></div>
    
    <div id="toolbar" >
    <form id="search_form" >
    <span>检索条件：</span>
    <span>订单编号：</span><input type="text" name="code" />
    <span>开始日期：</span><input type="text" name="startDate" />
    <span>结束日期：</span><input type="text" name="endDate" />
    <span>客户名称：</span><input type="text" name="customerCode" />
    <a href="javaScript:searchSaleOrder();"><input type="button" value="搜    索" /></a>
    <a href="javaScript:resetSearchBox();"><input type="button" value="重    置" /></a>
    <br />
    <hr />
    <a  class="easyui-linkButton" data-options="iconCls:'icon-search',plain:true" onClick="searchSaleOrder();">查询</a>
 	<a  class="easyui-linkButton" data-options="iconCls:'icon-add',plain:true" onClick="add();">增加</a>
 	<a  class="easyui-linkButton" data-options="iconCls:'icon-cancel',plain:true" onClick="delBatch();">批量删除</a>
 	<a  class="easyui-linkButton" data-options="iconCls:'icon-excel',plain:true" onClick="export1();">导出EXCEL</a>
    </form>
    </div>
  </body>
</html>










