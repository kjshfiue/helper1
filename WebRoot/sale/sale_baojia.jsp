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
		width:100%;
		min-width:900px;
		margin:0px;
	}
	#box{
		height:100%;
		min-height:380px;
		width:100%;
		min-width:900px;
		margin:0px;
	}
	#order span{
		color:red;
	}
	#myTable input{
		width:150px;
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
		
		$("#box").panel({    
			 // fit:true,
			  height:440,
			  title: "请选择报价单",        
		});   
		
		$("#sale_baojia").datagrid({    
   		 	//  url: 'UserCenter.aspx', //请求的数据源
                pagination: true, //显示分页
                pageList: [5, 10, 20], //页大小下拉选项此项各value是pageSize的倍数
                fit: true, //datagrid自适应宽度
                striped: true, //行背景交换
                border: false,
                toolbar:"#p_datagrid_toolbar",
                idField: 'partsCode', //主键
                columns: [[//显示的列
                	{field: 'ID', title: '编号', width: 140, sortable: true, checkbox: true },
                 	{ field: 'partsCode', title: '报价单号', width: 80},
                  	{ field: 'partsNo', title: '报价日期', width: 80},
                   	{ field: 'partsCategory', title: '客户名称', width: 80},
                   	{ field: 'partsName', title: '数量', width: 80},
                   	{ field: 'partsBrand', title: '总价值', width: 80},
                   	{ field: 'partsModel', title: '未选数量', width: 80},
                   	{ field: 'partsModelOld', title: '未选金额', width: 80},
                   	{ field: 'salePrice', title: '审核状态', width: 80}
                ]],
		}); 

	});

	function save(){
		var datestring = $("input[name='orderDate']").val();
		var re=/^(\d{4}-\d{1,2}-\d{1,2})(\s?\d{2}:\d{2}:\d{2})?$/
		if(!re.test(datestring)){
			alert("订单日期格式不正确");
		}else{
			$.ajax({
				url:"sale/AddSaleOderServlet",
				type:"post",
				dataType:"json",
				data:$("#orderForm").serialize(),
				success:function(data){
					$.messager.alert("信息提示",data.message,"info");
				},
				error:function(data){
					$.messager.alert("信息提示","添加请求失败！","error");
				}
			});
		}
	}

	
	</script>

  </head>
  
  <body>
    <div id="order">
	    <form id="orderForm">
	    <table id="myTable" >
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
	    	<td class="text">备&nbsp;&nbsp;&nbsp;&nbsp;注：</td>
	    	<td class="input" colspan="3"><input type="text" name="remarks" /></td>
	    </tr>
	    </table>
	    <input type="hidden" name="addUserName" value="管理员" />
	    <br />
	    <input type="button" onClick="" value="选报价单" disabled="disabled" />
	    <input type="button" onClick="history.go(-1);" value="添加配件" />
	    <input type="button" onClick="save();" value="保 存" />
	    <input type="button" onClick="" value="审 核" />
	    <input type="button" onClick="" value="撤 销" />
	    <input type="button" onClick="" value="打 印" />
	    <input type="button" onClick="" value="生成合同" />
	    <input type="button" onClick="history.go(-1);" value="返回" />
	    </form>
    </div>
    
    <br />
    
    <div id="box">
    	<div id="sale_baojia"></div>
    </div>
    </div>

    <div id="p_datagrid_toolbar" >
  		<span>检索条件：</span>
	    <span>报价单号：</span><input type="text" name="code" />
	    <span>开始日期：</span><input type="text" class="easyui-datebox"  name="startDate" />
	    <span>结束日期：</span><input type="text" class="easyui-datebox"  name="endDate" />
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn1">搜索</a>
       	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn2"	>重置</a>
	</div>
  </body>
</html>
