<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:include page="/common/base_path.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base_content.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
  <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
  <link href="themes/default/easyui.css" rel="stylesheet" type="text/css" />
  <link href="themes/icon.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
  a{
  	text-decoration:none;
  	color:#000;
  }
  form{
  	margin:0px;
  	padding:0px;
  }
  #tool2 td{
  	padding-right:20px;
  }
  #add_dialog,#up_dialog{
  	padding:5px 10px;
  }
  table{
  	border-color:#E7F0FF;
  }
  </style>
<script>
$(function(){
	$("#add_Dialog").dialog("close");
	$("#up_Dialog").dialog("close");
	$.messager.defaults={ok:"确定",cancel:"取消"};
	$("#baseContentList").datagrid({
		//url:"base/GetBaseContentJSONServlet",
		url:"base/SearchBaseContentJSONservlet",
		
		columns:[[
			{field:'iddd',checkbox:true},
			{field:'categorycode',title:'所属类别',width:100},
			{field:'code',title:'字典编号',width:100},
			{field:'codeName',title:'字典内容',width:100},
			{field:'compCode',title:'公司名称',width:100},
			{field:'orderNo',title:'排序编号',width:100},
			{field:'remarks',title:'备注',width:100},
			{field:'addUser',title:'操作员',width:100},
			{field:'isShow',title:'显示状态',width:100,formatter:function(val,row,idx){
				if(val==1){
					return "显示";
				}else{
					return "隐藏";
				}
			}},
			{field:'opt',title:'操作',width:100,formatter:function(val,row,idx){
				var content="<input type='button' value='删除' onClick=\"del('"+row.categorycode+"','"+row.code+"')\" />";
					content+="<input type='button' value='修改' onClick=\"update("+idx+")\"/>";
					return content;
			}},
		]],
		toolbar:"#toolbar",
		fit:true,
		pagination:true,
		pageList:[3,5,10,20],
	});
	$('#cc').combobox({      
	    valueField:'id',    
	    textField:'text'   
	});
	reloadCategory();
});
function reloadCategory(){
	$.ajax({url:"base/GetCategoryCodeJSONServlet",
		dataType:'json',
		async: false,
		success:function(data){
			$("select[name='categorycode']").empty();
			$("<option>").appendTo("select[name='categorycode']").html("--选择类别--").val(""); 
			for(var i=0;i<data.length;i++){
				$("<option>").appendTo("select[name='categorycode']").html(data[i]).val(data[i]);
			}
		}
	});
}

