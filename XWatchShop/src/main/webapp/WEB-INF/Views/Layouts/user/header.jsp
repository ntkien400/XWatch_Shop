<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp" %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="index.html"><span>Twitter Bootstrap
						ecommerce template</span> <img
					src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png"/>"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML
					template is available @ $14
				</h1>
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Support (24/7) : 0123 4567 890 </strong><br>
				<br>
			</p>
			
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${ menus }" varStatus="">
						<li class="">
						<a href="<c:url value="${ item.url }"/>">${ item.menuname }</a>
						</li>
						
					</c:forEach>
				</ul>
				<form action="<c:url value="/search"/>" class="navbar-search pull-left">
					<input type="text" placeholder="Tìm kiếm" name="keyword" class="search-query span5">
				</form>
				
			</div>
		</div>
	</div>
</div>