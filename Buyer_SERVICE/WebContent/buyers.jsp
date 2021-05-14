<%@page import="model.Buyer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer_Service_IT19171302</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Buyer.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">

				<h1>Buyer Service</h1>
				<form id="formBuyer" name="formBuyer" method="post" action="buyers.jsp">
					Name: 
					<input id="Name" name="Name" type="text" class="form-control form-control-sm"> <br> 
					Email: 
					<input id="Email" name="Email" type="text" class="form-control form-control-sm"> <br> 
				    Address:
					<input id="Address" name="Address" type="text" class="form-control form-control-sm"> <br> 
					Contact Number: 
					<input id="ContactNumber" name="ContactNumber" type="text" class="form-control form-control-sm"> <br>
					Card Name: 
					<input id="NameOnCard" name="NameOnCard" type="text" class="form-control form-control-sm"> <br> 
				    Credit card No:
					<input id="CreditCardNumber" name="CreditCardNumber" type="text" class="form-control form-control-sm"> <br> 
					Expiry Date: 
					<input id="ExpiryDate" name="ExpiryDate" type="text" class="form-control form-control-sm"> <br>  
					CVV: 
					<input id="CVV" name="CVV" type="text" class="form-control form-control-sm"> <br> 
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> 
					<input type="hidden" id="hidBuyerIDSave" name="hidBuyerIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<%
				out.print(session.getAttribute("statusMsg"));
				%>
				
				<br>
				<div id="divBuyersGrid">

					<%
					Buyer buyerObj = new Buyer();
					out.print(buyerObj.readBuyers());
					%>
				</div>

			</div>
		</div>
	</div>

</body>
</html>