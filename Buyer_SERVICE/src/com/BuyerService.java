package com;

import model.Buyer;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Buyers")
public class BuyerService {
	Buyer buyerObj = new Buyer();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readBuyers() {
		return buyerObj.readBuyers();
	}
  
	// inserBuyer() method
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertBuyer(@FormParam("Name") String Name, 
	 @FormParam("Email") String Email, 
	 @FormParam("Address") String Address, 
	 @FormParam("ContactNumber") String ContactNumber, 
	 @FormParam("NameOnCard") String NameOnCard, 
	 @FormParam("CreditCardNumber") String CreditCardNumber, 
	 @FormParam("ExpiryDate") String ExpiryDate, 
	 @FormParam("CVV") String CVV) 
	
	{ 
	 String output = buyerObj.insertBuyer(Name,Email,Address,ContactNumber,NameOnCard,CreditCardNumber,ExpiryDate,CVV); 
	 return output; 
	}
	
	//updateBuyer() method
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateBuyer(String buyerData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject buyerObject = new JsonParser().parse(buyerData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String BuyerID = buyerObject.get("BuyerID").getAsString(); 
	 String Name = buyerObject.get("Name").getAsString(); 
	 String Email = buyerObject.get("Email").getAsString(); 
	 String Address = buyerObject.get("Address").getAsString(); 
	 String ContactNumber = buyerObject.get("ContactNumber").getAsString(); 
	 String NameOnCard = buyerObject.get("NameOnCard").getAsString(); 
	 String CreditCardNumber = buyerObject.get("CreditCardNumber").getAsString(); 
	 String ExpiryDate = buyerObject.get("ExpiryDate").getAsString();
	 String CVV = buyerObject.get("CVV").getAsString(); 
	 String output = buyerObj.updateBuyer(BuyerID,Name,Email,Address,ContactNumber,NameOnCard,CreditCardNumber,ExpiryDate,CVV); 
	
	 return output; 
	}
	
	// deleteBuyer() method
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteBuyer(String buyerData) 
	{ 
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(buyerData, "", Parser.xmlParser()); 
	 
	//Read the value from the element <itemID>
	 String BuyerID = doc.select("BuyerID").text(); 
	 String output = buyerObj.deleteBuyer(BuyerID); 
	
	 return output; 
	}
}