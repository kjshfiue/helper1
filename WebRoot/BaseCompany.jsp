<%@page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>公司信息管理</title>
 <script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
 <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
 <link  type="text/css" href="themes/default/easyui.css" rel="stylesheet"/>
 <link  type="text/css" href="themes/icon.css" rel="stylesheet" />
 <style>
 
 
 
 td{
 	border-left:1px solid #C7D3E4;
	border-top:1px solid #C7D3E4;
 }
 
#mytd{
	width:80px;
	padding-left:30px;
}
#mytd1{
	width:245px;
}
 
</style>
<script type="text/javascript">
$(function(){
//匿名函数//
	 $("#tt").datagrid({
			title:'公司信息管理',
			fit:true,
			toolbar:"#news_tb",
	}); 
	$.ajax({
		url:'company/SearchCompanyJsonServlet',
		dataType:'json',
		success:function(data){
				if(data==null||data.cid==""){
					var date = new Date();
					cid = "GS"+date.getTime();
					$("#1").val(cid);
					$("#hide").val();
				}else{
					$("#hide").val(data.cid);
					$("#1").val(data.cid);
					$("#2").val(data.cName);
					$("#3").val(data.cAddress);
					$("#4").val(data.cPostCode);
					$("#5").val(data.cPhone);
					$("#6").val(data.cFax);
					$("#7").val(data.cUrl);
					$("#8").val(data.cEmail);
					$("#9").val(data.cLegaler);
					$("#10").val(data.cAgent);
					$("#11").val(data.cAccount);
					$("#12").val(data.cBank);
					$("#13").val(data.cTax);
					$("#14").val(data.cMark);
				}
				
			}
	
	});

});
function save(){
	var hide=$("#hide").val();    
	var code=$("#1").val();      
	var compName=$("#2").val();
	var compAddress=$("#3").val();
	var compPostCode=$("#4").val();
	var compPhone=$("#5").val();
	var compFax=$("#6").val();
	var compUrl=$("#7").val();
	var compEmail=$("#8").val();
	var compLegaler=$("#9").val();
	var compAgent=$("#10").val();
	var compAccount=$("#11").val();
	var compBank=$("#12").val();
	var compTax=$("#13").val();
	var remarks=$("#14").val();
	var data1={'hide':hide,'code':code,'compName':compName,'compAddress':compAddress,
	'compPostCode':compPostCode,'compPhone':compPhone,'compFax':compFax,
	'compUrl':compUrl,'compEmail':compEmail,'compLegaler':compLegaler,
	'compAgent':compAgent,'compAccount':compAccount,'compBank':compBank,
	'compTax':compTax,'remarks':remarks};
	$.ajax({
		url:'company/ModifyBaseCompanyServlet',
		dataType:'json',
		type:'post',
		data:data1,
		success:function(data){
			$.messager.alert('提示信息',data.flag);    
		},
		error:function(){
			alert("cuowu");
		}
	
	});
	
}
function close(){
	
	$("#tt").window.close();
	//response.Readirect("./FirstPage.jsp");

}

</script>
</head>
 <body>
  <div id="tt"> 
  </div>
  <div id="news_tb">      
    <form method="post">
    <input id="hide" type="hidden" />
	 <table id="mytable" style="border:1px solid #C4D2E3;">
	  <tr>
	  	<td id="mytd">*公司代码：</td><td id="mytd1"><input id="1" type="text"></td>
	  	<td id="mytd">*公司名称：</td><td id="mytd1"><input id="2" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">公司地址：</td><td id="mytd1"><input id="3" type="text"></td>
	  	<td id="mytd">公司邮编：</td><td id="mytd1"><input id="4" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">公司电话：</td><td id="mytd1"><input id="5" type="text"></td>
	  	<td id="mytd">公司传真：</td><td id="mytd1"><input id="6" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">公司网址：</td><td id="mytd1"><input id="7" type="text"></td>
	  	<td id="mytd">公司邮箱：</td><td id="mytd1"><input id="8" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">法&nbsp;&nbsp;人：</td><td id="mytd1"><input id="9" type="text"></td>
	  	<td id="mytd">委托代理：</td><td id="mytd1"><input id="10" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">账&nbsp;&nbsp;号：</td><td id="mytd1"><input id="11" type="text"></td>
	  	<td id="mytd">银&nbsp;&nbsp;行：</td><td id="mytd1"><input id="12" type="text"></td>
	  </tr>
	  <tr>
	  	<td id="mytd">税&nbsp;&nbsp;号：</td><td id="mytd1"><input id="13" type="text"></td>
	  	<td id="mytd">备&nbsp;&nbsp;注：</td><td id="mytd1"><input id="14" type="text"></td>
	  </tr>
	 </table>
	</form>
	<input type="button" value="保存" onclick=save(); />
	
	<input type="button" value="关闭" onclick=close(); />
   </div>    
 </body>
</html>
