<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.18
  Time: 17:03
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
<table id="log_data_grid" style="height: 100%"></table>
<div id="log_dialog"></div>

<script>
    $("#log_data_grid").datagrid({
        url: "<c:url value="/log/queryAll"/>",
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        pageSize: 9,
        nowrap: false,
        pageList: [6, 9, 15],
        columns: [[
            {field: 'id', title: '编号', width: 120, align: "center"},
            {field: 'createUsername', title: '操作用户名', width: 45, align: "center"},
            {field: 'createTime', title: '时间', width: 60, align: "center"},
            {field: 'content', title: '详细内容', width: 200},
            {field: 'action', title: '类型', width: 40, align: "center"}
        ]]
    });
</script>
</body>
</html>
