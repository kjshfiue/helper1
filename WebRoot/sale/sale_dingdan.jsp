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
	$(function(){
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
	});
	function save(){
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
	    <br />
	    <input type="button" onClick="" value="新 增" />
	    <input type="button" onClick="" value="选报价单" />
	    <input type="button" onClick="" value="添加配件" />
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
    
  </body>
</html>
