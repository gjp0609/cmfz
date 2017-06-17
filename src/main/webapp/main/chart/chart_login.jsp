<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.6.16
  Time: 19:38
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
    <script type="text/javascript" src="<c:url value="/js/echarts.js"/>"></script>
</head>
<body>
<div id="chart_login" style="width: 100%;height:100%;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart_login'));
    //    require.config

    $.get('<c:url value="/user/chart1"/>').done(function (data) {
        myChart.setOption({
            title: {
                text: '年度用户登录统计'
            },
            tooltip: {},
            legend: {
                data: ['总登陆次数']
            },
            xAxis: {
                data: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                    "11", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                    "31", "32", "33", "34", "35", "36", "37", "38", "39", "30",
                    "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52"]
            },
            yAxis: {},
            series: [{
                name: '总登陆次数',
                type: 'bar',
                data: data
            }]
        });
    });
</script>
</body>
</html>
