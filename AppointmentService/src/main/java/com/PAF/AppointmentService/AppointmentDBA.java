package com.PAF.AppointmentService;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AppointmentDBA {

	List<Appointment> appointments;
	
	//Database connectivity
		Connection con = null;
		
		public AppointmentDBA() 
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
				public List<Appointment> getAppointments()
				{
					List<Appointment> appointments = new ArrayList<>();
					String sql = "select * from appointment";
					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);
						while(rs.next()) {
							
							Appointment a = new Appointment();
							
							a.setAppointId(rs.getInt(1));
							a.setPatientId(rs.getString(2));
							a.setPatientName(rs.getString(3));
							a.setAppointDate(rs.getString(4));
							a.setAppointTime(rs.getString(5));
							a.setAppointDoct(rs.getString(6));
							a.setHospital(rs.getString(7));
							a.setSpecialization(rs.getString(8));
							
							appointments.add(a);
						}
						
					}
					catch(Exception e) {
						System.out.println(e);
					}
					
					return appointments;
				}	
				
				public Appointment getAppointment(int appointId)
				{
					Appointment a = new Appointment();
					String sql = "select * from appointment where appointId="+appointId;
					try {
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery(sql);
						if(rs.next()) {
							
							
							a.setAppointId(rs.getInt(1));
							a.setPatientId(rs.getString(2));
							a.setPatientName(rs.getString(3));
							a.setAppointDate(rs.getString(4));
							a.setAppointTime(rs.getString(5));
							a.setAppointDoct(rs.getString(6));
							a.setHospital(rs.getString(7));
							a.setSpecialization(rs.getString(8));
							
							
						}
						
					}
					catch(Exception e) {
						System.out.println(e);
					}
					
					return a;
				}
				
				
				public void create(Appointment a1) {
					String sql = "insert into appointment values(?,?,?,?,?,?,?,?)";
					try {
						PreparedStatement st = con.prepareStatement(sql);
						st.setInt(1, a1.getAppointId());
						st.setString(2, a1.getPatientId());
						st.setString(3, a1.getPatientName());
						st.setString(4, a1.getAppointDate());
						st.setString(5, a1.getAppointTime());
						st.setString(6, a1.getAppointDoct());
						st.setString(7, a1.getHospital());
						st.setString(8, a1.getSpecialization());
						
						st.executeUpdate();
						
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
				
				public void update(Appointment a1) {
						String sql = "update appointment set patientId=?, patientName=?, appointDate=?, appointTime=?, appointDoct=?, hospital=?, specialization=? where appointId=?";
						try {
							PreparedStatement st = con.prepareStatement(sql);
							
							st.setString(1, a1.getPatientId());
							st.setString(2, a1.getPatientName());
							st.setString(3, a1.getAppointDate());
							st.setString(4, a1.getAppointTime());
							st.setString(5, a1.getAppointDoct());
							st.setString(6, a1.getHospital());
							st.setString(7, a1.getSpecialization());
							st.setInt(8, a1.getAppointId());
							
							st.executeUpdate();
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
					}
					
					//Deleting
					
					public void delete(int appointId) {
						String sql = "delete from appointment where appointId=?";
						try {
							PreparedStatement st = con.prepareStatement(sql);
							
							st.setInt(1, appointId);
							st.executeUpdate();
							
						}
						catch(Exception e) {
							System.out.println(e);
						}
						
					}	
					
	}	
	

