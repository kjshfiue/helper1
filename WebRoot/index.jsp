<%@page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基础管理</title>
<script src="lib/jquery-1.7.2.js" type="text/javascript"></script>
<script src="lib/jquery.easyui.min.js" type="text/javascript"></script>
<link href="themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="themes/icon.css"  rel="stylesheet"  type="text/css"/>

<style>
ul,li{margin:0px; padding:0px}
#nav li{
	list-style:none;
	height:30px;
	margin:0px 2px;
	font-size:12px;
	line-height:30px; 
	border-bottom:#eee 1px solid;
	
}
li a{
	padding:0px 14px;
	text-decoration:none;
	color:#333;
	
}
li a:hover{
	display:block;
	height:100%;
	background-color:#FFC;
	}
	
</style>
<script>
function addTabs(title,url){
 if($('#tt').tabs('exists',title)){
		$('#tt').tabs('select',title);
}else{
	var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';   
	$('#tt').tabs('add',{
		title:title,
		closable:true,
		content:content
		})
	}
}
</script>
</head>

<body  class="easyui-layout" >

<div data-options="region:'north'" style="width:1300px;height:50px" >
	<iframe src="head.html" frameborder="0" scrolling="no" width="100%" height="100%"></iframe>
</div>
<div data-options="region:'west',title:'导航',split:true" style="width:150px;" >
	<div id="nav"  class="easyui-accordion"   data-options="fit:true,selected:0">
    	<div title="销售管理" data-options="iconCls:'icon-search'">
           <ul>
        	 <li><a href="javascript:addTabs('销售报价管理','sale/')">销售报价管理</a></li>
        	 <li><a href="javascript:addTabs('销售订单管理','sale/sale_order.jsp')">销售订单管理</a></li>
             <li><a href="javascript:addTabs('销售退货管理','')">销售退货管理</a></li>
             <li><a href="javascript:addTabs('销售合同管理','')">销售合同管理</a></li>
           </ul>
        </div> 
    	<div title="基础管理" data-options="iconCls:'icon-search'">
           <ul>
        	 <li><a href="javascript:addTabs('往来单位管理','base/coslinkmanger.html')">往来单位管理</a></li>
        	 <li><a href="javascript:addTabs('字典内容管理','base/base_content.jsp')">字典内容管理</a></li>
             <li><a href="javascript:addTabs('配件类别管理','base/base_content.jsp')">配件类别管理</a></li>
             <li><a href="javascript:addTabs('配件信息管理','Xxgl/PeiJianMessage.jsp')">配件信息管理</a></li>
             <li><a href="javascript:addTabs('公司信息管理','BaseCompany.jsp')">公司信息管理</a></li>
           </ul>
        </div> 
	</div>
</div>
<div data-options="region:'center',split:true,iconCls:'icon-reload'">
	<div  id="tt" class="easyui-tabs"  data-options="fit:true">
         <div title="主页" style="padding:10px">
         <iframe scrolling="auto" frameborder="0"  src="welcome.jsp" style="width:100%;height:100%;"></iframe>
         </div>   
    </div>
</div>
</body>
</html>
