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
<table id="user_data_grid" style="height: 100%"></table>
<div id="user_dialog"></div>

<script>
    $("#user_data_grid").datagrid({
        url: "<c:url value="/user/queryAll"/>",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageSize: 9,
        pageList: [6, 9, 15],
        columns: [[
            {field: 'id', title: '编号', width: 100},
            {field: 'name', title: '姓名', width: 100},
            {field: 'faName', title: '法名', width: 100},
            {field: 'phone', title: '电话号码', width: 100},
            {field: 'src', title: '头像路径', width: 100},
            {field: 'user_img', title: '用户头像', width: 70, formatter: user_img},
            {field: 'sex', title: '性别', width: 50, align: 'center'},
            {field: 'status', title: '状态', width: 50, align: 'center'},
            {field: 'province', title: '国家', width: 100, align: 'center'},
            {field: 'area', title: '地区', width: 100},
            {field: 'sign', title: '签名', width: 100},
            {field: 'email', title: '邮箱', width: 100},
            {field: 'registerTime', title: '注册时间', width: 100},
            {field: 'lastLoginTime', title: '最近登陆', width: 100},
            {field: 'lama.name', title: '上师法名', width: 100, formatter: lama_name},
            {field: 'operate', title: '操作', width: 100, align: 'center', formatter: user_operate}
        ]],
        onLoadSuccess: function () {
            $.parser.parse($("a").parent());
        }

    });
    function user_operate(value, row, index) {
        return "<a href=\"javascript:void(0)\" onclick=\"user_edit('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">修改</a>";
    }

    function lama_name(value, row, index) {
        return row.lama.lamaName;
    }
    function user_img(value, row, index) {
        return "<img style='height: 35px; width: 35px' src='/img/user/" + row.src + "'/>";
    }

    function user_edit(id) {
        userId = id;
        $("#user_dialog").dialog({
            title: '修改',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            href: "<c:url value="/main/user/user_edit.jsp"/>",
            modal: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    $("#user_edit_form").submit().form({
                        success: function () {
                            $.messager.show({
                                title: "保存成功",
                                msg: "修改已完成。",
                                timeout: 3000,
                                showType: "slide"
                            });

                            $("#user_dialog").dialog("close");
                            $('#user_data_grid').datagrid("reload");
                        }
                    });
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#user_dialog").dialog("close");
                }
            }]
        });
    }
</script>
</body>
</html>
