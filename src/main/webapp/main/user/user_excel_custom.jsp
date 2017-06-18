<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.18
  Time: 17:48
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
<form id="form" method="post">
    <input id="ct" title=""/>
    <a style="margin-left: 20px" id="sub" class="easyui-linkbutton" data-options="text:'导出'"></a>
</form>

<script>


    $("#ct").combotree({
        multiple: true,
        onlyLeafCheck: true,
        data: [{
            text: "自定义导出",
            children: [{
                id: "id",
                text: "编号",
                iconCls: "icon-edit"
            }, {
                id: "name",
                text: "姓名",
                iconCls: "icon-edit"
            }, {
                id: "faName",
                text: "法名",
                iconCls: "icon-edit"
            }, {
                id: "phone",
                text: "电话号码",
                iconCls: "icon-edit"
            }, {
                id: "src",
                text: "头像路径",
                iconCls: "icon-edit"
            }, {
                id: "password",
                text: "密码",
                iconCls: "icon-edit"
            }, {
                id: "salt",
                text: "密码盐",
                iconCls: "icon-edit"
            }, {
                id: "sex",
                text: "性别",
                iconCls: "icon-edit"
            }, {
                id: "status",
                text: "状态",
                iconCls: "icon-edit"
            }, {
                id: "province",
                text: "省份",
                iconCls: "icon-edit"
            }, {
                id: "area",
                text: "地区",
                iconCls: "icon-edit"
            }, {
                id: "sign",
                text: "签名",
                iconCls: "icon-edit"
            }, {
                id: "email",
                text: "邮箱",
                iconCls: "icon-edit"
            }, {
                id: "registerTime",
                text: "注册时间",
                iconCls: "icon-edit"
            }, {
                id: "lastLoginTime",
                text: "最近登陆",
                iconCls: "icon-edit"
            }, {
                id: "loginRecord",
                text: "登陆记录",
                iconCls: "icon-edit"
            }]
//            {
//                id: "lama",
//                text: "登陆记录",
//                iconCls: "icon-edit"
//            }
        }]
    });
</script>

</body>
</html>
