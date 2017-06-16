<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.16
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
</head>
<body>
<form id="user_edit_form" method="post">
    <table>
        <tr>
            <td>编号</td>
            <td>
                <input name="id" title="编号" readonly class="easyui-textbox"/></td>
        </tr>
        <tr>
            <td>法名</td>
            <td><input name="faName" title="账号" readonly
                       class="easyui-textbox" data-options="required:true,validType:'text'"/></td>
        </tr>
        <tr>
            <td>法名</td>
            <td><input name="phone" title="手机号" readonly
                       class="easyui-textbox" data-options="required:true,validType:'text'"/></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <select name="status" title="状态" class="easyui-combobox" style="width: 60px">
                    <option value="Y">正常</option>
                    <option value="N">封禁</option>
                </select>
            </td>
        </tr>
    </table>
</form>

<script>
    $("#user_edit_form").form({
        url: "<c:url value="/user/modify"/>"
    }).form("load", "<c:url value="/user/queryOne?id="/>" + userId);
    console.log(userId);
</script>
</body>
</html>
