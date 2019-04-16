<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
	function checkUserPwd(){
		var oldPwd = $("#userPwd").val();
		alert(oldPwd);
		$.ajax({
			"async":false,//同步操作
			"url":"${path}/user/checkOldPwd.do",
			"type":"POST",
			"data":{
				"userPwd":oldPwd
				},
			"dataType":"json",
			"success":function(data){
				flag = data.flag;
				if(!flag){
					return flag;
				}
			},
			"error":function(){
				alert("密码错误");			
			}
		});
	}
	
	function confirmPwd(){
		var newPwd = $("#newPwd").val();
		var confirmPwd = $("#confirmPwd").val();
		if(newPwd != confirmPwd){
			alert("两次密码不一致");
		}
	}
</script>
<body>
<jsp:include page="common_login.jsp"></jsp:include>
<form action="">
	原密码：<input type="text" id="userPwd" name="userPwd" onblur="checkUserPwd()"><br><br>
	新密码：<input type="text" id="newPwd" name="userPwd"><br><br>
	确认密码：<input type="text" id="confirmPwd" name="userPwd" onblur="confirmPwd()"><br><br>
	<input type="submit" value="确认修改">
</form>
</body>
</html>