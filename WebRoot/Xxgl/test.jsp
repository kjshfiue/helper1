<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
<script type="text/javascript">

        $(function () {
            var datagrid; //定义全局变量datagrid
            var editRow = undefined; //定义全局变量：当前编辑的行
            datagrid = $("#dd").datagrid({
                url: 'UserCenter.aspx', //请求的数据源
                iconCls: 'icon-save', //图标
                pagination: true, //显示分页
                pageSize: 15, //页大小
                pageList: [15, 30, 45, 60], //页大小下拉选项此项各value是pageSize的倍数
                fit: true, //datagrid自适应宽度
                fitColumn: false, //列自适应宽度
                striped: true, //行背景交换
                nowap: true, //列内容多时自动折至第二行
                border: false,
                idField: 'ID', //主键
                columns: [[//显示的列
                {field: 'ID', title: '编号', width: 100, sortable: true, checkbox: true },
                 { field: 'UserName', title: '用户名', width: 100, sortable: true,
                     editor: { type: 'validatebox', options: { required: true} }
                 },
                  { field: 'RealName', title: '真实名称', width: 100,
                      editor: { type: 'validatebox', options: { required: true} }
                  },
                   { field: 'Email', title: '邮箱', width: 100,
                       editor: { type: 'validatebox', options: { required: true} }
                   }
                   ]],
                queryParams: { action: 'query' }, //查询参数
                toolbar: [{ text: '添加', iconCls: 'icon-add', handler: function () {//添加列表的操作按钮添加，修改，删除等
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

                }
                }, '-',
                 { text: '删除', iconCls: 'icon-remove', handler: function () {
                     //删除时先获取选择行
                     var rows = datagrid.datagrid("getSelections");
                     //选择要删除的行
                     if (rows.length > 0) {
                         $.messager.confirm("提示", "你确定要删除吗?", function (r) {
                             if (r) {
                                 var ids = [];
                                 for (var i = 0; i < rows.length; i++) {
                                     ids.push(rows[i].ID);
                                 }
                                 //将选择到的行存入数组并用,分隔转换成字符串，
                                 //本例只是前台操作没有与数据库进行交互所以此处只是弹出要传入后台的id
                                 alert(ids.join(','));
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
                 }
                 }, '-',
                 { text: '取消编辑', iconCls: 'icon-redo', handler: function () {
                     //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
                     editRow = undefined;
                     datagrid.datagrid("rejectChanges");
                     datagrid.datagrid("unselectAll");
                 }
                 }, '-'],
                onAfterEdit: function (rowIndex, rowData, changes) {
                    //endEdit该方法触发此事件
                    console.info(rowData);
                    editRow = undefined;
                },
                onDblClickRow: function (rowIndex, rowData) {
                //双击开启编辑行
                    if (editRow != undefined) {
                        datagrid.datagrid("endEdit", editRow);
                    }
                    if (editRow == undefined) {
                        datagrid.datagrid("beginEdit", rowIndex);
                        editRow = rowIndex;
                    }
                }
            });
        });
    </script>

  </head>
  
  <body>
	

  <table id="dd">
  </table>


  </body>
</html>
