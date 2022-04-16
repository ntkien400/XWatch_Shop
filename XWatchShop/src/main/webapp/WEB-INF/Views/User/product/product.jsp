<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
<style>
	.product-content{
		overflow-x: hidden
	}
</style>
</head>
<body>
<!-- 
Body Section 
-->
	<div class="row product-content">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Watches</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fine Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Fashion Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Engagement & Wedding</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Men's Jewelry</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Vintage & Antique</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Diamonds </a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Loose Beads</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>See All Jewelry & Watches</a></li>
		<li style="border:0"> &nbsp;</li>
		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li>
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a href="#"><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block" href="#">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/bootstrap-ecommerce-templates.png" alt="bootstrap ecommerce templates">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/shopping-cart-template.png" alt="shopping cart template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
			<li style="border:0"> &nbsp;</li>
			<li>
			  <div class="thumbnail">
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<img src="assets/img/bootstrap-template.png" alt="bootstrap template">
				<div class="caption">
				  <h4><a class="defaultBtn" href="product_details.html">VIEW</a> <span class="pull-right">$22.00</span></h4>
				</div>
			  </div>
			</li>
		  </ul>

	</div>
	<div class="span9">
    <ul class="breadcrumb">
    <li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
    <li><a href="products.html">sản phẩm</a> <span class="divider">/</span></li>
    <li class="active">${ product.name }</li>
    </ul>	
	<div class="well well-small">
	<div class="row-fluid">
			<div class="span5">
			<div id="myCarousel" class="carousel slide cntr">
                <div class="carousel-inner">
                	<c:if test="${ images.size() >0 }">
                		<c:forEach var="item" items="${ images }" varStatus="loop">
                			<c:if test="${ loop.first }">
                				<div class="item active">
                			</c:if>
                			<c:if test="${ not loop.first }">
                				<div class="item">
                			</c:if>
                			<a href="#"> <img src="<c:url value ="/assets/user/watch/${ item.image }"/>" alt="" style="width:100%"></a>
                			</div>
                		</c:forEach>
                	</c:if>
                </div>
                
            </div>
			</div>
			<div class="span7">
				<h3>${ product.name }</h3>
				<hr class="soft"/>
				
				<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/add-cart/${ product.productID }"/>">
				  <div class="control-group">
					<label class="control-label"><span><fmt:formatNumber
						type="number" groupingUsed="true" value="${ product.price*(100-product.sale)/100 }" />đ</span></label>
					<div class="controls">
						<input name="qty" type="number" min="0" max="${ product.amount }" class="span6" value="1">
					</div>
				  </div>
				
				  <h4>Kho: ${ product.amount } cái</h4>
				  <p>${ product.title } <p>
				  <button type="submit" class="shopBtn"><span class=" icon-shopping-cart"></span>Thêm vào giỏ</button>
				</form>
			</div>
			</div>
				<hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">Mô tả sản phẩm</a></li>
              <li class=""><a href="#profile" data-toggle="tab">Sản phẩm tương tự </a></li>
              
            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
            <div class="tab-pane fade active in" id="home">
			  <h4>Thông tin sản phẩm</h4>
                <table class="table table-striped">
				<tbody>
				<tr class="techSpecRow"><td class="techSpecTD1">Mặt kính:</td><td class="techSpecTD2">${ product.glass }</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Chất liệu dây:</td><td class="techSpecTD2">${ product.strap_material }</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Chống nước:</td><td class="techSpecTD2">${ product.water_resistant }</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Màu:</td><td class="techSpecTD2">${ product.color }</td></tr>
				<tr class="techSpecRow"><td class="techSpecTD1">Giới tính:</td><td class="techSpecTD2"><c:if test="${ product.gender == 0}">Nam</c:if>
				<c:if test="${ product.gender != 0}">Nữ</c:if></td></tr>
				</tbody>
				</table>
				<p>${ product.detail }<p>

			</div>
			<div class="tab-pane fade" id="profile">
			<c:forEach var="item" items="${ products }" varStatus="loop">
			<hr class="soft">
			<div class="row-fluid">
			<div class="span2">
				<img src="<c:url value="/assets/user/watch/${ item.image }"/>" alt="">
			</div>
			<div class="span6">
				<h5>${ item.name }</h5>
				<p>${ item.title }</p>
			</div>
			<div class="span4 alignR">
			<form class="form-horizontal qtyFrm">
			<h3><fmt:formatNumber
						type="number" groupingUsed="true" value="${ product.price*(100-product.sale)/100 }" />đ</h3>
			<label class="checkbox">
				<input type="checkbox">  Adds product to compair
			</label><br>
			<div class="btn-group">
			  <a href="product_details.html" class="defaultBtn"><span class=" icon-shopping-cart"></span> Add to cart</a>
			  <a href="<c:url value="/chi-tiet-san-pham/${ item.productID }"/>" class="shopBtn">VIEW</a>
			 </div>
				</form>
			</div>
			</div>
			</c:forEach>
			</div>
            </div>

</div>
</div>
</div> <!-- Body wrapper -->
</body>
</html>