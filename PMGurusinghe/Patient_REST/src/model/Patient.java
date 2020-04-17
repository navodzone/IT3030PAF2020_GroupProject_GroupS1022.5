package model;

import java.sql.*;

public class Patient {

public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patient", "root", "");

			// For testing
			System.out.print("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

public String insertPatient(String FName, String LName, String NIC,String DOB,String Email,String Mobile,String Address,String BloodGroup, String Allergy,String Gender,String password,String ConfirmPassword)
		
		 
{
		String output = "";

		try {

			Connection con = connect();

			if (con == null) 
			{
				return "Error while connecting to the database for inserting.";
			}

			// create a prepared statement
			String query = " insert into patient(`Patient_ID`,`FirstName`,`LastName`,`NIC`,`DOB`,`Email`,`Mobile`,`Address`,`BloodGroup`,`Allergy`,`Gender`,`password`,`ConfirmPassword`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
			 
			 
			
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, FName);
			preparedStmt.setString(3, LName);
			preparedStmt.setString(4, NIC);
			preparedStmt.setString(5, DOB);
			preparedStmt.setString(6, Email);
			preparedStmt.setString(7, Mobile);
			preparedStmt.setString(8, Address);
			preparedStmt.setString(9, BloodGroup);
			preparedStmt.setString(10, Allergy);
			preparedStmt.setString(11, Gender);
			preparedStmt.setString(12, password);
			preparedStmt.setString(13, ConfirmPassword);
		
			/* preparedStmt.setDouble(4, Double.parseDouble(price)); */
			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Inserted successfully";
			
		   }
		
		catch (Exception e) 
		{
			output = "Error while inserting the Patient Details.";
			System.err.println(e.getMessage());
		}

		return output;

	}

}
