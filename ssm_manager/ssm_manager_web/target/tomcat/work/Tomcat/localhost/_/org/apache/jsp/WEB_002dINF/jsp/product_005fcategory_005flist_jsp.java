/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-09-10 01:40:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class product_005fcategory_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>商品分类</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <ul id=\"productCategory\" class=\"easyui-tree\"></ul>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"mm\" class=\"easyui-menu\" style=\"width:120px;\">\r\n");
      out.write("        <div onclick=\"append()\" data-options=\"iconCls:'icon-add'\" >添加子分类</div>\r\n");
      out.write("        <div onclick=\"appendF()\" data-options=\"iconCls:'icon-add'\" >添加父分类</div>\r\n");
      out.write("        <div onclick=\"remove()\" data-options=\"iconCls:'icon-remove'\">删除</div>\r\n");
      out.write("        <div onclick=\"reEdit()\" data-options=\"iconCls:'icon-edit'\">编辑</div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $('#productCategory').tree({\r\n");
      out.write("                url: \"/product_category/list\",\r\n");
      out.write("                onContextMenu: function(e, node){\r\n");
      out.write("                    e.preventDefault();\r\n");
      out.write("                    // select the node\r\n");
      out.write("                    $('#productCategory').tree('select', node.target);\r\n");
      out.write("                    // display context menu\r\n");
      out.write("                    $('#mm').menu('show', {\r\n");
      out.write("                        left: e.pageX,\r\n");
      out.write("                        top: e.pageY\r\n");
      out.write("                    });\r\n");
      out.write("                },\r\n");
      out.write("                onAfterEdit:function (node) {\r\n");
      out.write("                    var _tree = $('#productCategory');\r\n");
      out.write("                    if (node.id == 0){\r\n");
      out.write("                        $.post(\"/product_category/add\",{ parentId:node.parentId,name:node.text},function (data) {\r\n");
      out.write("                            if (data.status==200) {\r\n");
      out.write("                                _tree.tree(\"update\",{\r\n");
      out.write("                                    target:node.target,\r\n");
      out.write("                                    id:data.msg\r\n");
      out.write("                                })\r\n");
      out.write("                            }else {\r\n");
      out.write("                                $.messager.alert(\"添加失败\")\r\n");
      out.write("                            }\r\n");
      out.write("                        })\r\n");
      out.write("                    }else {\r\n");
      out.write("                        $.post(\"product_category/update\",{id:node.id,name:node.text})\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("        function append() {\r\n");
      out.write("            //添加分类\r\n");
      out.write("            var tree = $('#productCategory');\r\n");
      out.write("            var node = tree.tree('getSelected');\r\n");
      out.write("            tree.tree('append', {\r\n");
      out.write("                parent: (node?node.target:null),\r\n");
      out.write("                data: [\r\n");
      out.write("                    {\r\n");
      out.write("                        id:0,\r\n");
      out.write("                        parentId:node.id,\r\n");
      out.write("                        text:\"新建子分类\"\r\n");
      out.write("                    }\r\n");
      out.write("                ]\r\n");
      out.write("            });\r\n");
      out.write("            var _selected = tree.tree(\"find\",0);\r\n");
      out.write("            tree.tree(\"select\",_selected.target).tree('beginEdit',_selected.target)\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function appendF() {\r\n");
      out.write("            //添加父分类\r\n");
      out.write("            var tree = $('#productCategory');\r\n");
      out.write("            var node = tree.tree('getSelected');\r\n");
      out.write("            tree.tree('append', {\r\n");
      out.write("                parent: null,\r\n");
      out.write("                data: [\r\n");
      out.write("                    {\r\n");
      out.write("                        id:0,\r\n");
      out.write("                        parentId:0,\r\n");
      out.write("                        text:\"新建父分类\"\r\n");
      out.write("                    }\r\n");
      out.write("                ]\r\n");
      out.write("            });\r\n");
      out.write("            var _selected = tree.tree(\"find\",0);\r\n");
      out.write("            tree.tree(\"select\",_selected.target).tree('beginEdit',_selected.target)\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        function reEdit() {\r\n");
      out.write("            //编辑\r\n");
      out.write("            var tree = $('#productCategory');\r\n");
      out.write("            var node = tree.tree('getSelected');\r\n");
      out.write("            tree.tree('beginEdit',node.target)\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function remove() {\r\n");
      out.write("            //删除\r\n");
      out.write("            var tree = $('#productCategory');\r\n");
      out.write("            var node = tree.tree('getSelected');\r\n");
      out.write("            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){\r\n");
      out.write("                if(r){\r\n");
      out.write("                    $.post(\"product_category/delete\",{parentId:node.attributes,id:node.id},function(){\r\n");
      out.write("                        tree.tree(\"remove\",node.target);\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
