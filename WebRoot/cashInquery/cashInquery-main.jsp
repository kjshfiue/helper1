<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:include page="/common/base_path.jsp" />
<html>
  <head>
  <script type="text/javascript" src="lib/jquery-1.7.2.min.js"></script>
  <script type="text/javascript" src="lib/jquery.easyui.min.js"></script>
  <link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
  <link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
    <title>询价单据管理</title>
    
    <style type="text/css">
      tr,td{
  	     margin:0px;
  	     padding:0px;
       }
       #addTable{
       border:1px #F4F4F4 solid;
       }
    </style>
    <script type="text/javascript">
      $(function(){
      document.getElementById("search_part").style.display="none";
       var prividerName=null;
       $('#addPrividerName').window('close');         
       $("#update_win").window("close");
       $('#add_win').window('close'); 
      //选择供应商
        $("input[name='comPcode_add']").focus(function(){
          
        $('#addPrividerName').window('open');  
        }); 
        //对选择供应商名称的DataGrid进行初始化
          $("#addPrividerNameList").datagrid({
                  url:"base/GetPrividerNameServlet",//定义请求数据地址
                  fitColumns:true,
                  type:'post',
          		  columns:[[
    	             {field:'salerCode',title:'供应商代码',width: 100},
    	             {field:'saerName',title:'供应商名称',width:100},
    	             {field:'salerLegaler',title:'联系人员',width:100},
    	             {field:'salerTelphone',title:'电话',width:100},
    	             {field:'salerFax',title:'传真',width:100},
    	             {field:'salerAddress',title:'地址',width:100},
    	             ]],
    	            onDblClickRow:function(rowIndex,rowData){
    	            	prividerName=rowData.saerName;
    	            	$("input[name='comPcode_add']").val(prividerName);  
    	            	  $('#addPrividerName').window('close');  	          
    	              }
          });      
      //定义datagrid将询价详细信息展示出来
     $("#managePrice").datagrid({
    	        url:"base/GetBaseCashInqueryServlet",//定义请求数据地址
    			pagination:true,//定义分页操作图标
    			pageList:[3,5,10,20],
    	        toolbar:'#toolBar',
    	        fitColumns:true,
    	        columns:[[
    	             {field:'id',checkbox:true},
    	             {field:'code',title:'询价单号',width: 100},
    	             {field:'addDate',title:'询价日期',width:100},
    	             {field:'comPCode',title:'供应商名称',width:100},
    	             {field:'nums',title:'数量',width:100},
    	             {field:'numSprice',title:'金额',width:100},
    	             {field:'contacter',title:'联系人',width:100},
    	             {field:'telphone',title:'联系方式',width:100},
    	             {field:'state',title:'审核状态',width:100,formatter:function(val,row,idx){
    	             			if(val==1){
    	             			return "已审核！";
    	             			}else{
    	             			return "未审核！";
    	             			}
    	             }},
    	             {field:'addUserName',title:'操作员',width:100},
    	             {field:'opt', title: '操作', width: 140,formatter:function(val,row,idx){	
		             	var content="<input type='button' value='修改' onclick=\"update("+idx+")\"/>";
		            	content+="<input type='button' value='删除' onclick=\"del("+row.code+")\"/>";
		                   	return content;}}
    	        ]],
    	 //定义双击事件
    	 onDblClickRow:function(rowIndex,rowData){
 		//获取配件详细信息
 		     $("#partName").val("hahahh");
	 	    $.ajax({
	 	    	url:"base/GetBasePartServlet",
	 	    	type:"post",
	 	    	data:{"code":rowData.code},
	 	    	dataType:'json',
	 	    	success:function(data){
	 	    		 $("#basePartDetail").datagrid('loadData',data)
	 	    	},
	 	    	error:function(){
	 	    		$.messager.confirm("错误提示","信息提取错误？");
	 	    	}
	 	    });
 		}
    	});
 $("#basePartDetail").datagrid({
    			columns:[[
    	             {field:'pcode',title:'配件件号',width: 100},
    	             {field:'partsName',title:'配件名称',width:100},
    	             {field:'partsBrand',title:'配件品牌',width:100},
    	             {field:'partsmodel',title:'配件型号',width:100},
    	             {field:'nums',title:'数量',width:100},
    	             {field:'price',title:'单价',width:100},
    	             {field:'total',title:'金额',width:100 },
    	             {field:'remarks',title:'备注',width:100},
    	        ]]
    	});
    });
    //实行删除操作
