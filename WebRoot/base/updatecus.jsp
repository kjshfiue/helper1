
<%@page import="com.helper.dao.impl.CusLinkDaoImpl"%>
<%@page import="com.helper.entity.CustomerLink"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>修改界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <% 
  String code = request.getParameter("code");
  System.out.println(code);
  CustomerLink c = (new CusLinkDaoImpl()).selectByCode(code);
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
  SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
  Date date = new Date();
  sdf.format(date);
  
   %>
   <form action="/helper/base/AddCusServlet" method="post">
   <input name="state" value="update" type="hidden">
   <table>
   <tr>
   <td>编号:</td><td><input name="code" readonly="readonly" type="text" value=<%= code%>></td>
   <td>时间:</td><td><input name="date" readonly="readonly" type="text" value="<%=sdf2.format(date) %>"/></td>
   </tr>
   <tr>
   <td>名称:</td><td><input value="<%=c.getCsName()%>" name="name"/></td> 
   <td>类型:</td>
   <td><select name="type"><option value="1">顾客</option><option value="2">供应商</option>
   </select>
   </td>
   </tr>
   <tr>
   <td>联系人: </td><td><input value=<%=c.getContActor() %> name="conActor"/></td>
   <td>联系电话:</td><td><input value=<%=c.getTelPhone()  %> name="telPhone"/></td>
   </tr>
   <tr>
   <td>地址:</td><td><input value="<%=c.getAddress() %>" name="address"/></td>
   <td>备注:</td><td><input value="<%=c.getRemarks() %>" name="remarks"></td>
   </tr>
   <tr><td><input type="submit" value="保存"></td></tr>
   </table>
   </form>
  </body>
</html>
