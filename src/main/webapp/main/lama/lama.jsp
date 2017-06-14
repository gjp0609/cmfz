<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.14
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/default/easyui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/IconExtension.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
<table id="lama_data_grid" style="height: 100%"></table>
<div id="lama_dialog"></div>

<script>
    $("#lama_data_grid").datagrid({
        url: "<c:url value="/lama/queryAll"/>",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageSize: 6,
        pageList: [3, 6, 9],
        toolbar: [{
            text: "添加",
            iconCls: 'icon-add',
            handler: function () {
                $("#lama_dialog").dialog({
                    title: '添加',
                    width: 400,
                    height: 200,
                    closed: false,
                    cache: false,
                    href: "<c:url value="lama_add.jsp"/>",
                    modal: true,
                    buttons: [{
                        text: '保存',
                        handler: function () {
                            $("#lama_add_form").submit();
                            $("#lama_add_form").form({
                                success: function () {
                                    $("#lama_dialog").dialog("close");
                                    $('#lama_data_grid').datagrid("load");
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        handler: function () {
                            $("#lama_dialog").dialog("close");
                        }
                    }]
                });
            }
        }],
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'lamaName', title: '法名', width: 100},
            {field: 'src', title: '头像文件名', width: 100, align: 'right'},
            {field: 'operate', title: '操作', width: 60, align: 'center', formatter: lama_operate}
        ]],
        onLoadSuccess: function () {
            $.parser.parse($("a").parent());
        }

    });
    function lama_operate(value, row, index) {
        return "<a href=\"javascript:void(0)\" onclick=\"lama_edit('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">修改</a>";
    }


    function lama_edit(id) {
        lamaId = id;
        $("#lama_dialog").dialog({
            title: '修改',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            href: "<c:url value="/main/lama/lama_edit.jsp"/>",
            modal: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    $("#lama_edit_form").submit();
                    $("#lama_edit_form").form({
                        success: function () {
                            $("#lama_dialog").dialog("close");
                            $('#lama_data_grid').datagrid("reload");
                        }
                    });
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#lama_dialog").dialog("close");
                }
            }]
        });
        console.log(id);
    }
</script>
</body>
</html>
