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
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+m+'-'+d;
	}
	
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
		pageSize:5,
		toolbar:"#mydiv1",
		columns:[[
		{field:'select',checkbox:true},
		{field:'code',title:'入库单号',width:40},
		{field:'inDate',title:'入库日期',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'supplierCode',title:'供应商名',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'nums',title:'数量',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'numSprice',title:'总货值',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'state',title:'审核状态',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'addUserName',title:'操作员',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'stockIn',title:'操作',fixed:true,formatter:function(val,row,index){
					var content="<input type='button'  id='delButton' value='删除' onclick=\"del('"+row.code+"')\"/>"+
						"<input type='button' id='updateButton' value='修改' onclick=\"update('"+row.code+"','"+index+"')\"/>";
										
					return content;
				}}		
		]]			
		});
				
}); 
//删除入库单据
function del(code){
	$.messager.confirm('确认','你确认要删除选中的数据吗？',function(r){
		if(r){
			$.ajax({
				url:'kucun/deleteStockInDanJuServlet',
				dataType:'json',
				type:'post',
				data:{'code':code},
				success:function(data){
					if(data.ret==1){
						
						$.messager.confirm("信息提示","删除成功!");
						$("#mydiv2").datagrid("reload");
						
					}else{
						$.messager.confirm("信息提示1","删除失败!");
					}
				},
				error:function(){
					$.messager.confirm("信息提示2","删除失败!");
				}
			});
		}
	});
}
function saveVal(code,index){
//alert("**"+code);
$.messager.confirm('信息提示','你要修改选中的数据吗?',function(r){
		if(r){
		var row = $("#mydiv2").datagrid("getRows")[index];
		var inDate=row.inDate;
		var supplierCode=row.supplierCode;
		var nums=row.nums;
		var numSprice=row.numSprice;
		var state=row.state;
		var addUserName=row.addUserName;
			$.ajax({
				url:'kucun/updateStockInDanJuServlet',
				type:'post',
				dataType:'json',
				data:{'code':code,'inDate':inDate,'supplierCode':supplierCode,'nums':nums,
				'numSprice':numSprice,'state':state,'addUserName':addUserName},
				success:function(data){
					if(data.ret==1){
						$.messager.confirm("信息提示","修改成功!");
						$("#mydiv2").datagrid("reload");
					}else{
						$.messager.confirm("信息提示1","修改失败!");
					}
				},
				error:function(){
					$.messager.confirm("信息提示2","修改失败!");
				}
			});
		}
	}); 
}
//修改入库单据
function update(code,index){
   var val=$("input[id='updateButton']").val();
   if(val=="修改"){	
   	  
   	  $("#updateButton").val("确定");
   	  $("#mydiv2").datagrid("beginEdit", index);
   }else if(val=="确定"){
   	  $("#mydiv2").datagrid("endEdit", index);
   	    $("#updateButton").attr('onclick',saveVal(code,index));
   }else{
   	  alert('有错误!');
   } 
   
}
//多条件搜索入库单据
function searchAll(){
 var code = $("#code").val();
 var date1= $("#date1").datebox("getValue");
 var date2= $("#date2").datebox("getValue");
 var name = $("#name").val();	
 $("#mydiv2").datagrid('reload',{'code':code,'date1':date1,'date2':date2,'name':name});
 
 
 }
 
//批量删除
function delBatchRow(){
	var rows = $("#mydiv2").datagrid("getSelections");
	if(rows.length==0){
		alert("没有选中任何要删除的数据！");
	}else{
		$.messager.confirm("批量删除","确定要删除选中的数据吗？",
		function(r){
			if(r){
				var ret = "rows";
				for(var i=0;i<rows.length;i++){
					$.ajax({
						url:'kucun/deleteStockInDanJuServlet',
						dataType:'json',
						type:'post',
						data:{'code':rows[i].code},
						success:function(data){
							if(data.ret==0){
								ret += ","+data.ret;
							}
						},
					});
				}
				if(ret=="rows"){
					$.messager.confirm("信息提示","删除成功!");
				}else{
					$.messager.confirm("信息提示","删除失败!失败行号"+ret);
				}
				$("#mydiv2").datagrid("reload");
				
			}
		});
	}
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
    				<td><input type="button" id="search" onClick="searchAll();" value="搜索"></td>
    				<td><input type="reset" id="button2" value="重置"></td>
    			</tr>
    		</table>
    		
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchAll();">查询</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'"  onclick="add();">添加</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="delBatchRow();">批量删除</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-print'"  onclick="outexcel();">导出EXCEl </a>
			
    	</form>
    </div>
    <div id="mydiv2"></div>
   
  </body>
</html>
