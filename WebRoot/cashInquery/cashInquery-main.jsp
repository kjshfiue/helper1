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
         	
            
      $("#update_win").window("close");
      $('#add_win').window('close'); 
    	$("#managePrice").datagrid({
    	        url:"base/GetBaseCashInqueryServlet",//定义请求数据地址
    			pagination:true,//定义分页操作图标
    			pageList:[3,5,10,20],
    	        fit:true,
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
    	             { field: 'opt', title: '操作', width: 140,formatter:function(val,row,idx){	
		             	var content="<input type='button' value='修改' onclick=\"update("+idx+")\"/>";
		            	content+="<input type='button' value='删除' onclick=\"del("+row.code+")\"/>";
		                   	return content;}}
    	        ]]
    	});
    });
    function add(){
            var myDate = new Date();   
		    var year= myDate.getFullYear();   //获取完整的年份(4位,1970-????)
		    var month=myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)
		    var day=myDate.getDate();       //获取当前日(1-31)
            var hour= myDate.getHours();      //获取当前小时数(0-23)
		    var minutes=myDate.getMinutes();    //获取当前分钟数(0-59)
		    var seconds= myDate.getSeconds();    //获取当前秒数(0-59)
		    var mytime="KH"+year+month+day+hour+minutes+seconds;
           $('#add_win').window('open');
            $("#addTable").find("input[name='code_add']").val(mytime.toString());
           
    };
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
    function update(idx){
        var row=$("#managePrice").datagrid("getRows")[idx];
        $("#updateTable").find("input[name='code_update']").val(row.code);
        $("#updateTable").find("input[name='comPcode_update']").val(row.comPCode);
        $("#updateTable").find("input[name='nums_update']").val(row.nums);
        $("#updateTable").find("input[name='numSprice_update']").val(row.numSprice);
        $("#updateTable").find("input[name='contacter_update']").val(row.contacter);
        $("#updateTable").find("input[name='telephone_update']").val(row.telphone);
        $("#updateTable").find("input[name='state_update']").val(row.state);
        $("#updateTable").find("input[name='remarks_add']").val(row.remarks);
        $("#update_win").window("open");
    }
    
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
          
   }
    
 
    </script>
  </head>
  
  <body>
      <div id="managePrice"></div>
      <div id="toolBar" >
              
            		<table>
            			<tr>
            				<td>检索条件:</td><td>询问编号:</td><td><input type="text" name="priceNo"></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>开始日期：</td><td><input type="text" name="startDate"></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>结束日期：</td><td><input type="text" name="endDate"></td>
            				<td>&nbsp;&nbsp;</td>
            				<td>开始日期：</td><td><input type="text" name="privider"></td>
            				<td>&nbsp;&nbsp;</td>
            				<td><input type="submit" value="搜索"></td>
            				<td><input type="reset" value="搜索"></td></tr>
            		</table>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="search()">搜索</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delBanch()">批量删除</a>
	            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-excel'" onclick="outPutExcel()">导出EXCEL</a>
            </div>
 <div id="add_win" class="easyui-window" title="添加配件窗口" style="width:600px;height:400px" data-options="iconCls:'icon-save',modal:true">   
    <form id="MyForm_add">
    <table id="addTable">
    	<tr>    
    	        <td><input type="hidden" name="code_add" /></td>
    			<td>询价日期：</td><td><input type="text" name="addDate_add" /></td>
    	</tr>
    	<tr>
    		<td>供应商名：</td><td><input type="text" name="comPcode_add" /></td>
    			<td>数量：</td><td><input type="text" name="nums_add" /></td>
    	</tr>
    	<tr>
    		<td>金额：</td><td><input type="text" name="numSprice_add" /></td>
    			<td>联系人员：</td><td><input type="text" name="contacter_add" /></td>
    	</tr>
    	<tr>
    		<td>电&nbsp;&nbsp;话：</td><td><input type="text" name="telephone_add" /></td>
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
     <form id="MyForm1">
    <table id="updateTable">
        <tr>
        	<td><input type="hidden" name="code_update" />询价编号</td>
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
    		<td>电&nbsp;&nbsp;话：</td><td><input type="text" name="telephone_update" /></td>
    			<td>审核状态：</td><td><input type="text" name="state_update" /></td>
    	</tr>
    	
    	<tr>
    	  <td rowspan="3"><input type="button" value="新增"/>
	      <input type="button" value="添加配件" onclick="add()"/></td>
	      <td><input type="button" value="保存" onclick="save_update()"/>
	      <input type="button" value="审核" onclick=""/></td>
	      <td><input type="button" value="打印" onclick=""/></td>
	      <td><input type="button" value="生成word" onclick=""/></td>
	     <td><input type="button" value="关闭" onclick="close()"/></td>
    	</tr>
    </table>  
    </form> 
</div>
  
            
      
  </body>
</html>
