<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path }/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${path }/css/emoji.css" />
    <link rel="stylesheet" href="${path }/css/userhome.css" />
    <link rel="stylesheet" href="${path }/css/user.css" />
    
    <link rel="stylesheet" href="${path }/css/index.css" />
    <link rel="stylesheet" href="${path }/css/materialize-icon.css" />
</head>
<body>
<jsp:include page="common_login.jsp"></jsp:include>
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
                           <p>武汉商学院</p>
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

</body>
</html>