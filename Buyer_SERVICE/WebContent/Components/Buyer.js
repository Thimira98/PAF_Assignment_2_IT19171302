$(document).ready(function()
	{
	if ($("#alertSuccess").text().trim() == "")
	{
	$("#alertSuccess").hide();
	}
	$("#alertError").hide();
	});
	
// SAVE ============================================
	$(document).on("click", "#btnSave", function(event)
	{
		// Clear alerts---------------------
		$("#alertSuccess").text("");
		$("#alertSuccess").hide();
		$("#alertError").text("");
		$("#alertError").hide();
		
		// Form validation-------------------
	    var status = validateBuyerForm();
		if (status != true)
		{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
		}
		
		 // If valid------------------------
		 var type = ($("#hidBuyerIDSave").val() == "") ? "POST" : "PUT"; 
		 $.ajax( 
		 { 
		 url : "BuyerAPI", 
		 type : type, 
		 data : $("#formBuyer").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 onBuyerSaveComplete(response.responseText, status); 
		 } 
 	}); 
});
		
// UPDATE==========================================
	$(document).on("click", ".btnUpdate", function(event)
	{
	$("#hidBuyerIDSave").val($(this).data("buyerid"));
	$("#Name").val($(this).closest("tr").find('td:eq(0)').text());
	$("#Email").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Address").val($(this).closest("tr").find('td:eq(2)').text());
	$("#ContactNumber").val($(this).closest("tr").find('td:eq(3)').text());
	$("#NameOnCard").val($(this).closest("tr").find('td:eq(4)').text());
	$("#CreditCardNumber").val($(this).closest("tr").find('td:eq(5)').text());
	$("#ExpiryDate").val($(this).closest("tr").find('td:eq(6)').text());
	$("#CVV").val($(this).closest("tr").find('td:eq(7)').text());
	});
	
// DELETE===========================================
	$(document).on("click", ".btnRemove", function(event)
	{ 
	 $.ajax( 
	 { 
	 url : "BuyerAPI", 
	 type : "DELETE", 
	 data : "BuyerID=" + $(this).data("buyerid"),
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 onBuyerDeleteComplete(response.responseText, status); 
	 } 
	 }); 
});

// CLIENT-MODEL================================================================
function validateBuyerForm()
	{
	// NAME
	if ($("#Name").val().trim() == "")
	{
	return "Insert Name.";
	}
	
	// EMAIL
	if ($("#Email").val().trim() == "")
	{
	return "Insert Email.";
	}
	
	// ADDRESS-------------------------------
	if ($("#Address").val().trim() == "")
	{
	return "Insert Address.";
	}
	
	// CONTACT NUMBER-------------------------------
	if ($("#ContactNumber").val().trim() == "")
	{
	return "Insert Contact Number.";
	}
	
	// is numerical value
	var tmpContactNumber = $("#ContactNumber").val().trim();
	if (!$.isNumeric(tmpContactNumber))
	{
	return "Insert a numerical value for Contact Number.";
	}
	
	// NAME ON CARD-------------------------------
	if ($("#NameOnCard").val().trim() == "")
	{
	return "Insert Name on card.";
	}

	// CREDIT CARD NUMBER-------------------------------
	if ($("#CreditCardNumber").val().trim() == "")
	{
	return "Insert Credit Card Number.";
	}

	// EXPIRY DATE-------------------------------
	if ($("#ExpiryDate").val().trim() == "")
	{
	return "Insert Expiry date.";
	}

	// CVV------------------------
	if ($("#CVV").val().trim() == "")
	{
	return "Insert CVV.";
	}
	
	// is numerical value
	var tmpCVV = $("#CVV").val().trim();
	if (!$.isNumeric(tmpCVV))
	{
	return "Insert a numerical value for CVV.";
	}
	
	return true;
}

function onBuyerSaveComplete(response, status)
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully saved."); 
	 $("#alertSuccess").show();
	 $("#divBuyersGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while saving."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while saving.."); 
	 $("#alertError").show(); 
	 } 
	 $("#hidBuyerIDSave").val(""); 
	 $("#formBuyer")[0].reset(); 
}

function onBuyerDeleteComplete(response, status)
	{ 
	if (status == "success") 
	 { 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
	 $("#alertSuccess").text("Successfully deleted."); 
	 $("#alertSuccess").show();
	 $("#divBuyersGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
	 $("#alertError").text(resultSet.data); 
	 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
	 $("#alertError").text("Error while deleting."); 
	 $("#alertError").show(); 
	 } else
	 { 
	 $("#alertError").text("Unknown error while deleting.."); 
	 $("#alertError").show(); 
 } 
}
