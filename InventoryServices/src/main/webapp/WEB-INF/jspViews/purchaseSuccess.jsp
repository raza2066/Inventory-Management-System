<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<jsp:include page="include2.jsp" />
<h2 align="center">Material Purchase Details</h2>
</div>
<!-- Display purchase details in table along with purchase id. -->
<center>
	<table >
	<tr>
		<td>Vendor Name</td>
		<td>
			${purchaseBean.vendor_name}
		</td>
	</tr>
	<tr>
		<td>Material Category</td>
		<td >
				${purchaseBean.material_category_id}
		</td>
	</tr>
	<tr>
		<td>Material Type</td>
		<td>
				${purchaseBean.material_type_id}
		</td>
	</tr>
	<tr>
		<td>Unit</td>
		<td>
				${purchaseBean.unit_id}	
		</td>
	</tr>
	<tr>
		<td>Brand Name</td>
		<td>
			${purchaseBean.brandname}
		</td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td>
			${purchaseBean.quantity}
		</td>
	</tr>
	<tr>
		<td>Purchase Amount </td>
		<td>
			${purchaseBean.purchase_amount}
		</td>
	</tr>
	<tr>
		<td>Purchase Date</td>
		<td>
			${purchaseBean.purchase_date}
		</td>
	</tr>
	<tr>
		<%-- <td>Transaction Id</td>
		<td>
			${PurchaseBean.transaction_id}
		</td> --%>
	</tr>
	</table>
</center>
<div class="terms1">
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>