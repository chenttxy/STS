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
<jsp:include page="common_login.jsp"></jsp:include>
<a href="${path }/main.action">返回首页</a>
<h1>未完成订单</h1>
<table class="gridtable">
	<tr>
	    <th>订单号</th>
	    <th>商品ID</th>
	    <th>卖家ID</th>
	    <th>买家ID</th>
	    <th>交易时间</th>
	    <th>交易地址</th>
	    <th>操作</th>
	</tr>
	<c:forEach items="${orderList1 }" var="orders">
		<tr>
			<form action="${path }/orders/addOrderInfo.action">
			<input type="hidden" value="${orders.orderId }" name="orderId">
			
		    <td>${orders.orderId }</td>
		    <td>${orders.goodId }</td>
		    <td>${orders.sellerId }</td>
		    <td>${orders.userId }</td>
		    <td><input name="meetTime" type="datetime-local"></td>
		    <td><input name="meetAddress"></td>
		    <td><input type="submit" value="提交订单"></td>
		    
		    </form>
		</tr>
	</c:forEach>
</table>
<br><br><hr>
<h1>待评价订单</h1>
<table class="gridtable">
	<tr>
	    <th>订单号</th>
	    <th>商品ID</th>
	    <th>卖家ID</th>
	    <th>买家ID</th>
	    <th>交易时间</th>
	    <th>交易地址</th>
	    <th>评价详情</th>
	    <th>交易评分</th>
	    <th>操作</th>
	</tr>
	<c:forEach items="${orderList2 }" var="orders">
		<tr>
			<form action="${path }/orders/orderEvaluation.action">
			<input type="hidden" value="${orders.orderId }" name="orderId">
		    <td>${orders.orderId }</td>
		    <td>${orders.goodId }</td>
		    <td>${orders.sellerId }</td>
		    <td>${orders.userId }</td>
		    <td><fmt:formatDate value="${orders.meetTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		    <td>${orders.meetAddress }</td>
		    <td><input type="text" name="evaluationInfo"></td>
		    <td><input type="text" name="evaluationGrade"></td>
		    <td><input type="submit" value="提交"></td>
		    </form>
		</tr>
	</c:forEach>
</table>
<br><br><hr>
<h1>已完成订单</h1>
<table class="gridtable">
	<tr>
	    <th>订单号</th>
	    <th>商品ID</th>
	    <th>卖家ID</th>
	    <th>买家ID</th>
	    <th>交易时间</th>
	    <th>交易地址</th>
	    <th>评价详情</th>
	    <th>交易评分</th>
	</tr>
	<c:forEach items="${orderList3 }" var="orders">
		<tr>
		    <td>${orders.orderId }</td>
		    <td>${orders.goodId }</td>
		    <td>${orders.sellerId }</td>
		    <td>${orders.userId }</td>
		    <td><fmt:formatDate value="${orders.meetTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		    <td>${orders.meetAddress }</td>
		    <td>${orders.evaluationInfo }</td>
		    <td>${orders.evaluationGrade }</td>
		</tr>
	</c:forEach>
</table>
<br><br><hr>
</body>
</html>