<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp"%>

<title>Đăng nhập</title>
<body>
	<div class="row">
	<c:if test="${ not empty message }">${ message }</c:if>
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
		<div class="span4">
			<div class="well">
				<h5>Đăng nhập</h5>
				<form:form action="dang-nhap" modelAttribute="user" method="POST">
					<div class="control-group">
						<label class="control-label" for="inputEmail">Email</label>
						<div class="controls">
							<form:input type="text" name="username" class="span3"  placeholder="Email" path="userID" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" name="password" for="inputPassword">Password</label>
						<div class="controls">
							<form:input type="password"  class="span3"  placeholder="Password" path="password" />
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="defaultBtn">Đăng nhập</button>
							<p>Chưa có tài khoản?<a href="<c:url value="/dang-ky"/>">Tạo tài khoản.</a></p>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>