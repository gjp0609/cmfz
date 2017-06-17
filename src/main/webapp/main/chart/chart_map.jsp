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
    <script type="text/javascript" src="<c:url value="/js/china.js"/>"></script>
</head>
<body>
<div id="chart_login" style="width: 100%;height:100%;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart_login'));
    //    require.config

    function randomData() {
        return Math.round(Math.random() * 2000);
    }

    var obj;
    obj = [{}, {}];

    option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: '2017年6月15日 最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        // 说明
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        // 工具箱
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{"name": "台湾", "value": randomData()},
                    {"name": "河北", "value": randomData()},
                    {"name": "山西", "value": randomData()},
                    {"name": "内蒙古", "value": randomData()},
                    {"name": "辽宁", "value": randomData()},
                    {"name": "吉林", "value": randomData()},
                    {"name": "黑龙江", "value": randomData()},
                    {"name": "江苏", "value": randomData()},
                    {"name": "浙江", "value": randomData()},
                    {"name": "安徽", "value": randomData()},
                    {"name": "福建", "value": randomData()},
                    {"name": "江西", "value": randomData()},
                    {"name": "山东", "value": randomData()},
                    {"name": "河南", "value": randomData()},
                    {"name": "湖北", "value": randomData()},
                    {"name": "湖南", "value": randomData()},
                    {"name": "广东", "value": randomData()},
                    {"name": "广西", "value": randomData()},
                    {"name": "海南", "value": randomData()},
                    {"name": "四川", "value": randomData()},
                    {"name": "贵州", "value": randomData()},
                    {"name": "云南", "value": randomData()},
                    {"name": "西藏", "value": randomData()},
                    {"name": "陕西", "value": randomData()},
                    {"name": "甘肃", "value": randomData()},
                    {"name": "青海", "value": randomData()},
                    {"name": "宁夏", "value": randomData()},
                    {"name": "新疆", "value": randomData()},
                    {"name": "北京", "value": randomData()},
                    {"name": "天津", "value": randomData()},
                    {"name": "上海", "value": randomData()},
                    {"name": "重庆", "value": randomData()},
                    {"name": "香港", "value": randomData()},
                    {"name": "澳门", "value": randomData()}]
            },
            {
                name: '女',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{"name": "台湾", "value": randomData()},
                    {"name": "河北", "value": randomData()},
                    {"name": "山西", "value": randomData()},
                    {"name": "内蒙古", "value": randomData()},
                    {"name": "辽宁", "value": randomData()},
                    {"name": "吉林", "value": randomData()},
                    {"name": "黑龙江", "value": randomData()},
                    {"name": "江苏", "value": randomData()},
                    {"name": "浙江", "value": randomData()},
                    {"name": "安徽", "value": randomData()},
                    {"name": "福建", "value": randomData()},
                    {"name": "江西", "value": randomData()},
                    {"name": "山东", "value": randomData()},
                    {"name": "河南", "value": randomData()},
                    {"name": "湖北", "value": randomData()},
                    {"name": "湖南", "value": randomData()},
                    {"name": "广东", "value": randomData()},
                    {"name": "广西", "value": randomData()},
                    {"name": "海南", "value": randomData()},
                    {"name": "四川", "value": randomData()},
                    {"name": "贵州", "value": randomData()},
                    {"name": "云南", "value": randomData()},
                    {"name": "西藏", "value": randomData()},
                    {"name": "陕西", "value": randomData()},
                    {"name": "甘肃", "value": randomData()},
                    {"name": "青海", "value": randomData()},
                    {"name": "宁夏", "value": randomData()},
                    {"name": "新疆", "value": randomData()},
                    {"name": "北京", "value": randomData()},
                    {"name": "天津", "value": randomData()},
                    {"name": "上海", "value": randomData()},
                    {"name": "重庆", "value": randomData()},
                    {"name": "香港", "value": randomData()},
                    {"name": "澳门", "value": randomData()}]
            }
        ]
    };
    myChart.setOption(option);

    //    $(function () {
    //        $.post("", function (data) {
    //            console.log(data);
    //            myChart.setOption({
    //                series: [{
    //                    // 根据名字对应到相应的系列
    //                    name: '男',
    //                    data: data
    //                }]
    //            });
    //        }, "json");
    //
    //        $.post("", function (data) {
    //            console.log(data);
    //            myChart.setOption({
    //                series: [{
    //                    // 根据名字对应到相应的系列
    //                    name: '女',
    //                    data: data
    //                }]
    //            });
    //        }, "json");
    //    });
</script>
</body>
</html>
