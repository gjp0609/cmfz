<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.14
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
<table id="article_data_grid" style="height: 100%"></table>
<div id="article_dialog"></div>
<div id="article_detail"></div>
<div id="article_wait_dialog"></div>
<script>

    $("#article_data_grid").datagrid({
        url: "<c:url value="/article/queryAll"/>",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageSize: 6,
        pageList: [3, 6, 9],
        columns: [[
            {field: 'id', title: '编号', width: 130, align: 'center'},
            {field: 'title', title: '标题', width: 100},
            {field: 'lamaName', title: '作者', width: 100, formatter: article_author_operate},
            {field: 'status', title: '是否显示', width: 50, align: 'center'},
            {field: 'createTime', title: '创建时间', width: 100, align: 'right'},
            {field: 'updateTime', title: '修改时间', width: 100, align: 'right'},
            {field: 'operate', title: '操作', width: 120, align: 'center', formatter: article_operate}
        ]],
        onLoadSuccess: function () {
            $.parser.parse($("a").parent());
        }

    });
    function article_operate(value, row, index) {
        return "<a href=\"javascript:void(0)\" onclick=\"article_detail('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">查看详情</a>" +
            "<a href=\"javascript:void(0)\" onclick=\"article_edit('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">修改</a>";
    }
    function article_author_operate(value, row, index) {
        if (row.lama === undefined) return "未知";
        else return row.lama.lamaName;
    }

    function article_detail(idw) {
        $('#article_detail').window({
            width: 800,
            height: 600,
            modal: true,
            title: "文章",
            href: "<c:url value="/article/getDetail"/>?id=" + idw
        });
    }

    function article_edit(id) {
        articleId = id;
        $("#article_dialog").dialog({
            title: '修改',
            width: 850,
            height: 500,
            closed: false,
            cache: false,
            href: "<c:url value="/main/article/article_edit.jsp"/>",
            modal: true
        });
    }
</script>
</body>
</html>
