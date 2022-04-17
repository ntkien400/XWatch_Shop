<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thương hiệu</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<h3>Thương hiệu</h3>
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ brands }">
						<li><a href="<c:url value="/thuong-hieu/${ item.brandname }"/>"><span
								class="icon-chevron-right"></span>${ item.brandname }</a></li>
					</c:forEach>
				</ul>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<c:forEach var="item" items="${ productsPaginate }" begin="0" end="1">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="<c:url value="/chi-tiet-san-pham/${ item.productID }"/>"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="<c:url value ="/assets/user/watch/${ item.image }"/>"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="shopBtn" href="<c:url value="/add-cart/${ item.productID }"/>">Thêm</a> <span
									class="pull-right"><fmt:formatNumber
															type="number" groupingUsed="true"
															value="${ item.price *(100-item.sale)/100 }" />đ</span>
							</h4>
						</div>
					</div>
				</li>
				</c:forEach>
			</ul>

		</div>
		<div class="span9">
			<!-- 
New Products
-->
			<div class="well well-small">
				<h3>Danh sách sản phẩm</h3>
				<c:if test="${ productsPaginate.size() >0 }">
					<div class="row-fluid">
						<ul class="thumbnails">
							<c:forEach var="item" items="${ productsPaginate }" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a href="<c:url value="/chi-tiet-san-pham/${ item.productID }"/>" class="overlay"></a> <a
											class="zoomTool" href="<c:url value="/chi-tiet-san-pham/${ item.productID }"/>"
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
												<a class="shopBtn" href="<c:url value="/add-cart/${ item.productID }"/>" title="add to cart"> Add to
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
								<c:if test="${ (loop.index +1) %3 ==0 || (loop.index +1) == productsPaginate.size() }">
									</ul>
									</div>
									<c:if test="${ (loop.index +1) < productsPaginate.size() }">
										<div class="row-fluid">
											<ul class="thumbnails">
									</c:if>
								</c:if>
							</c:forEach>
						</c:if>
			</div>
		</div>
	</div>
	<div class="pagination">
		<c:if test="${ paginatesData.totalPage >0}">
		<a href="<c:url value="/thuong-hieu/${ brandName }/1"/>">&laquo;</a> 
		<c:forEach begin="1" end="${ paginatesData.totalPage }" varStatus="loop">
		<c:if test="${ (loop.index) == paginatesData.currentPage }">
		<a href='<c:url value="/thuong-hieu/${ brandName }/${ loop.index}"/>'class="active">${ loop.index}</a>
		</c:if>
		<c:if test="${ (loop.index) != paginatesData.currentPage }">
		<a href="<c:url value="/thuong-hieu/${ brandName }/${ loop.index}"/>">${ loop.index}</a>
		</c:if>
		</c:forEach>
		<a href="<c:url value="/thuong-hieu/${ brandName }/${ paginatesData.totalPage }"/>">&raquo;</a>
		</c:if>
	</div>
</body>
</html>