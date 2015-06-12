<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'CaiGou.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easyui.min.js" type="text/javascript"></script>
<link href="themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
<link href="themes/icon.css"  rel="stylesheet"  type="text/css"/>
<style type="text/css">
	ul{
	padding-left:0px;
	}
	#box{
	height:400px;
	}
	ul li{
	list-style:none;
	
	margin-left:0px;
	}
</style>
<script type="text/javascript">
$(function(){


$('#DanJuTJ').window('close');
$('#win').window('close'); 
$('#win1').window(

'close'); 

    
//按钮1效果
$("#bt1").bind('click',function(){

})
//按钮2效果
$("#bt2").bind('click',function(){
$('#win').window('open'); 
var date=new Date();

	var str='MTCG'+date.getTime();
	var code=$("input[name='bh']").val(str);
	//$("input[name='bh']").val(str);
})
//按钮3效果
$("#bt3").bind('click',function(){
var rows=$("#box").datagrid('getSelections');

 var strs=[];
for ( var i = 0;i < rows.length;i++){
	//alert(rows[i].code);
	strs.push(rows[i].code);
}
	var str=strs.join(',');
	//alert(str);
	$.ajax({
	url:'/helper/DeleteAllOrderMessages.do',
	data:{"idx":str},
	success:function(data){
	if(data==1){
	alert("删除成功");
	$("#box").datagrid('reload',{});
	}else{
	alert("删除失败");
	}
	}
	})
})
//按钮4效果
$("#bt4").bind('click',function(){
alert(4);
})

$("#box").datagrid(

{

		url:'/helper/ForFindOrders.do',
		 iconCls: 'icon-save', //图标
                pagination: true, //显示分页
                pageNumber:1,
                pageSize:8, //页大小
                pageList: [3, 5, 8], //页大小下拉选项此项各value是pageSize的倍数
               // fit: true, //datagrid自适应宽度
                pagination: true,
                pagePosition:'bottom',
                fitColumn: true, //列自适应宽度
                striped: true, //行背景交换
                nowap: true, //列内容多时自动折至第二行
                border: false,
                idField: 'code', //主键
		columns:[[
		{field:'Id',title:'编号',width:50,checkbox:true},    
        {field:'code',title:'订单编号',width:100},    
        {field:'orderDate',title:'订单日期',width:200},    
        {field:'suppliercode',title:'供应商名',width:100},
        {field:'nums',title:'数量',width:100},    
        {field:'numsprice',title:'金额',width:100},    
        {field:'contacter',title:'联系人',width:100},
        {field:'telphone',title:'联系方式',width:100},    
        {field:'state',title:'审核状态',width:100},    
        {field:'addUserName',title:'操作员',width:100},
        {field:'opt',title:'操作',width:130,formatter:function(val,row,idx){	
			var content="<input type='button' value='修改' onclick=\"updates('"+row.code+"')\"/>";
			content+="<input type='button' value='删除' onclick=\"del('"+row.code+"')\"/>";
			return content;}
		}
    ]],
    toolbar:'#tb',
    //单击事件
    onClickRow:function(rowIndex, rowData){
    //alert(rowData.suppliercode);
    $("#danhao").html(rowData.code);
    //详细显示的datagrid
 $('#details').datagrid(

 {    
   	 url:'/helper/ForFindXJMessage.do',
   	 
     pagination: true, //显示分页
                pageNumber:1,
                pageSize:8, //页大小
                pageList: [3, 5, 8], //页大小下拉选项此项各value是pageSize的倍数
               // fit: true, //datagrid自适应宽度
                pagination: true,
    columns:[[    
        {field:'xunCode',title:'询价编号',width:100},    
        {field:'pjCode',title:'配件件号',width:100},    
        {field:'pjName',title:'配件名称',width:100},
         {field:'pjBrand',title:'配件品牌',width:100},    
        {field:'pjXinghao',title:'配件型号',width:100},    
        {field:'number',title:'数量',width:100},
        {field:'dPrice',title:'单价',width:100},    
        {field:'num',title:'金额',width:100},    
        {field:'marks',title:'备注',width:100},
         {field:'lastPrice',title:'上次价格',width:100}      
    ]]    
});
 	//alert(rowData.suppliercode);
$('#details').datagrid('load',{'codes':rowData.code});
    }
    
       
		
});

$('#GongYin').datagrid({
				url:'/helper/base/GetBaseCashInqueryServlet',
				iconCls: 'icon-save', //图标
                pagination: true, //显示分页
                pageNumber:1,
                pageSize:8, //页大小
                pageList: [3, 5, 8], //页大小下拉选项此项各value是pageSize的倍数
               // fit: true, //datagrid自适应宽度
                pagination: true,
                pagePosition:'bottom',
                fitColumn: true, //列自适应宽度
                striped: true, //行背景交换
                nowap: true, //列内容多时自动折至第二行
                border: false,
                idField: 'code', //主键
                toolbar:'#GongYintools',
columns:[[
		{field:'Id',title:'编号',width:50,checkbox:true},
		{field:'code',title:'询价编号',width:50,},    
        {field:'addDate',title:'询价日期',width:100},  
         {field:'supplierCode',title:'供应商名',width:100},  
       
       
        {field:'nums',title:'数量',width:100},    
        {field:'numSprice',title:'金额',width:100},    
        {field:'zw',title:'未选数量',width:100},
        {field:'zz',title:'未选金额',width:100}, 
        {field:'state',title:'审核状态',width:100},
         {field:'opt',title:'操作',width:130,formatter:function(val,row,idx){	
			var content="<input type='button' value='确定' onclick=\"TiJiaoXun('"+row.code+"')\"/>";
			
			return content;}
		}   
     
       
    ]]
}


);

  
})
function search(){
	var codes=$("input[name='xjbh']").val();
	var startTime=$("input[name='rq']").val();
	var endTime=$("input[name='jsrq']").val();
	var gName=$("input[name='gys']").val();
	//alert(codes+startTime+endTime+gName);
	$("#box").datagrid('reload',{'codes':codes,'sTime':startTime,'eTime':endTime,'name':gName});
}
function resetval(){
	$("input[name='xjbh']").val('');
	$("input[name='rq']").val('');
	$("input[name='jsrq']").val('');
	$("input[name='gys']").val('');
}
//添加
function submits(){
	
	var code=$("input[name='bh']").val();
	var ddrq=$("input[name='ddrq']").val();
	var gys=$("input[name='gys']").val();

	var lxr=$("input[name='lxr']").val();
	var dh=$("input[name='dh']").val();
	var cz=$("input[name='cz']").val();
	var ysfs=$("input[name='ysfs']").val();
	
	var jhrq=$("input[name='jhrq']").val();
	var ywry=$("input[name='ywry']").val();
	var bz=$("input[name='bz']").val();
	var xsfs=$("input[name='xsfs']").val();
	var pjsl=$("input[name='pjsl']").val();
	var cgzj=$("input[name='cgzj']").val();
	var sh=$("input[name='sh']").val();
	var czrq=$("input[name='czrq']").val();
	
	var czyh=$("input[name='czyh']").val();
	var czyhm=$("input[name='czyhm']").val();
	var czip=$("input[name='czip']").val();
	
	var dataMM={"code":code,"ddrq":ddrq,"gys":gys,"lxr":lxr,"dh":dh,"cz":cz,"ysfs":ysfs,"jhrq":jhrq,"ywry":ywry,"bz":bz,"xsfs":xsfs,"pjsl":pjsl,"cgzj":cgzj,"sh":sh,"czrq":czrq,"czyh":czyh,"czyhm":czyhm,"czip":czip};
	$.ajax({
	url:'/helper/ForAddorder.do',
	data:dataMM,
	success:function(data){
		if(data==1){
		alert("添加成功");
		$('#win').window('close'); 
		$("#box").datagrid('reload',{});
		}else{
		alert("添加失败");
		}
	}
	})
}
//打开修改界面
function updates(code){
alert(code);
$("input[name='bh']").val(code);
$('#win').window('open'); 


}

