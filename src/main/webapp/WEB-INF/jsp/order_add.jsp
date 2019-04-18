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
<a href="${path }/main.do">返回首页</a>
<h1>请完善订单信息</h1>
<br>
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
		<c:if test="${not empty orderInfo }">
			<tr>
			<form action="${path }/orders/addOrderInfo.do">
			    <td>${orderInfo.orderId }</td>
			    <td>${orderInfo.goodId }</td>
			    <td>${orderInfo.sellerId }</td>
			    <td>${orderInfo.userId }</td>
			    <td><input name="meetTime" type="datetime-local"></td>
			    <td><input name="meetAddress"></td>
			    <input type="hidden" name="orderId" value="${orderInfo.orderId }">
				<td><input class="button white" type="submit" value="提交"></td>
			</form>
			</tr>
		</c:if>
		
		<c:if test="${not empty addOrderList }">
			<c:forEach items="${addOrderList }" var="orders">
				<tr>
					<form action="${path }/orders/addOrderInfo.do">
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
		</c:if>
		
		</table>
		<br>
</body>
</html>