function add(){
	$("#add_Dialog").dialog({
		title:"添加字典",
		modal:true,
		close:false
	});
	$("#myform").form("reset");
	$("#saveButton").attr("href","javascript:save();");
}
function del(code1,code2){
	$.messager.confirm("信息提示","确认要删除选中数据？",
		function(r){
		 if(r){
		 	$.ajax({url:"base/DeleteBaseContentServlet",//?categorycode="+code1+"&code="+code2,
				dataType:'json',
				type:"post",
				data:{"categorycode":code1,"code":code2},
				success:function(data){
					if(data.ret==1){
						$.messager.confirm("信息提示","删除成功!");
						$("#baseContentList").datagrid("reload");
						reloadCategory();	
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
function delBatch(){
	var rows = $("#baseContentList").datagrid("getSelections");
	if(rows.length==0){
		alert("没有选中任何要删除的数据！");
	}else{
		$.messager.confirm("批量删除","确定要删除选中的数据吗？",
		function(r){
			if(r){
				var ret = "rows";
				for(var i=0;i<rows.length;i++){
					$.ajax({url:"base/DeleteBaseContentServlet",
						dataType:'json',
						type:"post",
						data:{"categorycode":rows[i].categorycode,"code":rows[i].code},
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
				$("#baseContentList").datagrid("reload");
				reloadCategory();	
			}
		});
	}
}
function update(idx){
	var row = $("#baseContentList").datagrid("getRows")[idx];
	$("#myform").find("input[name='categorycode']").val(row.categorycode);
	$("#myform").find("input[name='code']").val(row.code);
	$("#myform").find("input[name='codeName']").val(row.codeName);
	$("#myform").find("input[name='orderNo']").val(row.orderNo);
	$("#myform").find("input[name='remarks']").val(row.remarks);
	$("#myform").find("input[name='isShow']").val(row.isShow);
	
	$("#myform").find("input[name='up_categorycode']").val(row.categorycode);
	$("#myform").find("input[name='up_code']").val(row.code);
	$("#add_Dialog").dialog({
		title:"修改字典",
		modal:true,
		close:false
	});
	$("#saveButton").attr("href","javascript:updateBase();");
};
function updateBase(){
	$.ajax({
	   cache: true,//读取缓存
       type: "POST",
       url:"base/UpdateBaseContentServlet",
       data:$('#myform').serialize(),// 你的formid
       async: false,
       error: function(request) {
           $.messager.confirm("信息提示2","字典修改失败！");
       },
       success: function(data) {
	       if(data.ret=="1"){
	       		$.messager.confirm("信息提示","字典修改成功！");
	       		closeDialog("#add_Dialog");
           		reloadCategory();
	       		$("#baseContentList").datagrid("reload");//重新加载数据
	       }else{
	       		$.messager.confirm("信息提示1","字典修改失败！");
	       }	           
       }
	});
}
function searchBC(){
	var code=$("#searchForm").find("input[name='code']").val();
	var codeName=$("#searchForm").find("input[name='codeName']").val();
	var categorycode=$("#searchForm").find("select[name='categorycode']").val();
	obj={'code':code,'codeName':codeName,'categorycode':categorycode}
	$("#baseContentList").datagrid("reload",obj);
}
function save(){
	//$("#myform").load();
	$("#saveButton").attr("href","javascript:save();");
	if($("#myform").form("validate")){//验证表单的方法，有待验证
		$.ajax({
	       cache: true,//读取缓存
	       type: "POST",
	       url:"base/AddBaseContentServlet",
	       data:$('#myform').serialize(),// 你的formid
	       async: false,
	       error: function(request) {
	           $.massager.confirm("信息提示","字典添加错误！");
	       },
	       success: function(data) {
	           closeDialog("#add_Dialog");
	           $("#baseContentList").datagrid("reload");
	           reloadCategory();
	           $.messager.confirm("信息提示","添加成功！");
	       }
	   });
	}else{
		$.messager.confirm("信息提示","添加失败！表单不合法！");
	}
	
   
}
function closeDialog(dialogId){
	 //$(dialogId).find("form").not($("input[type='button']")).val(null);
	 $(dialogId).find("form").form("reset");
     $(dialogId).dialog("close");
}
function print(){
	$.ajax({
		url:"base/OutputDocServlet",
		type:"post",
		data:$("#myform").serialize(),
	});
	closeDialog("#add_Dialog");
}
function export1(){
	var code=$("#searchForm").find("input[name='code']").val();
	var codeName=$("#searchForm").find("input[name='codeName']").val();
	var categorycode=$("#searchForm").find("select[name='categorycode']").val();
	obj={'code':code,'codeName':codeName,'categorycode':categorycode}
	$.ajax({
		url:"base/ExportExcelServlet",
		type:"post",
		data:obj,
		success:function(data){
		
		}
	});
}
function close(){
	closeDialog("#add_Dialog");
}
function reset(){
	$("#searchForm").form("reset");
}
</script>
  </head>
  <body>
    <div id="baseContentList" >
    </div>
    <div id="toolbar">
    <form id="searchForm">
    <table id="tool1">
	    <tr>
	  		<td>检索条件:</td>
	  		<td>字典编号:</td>
	  		<td><input type="text" name="code" /></td>
	  		<td>&nbsp;&nbsp;&nbsp;&nbsp;字典名称:</td>
	  		<td><input type="text" name="codeName" /></td>
	  		<td>&nbsp;&nbsp;&nbsp;&nbsp;所属类别:</td>
	  		<td>
		  		<select id="select"  style="width:150px" name="categorycode" >
		  			<option value="">--选择类别--</option>
		  		</select>
	  		</td>
	  		<td>
	  			<a onClick="searchBC();" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" >搜索</a>
	  			<a onClick="reset();" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" >重置</a>
	  		</td>
	  	</tr>
	</table>
	<hr />

   		<a  class="easyui-linkButton" data-options="iconCls:'icon-search'" onClick="searchBC();">查询</a>
   		<a  class="easyui-linkButton" data-options="iconCls:'icon-add'" onClick="add();">增加</a>
   		<a  class="easyui-linkButton" data-options="iconCls:'icon-cancel'" onClick="delBatch();">批量删除</a>
   		<a  class="easyui-linkButton" data-options="iconCls:'icon-excel'" onClick="export1();">导出EXCEL</a>

	</form>
    </div>
    <%
    	String compName = "宝鸡盟泰";
    	String userCode = "管理员";
     %>
    <div id="add_Dialog" class="easyui-dialog">
    <form id="myform" >
    	<input type="hidden" name="addUser" value="<%=userCode %>" />
    	<input type="hidden" name="addUserName" value="用户姓名 "/>
    	<input type="hidden" name="addCode" value="用户编号"/>
    	<input type="hidden" name="compCode" value="<%=compName %>" />
    	<input type="hidden" name="up_code" />
    	<input type="hidden" name="up_categorycode" />
    <table border="1" cellspacing="0">
	    <tr>
	    	<td>所属类别：</td>
	    	<td><input type="text" name="categorycode" /></td>
	    	<td><span class="red">*</span>字典编号：</td>
	    	<td><input type="text" name="code" /></td>
	    </tr>
	    <tr>
	    	<td><span class="red">*</span>字典名称：</td>
	    	<td><input type="text" name="codeName" /></td>
	    	<td>排序编号：</td>
	    	<td>
	    		<input type="text" name="orderNo" /><br />
	    		<span class="txt">(请按001格式填写，001为最先)</span>
	    	</td>
	    </tr>
	    <tr>
	    	<td>显示状态：</td>
	    	<td>
	    		<input type="radio" name="isShow" value="1" checked="checked"/>显示
	    		<input type="radio" name="isShow" value="0"/>隐藏
	    	</td>
	    	<td>备注：</td>
	    	<td>
	    		<input type="text" name="remarks" /><br />
	    	</td>
	    </tr>
	</table>
	<br />
	<a href="javascript:add();"><input type="button" value="新增"/></a>
	<a id="saveButton" href="javascript:save();"><input type="button" value="保存"/></a>
	<a href="javascript:print();"><input type="button" value="打印"/></a>
	<a href="javascript:close();"><input type="button" value="关闭"/></a>
    </form>
    </div>
    
  </body>
</html>






















