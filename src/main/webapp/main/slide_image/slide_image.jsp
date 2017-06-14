<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.13
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--<html>--%>
<%--<head>--%>
<%--<title>持名法州主页</title>--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/themes/default/easyui.css"/>">--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/themes/IconExtension.css"/>">--%>
<%--<script type="text/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/js/jquery.easyui.min.js"/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/js/datagrid-detailview.js"/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/js/easyui-lang-zh_CN.js"/>"></script>--%>

<%--</head>--%>
<%--<body>--%>
<table id="slide_image_datagrid" style="height: 100%"></table>
<div id="slideImageEditDialog"></div>
<script>
    $(function () {
        $('#slide_image_datagrid').datagrid({
            pagination: true,
            pageSize: 6,
            pageList: [3, 6, 9],
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fitColumns: true,
            url: '<c:url value="/sli/queryAll"/>',
            toolbar: [{
                text: "添加",
                iconCls: 'icon-add',
                handler: function () {
                    $("#slideImageEditDialog").dialog({
                        title: '添加',
                        width: 400,
                        height: 200,
                        closed: false,
                        cache: false,
                        href: "<c:url value="/main/slide_image/slide_image_add.jsp"/>",
                        modal: true,
                        buttons: [{
                            text: '保存',
                            handler: function () {
                                $.messager.show({
                                    title: "保存成功",
                                    msg: "轮播图已添加。",
                                    timeout: 3000,
                                    showType: "slide"
                                });
                                $("#slide_image_add_form").submit();
                                $("#slide_image_add_form").form({
                                    success: function () {
                                        $("#slideImageEditDialog").dialog("close");
                                        $('#slide_image_datagrid').datagrid("load");
                                    }
                                });
                            }
                        }, {
                            text: '关闭',
                            handler: function () {
                                $("#slideImageEditDialog").dialog("close");
                            }
                        }]
                    });
                }
            }],
            columns: [[
                {field: 'id', title: '文件编号', width: 200, align: "center"},
                {field: 'src', title: '文件名', width: 120, sortable: true},
                {field: 'detail', title: '描述信息', width: 140},
                {field: 'status', title: '状态', width: 50, align: "center", sortable: true},
                {field: 'createTime', title: '创建时间', width: 120, align: "center", sortable: true},
                {field: 'updateTime', title: '上次修改时间', width: 120, align: "center", sortable: true},
                {field: 'operate', title: '操作', width: 60, align: 'center', formatter: operate}
            ]],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src=${pageContext.request.contextPath}/img/indexImages/' + rowData.src + ' style="height:200px;"></td>' +
                    '</tr></table>';
            },
            onLoadSuccess: function () {
                $.parser.parse($("a").parent());
            }
        });

    });

    function operate(value, row, index) {
        return "<a href=\"javascript:void(0)\" onclick=\"edit('" + row.id + "')\" " +
            "class=\"easyui-linkbutton asd\" data-options=\"iconCls:'icon-edit'\">修改</a>";
    }

    function edit(id) {
        slideImageId = id;
        $("#slideImageEditDialog").dialog({
            title: '修改',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            href: "<c:url value="/main/slide_image/slide_image_edit.jsp"/>",
            modal: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    $("#slide_image_edit_form").submit();
                    $("#slide_image_edit_form").form({
                        success: function () {
                            $.messager.show({
                                title: "保存成功",
                                msg: "修改已保存。",
                                timeout: 3000,
                                showType: "slide"
                            });
                            $("#slideImageEditDialog").dialog("close");
                            $('#slide_image_datagrid').datagrid("reload");
                        }
                    });
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#slideImageEditDialog").dialog("close");
                }
            }]
        });
        console.log(id);
    }

</script>
<%--</body>--%>
<%--</html>--%>
