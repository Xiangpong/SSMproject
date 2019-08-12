<%--
  Created by IntelliJ IDEA.
  User: 吴湘鹏
  Date: 2019/6/25 0025
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table id="dg" title="商品列表" class="easyui-datagrid"
       url="/product/list" data-options="pageSize:5,pageList:[5,10,15,20]" toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true" >
    <thead>
        <tr>
            <th data-options="field:'id'" width="20">id</th>
            <th data-options="field:'name'" width="50" >商品名称</th>
            <th data-options="field:'image',formatter:showImage" width="50">商品主图</th>
            <th data-options="field:'price'" width="20">价格</th>
            <th data-options="field:'marketPrice'" width="20">市场价格</th>
            <th data-options="field:'productBelongs'" width="20">作者</th>

        </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editorProduct()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteProduct()">删除</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:500px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>商品信息</h3>
        <input type="hidden" name="id">
        <input type="hidden" name="categoryId" />
        <input type="hidden" name="image" />
        <input type="hidden" name="description" />
        <input type="hidden" name="status" />
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" required="true"  label="商品名称：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="price" class="easyui-textbox" required="true"  label="商品价格："style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="marketPrice" class="easyui-textbox" required="true"  label="市场价格：" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="productBelongs" class="easyui-textbox" required="true"  label="作者：" style="width:100%">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="editorProductDone()"  style="width:100px">修改</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:100px">取消</a>
</div>
<script type="text/javascript">

    function showImage(value,row,index) {
        if (row.image){
            return "<img style='height:100px;width:auto' src=http://192.168.46.128:8888/"+row.image+">"
        }
    }

    var url;

    function editorProduct(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','商品信息编辑');
            $('#fm').form('load',row);
            url = '/product/list/'+row.id;
            $("#fm").find("input[name='id']").val(row.id)
            $("#fm").find("input[name='categoryId']").val(row.categoryId)
            $("#fm").find("input[name='image']").val(row.image)
            $("#fm").find("input[name='description']").val(row.description)
            $("#fm").find("input[name='status']").val(row.status)
        }
    }
    function editorProductDone(){


        $.post("/product_editor",$('#fm').serialize(),function(data){
            if (data.status == 200){
                $.messager.alert("提示","修改成功！");
                location.reload();
            }
        });
    }
    function deleteProduct(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('警告','确定要删除这条商品信息！？',function(r){
                if (r){
                    $.post('/product_remove',{id:row.id},function(data){
                        if (data.status == 200){
                            $('#dg').datagrid('reload');    // reload the user data
                        } else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: data.errorMsg
                            });
                        }
                    },'json');
                }
            });
        }
    }
</script>
</body>
</html>