function del(code){
      var info={"code":code};
      $.messager.confirm("删除确认","确认删除数据？",
    	 function(r){
    		   if(r){
    		       $.ajax({
    		      	dataType:'json',//预期服务器返回的数据类型
    		        data:info,
    		        url:"base/DeleteCashInqueryServlet",
    		      	success:function(data){
    		      		 if(data.ret==1){
    		      			     $.messager.confirm("信息提示","删除成功！");
    		      			     $("#managePrice").datagrid("reload");
    		      	      }else{
    		      	            $("#managePrice").datagrid("reload");
    		      			      $.messager.confirm("信息提示","删除失败！");
    		      		  }
    		      	},
    		      	error:function(){
    		      		   $.messager.confirm("错误提示：","删除失败！");
    		      	}
    		     });
    		  }
         }
      );
    }
    //实现搜索框的显示与隐藏
    function show_search_bar(){
          if(document.getElementById("search_part").style.display=="none"){
          	document.getElementById("search_part").style.display="block";
          	//$('#show_search_button').linkbutton({text:'关闭搜索'});
          }else{
          	document.getElementById("search_part").style.display="none";
          	//$('#show_search_button').linkbutton({text:'搜索'});
          	}  
  }
  //实现搜索供应商姓名
  function searchprividerName(){
  		  var code= $("#privider_part").find("input[name='prividerCode']").val();
        var name= $("#privider_part").find("input[name='prividerName']").val();
       
        var data={"prividerCode":code,"prividerName":name}
           $("#addPrividerNameList").datagrid(
             	'reload',data
        );
  }
  //实现搜索功能
    function search(){
        var code= $("#search_part").find("input[name='searchCode']").val();
        var startDate= $("#search_part").find("input[name='startDate']").val();
        var endDate=$("#search_part").find("input[name='endDate']").val();
        var privider=$("#search_part").find("input[name='privider']").val();
        var data={"code":code,"startDate":startDate,"endDate":endDate,"privider":privider}
           $("#managePrice").datagrid(
             	'reload',data
        );
    }
    
    //打开添加表单，并且将日期以及表单号添加上
    function add(){
           $('#add_win').window('open');
            var myDate = new Date();   
		    var year= myDate.getFullYear();   //获取完整的年份(4位,1970-????)
		    var month=myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)
		    var day=myDate.getDate();       //获取当前日(1-31)
            var hour= myDate.getHours();      //获取当前小时数(0-23)
		    var minutes=myDate.getMinutes();    //获取当前分钟数(0-59)
		    var seconds= myDate.getSeconds();    //获取当前秒数(0-59)
		    var mytime="KH"+year+month+day+hour+minutes+seconds;
            $("#addTable").find("input[name='code_add']").val(mytime.toString());
           
    };
    
    //保存新添加信息
    function save_add(){
           $.ajax({
           		 url:"base/AddCashInqureyServlet",
                 data:$("#MyForm_add").serialize(),
                 type:"post",
                 success:function(data){
                         if(data.ret==1){
	    		      	      $.messager.confirm("信息提示","添加成功！");
	    		      		  $("#managePrice").datagrid("reload");}
    		      		  else{
    		      			   $.messager.confirm("信息提示","添加失败！");
    		      			  }},
    		     error:function(){
    		      		$.messager.confirm("错误提示：","添加失败！");
    		      			      }
           });
    }
    
   //批量删除数据
 function delBatch(){
	var rows = $("#managePrice").datagrid("getSelections");
	alert(rows[0].code);
	if(rows.length==0){
		alert("没有选中任何要删除的数据！");
	}else{
		$.messager.confirm("批量删除","确定要删除选中的数据吗？",
		function(r){
			if(r){
				var ret = "rows";
				for(var i=0;i<rows.length;i++){
					$.ajax({url:"base/DeleteCashInqueryServlet",
						dataType:'json',
						data:{"code":rows[i].code},
						success:function(data){
							if(data.ret==0){
								ret += ","+data.ret;
							}
						},
					});
				}
				if(ret=="rows"){
					$.messager.confirm("信息提示","删除成功!");
				}else{
					$.messager.confirm("信息提示","删除失败!失败行号"+ret);
				}
				$("#managePrice").datagrid("reload");	
			}
		});
	}
}

    //打开更新表单将原有数据存到新的表单上
