<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>字典内容管理</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="lib/jquery-1.7.2.js"></script>
	<style>
	table{
		border-color:#EAF2FE;
		width:980px;
	}
	
	span.txt{
		font-size:12px;
	}
	span.red{
		color:red;
	}
	</style>
	<script type="text/javascript">
	function add(){
	
	}
	function save(){
		$("#myform").submit();
	}
	function print(){
		alert("打印");
	}
	function close(){
		alert("关闭");
	}
	</script>
  </head>
  
  <body>
    <div>
    <form id="myform" action="base/AddBaseContentServlet" method="post">
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
	<a href="javascript:save();"><input type="button" value="保存"/></a>
	<a href="javascript:print();"><input type="button" value="打印"/></a>
	<a href="javascript:close();"><input type="button" value="关闭"/></a>
    </form>
    </div>
  </body>
</html>
