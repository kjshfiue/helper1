<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'PeiJianMessage.jsp' starting page</title>
    
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
	ul li{
	list-style:none;
	display:inline;
	}
</style>
<script type="text/javascript">
$(function(){    
$('#win').window('close');  
    $('#btn1').bind('click', function(){   
		var leibie=$("#cc").combobox('getText');	
		var mingcheng=$("input[name='m_name']").val();
		var jianhao=$("input[name='m_number']").val();	
		var dataMM={"type1":leibie,"name1":mingcheng,"number1":jianhao};
$.ajax({
  url:'/helper/FindMessage.do',
  data:dataMM,
  dataType:'json',
  success: function(data){
   $('#dg').datagrid(
     'loadData',[]
    ) 
    $.each(data,function(idx,item){
	 datas={partsCode:item.partsCode,partsNo:item.partsNo,partsCategory:item.partsCategory,
 	partsName:item.partsName,partsBrand:item.partsBrand,partsModel:item.partsModel,partsModelOld:item.partsModelOld
 	,salePrice:item.salePrice,idShow:item.idShow,addUserName:item.addUserName,remarks:item.remarks};
   	 $('#dg').datagrid(
     'appendRow',datas
    ) 
   })  

  }
});
    });  
   //编辑部分
  var datagrid; //定义全局变量datagrid
  var editRow = undefined; //定义全局变量：当前编辑的行
   datagrid=$('#dg').datagrid({    
   		 // url: 'UserCenter.aspx', //请求的数据源
                iconCls: 'icon-save', //图标
                pagination: true, //显示分页
                pageSize: 15, //页大小
                pageList: [15, 30, 45, 60], //页大小下拉选项此项各value是pageSize的倍数
                fit: false, //datagrid自适应宽度
                pagePosition:'top',
                fitColumn: true, //列自适应宽度
                striped: true, //行背景交换
                nowap: true, //列内容多时自动折至第二行
                border: false,
                idField: 'partsCode', //主键
                columns: [[//显示的列
                {field: 'ID', title: '编号', width: 140, sortable: true, checkbox: true },
                 { field: 'partsCode', title: '配件编号', width: 80, sortable: true,
                     editor: { type: 'validatebox', options: { required: true} }
                 },
                  { field: 'partsNo', title: '配件件号', width: 80,
                      editor: { type: 'validatebox', options: { required: true} }
                  },
                   { field: 'partsCategory', title: '配件类别', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'partsName', title: '配件名称', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'partsBrand', title: '配件品牌', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'partsModel', title: '配件型号', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'partsModelOld', title: '配件旧型号', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'salePrice', title: '配件销售价格', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'idShow', title: '显示状态', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'addUserName', title: '操作员', width: 80,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'remarks', title: '备注', width: 180,
                       editor: { type: 'validatebox', options: { required: true} }
                   },
                   { field: 'opt', title: '操作', width: 140,formatter:function(val,row,idx){	
			var content="<input type='button' value='修改' onclick=\"update("+idx+","+row.partsCode+","+row.partsNo+","+row.partsCategory+","+row.partsName+","+row.partsBrand+","+row.partsModel+","+row.partsModelOld+","+row.salePrice+","+row.idShow+","+row.addUserName+","+row.remarks+")\"/>";
			content+="<input type='button' value='删除' onclick=\"del("+row.partsCode+")\"/>";
			return content;
		}
                 
                   }
                   ]],
                queryParams: { action: 'query' }, //查询参数
                toolbar: [
                { text: '查询', iconCls: 'icon-redo', handler: function () {
                  var newRindex=datagrid.datagrid("getSelections")
                  // alert(newRindex[0].partsCode);
                 window.location.href="DanJu.jsp?code="+newRindex[0].partsCode+"";
  				
                 
                 }
                 }, '-',
                { text: '添加', iconCls: 'icon-add', handler: function () {//添加列表的操作按钮添加，修改，删除等
                    //添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
                    if (editRow != undefined) {
                        datagrid.datagrid("endEdit", editRow);
                    }
                    //添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
                    if (editRow == undefined) {
                        datagrid.datagrid("insertRow", {
                            index: 0, // index start with 0
                            row: {

                            }
                        });
                        //将新插入的那一行开户编辑状态
                        datagrid.datagrid("beginEdit", 0);
                        //给当前编辑的行赋值
                        editRow = 0;
                    }
				//alert(row.partsCode);
                }
                }, '-',
                 { text: '批量删除', iconCls: 'icon-remove', handler: function () {
                    //删除时先获取选择行
                     var rows1 = datagrid.datagrid("getSelections");
                 
                     if (rows1.length > 0) {
                         $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                             if (r) {
                                 var ids = [];
                                 for (var i = 0; i < rows1.length; i++) {
                                 	alert("code:"+rows1[i].partsCode);
                                     ids.push(rows1[i].partsCode);
                                 }
                        
                             
                                 alert("str:"+ids.join(','));
                             }
                         });
                     }
                     else {
                         $.messager.alert("提示", "请选择要删除的行", "error");
                     }
                 }
                 }, '-',
                 { text: '修改', iconCls: 'icon-edit', handler: function () {
                     //修改时要获取选择到的行
                     var rows = datagrid.datagrid("getSelections");
                     //如果只选择了一行则可以进行修改，否则不操作
                     if (rows.length == 1) {
                         //修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
                         if (editRow != undefined) {
                             datagrid.datagrid("endEdit", editRow);
                         }
                         //当无编辑行时
                         if (editRow == undefined) {
                             //获取到当前选择行的下标
                             var index = datagrid.datagrid("getRowIndex", rows[0]);
                             //开启编辑
                             datagrid.datagrid("beginEdit", index);
                             //把当前开启编辑的行赋值给全局变量editRow
                             editRow = index;
                             //当开启了当前选择行的编辑状态之后，
                             //应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
                             datagrid.datagrid("unselectAll");
                         }
                     }
                 }
                 }, '-',
               
                 { text: '保存', iconCls: 'icon-save', handler: function () {
                     //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
                    datagrid.datagrid("endEdit", editRow);
                    var rows=datagrid.datagrid("getRows");
                    var dataMM={partsCode:rows[0].partsCode,partsNo:rows[0].partsNo,partsCategory:rows[0].partsCategory,partsName:rows[0].partsCategory,partsBrand:rows[0].partsBrand,partsModel:rows[0].partsModel,partsModelOld:rows[0].partsModelOld,salePrice:rows[0].salePrice,idShow:rows[0].idShow,addUserName:rows[0].addUserName,remarks:rows[0].remarks};
                    //alert(rows[0].partsCode);
                    $.ajax({
  						url:'/helper/InsertMessage.do',
 						 data:dataMM,
  						dataType:'html',
  						success: function(data){
  					if(data==1){
  						alert("添加成功");
  							}else{
  							alert("添加失败");
  							}
  						}
  
  
  })
                 }
                 }, '-',
                 { text: '取消编辑', iconCls: 'icon-redo', handler: function () {
                     //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                     editRow = undefined;
                     datagrid.datagrid("rejectChanges");
                     datagrid.datagrid("unselectAll");
                 }
                 }, '-',
                 
                 { text: '价格调整', iconCls: 'icon-remove', handler: function () {
                   
                     $('#win').window('open');  
                    
                  
                 }
                 }],
                onAfterEdit: function (rowIndex, rowData, changes) {
                    //endEdit该方法触发此事件
                    console.info(rowData);
                    editRow = undefined;
                },
                onDblClickRow: function (rowIndex, rowData) {
                //双击开启编辑行
                $('#dg').datagrid("checkRow", rowIndex);
                    if (editRow != undefined) {
                        datagrid.datagrid("endEdit", editRow);
                    }
                    if (editRow == undefined) {
                        datagrid.datagrid("beginEdit", rowIndex);
                        editRow = rowIndex;
                    }
                }
    
}); 



 //按钮2效果
   $("#btn2").bind('click',function(){
   	$("input[name='m_number']").val('');
   		$("input[name='m_name']").val('');
   })


})
//修改
//row.partsCode+","+row.partsNo+","+row.partsCategory+","+row.partsName+","+row.partsBrand+","+row.partsModel+","+row.partsModelOld+","+row.salePrice+","+row.idShow+","+row.addUserName+","+row.remarks+
function update(code,a,b,c,d,e,f,g,h,i,j,k){
 $('#dg').datagrid("beginEdit", code);
	var newrows=$('#dg').datagrid("getSelections");
   alert(newrows[0].partsCode);
 
  
   $('#dg').datagrid("endEdit", code);
  var dataMM={partsCode:newrows[0].partsCode,partsNo:newrows[0].partsNo,partsCategory:newrows[0].partsCategory,partsName:newrows[0].partsName,partsBrand:newrows[0].partsBrand,partsModel:newrows[0].partsModel,partsModelOld:newrows[0].partsModelOld,salePrice:newrows[0].salePrice,idShow:newrows[0].idShow,addUserName:newrows[0].addUserName,remarks:newrows[0].remarks};
   
   
  $.ajax({
  url:'/helper/UpdateMessage.do',
  data:dataMM,
  dataType:'html',
  success: function(data){
  	if(data==1){
  	alert("修改成功");
  	}else{
  	alert("修改失败");
  	}
  }
  
  
  })
 
}
//删除
function del(code){
var dataMM={"partscode":code};
alert(code);
$.ajax({
  url:'/helper/deleteMessage.do',
  data:dataMM,
  dataType:'json',
  success: function(data){
  	if(data==1){
  	alert("删除成功");
  	}else{
  	alert("删除失败");
  	}
  }
  
  
  })
}
//统一价格修改
function submitprice(){
var leibie=$("#cc").combobox('getText');	
		var mingcheng=$("input[name='m_name']").val();
		var price=$("#newprice").val();
		var jianhao=$("input[name='m_number']").val();	
		var dataMM={"type1":leibie,"name1":mingcheng,"number1":jianhao,"prices":price};
	$.ajax({
	url:'/helper/changePriceMessage.do',
	 data:dataMM,
	  dataType:'html',
  success: function(data){
  alert(data);
  	if(data==3){
  	alert("修改成功");
  	$('#win').window('close');  
  	}else{
  	alert("修改失败");
  	}
  }
	})
}
</script>
</head>
  
  <body>
 
  <div id="tb" >
  	<ul>
  		<li>检索条件：</li>
		<li>件号：<input type="text" name="m_number"/></li>  
		<li>名称：<input type="text" name="m_name"/></li>
		<li>类别：<select id="cc" class="easyui-combobox" name="dept" style="width:200px;">   
    			 <option value="0">-选择类别-</option>   
   					 <option value="1">轴承</option>   
    					<option value="2">皮带</option>   
						</select> </li>
		<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn1">搜索</a></li>
       	<li><a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"   
        	id="btn2"	>重置</a>  </li>
	</ul>
	
	</div>
	<table id="dg">
		
	</table>  
<div id="win" class="easyui-window" title="My Window" style="width:600px;height:400px"   
        data-options="iconCls:'icon-save',modal:true">   
   <ul>
   		<li>请输入新的价格<input type="text" id="newprice"></li>
   		<li><input type="button" value="确定" onclick="submitprice()" ></li>
   </ul>  
</div> 
  </body>
</html>