//修改并提交
function updateval(){

var code=$("input[name='bh']").val();
	var ddrq=$("input[name='ddrq']").val();
	var gys=$("input[name='gys']").val();

	var lxr=$("input[name='lxr']").val();
	var dh=$("input[name='dh']").val();
	var cz=$("input[name='cz']").val();
	var ysfs=$("input[name='ysfs']").val();
	
	var jhrq=$("input[name='jhrq']").val();
	var ywry=$("input[name='ywry']").val();
	var bz=$("input[name='bz']").val();
	var xsfs=$("input[name='xsfs']").val();

	var pjsl=$("input[name='pjsl']").val();
	var cgzj=$("input[name='cgzj']").val();
	var sh=$("input[name='sh']").val();
	var czrq=$("input[name='czrq']").val();
	
	var czyh=$("input[name='czyh']").val();
	var czyhm=$("input[name='czyhm']").val();
	var czip=$("input[name='czip']").val();
	var dataMM={"code":code,"ddrq":ddrq,"gys":gys,"lxr":lxr,"dh":dh,"cz":cz,"ysfs":ysfs,"jhrq":jhrq,"ywry":ywry,"bz":bz,"xsfs":xsfs,"pjsl":pjsl,"cgzj":cgzj,"sh":sh,"czrq":czrq,"czyh":czyh,"czyhm":czyhm,"czip":czip};
	$.ajax({
	url:'/helper/ForUpDateXjMessage.do',
	data:dataMM,
	success:function(data){
		if(data==1){
		alert("修改成功");
		$('#win').window('close'); 
		$("#box").datagrid('reload',{});
		}else{
		alert("修改失败");
		}
	}
	})

}
//取消
function closeAlls(){
$('#win').window('close'); 
}
//删除
function del(code){
$.ajax({
url:'/helper/deleteXJmessage.do',
data:{'codes':code},
success:function(data){
if(data==1){
alert("删除成功");
$('#win').window('close'); 
$("#box").datagrid('reload',{});
}else{
alert("删除失败");
}
}

})
}
//选择询价单
function selectXun(){
$('#win1').window('open'); 
$('#win1').window({
width:900,
}); 
}
//提交询价单
function TiJiaoXun(Xcode){
$.ajax({
url:'',
data:{"codes":Xcode},
success:function(data){

}
})

}
//取消添加询价单
function QuXiaoTiJiaoXun(){
alert(1);
}
</script>
  </head>
  
  <body>


	<div id="box">
		<div id="tb">
		<ul>
		<li>
			检索条件：订单编号<input type="text" name="xjbh" />
			开始日期<input type="text" name="rq" />
			结束日期<input type="text" name="jsrq" />
			供应商名<input type="text" name="gysmm" />
			<input type="button"  value="搜索" onclick="search()" />
			<input type="button"  value="重置" onclick="resetval()" />
		</li>
		<li>
			<a href="#" class="easyui-linkbutton" id="bt1" data-options="iconCls:'icon-edit',plain:true">查询</a>
			<a href="#" class="easyui-linkbutton" id="bt2" data-options="iconCls:'icon-help',plain:true">添加</a>
			<a href="#" class="easyui-linkbutton" id="bt3" data-options="iconCls:'icon-edit',plain:true">批量删除</a>
			<a href="#" class="easyui-linkbutton" id="bt4" data-options="iconCls:'icon-help',plain:true">导出Excel</a>
		</li>
		</ul>
	</div>
	</div> 
	<p>
	<lable>单号为：<lable id="danhao"></lable>的明细如下列表</lable>
	</p>
	<div id="details">
	</div>
	
	
