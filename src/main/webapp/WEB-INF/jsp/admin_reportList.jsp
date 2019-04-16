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
<body>
<table class="gridtable">
	<tr>
	    <th>举报信息ID</th>
	    <th>举报详情</th>
	    <th>举报时间</th>
	    <th>举报人ID</th>
	    <th>被举报商品ID</th>
	    <th>操作</th>
	</tr>
	<c:forEach items="${reporteList }" var="reporte">
		<tr>
			<td>${reporte.reporteId }</td>
			<td>${reporte.reporteInfo }</td>
			<td>
				<fmt:formatDate value="${reporte.reporteTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>${reporte.userId }</td>
			<td>${reporte.goodId }</td>
			<td>
				<a onclick="changeStatus('${user.userId}', '${user.userStatus }')" style="cursor:pointer;">更改用户状态</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>