function update(idx){
        var row=$("#managePrice").datagrid("getRows")[idx];
        $("#updateTable").find("input[name='priceNo']").val(row.code);
        $("#updateTable").find("input[name='comPcode_update']").val(row.comPCode);
        $("#updateTable").find("input[name='nums_update']").val(row.nums);
        $("#updateTable").find("input[name='numSprice_update']").val(row.numSprice);
        $("#updateTable").find("input[name='contacter_update']").val(row.contacter);
        $("#updateTable").find("input[name='telephone_update']").val(row.telphone);
        $("#updateTable").find("input[name='state_update']").val(row.state);
        $("#updateTable").find("input[name='remarks_add']").val(row.remarks);
        $("#update_win").window("open");
    }
    //保存更新后的数据
function save_update(){
       $.ajax({
            data:$("#MyForm1").serialize(),
            // cache:true,
            type:"post",
            url:"base/UpdateCashInqueryServlet",
            async:false,
            error: function(request){
             	$.messager.confirm("信息提示","错误提示：信息修改失败！");
             } ,
             success:function(data){
             	if(data.ret=="1"){
             		$.messager.confirm("信息提示","信息修改成功！");
             		$('#update-win').window('close');
             		$("#managePrice").datagrid("reload");
             	}else{
                   $.messager.confirm("信息提示","信息修改失败！");
             }
             }  
         });
   }; 
   
   //导出任意一条询价明细
function outPutExcel(){
       var rows= $("#managePrice").datagrid("getSelections");
       if(rows.length==0){
		     $.messager.confirm("信息提示","请选择一条要导出的语句！");
	    }else{
	         var info={"code":rows[0].code,"addDate":rows[0].addDate,"comPCode":rows[0].comPCode,"nums":rows[0].nums
          	,"numSprice":rows[0].numSprice,"contacter":rows[0].contacter,"telphone":rows[0].telphone,"state":rows[0].state}
	         $.ajax({
	             url:"base/ExportCashInqueryExcelServlet",
	             type:"post",
	             data:info,
	             success:function(data){
	                }
	               });
	         }
          }
          //导出按条件筛出来的数据，导出格式为.xls
 function outSelectExcel() {
 		var code= $("#search_part").find("input[name='searchCode']").val();
        var startDate= $("#search_part").find("input[name='startDate']").val();
        var endDate=$("#search_part").find("input[name='endDate']").val();
        var privider=$("#search_part").find("input[name='privider']").val();
        var obj={"code":code,"startDate":startDate,"endDate":endDate,"privider":privider}
         $.ajax({
         	url:"base/ExportAllSearchServlet",
         	type:"post",
         	data:obj,
         	success:function(data){
         	
            }}); 		      
}
 //生成world
