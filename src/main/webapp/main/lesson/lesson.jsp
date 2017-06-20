<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.16
  Time: 17:43
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
<table id="lesson_data_grid" style="height: 100%"></table>
<div id="lesson_dialog"></div>

<script>
    $("#lesson_data_grid").datagrid({
        url: "<c:url value="/lesson/queryAll"/>",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageSize: 9,
        pageList: [6, 9, 15],
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '名称', width: 100},
            {field: 'type', title: '类型', width: 100, formatter: type_name},
            {field: 'lama.name', title: '用户名', width: 100, formatter: user_name},
            {field: 'operate', title: '操作', width: 60, align: 'center', formatter: lesson_operate}
        ]],
        onLoadSuccess: function () {
            $.parser.parse($("a").parent());
        }, toolbar: [{
            text: "添加",
            iconCls: 'icon-add',
            handler: function () {
                $("#lesson_dialog").dialog({
                    title: '添加',
                    width: 400,
                    height: 200,
                    closed: false,
                    cache: false,
                    href: "<c:url value="/main/lesson/lesson_add.jsp"/>",
                    modal: true,
                    buttons: [{
                        text: '保存',
                        handler: function () {
                            $("#lesson_add_form").submit().form({
                                success: function () {
                                    $.messager.show({
                                        title: "添加成功",
                                        msg: "功课已添加",
                                        timeout: 3000,
                                        showType: "slide"
                                    });
                                    $("#lesson_dialog").dialog("close");
                                    $('#lesson_data_grid').datagrid("load");
                                }
                            });
                        }
                    }, {
                        text: '关闭',
                        handler: function () {
                            $("#lesson_dialog").dialog("close");
                        }
                    }]
                });
            }
        }]
    });
    function lesson_operate(value, row, index) {
        return "<a href=\"javascript:void(0)\" onclick=\"lesson_edit('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">修改</a>";
    }

    function type_name(value, row, index) {
        if (row.type === "S") return "系统";
        else  return "用户";
    }
    function user_name(value, row, index) {
        console.log(row);
        if (row.user)
            return row.user.name;
        else return "admin";
    }

    function lesson_edit(id) {
        lessonId = id;
        $("#lesson_dialog").dialog({
            title: '修改',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            href: "<c:url value="/main/lesson/lesson_edit.jsp"/>",
            modal: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    $("#lesson_edit_form").submit().form({
                        success: function () {
                            $.messager.show({
                                title: "保存成功",
                                msg: "修改已完成。",
                                timeout: 3000,
                                showType: "slide"
                            });

                            $("#lesson_dialog").dialog("close");
                            $('#lesson_data_grid').datagrid("reload");
                        }
                    });
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#lesson_dialog").dialog("close");
                }
            }]
        });
    }
</script>
</body>
</html>
