<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司信息管理</title>
<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="lib/jquery.easyui.min.js" type="text/javascript"></script>
<link href="themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="themes/icon.css"  rel="stylesheet"  type="text/css"/>
<style>
	
</style>
<script>

</script>
</head>
  <body  class="easyui-layout">
   <div data-options="region:'center',split:true,iconCls:'icon-reload'">
	<div  id="tt" class="easyui-tabs"  data-options="fit:true">
        <div title="公司信息管理" style="padding:10px">
         	<iframe scrolling="auto" frameborder="0"  src="BaseCompany.jsp" style="width:100%;height:100%;"></iframe>
        </div>   
   </div>
  </div>
 </body>
</html>