function outputWord(){
    $.ajax({
    	url:"base/OutputCahInqueryDocServlet",
    	type:"post",
    });
}   
      
    </script>
  </head>
  
  <body>
      <div id="managePrice"></div>
      <div id="addPrividerName" class="easyui-window" title="选择供应商名称界面"  style="width:1000px;height:400px" data-options="iconCls:'icon-save',modal:true">
      		 		<table id="privider_part">
            			 <tr>
            				<td>检索条件:
            				</td><td>供应商代号:</td><td><input type="text" name="prividerCode"/></td>
                             <td>&nbsp;&nbsp;</td>
            				<td>供应商名称：</td><td><input type="text" name="prividerName"/></td>
            				<td>&nbsp;&nbsp;</td>
            				<td><input type="button" value="搜索" onclick="searchprividerName()"/></td>
            				<td><input type="reset" value="重置"/></td>
            			  </tr>
            			</table>
      		<div id="addPrividerNameList"  class="easyui-layout" data-options="fit:true">
      		</div>
      </div>
     
      <div id="basePartDetail"></div>
      <div id="toolBar" >
            		   <table id="search_part">
            			 <tr>
            				<td>检索条件:</td><td>询问编号:</td><td><input type="text" name="searchCode"/></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>开始日期：</td><td><input type="text" name="startDate"/></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>结束日期：</td><td><input type="text" name="endDate"/></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>供应商：</td><td><input type="text" name="privider"/></td>
            				<td>&nbsp;&nbsp;</td>
            				<td><input type="button" value="搜索" onclick="search()"/></td>
            				<td><input type="reset" value="重置"/></td>
            			  </tr>
            			</table>
            		
	            <a href="#"  id="show_search_button" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="show_search_bar()" >搜索</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delBatch()">批量删除</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-excel'" onclick="outSelectExcel() ">导出EXCEL</a>
            </div>
 <div id="add_win" class="easyui-window" title="添加配件窗口" style="width:600px;height:400px" data-options="iconCls:'icon-save',modal:true">   
    <form id="MyForm_add">
    <table id="addTable">
        <tr>  <td><input type="hidden" name="code_add" /></td></tr>
    	<tr>
    		<td>供应商名：</td><td><input type="text" name="comPcode_add" /></td>
    			<td>数量：</td><td><input type="text" name="nums_add" /></td>
    	</tr>
    	<tr>
    		<td>金额：</td><td><input type="text" name="numSprice_add" /></td>
    			<td>联系人员：</td><td><input type="text" name="contacter_add" /></td>
    	</tr>
    	<tr>
    		<td>电话：</td><td><input type="text" name="telephone_add" /></td>
    			<td>审核状态：</td><td><input type="text" name="state_add" /></td>
    	</tr>
    	<tr>
    		<td>操作员：</td><td><input type="text" name="remarks_add" /></td>	
    	</tr>
    	<tr>
    	  <td rowspan="3"><input type="button" value="新增" />
	      <input type="button" value="添加配件" onclick="add()"/></td>
	      <td><input type="button" value="保存" onclick="save_add()"/>
	      <input type="button" value="审核" onclick=""/></td>
	      <td><input type="button" value="打印" onclick=""/></td>
	      <td><input type="button" value="生成word" onclick=""/></td>
	     <td><input type="button" value="关闭" onclick="close()"/></td>
    	</tr>
    </table> 
    </form>  
</div>
   <div id="update_win" class="easyui-window" title="修改配件窗口" style="width:600px;height:400px" data-options="iconCls:'icon-save',modal:true">   
     <form id="MyForm1" >
    <table id="updateTable">
        <tr>
        	<td><input type="hidden" name="code_update" /></td>
        </tr>
    	<tr> 
    		<td>供应商名：</td><td><input type="text" name="comPcode_update" /></td>
    			<td>数量：</td><td><input type="text" name="nums_update" /></td>
    	</tr>
    	<tr>
    		<td>金额：</td><td><input type="text" name="numSprice_update" /></td>
    			<td>联系人员：</td><td><input type="text" name="contacter_update" /></td>
    	</tr>
    	<tr>
    		<td>电话：</td><td><input type="text" name="telephone_update" /></td>
    			<td>审核状态：</td><td><input type="text" name="state_update" /></td>
    	</tr>
    	
    	<tr>
    	  <td rowspan="3"><input type="button" value="新增"/>
	      <input type="button" value="添加配件" onclick="add()"/></td>
	      <td><input type="button" value="保存" onclick="save_update()"/>
	      <input type="button" value="审核" onclick=""/></td>
	      <td><input type="button" value="打印" onclick=""/></td>
	      <td><input type="button" value="生成word" onclick="outputWord()"/></td>
	     <td><input type="button" value="关闭" onclick="close()"/></td>
    	</tr>
    </table>  
    </form> 
</div>
  </body>
</html>
