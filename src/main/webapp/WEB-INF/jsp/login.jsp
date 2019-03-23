<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>log-in</title>
    <link rel="stylesheet" href="${path }/css/common_form.css">
</head>
<body>
    <header>
        <div class="header-line"></div>
    </header>
    <div class="content">
        <img class="content-logo" src="${path }/img/form_logo.png" alt="logo">
        <h1 class="content-title">登录</h1>
        <div class="content-form">
            <form method="post" action="${path }/user/login.action" onsubmit="return submitTest()">
                <div id="change_margin_1">
                    <input class="userName" type="text" id="userName" name="userName" placeholder="请输入用户名" onblur="oBlur_1()" onfocus="oFocus_1()">
                </div>
                <!-- input的value为空时弹出提醒 -->
                <p id="remind_1"></p>
                <div id="change_margin_2">
                    <input class="userPwd" type="password" id="userPwd" name="userPwd" placeholder="请输入密码" onblur="oBlur_2()" onfocus="oFocus_2()">
                </div>
                <!-- input的value为空时弹出提醒 -->
                <p id="remind_2"></p>
                <div id="change_margin_3">
                    <input class="content-form-signup" type="submit" value="登录">
                </div>
            </form>
        </div>
        <div class="content-login-description">没有账户？</div>
        <div><a class="content-login-link" href="register.jsp">注册</a></div>
    </div>
<script type="text/javascript">
//用户框失去焦点后验证value值
function oBlur_1() {
	var a = document.getElementById("userName").value;
    if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    } else { //用户框value值不为空
        document.getElementById("remind_1").innerHTML = "";
        document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
    }
}
//密码框失去焦点后验证value值
function oBlur_2() {
	var b = document.getElementById("userPwd").value;
    if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
}
//用户框获得焦点的隐藏提醒
function oFocus_1() {
    document.getElementById("remind_1").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
}
//密码框获得焦点的隐藏提醒
function oFocus_2() {
    document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
}
//若输入框为空，阻止表单的提交
function submitTest() {
	var a = document.getElementById("userName").value;
	var b = document.getElementById("userPwd").value;
    if (!a && !b) { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (!a) { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (!b) { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }
}
</script>
</body>
</html>