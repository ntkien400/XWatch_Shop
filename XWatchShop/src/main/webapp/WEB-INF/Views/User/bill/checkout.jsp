<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<h3>Thương hiệu</h3>
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ brands }">
						<li><a
							href="<c:url value="/thuong-hieu/${ item.brandname }"/>"><span
								class="icon-chevron-right"></span>${ item.brandname }</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value="/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="<c:url value="/assets/user/img/bootstrap.png"/>"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value="/assets/user/img/AE-1200WHD-1AVDF-399x399.webp"/>"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
							src="<c:url value="/assets/user/img/bootstrap-template.png"/>"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> <span
									class="pull-right">$22.00</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active"><a href="index.html">Giỏ hàng</a><span
					class="divider">/</span></li>
				<li class="active"><a href="index.html">Thanh toán</a></li>
			</ul>
			<h3>Thanh toán đơn hàng</h3>
			<hr class="soft" />
			<div class="well">
				<form:form action="thanh-toan" method="POST" modelAttribute="bill"
					class="form-horizontal">
					<h3>Thông tin thanh toán</h3>
					<div class="control-group">
						<label class="control-label" for="inputLname">Họ tên <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Họ tên" path="display_name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Email <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Email" path="userID" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Số điện thoại <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Số điện thoại"
								path="phone_number" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Địa chỉ nhận
							hàng <sup>*</sup>
						</label>
						<div class="controls">
							<form:textarea path="address" rows="3" cols="30" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Ghi chú</label>
						<div class="controls">
							<form:textarea path="note" rows="3" cols="30" />
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<input type="submit" name="submitAccount" value="Đặt hàng"
								class="exclusive shopBtn">
						</div>
					</div>
				</form:form>
			</div>
		</div>
		
		<div class="span9">
			<div class="well well-small">
				<h3>Đơn hàng</h3>
				<c:forEach var="item" items="${ ShoppingCart }">
					<div class="row-fluid">
						<div class="span2">
							<img class="img-checkout" src="<c:url value ="/assets/user/watch/${ item.value.product.image_name }"/>" alt="">
						</div>
						<div class="span5">
							<h5>${ item.value.product.name }</h5>
						</div>
						<div class="span2 child">
							<h5>Số lượng: ${ item.value.quantity }</h5>
						</div>
						<div class="span3 alignR">
							<form class="form-horizontal qtyFrm">
								<h5><fmt:formatNumber type="number" groupingUsed="true" 
									value="${ item.value.totalPrice }"/>đ</h5>
							</form>
						</div>
					</div>
				</c:forEach>
				<table class="total-line-table">
					<thead>
						<tr>
							<th scope="col"><span class="visually-hidden">Mô tả</span></th>
							<th scope="col"><span class="visually-hidden">Giá</span></th>
						</tr>
					</thead>
					<tfoot class="total-line-table-footer">
						<tr class="total-line">
							<td class="total-line"><span class="payment-due-price"
								data-checkout-payment-due-target="121900000">Tổng cộng: <b
									style="color: red; font-size:25px"><fmt:formatNumber type="number" groupingUsed="true" 
									value="${ CartTotalPrice }"/>đ</b>
							</span></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>
</html>