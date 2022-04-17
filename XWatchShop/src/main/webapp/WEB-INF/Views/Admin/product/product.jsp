<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/admin/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<div class="well well-small">
	<c:if test="${ not empty message }">
		<h3>${ message }</h3>
	</c:if>
		<h2>
			Danh sách sản phẩm <small class="pull-right"> ${ products.size() } sản phẩm </small>
		</h2>
		<a href="<c:url value="/admin/add-product"/>" class="button button-2">Thêm</a>
		<table class="table table-bordered table-condensed">
			<thead>
				<tr>
					<th>Ảnh</th>
					<th>Tên sản phẩm</th>
					<th>Hãng</th>
					<th>Dòng</th>
					<th>Đơn giá</th>
					<th>Số lượng</th>
					<th>Sửa/Xoá</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ products }">
					<tr>
						<td><img width="50" 
							src="<c:url value ="/assets/user/watch/${ item.image }"/>"
							alt=""></td>
						<td>${ item.name }</td>
						<td>${ item.brandname }</td>
						<td>${ item.seriesname }</td>
						<td><fmt:formatNumber
								type="number" groupingUsed="true" value="${ item.price }"/>đ</td>
						<td>${ item.amount }</td>
						<td>
							<a href="<c:url value ="/admin/product-detail/${ item.productID }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
								class="icon-edit" style="font-size:15px"></span>
							</a>
							<a href="<c:url value ="/admin/list-product/delete-product/${ item.productID }"/>"
								class="btn btn-mini btn-danger" type="button"> <span
								class="icon-trash" style="font-size:15px"></span>
							</a>
					    </td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>