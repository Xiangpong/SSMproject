<%--
  Created by IntelliJ IDEA.
  User: 吴湘鹏
  Date: 2019/6/26 0026
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
</head>
<body>
    <ul id="productCategory" class="easyui-tree"></ul>

    <div id="mm" class="easyui-menu" style="width:120px;">
        <div onclick="append()" data-options="iconCls:'icon-add'" >添加子分类</div>
        <div onclick="appendF()" data-options="iconCls:'icon-add'" >添加父分类</div>
        <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
        <div onclick="reEdit()" data-options="iconCls:'icon-edit'">编辑</div>
    </div>

    <script>
        $(function () {
            $('#productCategory').tree({
                url: "/product_category/list",
                onContextMenu: function(e, node){
                    e.preventDefault();
                    // select the node
                    $('#productCategory').tree('select', node.target);
                    // display context menu
                    $('#mm').menu('show', {
                        left: e.pageX,
                        top: e.pageY
                    });
                },
                onAfterEdit:function (node) {
                    var _tree = $('#productCategory');
                    if (node.id == 0){
                        $.post("/product_category/add",{ parentId:node.parentId,name:node.text},function (data) {
                            if (data.status==200) {
                                _tree.tree("update",{
                                    target:node.target,
                                    id:data.msg
                                })
                            }else {
                                $.messager.alert("添加失败")
                            }
                        })
                    }else {
                        $.post("product_category/update",{id:node.id,name:node.text})
                    }
                }
            });
        })

        function append() {
            //添加分类
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('append', {
                parent: (node?node.target:null),
                data: [
                    {
                        id:0,
                        parentId:node.id,
                        text:"新建子分类"
                    }
                ]
            });
            var _selected = tree.tree("find",0);
            tree.tree("select",_selected.target).tree('beginEdit',_selected.target)
        }

        function appendF() {
            //添加父分类
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('append', {
                parent: null,
                data: [
                    {
                        id:0,
                        parentId:0,
                        text:"新建父分类"
                    }
                ]
            });
            var _selected = tree.tree("find",0);
            tree.tree("select",_selected.target).tree('beginEdit',_selected.target)
        }



        function reEdit() {
            //编辑
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            tree.tree('beginEdit',node.target)

        }

        function remove() {
            //删除
            var tree = $('#productCategory');
            var node = tree.tree('getSelected');
            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
                if(r){
                    $.post("product_category/delete",{parentId:node.attributes,id:node.id},function(){
                        tree.tree("remove",node.target);
                    });
                }
            });
        }


    </script>
</body>
</html>
