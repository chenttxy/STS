<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String goodId = (String)request.getAttribute("goodId");
%>
<form action="${path }/user/reporteAdd.do">
<h2>请输入举报理由：</h2>
<input type="hidden" name="goodId" value="<%=goodId%>">
<textarea style="font-size:20px;" rows="10" cols="70" name="reporteInfo"></textarea><br><br>
<input type="submit" value="提交">
</form>
</body>
</html>