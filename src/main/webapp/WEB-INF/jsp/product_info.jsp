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
                <form ng-submit="search()" class="ng-pristine ng-invalid ng-invalid-required" action="${path }/product/queryListByName.action">
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
                        <button ng-click="showLogin()" data-position="bottom" data-delay="50"
                        		data-toggle="popover" title="弹出框标题" data-content="弹出框内容"
                                data-tooltip="需要先登录哦！" class="red lighten-1 waves-effect waves-light btn" data-tooltip-id="510d3084-e666-f82f-3655-5eae4304a83a"	>
                            我要发布</button>
                    </li>
                </c:if>
                <c:if test="${!empty cur_user}">
                    <li class="publish-btn">
                        <button data-position="bottom" class="red lighten-1 waves-effect waves-light btn">
                            <a href="${path }/product/productPub.action">我要发布</a>
                        </button>
                    </li>
                    <li>
                        <a href="/user/allGoods">我发布的商品</a>
                    </li>
                    <li>
                        <a>${cur_user.userName}</a>
                    </li>
                    <li class="notification">
                        <i ng-click="showNotificationBox()" class="iconfont"></i>
                        <div ng-show="notification.tagIsShow" class="notification-amount red lighten-1 ng-binding ng-hide">0 </div>
                    </li>
                    <li class="changemore">
                        <a class="changeMoreVertShow()">
                            <i class="iconfont"></i>
                        </a>
                        <div class="more-vert">
                            <ul class="dropdown-content">
                                <li><a href="/user/home">个人中心</a></li>
                                <li><a>消息</a></li>
                                <li><a onclick="ChangeName()">更改用户名</a></li>
                                <li><a href="/user/logout">退出登录</a></li>
                            </ul>
                        </div>
                    </li>
                </c:if>
                <c:if test="${empty cur_user}">
                    <li>
                        <a href="${path }/loginView.action">登录</a>
                    </li>
                    <li>
                        <a href="${path }/register.jsp">注册</a>
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
                <img src="#"/>
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
        <h1 class="item-name">${product.goodName}</h1>
        <h2 class="item-price">${product.goodPrice}</h2>
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
                    <a onclick="showLogin()">登录</a>
                    <em>或</em>
                    <a onclick="showSignup()">注册</a>
                    <em>后查看联系信息</em>
                </p>
            </div>
        </c:if>
        <c:if test="${!empty cur_user}">
            <div class="item-contact">
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value">${seller.username}</div>
                </div>
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value">${seller.phone}</div>
                </div>
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value">${seller.qq}</div>
                </div>
                <div>
                    <div class="base-blue z-depth-1 attr">
                        <i class="iconfont"></i>
                    </div>
                    <div class="value"></div>
                </div>
            </div>
        </c:if>
        <h1 class="item-pub-time">发布于 <fmt:formatDate value="${product.goodTime}" pattern="yyyy-MM-dd HH:mm:ss"/></h1>
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
<div class="row detail-area">
    <div class="clo s12">
        <div ng-controller="commentController" class="comment stark-components z-depth-1 ng-scope">
            <h1 class="title">评论</h1>
            <hr class="hr1" />
            <hr class="hr2" />
            <div class="comment-collection">
                <div class="comment-item ng-scope">
                    <div class="comment-main-content">
                        <em class="name ng-binding">hlk_1135:</em>
                        <em class="ng-hide">回复</em>
                        <em class="name ng-binding ng-hide">@:</em>
                        <em class="ng-binding">不错。</em>
                    </div>
                    <div class="comment-function">
                        <em class="time ng-biinding">2017/05/15 16:45:54</em>
                        <a class="reply-or-delete">删除</a>
                        <a class="reply-or-delete">回复</a>
                    </div>
                </div>
            </div>
            <div class="comment-add row">
                <div class="input-field col s12">
                    <i class="iconfont prefix"></i>
                    <input id="commentbox" type="text" class="validate ng-pristine ng-untouched ng-valid ng-empty"/>
                    <label for="commentbox">这里写下评论</label>
                    <button type="submit" class="waves-effect wave-light btn comment-submit">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>