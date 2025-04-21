<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</script>
<style>
.tablehead {
	background-color: #4caf50;
}

.table tr:nth-child(odd) {
	background-color: #7bb77c;
}

.table tr:nth-child(even) {
	background-color: #bde7be;
}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="include2.jsp" />
		<h2 align="center">Vendor Purchase Report</h2>
		<!-- Add tables and form tags to get purchase details here -->
	</div>
	<center>
		<h2>Order with in Price Range Report</h2>
		<form:form action="getVendorWisePurchaseDetail.html"
			modelAttribute="vendorPurchaseReport">
			<table>
				<tr>
					<td>Vendor Name: <form:select path="vendor_name">
							<form:option label="--Select--" value="" />
							<form:options items="${vendorList}" />
						</form:select>
					</td>
					<td>From Price:<form:input path="fromDate" type="date" />
					</td>
					<td>To Price:<form:input path="toDate" type="date" />
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Search">
			<br>
			<br>
			<br>
			<c:if test="${!empty vendorBean}">
				<table width="100%" class="container">
					<tr>
						<th>Address:</th>
						<td>${vendorBean.vendorAddress}</td>
						<th>Contact Number:</th>
						<td>${vendorBean.contactNumber}</td>
						<th>Contact Person:</th>
						<td>${vendorBean.contactPerson}</td>
						<td></td>
					</tr>
				</table>
			</c:if>
			<br>
			<c:if test="${not empty ListofPurchaseBean}">
				<table border="1" class="table">
					<tr class="tablehead">
						<th>Material Category</th>
						<th>Material Type</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit</th>
						<th>Price</th>
						<th>Purchase Date</th>
					</tr>
					<c:forEach items="${ListofPurchaseBean}" var="itr">
						<tr>
							<td><c:out value="${itr.materialCategoryNameString}" /></td>
							<td><c:out value="${itr.materialTypeName}" /></td>
							<td><c:out value="${itr.brandname}" /></td>
							<td><c:out value="${itr.quantity}" /></td>
							<td><c:out value="${itr.materialUnitName}" /></td>
							<td><c:out value="${itr.purchase_amount}" /></td>
							<td><c:out value="${itr.purchase_date}" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</form:form>
	</center>
	<br>
	<br>
	<div class="terms2">
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
</body>
</html>