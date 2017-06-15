<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.15
  Time: 10:03
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
    <script type="text/javascript" charset="utf-8"
            src="<c:url value="/main/article/ueditor/ueditor.config.js"/>"></script>
    <script type="text/javascript" charset="utf-8"
            src="<c:url value="/main/article/ueditor/ueditor.all.min.js"/>"></script>
    <script type="text/javascript" charset="utf-8"
            src="<c:url value="/main/article/ueditor/lang/zh-cn/zh-cn.js"/>"></script>

    <style>
        td:first-child {
            width: 100px;
            height: 30px;
        }
    </style>
</head>
<body>

<form id="article_edit_form" method="post" style="margin: 10px;width: 800px">
    <table>
        <tr>
            <td>文章编号：</td>
            <td>
                <input name="id" title="" readonly
                       class="easyui-textbox" style="width:300px">
            </td>
        </tr>
        <tr>
            <td>文章标题：</td>
            <td>
                <input name="title" title="文章标题"
                       class="easyui-textbox" style="width:300px">
            </td>
        </tr>
        <tr>
            <td>文章作者：</td>
            <td>
                <input id="cc" title="作者" name="lama.id" value="">
            </td>
        </tr>
        <tr>
            <td>文章状态：</td>
            <td>
                <input id="qwe" name="status" title="是否展示"
                       class="easyui-switchbutton" data-options="onText:'展示',offText:'不展示',width:80">
            </td>
        </tr>
        <tr>
            <td>文章内容：</td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2" style="width: 100%">
                <div id="edit_editor" name="content" type="text/plain"></div>
            </td>
        </tr>
        <tr>
            <td><a id="submit" href="javascript:void(0)" class="easyui-linkbutton">创建文章</a></td>
            <td><a id="reset" href="javascript:void(0)" class="easyui-linkbutton">全部重置</a></td>
        </tr>
    </table>

</form>

<script type="text/javascript">
    console.log(new Date().getTime());

    UE.delEditor("edit_editor");

    editor = UE.getEditor('edit_editor');
    $("#cc").combobox({
        url: "<c:url value="/lama/getList"/>",
        valueField: 'id',
        textField: 'lamaName'
    });

    setTimeout(function () {
        $("#article_edit_form").form({
            url: "<c:url value="/article/modify"/>",
            success: function () {
                $.messager.show({
                    title: "保存成功",
                    msg: "修改已完成。",
                    timeout: 3000,
                    showType: "slide"
                });
            }, onLoadSuccess: function (art) {
                UE.getEditor('edit_editor').setContent(art.content);
            }
        }).form("load", "<c:url value="/article/queryOne?id="/>" + articleId);
    }, 3000);


    $("#submit").click(function () {
        $("#article_edit_form").submit();
    });

    $("#reset").click(function () {
        $("#article_edit_form").form("reset");
    });
</script>

</body>
</html>
