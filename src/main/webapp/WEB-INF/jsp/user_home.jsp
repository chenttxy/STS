<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <link rel="stylesheet" href="${path }/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${path }/css/emoji.css" />
    <link rel="stylesheet" href="${path }/css/userhome.css" />
    <link rel="stylesheet" href="${path }/css/user.css" />
    
    <link rel="stylesheet" href="${path }/css/index.css" />
    <link rel="stylesheet" href="${path }/css/materialize-icon.css" />
</head>
<body>
<jsp:include page="common_login.jsp"></jsp:include>
<div class="pre-2" id="big_img">
    <img src="http://findfun.oss-cn-shanghai.aliyuncs.com/images/head_loading.gif" class="jcrop-preview jcrop_preview_s">
</div>
<div id="cover" style="min-height: 639px;">
    <div id="user_area">
        <div id="home_header">
            <!-- <a href="/goods/homeGoods">
                <h1 class="logo"></h1>
            </a> -->
            <a href="${path }/main.do">
                <div class="home"></div>
            </a>
        </div>
        <!--
            描述：左侧个人中心栏
        -->
        <div id="user_nav">
            <div class="user_info">
                <div class="head_img">
                    <img src="${path }/img/photo.jpg">
                </div>
                <div class="big_headimg">
                    <img src="">
                </div>
                <span class="name">用户名：${cur_user.userName}</span>
                <span class="name">信用积分：${cur_user.userCredit}</span>
                <span class="school">武汉商学院</span>
                <span class="name"><a href="${path }/user/updateView.do">更改个人信息</a></span>
            </div>
        </div>
        <!--
            描述：右侧内容区域
        -->
        <div id="user_content">
            <div class="share">
               <h1>我发布的二手</h1>
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
                       	   <c:if test="${product.goodStatus==1}">
                       	   		<p>正常</p>
                       	   </c:if>
                       	   <c:if test="${product.goodStatus==2}">
                       	   		<p>已卖出</p>
                       	   </c:if>
                       	   <c:if test="${product.goodStatus==3}">
                       	   		<p>被锁定</p>
                       	   </c:if>
                       	   <c:if test="${product.goodStatus==4}">
                       	   		<p>已下架</p>
                       	   </c:if>
                           <%-- <p><c:out value="${product.goodTime}"></c:out></p> --%>
                           <p><fmt:formatDate value="${product.goodTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
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
        
    </div>
                
	</div>
          
</div>
</div>
</body>
</html>