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
   
<script type="text/javascript">
function tipMessage(){
	alert("请先登录！")
}
</script>
<body ng-view="ng-view">
<!--
    描述：顶部
-->
<div ng-controller="headerController" class="header stark-components navbar-fixed ng-scope">
    <nav class="white nav1">
        <div class="nav-wrapper">
            <a href="#" class="logo">
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
                    <!-- <li class="notification"> -->
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
                                <li><a href="${path }/orders/orderList.do">我的订单</a></li>
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

<!--
    描述：左侧导航条
-->
<div ng-controller="sidebarController" class="sidebar stark-components ng-scope">
    <li ng-class="{true: 'active'}[isAll]">
        <a href="${path }/main.do" class="index">
            <img src="${path }/img/index.png">
            <em>最新发布</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isAll]">
        <a href="${path }/product/productList.do" class="index">
            <img src="${path }/img/paimai.png">
            <em>拍卖专区</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isDigital]">
        <a href="${path }/product/productList.do?cid=1" class="digital">
            <img src="${path }/img/digital.png"  />
            <em>闲置数码</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isRide]">
        <a href="${path }/product/productList.do?cid=2" class="ride">
            <img src="${path }/img/ride.png"/>
            <em>校园代步</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isCommodity]">
        <a href="${path }/product/productList.do?cid=3" class="commodity">
            <img src="${path }/img/commodity.png"/>
            <em>电器日用</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isBook]">
        <a href="${path }/product/productList.do?cid=4" class="book">
            <img src="${path }/img/book.png"/>
            <em>图书教材</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isMakeup]">
        <a href="${path }/product/productList.do?cid=5" class="makeup">
            <img src="${path }/img/makeup.png"/>
            <em>美妆衣物</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isSport]">
        <a href="${path }/product/productList.do?cid=6" class="sport">
            <img src="${path }/img/sport.png"/>
            <em>运动棋牌</em>
        </a>
    </li>
    <li ng-class="{true: 'active'}[isSmallthing]">
        <a href="${path }/product/productList.do?cid=7" class="smallthing">
            <img src="${path }/img/smallthing.png"/>
            <em>票券小物</em>
        </a>
    </li>
    <div class="info">
        <a href="" target="_blank">关于我们</a><em>-</em>
        <a href="">联系我们</a>
        <p>©2019 武汉商学院</p>
    </div>
</div>
<!--
    描述：右侧显示部分
-->
<div class="main-content">
    <!--
        描述：商品列表
    -->
    <div class="index-title">
        <a href="">${categoryName }</a>
        <hr class="hr1">
        <hr class="hr2">
    </div>
    <div class="waterfoo stark-components row">
           <c:forEach var="product" items="${pageInfo.list}">
           	<div class="item-wrapper normal">
               <div class="card col">
                   <a href="${path }/product/productInfo.do?goodId=${product.goodId}">
                       <div class="card-image">
                           <img src="/imgUrl/${product.goodImage}" />
                       </div>
                       <div class="card-content item-price"><c:out value="${product.goodPrice}"></c:out></div>
                       <div class="card-content item-name">
                           <p><c:out value="${product.goodName}"></c:out></p>
                       </div>
                       <div class="card-content item-location">
                           <p>武汉商学院</p>
                           <c:if test="${product.goodType==1}">
                           		<p><fmt:formatDate value="${product.goodTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                           </c:if>
                           <c:if test="${product.goodType==2}">
                           		拍卖截止时间：
                           		<p><fmt:formatDate value="${product.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                           </c:if>
                       </div>
                   </a>
               </div>
               </div>
           </c:forEach>
    </div>
    
     <!-- 分页 -->
            <div style="text-align: center">
			        <p>当前 ${pageInfo.pageNum }页,总${pageInfo.pages } 页,总
			            ${pageInfo.total } 条记录</p>
			    </div>
			    <%-- <a href="?pageNo=${pageInfo.firstPage}">首页</a>
			    <c:if test="${pageInfo.hasPreviousPage }">
			        <a href="?pageNo=${pageInfo.pageNum-1}">上一页</a>
			    </c:if>
			
			    <c:if test="${pageInfo.hasNextPage }">
			        <a href="?pageNo=${pageInfo.pageNum+1}">下一页</a>
			    </c:if>
			
			    <a href="?pageNo=${pageInfo.lastPage}">最后页</a> --%>
			    
			    <div style="text-align: center" class="pagination">
				    <span class="disabled" title="首页"><a href="?pageNo=${pageInfo.firstPage}&cid=${cid}">首页</a></span>
				    <span class="disabled" title="上一页">
					    <c:if test="${pageInfo.hasPreviousPage }">
					        <a href="?pageNo=${pageInfo.pageNum-1}&cid=${cid}">上一页</a>
					    </c:if>
			    	</span>
				    <span class="disabled" title="下一页">
				    	<c:if test="${pageInfo.hasNextPage }">
					        <a href="?pageNo=${pageInfo.pageNum+1}&cid=${cid}">下一页</a>
					    </c:if>
				    </span>
				    <span><a href="?pageNo=${pageInfo.lastPage}&cid=${cid}">最后页</a></span>
				</div>
				<br><br>
</div>
</body>
</html>