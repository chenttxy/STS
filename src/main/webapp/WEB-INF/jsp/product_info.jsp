<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../taglibs.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>WBU</title>
    <link rel="stylesheet" href="${path }/css/index.css" />
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    <script type="text/javascript" src="${path }/js/index.bundle.js" ></script>
    <link rel="stylesheet" href="${path }/css/materialize-icon.css" />
    <link rel="stylesheet" href="${path }/css/user.css" />
    <link rel="stylesheet" href="${path }/css/detail.css" />
<script type="text/javascript">
	function addShopcart(){
		
		//判断是否为本人发布的商品，否则跳出
		var buyerId = $("#buyerId").val();
		var sellerId = $("#sellerId").val();
		if(buyerId == sellerId){
			alert("不能加购本人的商品");
			return;
		}
		
		$.ajax({
			type: "get",
			url:'${path }/shopcart/addShopcart.do?goodId=${product.goodId}',
			dataType:"json",
			async:false,
			error:function(){
		        alert('出错！')
		    },
		    success:function(data){
		    	if(data.flag1){
		    		alert("已经存在购物车中，请不要重复添加!")
		    	}else{
		    		if(data.flag){
						alert("添加成功！")
					} else{
						alert("添加失败！")
					}
		    	}
		    },
		});
	}
	
	function tipMessage(){
		alert("请先登录！")
	}
	
	function submitPrice(){
		
		var preorder = {
			goodId : $("#goodId").val(),
			money : $("#addPrice").val()
		}
		
		//判断是否为本人发布的商品，否则跳出
		var buyerId = $("#buyerId").val();
		var sellerId = $("#sellerId").val();
		if(buyerId == sellerId){
			alert("不能购买本人的商品");
			return;
		}
		
		var addMoney = $("#addPrice").val();
		var goodPrice = $("#goodPrice").val();
		if(goodPrice > addMoney){
			alert("出价请不要低于底价");
			return;
		}
		$.ajax({
			type: "post",
			url:'${path }/preorder/savePrice.do',
			dataType:"json",
			async:false,
			data:preorder,
			success:function(data){
	            if(data.flag){
	                alert("出价成功");
	                $("#addPrice").val("");
	            }else{
	                alert("失败");
	            }
	        },
	        error:function(){
	        	alert("出错！");
	        }
		});
	}
</script>
<body ng-view="ng-view">
<!--
    描述：顶部
-->
<input type="hidden" id="buyerId" value="${cur_user.userId }">
<input type="hidden" id="sellerId" value="${product.userId}">
<div ng-controller="headerController" class="header stark-components navbar-fixed ng-scope">
    <nav class="white nav1">
        <div class="nav-wrapper">
            <a href="${path }/main.do" class="logo">
                <em class="em1">武汉商学院</em>
                <em class="em2">二手市场</em>
                <em class="em3">Wbu.market</em>
            </a>
            <div class="nav-wrapper search-bar">
                <form ng-submit="search()" class="ng-pristine ng-invalid ng-invalid-required" action="${path }/product/queryListByName.do">
                    <div class="input-field">
                        <input id="search" name="goodName" placeholder="搜点什么吧233..." style="height: 40px;"
                               class="ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required"/>
                        <label for="search" class="active">
                            <i ng-click="search()" class="iconfont"><input type="submit" value=""></i>
                        </label>
                    </div>
                </form>
            </div>
            <ul class="right">
                <c:if test="${empty cur_user}">
                    <li class="publish-btn">
                        <button class="red lighten-1 waves-effect waves-light btn" 
                        	onclick="tipMessage()">
                          	我要发布
                         </button>
                    </li>
                </c:if>
                <c:if test="${!empty cur_user}">
                    <li class="publish-btn">
                        <button data-position="bottom" class="red lighten-1 waves-effect waves-light btn">
                            <a href="${path }/product/productPub.do">我要发布</a>
                        </button>
                    </li>
                    <li>
                        <a href="${path }/user/userHome.do">用户名:${cur_user.userName}</a>
                    </li>
                    <li>
                        <a>信用积分:${cur_user.userCredit }</a>
                    </li>
                    <li class="changemore">
                        <a class="changeMoreVertShow()">
                            <i class="iconfont"></i>
                        </a>
                        <div class="more-vert">
                            <ul class="dropdown-content">
                                <li><a href="${path }/shopcart/shopcartList.do">购物车</a></li>
                                <li><a href="${path }/shopcart/shopcartList.do">我的闲置</a></li>
                                <li><a onclick="ChangeName()">我的订单</a></li>
                                <li><a href="${path }/user/loginOut.do">退出登录</a></li>
                            </ul>
                        </div>
                    </li>
                </c:if>
                <c:if test="${empty cur_user}">
                    <li>
                        <a href="${path }/loginView.do">登录</a>
                    </li>
                    <li>
                        <a href="${path }/registerView.do">注册</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</div>

