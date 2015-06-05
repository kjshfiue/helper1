<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp" ></jsp:include>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>入库单据管理</title>
  		 <script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
 	 	 <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
 		 <link  type="text/css" href="themes/default/easyui.css" rel="stylesheet"/>
 	     <link  type="text/css" href="themes/icon.css" rel="stylesheet" />
	<style>
		a{
			text-decoration:none;
		}
	</style>
	<script type="text/javascript">
	//var output;
	$(function(){
	
		$("#mydiv2").datagrid({
		fit:true,
		fitColumns:true,
		url:'kucun/DisplayStockInServlet',
		dataType:'json',
		idField:'code',
		singleSelect:false,
		pagination:true,
		pageList:[3,5,10],
		//pageSize:5,
		toolbar:"#mydiv1",
		columns:[[
		{field:'select',checkbox:true},
		{field:'code',title:'入库单号',width:40},
		{field:'inDate',title:'入库日期',width:40},
		{field:'supplierCode',title:'供应商名',width:40},
		{field:'nums',title:'数量',width:40},
		{field:'numSprice',title:'总货值',width:40},
		{field:'state',title:'审核状态',width:40},
		{field:'addUserName',title:'操作员',width:40},
		{field:'opt',title:'操作',fixed:true,formatter:function(val,row,index){
					var content="<input type='button' value='删除' onclick=\"delRow('"+row.code+"','"+index+"')\"/>"+
							"<input type='button' value='修改' onclick=\"update('"+row.code+"')\"/>"+
							"<input type='button' value='预览' onclick=\"look('"+row.code+"')\"/>";;
								
					return content;
				}}		
		]]			
		});
		
		/* $.ajax({
			
			type:"POST",
			dataType:'json',
			success:function(data){
				
			}
		}); */
				
}); 

//搜索
function search(){
 var code = $("#code").val();
 var date1= $("#date1").datebox("getValue");
 var date2= $("#date2").datebox("getValue");
 var name = $("#name").val();	
 $("#mydiv2").datagrid('reload',{'code':code,'date1':date1,'date2':date2,'name':name});
 
 }

	</script>
  </head>
  
  <body>
    <div id="mydiv1">
    	<form method="post" id="myform">
    		<table>
    			<tr style="background-color:#DBEAF9;">
    				<td><span  style="font-weight:bold">检索条件&nbsp;</span>
						入库单号:<input type="text" id="code" />
    				</td>
    				<td>开始日期:<input class="easyui-datebox" type="text" id="date1"></td>
    				<td>结束日期:<input class="easyui-datebox" type="text" id="date2"></td>
    				<td>供应商名:<input type="text" id="name"></td>
    				<td><input type="button" id="search" onClick="search()" value="搜索"></td>
    				<td><input type="reset" id="button2" value="重置"></td>
    			</tr>
    		</table>
    		
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'"  onclick="add();">添加</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="delBatchRow();">批量删除</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'"  onclick="outexcel();">导出EXCEl </a>
			
    	</form>
    </div>
    <div id="mydiv2"></div>
   
  </body>
</html>
