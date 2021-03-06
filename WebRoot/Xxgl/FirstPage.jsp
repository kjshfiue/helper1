<%@page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基础管理</title>
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easyui.min.js" type="text/javascript"></script>
<link href="themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="themes/icon.css"  rel="stylesheet"  type="text/css"/>
<link href="css/head.css"  rel="stylesheet"  type="text/css"/>
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


<iframe src="common/head.html" frameborder="0" scrolling="no" width="100%" height="100%"></iframe>

<div data-options="region:'west',title:'导航',split:true" style="width:150px;" >
	<div id="nav"  class="easyui-accordion"   data-options="fit:true,selected:0">
    	<div title="基础管理" data-options="iconCls:'icon-cus-database_gear'">
        	<ul >
        	 <li><a href="">往来单位管理</a></li>
             <li><a href="">管理界面</a>
             <li><a href="">配件类别管理</a></li>
             <li><a href="">公司信息管理</a></li>
             <li><a href="javascript:addTabs('配件信息管理','PeiJianMessage.jsp')">配件信息管理</a></li>
               <li><a href="javascript:addTabs('单据界面','DanJu.jsp')">单据界面</a></li>
            </ul>
        </div> 
</div>	
</div>
<div data-options="region:'center',split:true,iconCls:'icon-reload'">
	<div  id="tt" class="easyui-tabs"  data-options="fit:true">
         <div title="主页" style="padding:10px">
         <iframe scrolling="auto" frameborder="0"  src="PeiJianMessage.jsp" style="width:100%;height:100%;"></iframe>
         </div>   
    </div>
</div>
</body>
</html>
