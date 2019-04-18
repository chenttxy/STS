<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0">
		<title>购物车</title>
		<link rel="stylesheet" type="text/css" href="${path }/css/shoppingcart.css"/>
	</head>
	<body>
	<jsp:include page="common_login.jsp"></jsp:include>
	<a href="${path }/main.do">返回首页</a>
		<div class="body">
			<div class="shop" style="height: 101px;"><i></i>
			<span><h1>我的购物车</h1></span>
			</div>
			<div class="product">
			<c:forEach items="${shopcartList }" var="shopcart">
				<div class="product-box">
					<div class="product-ckb">
					<em class="product-em">${shopcart.goodId }</em>
					</div>
					<div class="product-sx">
						<a href="###">
							<img src="/imgUrl/${shopcart.goodImage}" class="product-img" />
							<span class="product-name">${shopcart.goodName }</span>
						</a>
						<span class="product-price">¥&thinsp;<span id="price" class="price">${shopcart.goodPrice }</span></span>
						<div class="product-amount">
							<div class="product_gw">
							   <em class="product-jian">-</em>
							   <input type="text" value="1" class="product-num"/>
							   <em class="product-add">+</em>
							</div>
						</div>
						<div class="product-del"><img src="${path }/img/deleteico.png"/>
							<input type="hidden" value="${shopcart.goodId }">
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="product-js">
				<div class="product-al">
					<div class="product-all">
						<em class=""></em>
					</div>
					<div class="all-xz">
					<span class="product-all-qx">全选</span>
					<div class="all-sl" style="display: none;">(<span class="product-all-sl">0</span>)</div></div>
				</div>
				<a onclick="jiesuan()" class="product-sett product-sett-a">结算</a>
				<div class="all-product"><span class="all-product-a">¥&thinsp;<span class="all-price">296</span></span></div>
			</div><br>
		</div>
		<!--购物车空-->
		<div class="kon-cat">
			<div class="catkon">
				<div class="kon-box">
					<div class="kon-hz">
						<img src="${path }/img/cart-air.png" />
						<span class="kon-wz">购物车什么都没有</span>
						<a href="${path }/main.do" class="kon-lj">去逛逛</a>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script src="${path }/js/shoppingcart.js" type="text/javascript" charset="utf-8"></script>
</html>
