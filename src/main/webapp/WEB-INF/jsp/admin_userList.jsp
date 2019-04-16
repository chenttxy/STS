<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/css/common_table.css" />
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
</head>
<script type="text/javascript">
function changeStatus(userId, userStatus){
	if(userStatus == 1){
		if(window.confirm('你确定要锁定该用户么？')){
	        userStatus = 2;
	     }else{
	        return false;
	    }
	}else if(userStatus == 2){
		if(window.confirm('你确定要解锁该用户么？')){
	        userStatus = 1;
	     }else{
	        return false;
	    }
	}
	window.location.href = "${path}/admin/updateUserStatus.do?"+
							"userId="+userId+"&userStatus="+userStatus;
	
}
</script>
<body>
<table class="gridtable">
	<tr>
	    <th>用户ID</th>
	    <th>用户名</th>
	    <th>用户手机</th>
	    <th>用户信用积分</th>
	    <th>用户状态</th>
	    <th>操作</th>
	</tr>
	<c:forEach items="${userList }" var="user">
		<tr>
			<td>${user.userId }</td>
			<td>${user.userName }</td>
			<td>${user.userPhone }</td>
			<td>${user.userCredit }</td>
			<td>
				<c:if test="${user.userStatus==1}">
				正常
				</c:if>
				<c:if test="${user.userStatus==2}">
				被锁定
				</c:if>
			</td>
			<td>
				<a onclick="changeStatus('${user.userId}', '${user.userStatus }')" style="cursor:pointer;">更改用户状态</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>