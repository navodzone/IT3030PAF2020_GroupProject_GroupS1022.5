package org.extrolab.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements MyProvider {
	
	static Connection con = null;
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helthcare", "root", "");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return con;
	}

}