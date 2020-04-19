package com.PAF.healthcare;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class PaymentDB 
{
	List<Payment> payments;
	
	//Database connectivity
		Connection con = null;
		
		public PaymentDB() 
		{
			String url = "jdbc:mysql://localhost:3306/helthcare";
			String username = "root";
			String password = ""; 
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		//get data
		public List<Payment> getPayments()
		{
			List<Payment> payments = new ArrayList<>();
			String sql = "select * from payment";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					
					Payment a = new Payment();
					a.setId(rs.getInt(1));
					a.setAppointmentID(rs.getString(2));
					a.setPaymentAmount(rs.getDouble(3));
					a.setPaymentDate(rs.getString(4));
					a.setPaymentType(rs.getString(5));
					a.setCardNumber(rs.getString(6));
					a.setExpDate(rs.getString(7));
					a.setCvv(rs.getInt(8));
					
					payments.add(a);
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return payments;
		}
		
		public Payment getPayment(int id)
		{
			Payment a = new Payment();
			String sql = "select * from payment where id="+id;
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				if(rs.next()) {
					
					
					a.setId(rs.getInt(1));
					a.setAppointmentID(rs.getString(2));
					a.setPaymentAmount(rs.getDouble(3));
					a.setPaymentDate(rs.getString(4));
					a.setPaymentType(rs.getString(5));
					a.setCardNumber(rs.getString(6));
					a.setExpDate(rs.getString(7));
					a.setCvv(rs.getInt(8));
					
					
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			return a;
		}
		
		//Inserting section
		
		public void create(Payment a1) {
			String sql = "insert into payment values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, a1.getId());
				st.setString(2, a1.getAppointmentID());
				st.setDouble(3, a1.getPaymentAmount());
				st.setString(4, a1.getPaymentDate());
				st.setString(5, a1.getPaymentType());
				st.setString(6, a1.getCardNumber());
				st.setString(7, a1.getExpDate());
				st.setInt(8, a1.getCvv());
				
				st.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		//Updating 
		
		public void update(Payment a1) {
			String sql = "update payment set appointmentID=?, paymentAmount=?, paymentDate=?, paymentType=?, cardNumber=?, expDate=?, cvv=? where id=?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setString(1, a1.getAppointmentID());
				st.setDouble(2, a1.getPaymentAmount());
				st.setString(3, a1.getPaymentDate());
				st.setString(4, a1.getPaymentType());
				st.setString(5, a1.getCardNumber());
				st.setString(6, a1.getExpDate());
				st.setInt(7, a1.getCvv());
				st.setInt(8, a1.getId());
				
				st.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		//Deleting
		
		public void delete(int id) {
			String sql = "delete from payment where id=?";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				
				st.setInt(1, id);
				st.executeUpdate();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		

}
