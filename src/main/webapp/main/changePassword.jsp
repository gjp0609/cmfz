<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.19
  Time: 20:51
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
<form id="admin_change_pwd" method="post">
    <table>
        <tr>
            <td>编号</td>
            <td>
                <input name="id" title="编号" readonly class="easyui-textbox"/></td>
        </tr>
        <tr>
            <td>登陆名</td>
            <td>
                <input name="username" title="名称"
                       class="easyui-textbox" data-options="required:true,validType:'text'"/></td>
        </tr>
        <tr>
            <td>旧密码</td>
            <td>
                <input name="oldPassword" title="旧密码"
                       class="easyui-textbox" data-options="required:true,validType:'password'"/></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td>
                <input id="admin_to_clear" name="password" title="新密码"
                       class="easyui-textbox" data-options="required:true,validType:'password'"/></td>
        </tr>
        <tr>
            <td><a id="admin_submit_btn" href="javascript:void(0)" class="easyui-linkbutton">修改</a></td>
            <td></td>
        </tr>
    </table>
</form>

<script>
    $(function () {
        $("#admin_change_pwd").form({
            url: "<c:url value="/admin/changePassword"/>",
            success: function (data) {
                console.log(data);
                $.messager.show({
                    title: "提示",
                    msg: data,
                    timeout: 3000,
                    showType: "slide"
                });
                $("#admin_chPwd").dialog("close");
                setTimeout(function () {
                    location.href = "<c:url value="/login.jsp"/>";
                }, 2000);
            },
            onLoadSuccess: function () {
                $("#admin_to_clear").textbox("clear");
            }
        }).form("load", "<c:url value="/admin/queryOne"/>");
    });

    $("#admin_submit_btn").click(function () {
        $("#admin_change_pwd").form("submit");
    });
</script>

</body>
</html>
