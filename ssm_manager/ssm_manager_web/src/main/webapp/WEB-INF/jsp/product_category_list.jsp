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

    <script>
        $(function () {
            $('#productCategory').tree({
                url: "/product_category/list"

            });
        })
    </script>
</body>
</html>
