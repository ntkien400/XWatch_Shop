<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp" %>

<title>Đăng ký</title>

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

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Đăng ký</li>
			</ul>
			<h3>Đăng ký thành viên mới</h3>
			<hr class="soft" />
			<div class="well">
				<form:form action="dang-ky" modelAttribute="user" method="POST">
					<h3>Thông tin đăng ký</h3>
					<div class="control-group">
						<label class="control-label" for="inputFname">Họ <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Họ" path="first_name" />  
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLname">Tên<sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Tên" path="last_name" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmail">Email <sup>*</sup></label>
						<div class="controls">
							<form:input type="text" placeholder="Email" path="userID" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Mật khẩu <sup>*</sup></label>
						<div class="controls">
							<form:input type="password" placeholder="Mật khẩu" path="password" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Địa chỉ</label>
						<div class="controls">
							<form:input type="text" placeholder="Địa chỉ" path="address" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Số điện thoại <sup>*</sup></label>
						<div class="controls">
							<!-- <input type="text" placeholder="SĐT"> -->
							<form:input type="text" placeholder="SĐT" path="phone_number" />
						</div>
					</div>
						
					<div class="control-group">
						<div class="controls">
							<input type="submit" name="submitAccount" value="Đăng ký"
								class="exclusive shopBtn">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
