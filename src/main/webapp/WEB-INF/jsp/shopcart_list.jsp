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
	<a href="${path }/main.action">返回首页</a>
		<div class="body">
			<div class="shop" style="height: 101px;"><i></i>
			<span><h1>我的购物车</h1></span>
				<input type="checkbox" id="quanxuan" />全选<br/>
			</div>
			<div class="product">
			<c:forEach items="${shopcartList }" var="shopcart">
				<div class="product-box">
					<div class="product-ckb"><!-- <em class="product-em"></em> -->
						<input type="checkbox" class="qx" value="${shopcart.goodPrice }">
					</div>
					<div class="product-sx">
						<a href="###">
							<img src="/imgUrl/${shopcart.goodImage}" class="product-img" />
							<span class="product-name">${shopcart.goodName }</span>
						</a>
						<span class="product-price">¥&thinsp;<span id="price" class="price">${shopcart.goodPrice }</span></span>
						<div class="product-amount">
							<!-- <div class="product_gw">
							   <em class="product-jian">-</em>
							   <input type="text" value="1" class="product-num"/>
							   <em class="product-add">+</em>
							</div> -->
						</div>
						<div class="product-del"><img src="${path }/img/deleteico.png"/></div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="product-js">
				<!-- <div class="product-al">
					<div class="product-all">
						<em class=""></em>
					</div>
					<div class="all-xz">
					<span class="product-all-qx">全选</span>
					<div class="all-sl" style="display: none;">(<span class="product-all-sl">0</span>)</div></div>
				</div> -->
				<a href="${path }/orders/createOrder.action?goodId=2" class="product-sett product-sett-a">结算</a>
				<div class="all-product"><span class="all-product-a">¥&thinsp;<span class="all-price">296</span></span></div>
			</div><br>
		</div>
		<!--购物车空-->
		<div class="kon-cat">
			<div class="catkon">
				<div class="kon-box">
					<div class="kon-hz">
						<img src="img/cart-air.png" />
						<span class="kon-wz">购物车什么都没有</span>
						<a href="###" class="kon-lj">去逛逛</a>
					</div>
				</div>
			</div>
		</div>
		
	</body>
	<script src="${path }/js/jquery-3.1.1.min.js"></script>
	<script src="${path }/js/shoppingcart.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
	$("#quanxuan").click(function(){//给全选按钮加上点击事件
        var xz = $(this).prop("checked");//判断全选按钮的选中状态
        var ck = $(".qx").prop("checked",xz);  //让class名为qx的选项的选中状态和全选按钮的选中状态一致。  
    });
	
	$("#getValue").click(function(){
		var valArr = new Array;
		$("#list :checkbox[checked]").each(function(i){
		valArr[i] = $(this).val();
		});
		var vals = valArr.join(',');//转换为逗号隔开的字符串 join 拼合
		alert(vals);
	});
	
	//计算产品价格
	function TotalPrice(){
		
        $(".all-price").text(result); //输出全部总价
	}
	</script>
</html>
