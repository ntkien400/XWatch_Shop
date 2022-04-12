<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp"%>
<head>
<title>Giỏ hàng</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Giỏ hàng</li>
			</ul>
			<div class="well well-small">
				<h2>
					Giỏ hàng <small class="pull-right"> ${ CartQty } sản phẩm trong giỏ </small>
				</h2>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Ảnh sản phẩm</th>
							<th>Tên sản phẩm</th>
							<th>Đơn giá</th>
							<th>Sale</th>
							<th>Số lượng</th>
							<th>Thành tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ ShoppingCart }">
							<tr>
								<td><img width="100" src="<c:url value ="/assets/user/watch/${ item.value.product.image_name }"/>" alt=""></td>
								<td>${ item.value.product.name }</td>
								<td><fmt:formatNumber
								type="number" groupingUsed="true" value="${ item.value.product.price }"/>đ</td>
								<td>${ item.value.product.sale }%</td>
								<td><input type="number" min="1" max="${ item.value.product.amount }" class="span1 edit-qty"
									style="max-width: 34px" placeholder="1" data-id="${ item.value.product.productID }"
									id="cart-qty-${ item.value.product.productID }" size="16" type="text" value="${ item.value.quantity }">
									<div class="input-append">
										<a href="<c:url value ="/delete-cart/${ item.value.product.productID }"/>"
											class="btn btn-mini btn-danger" type="button"> <span
											class="icon-remove"></span>
										</a>
									</div>
								</td>
								<td><fmt:formatNumber
									type="number" groupingUsed="true" value="${ item.value.totalPrice }"/>đ</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5" class="alignR">Tổng tiền</td>
							<td><fmt:formatNumber
								type="number" groupingUsed="true" value="${ CartTotalPrice }" />đ</td>
						</tr>

					</tbody>
				</table>
				<br /> 
				<a href="<c:url value ="/trang-chu"/>" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Tiếp tục mua sắm </a> 
				<c:if test="${ empty LoginInfo}">
					<a href="<c:url value ="/dang-nhap"/>" class="shopBtn btn-large pull-right">Thanh
					toán<span class="icon-arrow-right"></span></a>
				</c:if>
				<c:if test="${ not empty LoginInfo && not empty ShoppingCart}">
					<a href="<c:url value ="/thanh-toan"/>" class="shopBtn btn-large pull-right">Thanh
					toán<span class="icon-arrow-right"></span></a>
				</c:if>

			</div>
		</div>
	</div>
	<content tag="script">
		<script>
			$(".edit-qty").on("change", function(){
				var id = $(this).data("id");
				var qty =$("#cart-qty-"+ id).val();
				if(isNaN(qty) == false && qty >=1){
					window.location = "edit-cart/"+id+"/"+qty;
				}
				else{
					return false; 	
				}
			});
		</script>
	</content>
</body>
