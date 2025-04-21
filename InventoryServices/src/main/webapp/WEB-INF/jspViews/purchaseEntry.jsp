<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<title>Purchase Entry</title>
<script type="text/javascript">
	function displayPageElements() {
		if (document.getElementById("category").value == "") {
			document.getElementById("belowTables").style.display = "none";
		} else {
			document.getElementById("belowTables").style.display = "block";
		}
	}
	function onChangeSubmit() {
		var ct_ele = document.getElementById("frm")
		ct_ele.action = "${pageContext.request.contextPath}/getUnitAndTypeList.html";
		ct_ele.submit();
	}
</script>
<style>
</style>
</head>
<body>
	<div class="container"><jsp:include page="include2.jsp" /><h2
			align="center">Material Purchase Entry</h2>
		<!-- Add tables and form tags to get purchase details here -->
		<center>
			<form:form id="frm" modelAttribute="purchaseBean"
				action="${pageContext.request.contextPath}/addPurchaseDetail.html"
				method="POST">
				<table>
					<tr>
						<td>Vendor Name</td>
						<td><form:select path="vendor_name">
								<form:option label="--Select--" value="" />
								<form:options items="${vendorList}" />
							</form:select> <font color="red"> <form:errors path="vendor_name"
									cssClass="error" style="font-family:sans serif;" />
						</font></td>
					</tr>
					<tr>
						<td>Material Category</td>
						<td><form:select path="material_category_id"
								onchange="onChangeSubmit()">
								<form:option label="--Select--" value="" />
								<form:options items="${categoryList}" />
							</form:select> <font color="red"> <form:errors
									path="material_category_id" cssClass="error"
									style="font-family:sans serif;" />
						</font></td>
					</tr>
					<c:if test="${IsVisible=='yes'}">
						<tr>
							<td>Material Type</td>
							<td><form:select path="material_type_id">
									<form:option label="--Select--" value="" />
									<form:options items="${typemap}" />
								</form:select> <font color="red"> <form:errors path="material_type_id"
										cssClass="error" style="font-family:sans serif;" />
							</font></td>
						</tr>
						<tr>
							<td>Unit</td>
							<td><form:select path="unit_id">
									<form:option label="--Select--" value="" />
									<form:options items="${typeunit}" />
								</form:select> <font color="red"> <form:errors path="unit_id"
										cssClass="error" style="font-family:sans serif;" />
							</font></td>
						</tr>
						<tr>
							<td>Brand Name</td>
							<td><form:input type="text" label="brand" path="brandname" />
								<font color="red"> <form:errors path="brandname"
										cssClass="error" style="font-family:sans serif;" />
							</font></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td><form:input type="number" label="quantity"
									path="quantity" /> <font color="red"> <form:errors
										path="quantity" cssClass="error"
										style="font-family:sans serif;" />
							</font></td>
						</tr>
						<tr>
							<td>Purchase Amount</td>
							<td><form:input label="" value="" type="number"
									path="purchase_amount" /> <font color="red"> <form:errors
										path="purchase_amount" cssClass="error"
										style="font-family:sans serif;" />
							</font></td>
						</tr>
						<tr>
							<td>Purchase Date</td>
							<td><form:input type="date" path="purchase_date" /> <font
								color="red"> <form:errors path="purchase_date"
										cssClass="error" style="font-family:sans serif;" />
							</font></td>
						</tr>
					</c:if>
				</table>
				<c:if test="${IsVisible=='yes'}">
					<input type="submit" value="Submit"
						style="padding: 7px; background-color: #4CAF50" />
				</c:if>
			</form:form>
			<br>
			<!-- <input type="submit" value="Submit" style="padding:7px;background-color: #4CAF50"/> -->
		</center>
	</div>
	<div class="terms2">
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
</body>
</html>