<%@ page import="java.net.URLDecoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript">

        $(function () {
            //点击更换验证码：
            $("#captchaImage").click(function () {//点击更换验证码
                var time = new Date().getTime();
                this.src = "<c:url value="/common/getValidateImg?time="/>" + time;
            });

            //  form 表单提交
            $("#loginForm").on("submit", function () {
                $.ajax({
                    type: "post",
                    url: "<c:url value="/admin/login" />",
                    data: $("#loginForm").serialize(),
                    success: function (msg) {
                        console.log(msg);
                        if (msg === "true") location.href = "<c:url value="/main/main.jsp"/>";
                        else alert(msg);
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>

<div class="login">
    <form id="loginForm" action="" method="post">
        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    <%
                        String username = null;
                        Cookie[] cookies = request.getCookies();
                        for (Cookie ck : cookies) {
                            if (ck.getName().equals("username")) {
                                username = ck.getValue();
                                username = URLDecoder.decode(username, "UTF-8");
                            }
                        }
                        if (username != null)
                            pageContext.setAttribute("username", username);
                        else
                            pageContext.setAttribute("username", "");
                    %>
                    用户名:
                </th>
                <td>
                    <input type="text" name="username" class="text" value="${username}" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" name="password" class="text" value="" maxlength="20"
                           autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
                    <img id="captchaImage" class="captchaImage" src="<c:url value="/common/getValidateImg" />"
                         title="点击更换验证码"/>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
                <td>
                    <label>
                        <input type="checkbox" name="remember" id="isRememberUsername" value="true"/> 记住用户名
                    </label>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" value="" onclick="location.href='/'">
                    <input type="submit" class="loginButton" value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>

</body>
</html>