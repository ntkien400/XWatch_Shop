<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/Views/Layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="well well2">
		<form:form action="add-product" modelAttribute="product" class="form-horizontal" method="POST" enctype="multipart/form-data">
			<h3>Thông tin sản phẩm</h3>
			<div class="control-group select-box">
				<div class="control-group span3">
					<label class="control-label">ID</label>
					<div class="controls">
						<form:input type="text" placeholder="Id" path="productID"/>
					</div>
				</div>
				<div class="controls span3">
					<label class="control-label">Nhãn hiệu</label>
					<form:select path="brandID">
					<c:forEach var="item" items="${ brands }">
						<form:option value="${ item.brandID }" label="${ item.brandname }"/>
					</c:forEach>
					</form:select>
				</div>
				<div class="controls span3">
					<label class="control-label">Dòng sản phẩm</label>
						<form:select path="seriesID" >
							<c:forEach var="item" items="${ series }">
								<form:option value="${ item.seriesID }" label="${ item.seriesname }"/>
							</c:forEach>
						</form:select>
				</div>
				<div class="control-group span3">
					<label class="control-label">Tên sản phẩm</label>
					<div class="controls">
						<form:input type="text" placeholder="Tên" path="name"/>
					</div>
				</div>
			</div>
			<div class="control-group select-box">
				<div class="control-group span3">
					<label class="control-label">Giá</label>
					<div class="controls">
						<form:input type="text" value="0" path="price"/>
					</div>
				</div>
				<div class="control-group span3">
					<label class="control-label ">Loại kính</label>
					<form:select path="glass">
						<form:option value="Nhựa" label="Nhựa"/>
						<form:option value="Kính khoáng" label="Kính khoáng"/>
						<form:option value="Sapphire" label="Sapphire"/>
					</form:select>
				</div>
				<div class="control-group span3">
					<label class="control-label ">Chất liệu dây đeo</label>
					<form:select path="strap_material">
						<form:option value="Dây cao su" label="Nhựa"/>
						<form:option value="Dây thép" label="Dây thép"/>
						<form:option value="Dây da" label="Dây da"/>
					</form:select>
				</div>
				<div class="control-group span3">
					<label class="control-label">Số lượng</label>
					<div class="controls">
						<form:input type="text" value="0" path="amount"/>
					</div>
				</div>
			</div>
			
			<div class="control-group select-box">
				<div class="control-group span3">
					<label class="control-label">Chống nước</label>
					<div class="controls">
						<form:input type="text" placeholder="atm" path="water_resistant"/>
					</div>
				</div>
				<div class="control-group span3">
					<label class="control-label">Màu sắc</label>
					<div class="controls">
						<form:input type="text" placeholder="Đen, trắng,..." path="color"/>
					</div>
				</div>
				<div class="control-group span3">
					<label class="control-label">Giảm giá</label>
					<div class="controls">
						<form:input type="text" placeholder="0%" value="0" path="sale"/>
					</div>
				</div>
				<div class="control-group span3">
					<label class="control-label ">Giới tính</label>
					<form:select path="gender">
						<form:option value="0" label="Nữ"/>
						<form:option value="1" label="Nam"/>
					</form:select>
				</div>
			</div>
			<div class="control-group select-box">
				<div class="control-group span3">
					<label class="control-label containers">Sản phẩm nổi bật<form:checkbox path="highlight"/>
					<span class="checkmark"></span></label>
				</div>
				<div class="control-group span3">
					<label class="control-label containers">Sản phẩm mới<form:checkbox path="new_product"/>
					<span class="checkmark"></span></label>
				</div>
				<div class="control-group span3">
					<input type="file" name ="imagename">
				</div>
			</div>
			<div class="control-group span">
			<div class="control-group ">
				<label class="control-label">Tiêu đề</label>
				<div class="controls">
					<form:textarea rows="2" cols="120" placeholder=" Field name" path="title"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">Mô tả</label>
				<div class="controls">
					<form:textarea rows="5" cols="120" placeholder=" Field name" path="detail"/>
				</div>
			</div>
			<div class="button-luu ">
			<button class="button-2">Lưu lại</button>
			</div>
			</div>
		</form:form>
	</div>
</body>
</html>