<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>往来客户详细信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="../themes/default/easyui.css" rel="stylesheet"  type="text/css"/>
      <link href="../themes/icon.css" rel="stylesheet"  type="text/css"/>  
	<script type="text/javascript" src="../lib/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="../lib/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$(function(){
	
	$("content").propertygrid({    
	
	 width: 298,
        height: "auto",
        showGroup: true,
        scrollbarSize: 0,
        columns: [[
                { field: "name", title: "Name", width: 100, resizable: true },
                { field: 'value', title: 'Value', width: 100, resizable: false }]]
}); 


	});
	</script>

  </head>
  
  <body>
  <table id="content" style="width:300px">

  </table>
  
  </body>
</html>
