<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp" ></jsp:include>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>出库单据管理</title>
  		 <script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
 	 	 <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
 		 <link  type="text/css" href="themes/default/easyui.css" rel="stylesheet"/>
 	     <link  type="text/css" href="themes/icon.css" rel="stylesheet" />
	<style>
		a{
			text-decoration:none;
		}
		
		.red{
			color:#E83A1E;
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
		//刷新时隐藏出库单
		$("#add_Dialog").dialog("close");

		$("#mydiv2").datagrid({
		fit:true,
		fitColumns:true,
		url:'kucun/DisplayStockOutServlet',
		dataType:'json',
		idField:'code',
		singleSelect:false,
		pagination:true,
		pageList:[3,5,10],
		pageSize:5,
		toolbar:"#mydiv1",
		columns:[[
		{field:'select',checkbox:true},
		{field:'code',title:'出库单号',width:40},
		{field:'outDate',title:'出库日期',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'customerCode',title:'客户名称',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'nums',title:'数量',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'numSprice',title:'总货值',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'state',title:'审核状态',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'addUserName',title:'操作员',width:40,editor:{ type: 'validatebox', options: { required: true}}},
		{field:'stockIn',title:'操作',fixed:true,formatter:function(val,row,index){
					var content="<input type='button'  id='delButton' value='删除' onclick=\"del('"+row.code+"')\"/>"+
						"<input type='button' id='updateButton' value='修改' onclick=\"update('"+row.code+"','"+index+"')\"/>";
										
					return content;
				}}		
		]],
		
		onDblClickRow: function(rowIndex,rowData){
			$("#code1").html(rowData.code);
			$("#stockOut_order_detail").datagrid("reload",{'outCode':rowData.code});
		}			
		});
		
		$("#stockOut_order_detail").datagrid({
		fit:true,
		fitColumns:true,
		url:'kucun/DescriptionStockInServlet',
		dataType:'json',
		idField:'code',
		columns:[[
		
		//{field:'code',title:'出库明细主键',width:40},
		//{field:'pCode',title:'配件名称',width:40},
		//{field:'nums',title:'配件品牌',width:40},
		//{field:'numSprice',title:'配件型号',width:40},
		//{field:'totalMoney',title:'金额',width:40},
		
		{field:'inCode',title:'出库单据编号',width:40},
		{field:'orderCode',title:'订单编号',width:40},
		{field:'pCode',title:'配件编号',width:40},
		{field:'nums',title:'数量',width:40},
		{field:'price',title:'单价',width:40},
		{field:'wareHouse',title:'所属仓库',width:40},
		{field:'remarks',title:'备注',width:40}
		]]
		
			
	});
				
}); 
//删除出库单据
function del(code){
	$.messager.confirm('确认','你确认要删除选中的数据吗？',function(r){
		if(r){
			$.ajax({
				url:'kucun/deleteStockOutDanJuServlet',
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
		var outDate=row.outDate;
		var customerCode=row.customerCode;
		var nums=row.nums;
		var numSprice=row.numSprice;
		var state=row.state;
		var addUserName=row.addUserName;
			$.ajax({
				url:'kucun/updateStockOutDanJuServlet',
				type:'post',
				dataType:'json',
				data:{'code':code,'outDate':outDate,'customerCode':customerCode,'nums':nums,
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
//修改出库单据
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
//多条件搜索出库单据
function searchAll(){
 var code = $("#code").val();
 var date1= $("#date1").datebox("getValue");
 var date2= $("#date2").datebox("getValue");
 var name = $("#name").val();	
 $("#mydiv2").datagrid('reload',{'code':code,'date1':date1,'date2':date2,'name':name});
 
 
 }
 
//批量删除出库单
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
						url:'kucun/deleteStockOutDanJuServlet',
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
//导出Excel
function export1(){	
	var code = $("#code").val();
 	var date1= $("#date1").datebox("getValue");
 	var date2= $("#date2").datebox("getValue");
 	var name = $("#name").val();
 	var obj={'code':code,'date1':date1,'date2':date2,'name':name};
	//alert(1);
	$.ajax({
		url:'kucun/ExportStockOutExcelServlet',
		dataType:'json',
		type:'post',
		data:obj,
		success:function(data){
		
		}
	});
	//alert("紧挨");
}

//增加
function add(){
	$("#add_Dialog").fadeIn("slow");
	$("#add_Dialog").dialog({
		title:"添加出库单",
		modal:true,
		close:false,
		width:550,
		heigth:200
	});
	$("#myform1").form("reset");
	$("#saveButton").attr("href","javascript:save();");
	alert(1);
}
function closeDialog(dialogId){
	 $(dialogId).find("form").form("reset");
     $(dialogId).dialog("close");
}
function close(){
	closeDialog("#add_Dialog");
}
function print(){
	$.ajax({
		url:"base/OutputDocServlet",
		type:"post",
		data:$("#myform").serialize(),
	});
	closeDialog("#add_Dialog");
}
function save(){
	
	$("#saveButton").attr("href","javascript:save();");
	if($("#myform1").form("validate")){//验证表单的方法，有待验证
		$.ajax({
	       cache: true,//读取缓存
	       type:'post',
	       dataType:'json',
	       url:"kucun/AddStockOutServlet",
	       data:$('#myform1').serialize(),// 你的formid
	       async: false,
	       error: function(request) {
	           $.massager.confirm("信息提示","添加错误！");
	       },
	       success: function(data) {
	           closeDialog("#add_Dialog");
	           $("#mydiv2").datagrid("reload");
	           $.messager.confirm("信息提示","添加成功！");
	       }
	   });
	}else{
		$.messager.confirm("信息提示","添加失败！表单不合法！");
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
						出库单号:<input type="text" id="code" />
    				</td>
    				<td>开始日期:<input class="easyui-datebox" type="text" id="date1"></td>
    				<td>结束日期:<input class="easyui-datebox" type="text" id="date2"></td>
    				<td>客户名称:<input type="text" id="name"></td>
    				<td><input type="button" id="search" onClick="searchAll();" value="搜索"></td>
    				<td><input type="reset" id="button2" value="重置"></td>
    			</tr>
    		</table>
    		
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchAll();">查询</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'"  onclick="add();">添加</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="delBatchRow();">批量删除</a>
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-excel'" onclick="export1();">导出EXCEl </a>
			
    	</form>
    </div>
    <div id="mydiv2"></div>
    
    <div id="add_Dialog" class="easyui-dialog" style="width:100%;">
      <form id="myform1" >
    	<table border="1" cellspacing="0">
	    	<tr>
	    		<td><span class="red">*</span>出库单号:</td>
	    		<td><input type="text" name="code" /></td>
	    		<td><span class="red">*</span>出库日期:</td>
	    		<td><input type="text" name="outDate" /></td>
	    	</tr>
	    	<tr>
	    		<td><span class="red">*</span>客户名称:</td>
	    		<td><input type="text" name="customerCode" /></td>
	    		<td><span class="red">*</span>联系人员:</td>
	    		<td><input type="text" name="contActer" /></td>
	    	</tr>
	    	<tr>
	    		<td>电话:</td>
	    		<td><input type="text" name="telphone" /></td>
	    		<td>传真:</td>
	    		<td><input type="text" name="fax" /></td>
	    	</tr>
	    	<tr>
	    		<td>出库类型:</td>	
	    		<td>
	    			<input type="radio" name="outType" value="1" checked="checked"/>正常出库
	    			<input type="radio" name="outType" value="0"/>销售出库
	    		</td>
	    		<td>是否开票:</td>	
	    		<td>
	    			<input type="radio" name="isInVoice" value="1" checked="checked"/>是
	    			<input type="radio" name="isInVoice" value="0"/>否
	    		</td>
	    	</tr>
	    	<tr>
	    		<td >备注：</td>
	    		<td colspan="3">
	    			<input type="text" name="remarks" /><br />
	    		</td>
	    	</tr>
		</table>
		<br />
		<a href="javascript:add();"><input type="button" value="新增"/></a>
		<a id="caiGou" href="#"><input type="button" value="销售订单"/></a>
		<a id="addPeiJian" href="#"><input type="button" value="添加配件"/></a>
		<a id="saveButton" href="javascript:save();"><input type="button" value="保存"/></a>
		<a id="shenHe" href="#"><input type="button" value="审核"/></a>
		<a id="cheXiao" href="#"><input type="button" value="撤销"/></a>
		<a id="order1" href="#"><input type="button" value="生成销售收款"/></a>
		<a id="order2" href="#"><input type="button" value="生成销售开票"/></a>
		<a href="javascript:print();"><input type="button" value="打印"/></a>
		<a href="javascript:close();"><input type="button" value="关闭"/></a>
    	</form>
    </div>
    
     <div id="stockOut_order"></div>
    <div id="center">单据标号为:<span id="code1"></span>的明细如下所示!</div>
    <div id="stockOut_order_detail"></div>
  </body>
</html>
