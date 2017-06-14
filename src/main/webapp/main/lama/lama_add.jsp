<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.13
  Time: 19:59
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
<form id="lama_add_form" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>文件</td>
            <td>
                <input name="uploadFile" title="文件"
                       class="easyui-filebox" data-options="buttonText:'选择文件'"/></td>
        </tr>
        <tr>
            <td>法名</td>
            <td>
                <input name="lamaName" title="法名"
                       class="easyui-textbox" data-options="required:true,validType:'text'"/></td>
        </tr>
    </table>
</form>

<script>
    $(function () {
        $("#lama_add_form").form({
            url: "<c:url value="/lama/add"/>"
        });
    });
</script>
</body>
</html>
