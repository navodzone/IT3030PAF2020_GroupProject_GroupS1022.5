package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {

	
	public Connection connect() {
		Connection con = null;

		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");
		 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/helthcare",
		 "root", "");
		
		 //For testing
		 System.out.print("Successfully connected");
		 }
		 catch(Exception e)
		 {
		 e.printStackTrace();
		 }
		return con;
		}
	
	public String readItems()

	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading.";
	 }
	 // Prepare the html table to be displayed
	 output = "<table border=\"1\"><tr><th>Doctor ID</th>"
			 +"<th>Doctor Name</th><th>Doctor Specialization</th>"
			 + "<th>Doctor residing Hospital</th>"
			 + "<th>Update</th><th>Remove</th></tr>"; 
	 String query = "select * from doctor";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 //String itemID = Integer.toString(rs.getInt("itemID"));
     //String itemCode = rs.getString("itemCode");
	 String ID = rs.getString("dID");
	 String name = rs.getString("dName");
	 //String itemPrice = Double.toString(rs.getDouble("itemPrice"));
	 String specialization = rs.getString("specialization");
	 String Hname = rs.getString("hName");
	 // Add into the html table
	 output += "<tr><td>" + ID + "</td>";
	 output += "<td>" + name + "</td>"; 
	output += "<td>" + specialization + "</td>";
	 output += "<td>" + Hname + "</td>";
	 // buttons
	 output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\"></td>\r\n"
			 + "<td><form method=\"post\" action=\"http://localhost:8080/DoctorService/index.jsp\">"
			 + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\">"
			 + "<input name=\"dID\" type=\"hidden\" value=\"" + ID + "\">"
			 + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}

	public String insertItem(String ID, String name, String specialization , String Hospital)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = " insert into Doctor(`dID`,`dName`,`specialization`,`hName`)"+ " values (?, ?, ?, ?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 //preparedStmt.setInt(1, 0);
	 //preparedStmt.setString(2, ID);
	 //preparedStmt.setString(3, name);
	 //preparedStmt.setDouble(4, Double.parseDouble(price));
	 //preparedStmt.setString(5, desc); 
	 preparedStmt.setString(1, ID);
	 preparedStmt.setString(2, name);
	 preparedStmt.setString(3, specialization);
	 preparedStmt.setString(4, Hospital);
	
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while inserting";
	 System.err.println(e.getMessage());
	 }
	return output;
	}

	
	public String deleteItem(String ID)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for deleting.";
	 }
	 // create a prepared statement
	 String query = "delete from Doctor where dID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	// preparedStmt.setInt(1, Integer.parseInt(ID));
	   preparedStmt.setString(1,ID);
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while deleting the item.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	
}	


	