<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true">   
    <table>
    	<tr>
    		<td>订单编号</td><td><input type="text" name="bh" /></td>
    			<td>订单日期</td><td><input type="text" class="easyui-datebox" name="ddrq" required="required"></input>  </td>
    	</tr>
    	<tr>
    		<td>供应商</td><td><input type="text" name="gys" /></td>
    			<td>联系人</td><td><input type="text" name="lxr" /></td>
    	</tr>
    	<tr>
    		<td>电话</td><td><input type="text" name="dh" /></td>
    			<td>传真</td><td><input type="text" name="cz" /></td>
    	</tr>
    	<tr>
    		<td>运输方式</td><td><input type="text" name="ysfs" /></td>
    			<td>交货日期</td><td><input name="jhrq" type="text" class="easyui-datebox" name="ddrq" required="required"></input></td>
    	</tr>
    	<tr>
    		<td>业务人员</td><td><input type="text" name="ywry" /></td>
    			<td>备注</td><td><input type="text" name="bz" /></td>
    	</tr>
    	<tr>
    		<td>显示方式</td><td>
    			<select id="cc" class="easyui-combobox" name="xsfs" style="width:100px;">   
    				<option value="0">显示</option>   
    				<option value="1">不显示</option>    
				</select> 
				</td>
    			<td>配件数量</td><td><input type="text" name="pjsl" /></td>
    	</tr>
    	<tr>
    		<td>采购总价</td><td><input type="text" name="cgzj" /></td>
    			<td>审核状态</td>
    			<td>
    			
    			<select id="cc" class="easyui-combobox" name="sh" style="width:100px;">   
    				<option value="0">未通过</option>   
    				<option value="1">通过</option>    
				</select> 
    			</td>
    	</tr>
    	<tr>
    		<td>操作日期</td><td><input name="czrq" type="text" class="easyui-datebox" name="ddrq" required="required"></input></td>
    			<td>操作用户</td><td><input type="text" name="czyh" /></td>
    	</tr>
    	<tr>
    		<td>操作用户名</td><td><input type="text" name="czyhm" /></td>
    			<td>操作Ip</td><td><input type="text" name="czip" /></td>
    	</tr>
    	<tr>
    		<td><input type="button" value="新增" onclick="submits()" /></td>   			
    		<td><input type="button" value="修改" onclick="updateval()" /></td>
    		<td><input type="button" value="取消" onclick="closeAlls()" /></td>
    		<td><input type="button" value="选择询价单" onclick="selectXun()" /></td>
    		<td><input type="button" value="添加配件" onclick="AddPei()" /></td>
    	</tr>
    </table>   
</div>
<div id="win1" class="easyui-window" title="My Window" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true">
  
       <div id="GongYin">
      <table id="GongYintools">
     <tr>
     	<td></td>
     	</tr>
     </table>
	</div>
          </div>
     

  
  
  </body>
</html>
