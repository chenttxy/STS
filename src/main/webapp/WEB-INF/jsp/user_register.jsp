<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>sign-up</title>
    <link rel="stylesheet" href="${path }/css/common_form.css">
</head>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-validate/1.19.0/jquery.validate.min.js"></script>
<script type="text/javascript">
$.validator.addMethod(
		//自定义校验规则的名称
		"checkUsername",
		//自定义校验规则的实现
		function(value,element,params){
			//value)表单元素值
			//element)校验的元素对象
			//params)校验规则输入的参数
			var flag = true;
			$.ajax({
				async:false,//同步操作
				url:"${path}/user/checkUsername.do",
				type:"POST",
				data:{
					"userName":value
					},
				dataType:"json",
				success:function(data){
					flag = data.flag;
				},
				error:function(){
					alert("出错")			
				}
			});
			return !flag;
		}
	)
	

$.validator.addMethod(
		//自定义校验规则的名称
		"checkPhoneNum",
		//自定义校验规则的实现
		function(value,element,params){
			//value)表单元素值
			//element)校验的元素对象
			//params)校验规则输入的参数
			var flag = true;
			var checkPhoneNum = 'checkPhoneNum';
			$.ajax({
				"async":false,//同步操作
				"url":"${path}/user/checkPhoneNum.do",
				"type":"POST",
				"data":{
					"telephone":value,
					},
				"dataType":"json",
				"success":function(data){
					flag = data.flag;
				},
				"error":function(){
					alert("手机已被注册过")			
				}
			});
			return !flag;
		}
	) 
	
	
$.validator.addMethod(
		//自定义校验规则的名称
		"checkIdentityNum",
		//自定义校验规则的实现
		function(value,element,params){
			//value)表单元素值
			//element)校验的元素对象
			//params)校验规则输入的参数
			var flag = false;
			$.ajax({
				"async":false,//同步操作
				"url":"${path}/user/checkIdentityNum.do",
				"type":"POST",
				"data":{
					"identityNum":value,
					},
				"dataType":"json",
				"success":function(data){
					flag = data.flag;
				},
				"error":function(){
					alert("出错")			
				}
			});
			return flag;
		}
	) 	

	
$(function(){
	$("#registerForm").validate({
		rules:{
			"userName":{
				"required":true,
				"checkUsername":true
			},
			"userPwd":{
				"required":true,
				"rangelength":[6,12]
			},
			"confirmpwd":{
				"required":true,
				"rangelength":[6,12],
				"equalTo":"#userPwd"
			},
			"userPhone":{
				"required":true,
				"rangelength":[11,11],
				"checkPhoneNum":true
			},
			"identityNum":{
				"required":true,
				"rangelength":[6,6],
				"checkIdentityNum":true
			}
			
		},
		messages:{
			"userName":{
				"required":"用户名不能为空",
				"checkUsername":"用户名已存在"
			},
			"userPwd":{
				"required":"密码不能为空",
				"rangelength":"密码长度在6-12位"
			},
			"confirmpwd":{
				"required":"确认密码不能为空",
				"rangelength":"确认密码长度在6-12位",
				"equalTo":"两次密码不一致"
			},
			"userPhone":{
				"required":"手机号码不能为空",
				"rangelength":"号码格式不正确",
				"checkPhoneNum":"手机已被注册"
			},
			"identityNum":{
				"required":"验证码不能为空",
				"rangelength":"验证码格式不正确",
				"checkIdentityNum":"验证码错误"
			}
		},
		errorPlacement: function (error, element) {//指定错误信息位置
			 error.appendTo(element.parent().next()); 
		}
	});
})
</script>

<script>	
function sendMsg(){
	var method = 'sendMsg';
	var telephone = $("#phoneNum").val();
	$.ajax({
		url:"${path }/user/sendMsg.do",
		type:"post",
		dataType:"json",
		data:{
			"phoneNum":telephone
		}
	});
	alert("验证码已发送...");
}
</script>

<body>
    <header>
        <div class="header-line"></div>
    </header>
    <div class="content">
        <img class="content-logo" src="${path }/img/form_logo.png" alt="logo">
        <h1 class="content-title">注册</h1>
        <div class="content-form">
            <form method="post" action="${path }/user/saveUser.do" name="registerForm" id="registerForm">
                <div id="change_margin_1">
                    <input class="inputForm" type="text" name="userName" placeholder="请输入用户名">
                </div><p id="remind"></p>
                
                <div id="change_margin_2">
                    <input class="inputForm" id="userPwd" type="password" name="userPwd" placeholder="请输入密码">
                </div>
                <p id="remind"></p>
                
                <div id="change_margin_3">
                    <input class="inputForm" type="password" name="confirmpwd" placeholder="请确认密码">
                </div>
                <!-- input的value为空时弹出提醒 -->
                <p id="remind"></p>
                
                <div id="change_margin_4">
                    <input class="inputForm" id="phoneNum" type="text" name="userPhone" placeholder="请输入手机号码">
                </div>
                <!-- input的value为空时弹出提醒 -->
                <p id="remind_phone"></p>
                
                <div id="change_margin_4">
                	<a class="inputForm" onclick="sendMsg()" style="cursor:pointer">发送验证码</a>
                </div>
                
                <div id="change_margin_5">
                    <input class="inputForm" type="text" name="identityNum" placeholder="请输入验证码">
                </div>
                <!-- input的value为空时弹出提醒 -->
                <p id="remind"></p>
                
                <div id="change_margin_3">
                    <input class="content-form-signup" type="submit" value="创建账户">
                </div>
            </form>
        </div>
        <div class="content-login-description">已经拥有账户？</div>
        <div><a class="content-login-link" href="${path }/loginView.do">登录</a></div>
    </div>
</body>
</html>