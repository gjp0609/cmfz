<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.baizhi.entity.Admin" isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    // get admin from session
    Object ad = pageContext.getSession().getAttribute("admin");
    if (ad != null) {
        Admin admin = (Admin) ad;
        String realName = admin.getRealName();
        pageContext.setAttribute("realName", realName);
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/default/easyui.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/themes/IconExtension.css"/>">
    <script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>
    <script type="text/javascript">

        // 菜单 --------------------------------------------------------------
        $(function () {
            // get all menus
            $.get("<c:url value="/menu/getMenus"/>", "", function (objs) {
                for (var i = 0; i < objs.length; i++) {
                    var sonMenus = objs[i].sonMenus;
                    var cont = "";
                    for (var j = 0; j < sonMenus.length; j++) {
                        cont += "<a class=\"easyui-linkbutton\" ";
                        cont += "href=\"javascript:void(0)\" ";
                        cont += "onclick=\"openTab('" + sonMenus[j].text + "','" + sonMenus[j].url + "','" + sonMenus[j].icon + "')\" ";
                        cont += "data-options=\"iconCls:'icon-" + sonMenus[j].icon + "', width:'100%'\">";
                        cont += sonMenus[j].text;
                        cont += "</a><br/>";
                    }
                    $("#aa").accordion("add", {
                        title: objs[i].text,
                        content: cont,
                        selected: false,
                        iconCls: "icon-" + objs[i].icon
                    });
                }
            }, "json");
        });

        function openTab(text, url, icon) {
            console.log(text);
            console.log(url);
            console.log(icon);

            if ($("#tt").tabs("exists", text)) {
                $("#tt").tabs("select", text)
            } else {

                $("#tt").tabs("add", {
                    title: text,
                    href: "${pageContext.request.contextPath}" + url,
                    iconCls: icon,
                    closable: true,
                    onLoad: function () {
                    }
                });
            }
        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${realName}
        &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>
        &nbsp;&nbsp;<a href="<c:url value="/admin/logout"/>" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 gaozhy@zparkhr.com.cn
    </div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="aa" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>