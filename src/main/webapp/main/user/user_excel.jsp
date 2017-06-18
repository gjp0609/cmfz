<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.17
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/black/easyui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/IconExtension.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
<style>
    ul {
        padding-left: 0;
    }

    #ul123 li {
        margin: 20px;
    }
</style>
<ul id="ul123">
    <li>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="exportAll()">全部导出</a>
    </li>
    <li>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="customExport()">自定义导出</a>
    </li>
    <li>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="">下载导入模板</a>
    </li>
    <li>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="">导入数据</a>
    </li>
</ul>
<div id="dia"></div>

<script>
    function exportAll() {
        $.messager.confirm('导出确认', '您确认全部导出吗？', function (r) {
            if (r) {
                location.href = "<c:url value="/user/getAllData"/>"
            }
        });
    }

    function customExport() {
        $("#dia").dialog({
            title: '自定义导出',
            closed: false,
            cache: false,
            modal: true,
            width: 350,
            height: 400,
            href: "<c:url value="/main/user/user_excel_custom.jsp"/>",
            onLoad: function () {
                $("#sub").linkbutton({
                    onClick: function () {
                        console.log("click");
                        var ct = $("#ct");
                        var text = ct.combotree("getText");
                        var values = ct.combotree("getValues");
                        console.log(text);
                        console.log(values);
                        $("form").form("submit", {
                            url: "<c:url value="/user/customExport"/>",
                            queryParams: {"text": text, "values": values}
                        });
                    }
                });
            }
        });
    }

</script>

</body>
</html>
