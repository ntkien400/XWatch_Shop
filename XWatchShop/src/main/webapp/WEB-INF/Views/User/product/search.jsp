<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>
</head>
<body>
<div class="well well-small">
				<h3>Danh sách sản phẩm</h3>
				<c:if test="${ searchPaginate.size() >0 }">
					<div class="row-fluid">
						<ul class="thumbnails">
							<c:forEach var="item" items="${ searchPaginate }" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a href="product_details.html" class="overlay"></a> <a
											class="zoomTool" href="product_details.html"
											title="add to cart"><span class="icon-search"></span>
											QUICK VIEW</a> <a href="/XWatchShop/chi-tiet-san-pham/${ item.productID }"><img
											src="<c:url value ="/assets/user/watch/${ item.image }"/>" alt=""></a>
										<div class="caption cntr">
											<p>${ item.name }</p>
											<p>
												<strong><fmt:formatNumber
															type="number" groupingUsed="true"
															value="${ item.price*(100-item.sale)/100 }" />đ</strong>
											</p>
											<h4>
												<a class="shopBtn" href="#" title="add to cart"> Add to
													cart </a>
											</h4>
											<div class="actionList">
												<a class="pull-left" href="#">Add to Wish List </a> <a
													class="pull-left" href="#"> Add to Compare </a>
											</div>
											<br class="clr">
										</div>
									</div>
								</li>
								<c:if test="${ (loop.index +1) %3 ==0 || (loop.index +1) == searchPaginate.size() }">
									</ul>
									</div>
									<c:if test="${ (loop.index +1) < searchPaginate.size() }">
										<div class="row-fluid">
											<ul class="thumbnails">
									</c:if>
								</c:if>
							</c:forEach>
						</c:if>
			</div>
			<div class="pagination">
				<c:if test="${ paginatesData.totalPage >0}">
				<a href="<c:url value="/search/1?keyword=${ keyword }"/>">&laquo;</a> 
				<c:forEach var="item" begin="1" end="${ paginatesData.totalPage }" varStatus="loop">
				<c:if test="${ (loop.index) == paginatesData.currentPage }">
				<a href='<c:url value="/search/${ loop.index}?keyword=${ keyword }"/>'class="active">${ loop.index}</a>
				</c:if>
				<c:if test="${ (loop.index) != paginatesData.currentPage }">
				<a href="<c:url value="/search/${ loop.index}?keyword=${ keyword }"/>">${ loop.index}</a>
				</c:if>
				</c:forEach>
				<a href="<c:url value="/search/${ paginatesData.totalPage }?keyword=${ keyword }"/>">&raquo;</a>
				</c:if>
			</div>
</body>
</html>