<!--显示商品详情-->
<div ng-controller="detailBoxController" class="detail-box stark-components z-depth-1 row ng-scope">
    <div class="col s12 path">
        <a href="#">${catelog.name}</a>
        <em>></em>
        <a>${product.goodName}</a>
    </div>
    <div class="col s6">
        <div class="slider" style="height: 440px;">
            <ul class="slides" style="height: 400px;">
                <img src="/imgUrl/${product.goodImage}"/>
            </ul>
            <ul class="indicators">
                <li class="indicator-item"></li>
                <li class="indicator-item"></li>
                <li class="indicator-item"></li>
                <li class="indicator-item"></li>
            </ul>
        </div>
    </div>
    <div class="col s6">
    	<input type="hidden" name="goodId" id="goodId" value="${product.goodId }">
        <h1 class="item-name">${product.goodName}</h1>
        <h2 class="item-price">${product.goodPrice}</h2>
        <input type="hidden" id="goodPrice" value="${product.goodPrice}">
        <div class="item-public-info">
            <p class="bargain">可讲价</p>
            <p>
                <i class="iconfont"></i>
                <em class="item-location">武汉商学院</em>
            </p>
        </div>
        <div class="publisher-info-title">
            <em>卖家信息</em><hr>
        </div>
        <c:if test="${empty cur_user}">
            <div class="item-contact">
                <p class="not-login">
                    <a href="${path }/loginView.do">登录</a>
                    <em>或</em>
                    <a href="${path }/registerView.do">注册</a>
                    <em>后查看联系信息</em>
                </p>
            </div>
        </c:if>
        <c:if test="${!empty cur_user}">
            <div class="item-contact">
            	<div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"><img src="${path }/img/xinyong.png"></i>
                    </div>
                    <div class="value">${seller.userCredit}</div>
                </div>
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value">${seller.userName}</div>
                </div>
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value">${seller.userPhone}</div>
                </div>
            </div>
            <c:if test="${product.goodType==1}">
            	<h3><a onclick="addShopcart()" style="cursor:pointer;">加购物车</a></h3><br><br>
       			<h3><a href="${path }/orders/createOrder.do?goodId=${product.goodId}">购买</a></h3>
       			<h1 class="item-pub-time">发布于 <fmt:formatDate value="${product.goodTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h1>
            </c:if>
            <br>
            <c:if test="${product.goodType==2}">
            	<h3>我的出价：</h3>
            	<input type="text" name="addPrice" id="addPrice">
            	<a onclick="submitPrice()" style="cursor: pointer;">提交我的出价</a>
            	<h1 class="item-pub-time">拍卖截止 <fmt:formatDate value="${product.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h1>
            </c:if>
            <a href="${path }/reporteView.do?goodId=${product.goodId }">举报该商品</a>
        </c:if>
    </div>
</div>
<div class="detail-box stark-components z-depth-1 row">
    <h1 class="title">商品详情</h1>
    <hr class="hr1" />
    <hr class="hr2" />
    <p class="section">${product.goodDescribe}</p>
    <p class="section"></p>
    <p class="section">
        联系我的时候，请说明是在武汉商学院二手平台上看见的哦~
    </p>
</div>

</body>
</html>