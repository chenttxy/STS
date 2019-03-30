<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${path }/css/common_table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>请完善订单信息</h1>
<br>
<form action="${path }/orders/addOrderInfo.action">
	<table class="gridtable">
		<tr>
		    <th>订单号</th>
		    <th>商品ID</th>
		    <th>卖家ID</th>
		    <th>买家ID</th>
		    <th>交易时间</th>
		    <th>交易地址</th>
		</tr>
		<tr>
		    <td>${orderInfo.orderId }</td>
		    <td>${orderInfo.goodId }</td>
		    <td>${orderInfo.sellerId }</td>
		    <td>${orderInfo.userId }</td>
		    <td><input name="meetTime" type="datetime-local"></td>
		    <td><input name="meetAddress"></td>
		</tr>
		
		</table>
		<br>
		<input type="hidden" name="orderId" value="${orderInfo.orderId }">
		<input class="button white" type="submit" value="提交">
</form>
</body>
</html>