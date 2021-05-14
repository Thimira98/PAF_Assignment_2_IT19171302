package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Buyer {
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf_project", "root", "");
			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
     
	//Insert Buyers
	public String insertBuyer(String name, String email, String address, String contactnumber, String cardname, String creditcardno, String expirydate, String cvv){

		String output = "";

		try {

			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = "insert into buyers (BuyerID, Name, Email, Address, ContactNumber, NameOnCard, CreditCardNumber, ExpiryDate, CVV)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0); 
			 preparedStmt.setString(2, name); 
			 preparedStmt.setString(3, email); 
			 preparedStmt.setString(4, address); 
			 preparedStmt.setString(5, contactnumber);
			 preparedStmt.setString(6, cardname);
			 preparedStmt.setString(7, creditcardno);
			 preparedStmt.setString(8, expirydate);
			 preparedStmt.setString(9, cvv);

			System.out.println(name);

			preparedStmt.execute();
			con.close();

			String newBuyers = readBuyers();
			output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
		}

		catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the buyer.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
     
	//Read Buyers
	public String readBuyers() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border='1'>"
			 		 + "<tr><th>name</th>" 
					 +"<th>email</th>"
					 + "<th>address</th>"
					 + "<th>contact number</th>" 
					 +"<th>name on card</th>"
					 + "<th>credit card number</th>"
					 + "<th>expiry date</th>"
					 + "<th>cvv</th>" 
					 + "<th>Update</th><th>Remove</th></tr>"; 
			
			String query = "select * from buyers";
			
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				 String BuyerID = Integer.toString(rs.getInt("BuyerID")); 
				 String Name = rs.getString("Name"); 
				 String Email = rs.getString("Email"); 
				 String Address = rs.getString("Address"); 
				 String ContactNumber = rs.getString("ContactNumber"); 
				 String NameOnCard = rs.getString("NameOnCard"); 
				 String CreditCardNumber = rs.getString("CreditCardNumber"); 
				 String ExpiryDate = rs.getString("ExpiryDate"); 
				 String CVV = rs.getString("CVV");
				 
				// Add a row into the html table
				output += "<tr><td><input id='hidBuyerIDUpdate' name='hidBuyerIDUpdate' type='hidden' value='" + BuyerID
						+ "'>" + Name + "</td>";
				output += "<td>" + Email + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + ContactNumber + "</td>";
				output += "<td>" + NameOnCard + "</td>";
				output += "<td>" + CreditCardNumber + "</td>";
				output += "<td>" + ExpiryDate + "</td>";
				
				output += "<td>" + CVV + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' "
						+ " type='button' value='Update' class =' btnUpdate btn btn-secondary'data-buyerid='" + BuyerID
						+ "'></td>" + "<td><form method='post' action='buyers.jsp'>" + "<input name='btnRemove' "
						+ " type='button' value='Remove' class='btnRemove btn btn-danger' data-buyerid='" + BuyerID + "'>"
						+ "<input name='hidBuyerIDDelete' type='hidden' " + " value='" + BuyerID + "'>"
						+ "</form></td></tr>";
			}
			con.close();
			
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the buyers.";
			System.err.println(e.getMessage());
		}
		return output;
	}
     
	//Delete Buyers
	public String deleteBuyer(String BuyerID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query = "delete from buyers where BuyerID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(BuyerID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newBuyers = readBuyers();
			output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
		}

		catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the buyer.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
 
	//Update Buyers
	public String updateBuyer(String ID,String name, String email, String address, String contactnumber, String cardname, String creditcardno, String expirydate, String cvv)
	{
		String output = "";
		try {
			Connection conn = connect();
			if (conn == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE buyers SET Name=?,Email=?,Address=?,ContactNumber=?,NameOnCard=?,CreditCardNumber=?,ExpiryDate=?,CVV=? WHERE BuyerID=? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			// binding values
			 preparedStmt.setString(1, name); 
			 preparedStmt.setString(2, email); 
			 preparedStmt.setString(3, address); 
			 preparedStmt.setString(4, contactnumber); 
			 preparedStmt.setString(5, cardname); 
			 preparedStmt.setString(6, creditcardno); 
			 preparedStmt.setString(7, expirydate); 
			 preparedStmt.setString(8, cvv); 
			 preparedStmt.setInt(9, Integer.parseInt(ID)); 
			 
			// execute the statement
			preparedStmt.execute();
			conn.close();
			String newBuyers = readBuyers();
			output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
		}

		catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while Updating the buyer.\"}";

			System.err.println(e.getMessage());
		}
		return output;
	}

}

