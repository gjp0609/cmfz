<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.13
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/default/easyui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/IconExtension.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
    <script>
        $(function () {
            $('#tt').datagrid({
                title: 'DataGrid - DetailView',
                width: 1000,
                height: 500,
                pagination: true,
                pageSize: 2,
                pageList: [2, 4, 6],
                remoteSort: false,
                singleSelect: true,
                nowrap: false,
                fitColumns: true,
                url: '<c:url value="/sli/queryAll"/>',
                columns: [[
                    {field: 'id', title: '文件编号', width: 200, align: "center"},
                    {field: 'src', title: '文件名', width: 60, sortable: true},
                    {field: 'detail', title: '描述信息', width: 180},
                    {field: 'status', title: '状态', width: 50, align: "center", sortable: true},
                    {field: 'createTime', title: '创建时间', width: 120, align: "center", sortable: true},
                    {field: 'updateTime', title: '上次修改时间', width: 120, align: "center", sortable: true},
                    {field: 'operate', title: '操作', width: 60, align: 'center'}
                ]],
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="/img/indexImages/' + rowData.src + '" style="height:100px;"></td>' +
//                        '<td style="border:0">' +
//                        '<p>Attribute: ' + rowData.attr1 + '</p>' +
//                        '<p>Status: ' + rowData.status + '</p>' +
//                        '</td>' +
                        '</tr></table>';
                }
            });

        });
    </script>
</head>
<body>
<table id="tt"></table>

</body>
</html>
