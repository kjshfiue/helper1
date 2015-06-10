<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp" ></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'sale_dingdan.jsp' starting page</title>

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
	#order{
		width:900px;
		margin:0px auto;
	}
	#box{
		height: 300px;
		width:900px;
		margin:0px auto;
	}
	#order span{
		color:red;
	}
	table{
		border:solid #EAF2FE 1px;
		border-width:1px;
		border-collapse:collapse;
  		padding:5px;
  	}
  	table td.text{
  		width:148;
  		text-align:right;
  		border:solid #EAF2FE 1px;
  	}
  	table td.input{
  		width:250;
  		border:solid #EAF2FE 1px;
  	}
	</style>
	<script type="text/javascript">
	/* $.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+m+'-'+d;
	} */
	function getCode(){
		var time = new Date();
		var year = time.getFullYear();
		var month = time.getMonth();
		var day = time.getDate();
		var hour = time.getHours();
		var minute = time.getMinutes();
		var seconds = time.getSeconds();
		var milliseconds = time.getMilliseconds();
		var codeStr = "MTXS"+year+month+day+hour+minute+seconds+milliseconds;
		//$("input[name='code']").val(codeStr);
		return codeStr;
	}
	$(function(){
		$("input[name='code']").val(getCode());
		$("#p_dialog").dialog({
			title:"选择配件",
			width:1000,
			height:500,
			modal:true,
			buttons:[{
					text:'保存',
					iconCls: 'icon-save',
					handler:function(){}
				},
				{
					text:'取消',
					iconCls: 'icon-cancel',
					handler:function(){
						$("#p_dialog").dialog('close');
					}
				}
			],
		});
		$("#p_dialog").dialog('close');
		//$("#peijian").dialog('open').dialog('refresh');
		
		$("#sale_order_detail").datagrid({
			url:"sale/GetSaleOrderDetailJSONServlet",
			dataType:'json',
			columns:[[
				{field:'sqcode',title:'报价单号',width:100},
				{field:'partsno',title:'件号',width:100},
				{field:'customerCode',title:'配件名称',width:80},
				{field:'nums',title:'配件品牌',width:80},
				{field:'numSprice',title:'配件型号',width:100},
				{field:'contacter',title:'数量',width:30},
				{field:'telPhone',title:'单价',width:80},
				{field:'state',title:'金额',width:80},
				{field:'addUserName',title:'备注',width:80},
				{field:'state',title:'上次价格',width:80},
				{field:'addUserName',title:'操作',width:50,formatter:function(val,idx,row){
					var content = "<input type='button' value='删除' onClick=\"("+row.sqcode+")\" />";
					return content;
				}}
			]],
			fit:true,
		});
		$("input[name='orderDate']").datebox({
			 required:true,
			 missingMessage:"订单日期不能为空",
			 formatter:function(date){
			 	var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				return y+'-'+m+'-'+d;
			 }
		});
		$("input[name='deliveryDate']").datebox({
			 required:true,
			 missingMessage:"交货日期不能为空",
			 formatter:function(date){
			 	var y = date.getFullYear();
				var m = date.getMonth()+1;
				var d = date.getDate();
				return y+'-'+m+'-'+d;
			 }
		});
		
		
		
		
		
		
		datagrid=$("#p_datagrid").datagrid({    
   		 	//  url: 'UserCenter.aspx', //请求的数据源
                pagination: true, //显示分页
                pageList: [5, 10, 20, 300], //页大小下拉选项此项各value是pageSize的倍数
                fit: true, //datagrid自适应宽度
                striped: true, //行背景交换
                border: false,
                toolbar:"#p_datagrid_toolbar",
                idField: 'partsCode', //主键
                columns: [[//显示的列
                	{field: 'ID', title: '编号', width: 140, sortable: true, checkbox: true },
                 	{ field: 'partsCode', title: '配件编号', width: 80},
                  	{ field: 'partsNo', title: '配件件号', width: 80},
                   	{ field: 'partsCategory', title: '配件类别', width: 80},
                   	{ field: 'partsName', title: '配件名称', width: 80},
                   	{ field: 'partsBrand', title: '配件品牌', width: 80},
                   	{ field: 'partsModel', title: '配件型号', width: 80},
                   	{ field: 'partsModelOld', title: '配件旧型号', width: 80},
                   	{ field: 'salePrice', title: '配件销售价格', width: 80},
                   	{ field: 'idShow', title: '显示状态', width: 80},
                   	{ field: 'addUserName', title: '操作员', width: 80},
                   	{ field: 'remarks', title: '备注', width: 180}
                   	]],
		}); 
		
		
		
		
		
		
		
		
		
	});
	function newOrder(){
		$("#orderForm").form("reset");
		//$("#p_datagrid").datagrid("loadDate",null);
		$("input[name='code']").val(getCode());
	}
	function save(){
		var datestring = $("input[name='orderDate']").val();
		var re=/^(\d{4}-\d{1,2}-\d{1,2})(\s?\d{2}:\d{2}:\d{2})?$/
		if(!re.test(datestring)){
			alert("订单日期格式不正确");
		}else{
			/* var rows = $("#sale_order_detail").datagrid("getRows");
			var data = "{[";
			for(var i=0;i<rows.length;i++){
				if(i<rows.length-1){
					data +="{''}"
				}
				
			} */
			$.ajax({
				url:"sale/AddSaleOderServlet",
				type:"post",
				dataType:"json",
				data:$("#orderForm").serialize(),
				success:function(data){
					$.messager.alert("信息提示",data.message);
				},
				error:function(data){
					$.messager.alert("信息提示","添加请求失败！");
				}
			});
			//parent.closeTabs("销售订单");
		}
		
		
		
		
	}
	function opendialog(){
		$("#p_dialog").dialog('open').dialog('refresh');
		$("#p_datagrid").datagrid("reload");
	}
	
	</script>

  </head>
  
  <body>
    <div id="order">
	    <form id="orderForm">
	    <table>
	    <tr>
	    	<td class="text"><span>*</span>订单编号：</td>
	    	<td class="input"><input type="text" name="code" /></td>
	    	<td class="text"><span>*</span>订单日期：</td>
	    	<td class="input"><input type="text" name="orderDate" /></td>
	    </tr>
	    <tr>
	    	<td class="text"><span>*</span>客户名称：</td>
	    	<td class="input"><input type="text" name="customerCode" /></td>
	    	<td class="text"><span>*</span>联系人员：</td>
	    	<td class="input"><input type="text" name="contacter" /></td>
	    </tr>
	    <tr>
	    	<td class="text">电&nbsp;&nbsp;&nbsp;&nbsp;话：</td>
	    	<td class="input"><input type="text" name="telPhone" /></td>
	    	<td class="text">传&nbsp;&nbsp;&nbsp;&nbsp;真：</td>
	    	<td class="input"><input type="text" name="fax" /></td>
	    </tr>
	    <tr>
	    	<td class="text">运输方式：</td>
	    	<td class="input"><input type="text" name="trans" /></td>
	    	<td class="text">业务人员：</td>
	    	<td class="input"><input type="text" name="businesser" /></td>
	    </tr>
	    <tr>
	    	<td class="text">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
	    	<td class="input"><input type="text" name="remarks" /></td>
	    	<td class="text"><span>*</span>交货日期：</td>
	    	<td class="input"><input type="text" name="deliveryDate" /></td>
	    </tr>
	    </table>
	    <input type="hidden" name="addUserName" value="管理员" />
	    <br />
	    <input type="button" onClick="newOrder()" value="新 增" />
	    <input type="button" onClick="" value="选报价单" />
	    <input type="button" onClick="opendialog()" value="添加配件" />
	    <input type="button" onClick="save();" value="保 存" />
	    <input type="button" onClick="" value="审 核" />
	    <input type="button" onClick="" value="撤 销" />
	    <input type="button" onClick="" value="打 印" />
	    <input type="button" onClick="" value="生成合同" />
	    <input type="button" onClick="" value="生成word" />
	    <input type="button" onClick="" value="生成出库" />
	    <input type="button" onClick="save();" value="完成订单" />
	    <input type="button" onClick="" value="关 闭" />
	    </form>
    </div>
    
    <br />
    
    <div id="box">
    	<div id="sale_order_detail"></div>
    </div>
    <div id="p_dialog"><div id="p_datagrid" ></div></div>
    <div id="p_datagrid_toolbar" >
  		检索条件：
  		件号：<input type="text" name="m_number"/>
		名称：<input type="text" name="m_name"/>
		类别：<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
    			<option value="0">-选择类别-</option>
   				<option value="1">轴承</option>   
    			<option value="2">皮带</option>   
			</select>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn1">搜索</a>
       	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn2"	>重置</a>
	</div>
  </body>
</html>
