<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>添加界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="../themes/default/easyui.css" rel="stylesheet"  type="text/css"/>
      <link href="../themes/icon.css" rel="stylesheet"  type="text/css"/>  
	<script type="text/javascript" src="../lib/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="../lib/jquery.easyui.min.js"></script>
<style>
 td{
 	border-left:1px solid #C7D3E4;
	border-top:1px solid #C7D3E4;
 }
 
#news_tb td{
	width:80px;
	padding-left:30px;
}
#mytd1{
	width:245px;
}
 
</style>
<script>
function addnew(){
alert("ddddd");
parent.addTabs("添加界面2","/helper/base/addcus.jsp");
}

$(function(){
	var text = //;
	$("input[name='name']").blur(function(){//失去焦点
		if($("input[name='name']").val()==""){
		alert("不能为空");}
		if(text.exec($("input[name='name']").val())){
		alert("测试");
		
		}
	});

$("#tt").datagrid({
		title:'公司信息管理',
		fit:true,
		toolbar:"#news_tb",
}); 
});
</script>
  </head>  
  <body>
  <%
  if(request.getParameter("ret")!=null){%>
  <script>
 	$.messager.alert('温馨提示','添加成功');    
  </script>
 <% }
  
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
  SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  Date date = new Date();
   %>
   <div id="tt">
   <div id="news_tb">
   <form action="/helper/base/AddCusServlet" method="post">
   <input name = "state" value="add" type="hidden"/>
   <table  align="center">
   <tr>
   	<td>编&nbsp,号:<input name="code" readonly="readonly" type="text" value="<%="GCS"+sdf.format(date)%>"/></td>
   	<td>时间:<input name="date" readonly="readonly" type="text" value="<%=sdf2.format(date) %>"/></td>
   </tr>
   <tr>
   	<td>名&nbsp,称:<input name="name"/></td> 
   	<td>类型:
		<select name="type">
		  	 <option value="1">顾客</option>
		  	 <option value="2">供应商</option>
	  	 </select>
  	 </td>
   </tr>
   <tr>
	  <td>联系人:<input name = "conActor"/></td>
	  <td>电话:<input name="telPhone"/></td>
   </tr>
   <tr>
   	<td>地&nbsp址:<input name="address"/></td>
   	<td>备注:<input name = "remarks"></td>
   </tr>
   <tr>
       <td>
       <input type="button" value="新增" onClick="addnew()">
   	 <input type="submit" value="保存" />
   	 </td>
   	 <td>
       <input type="button" value ="打印">
       <input type="button" value="关闭"/>
       </td>
   </tr>
   </table>
   </form>
   </div>
   </div>
  </body>
</html>
