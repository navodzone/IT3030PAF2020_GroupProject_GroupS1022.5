package org.extrolab.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
	static Connection con;
	static PreparedStatement ps;

	@Override
	public User getUser(String username, String pass) {
		// TODO Auto-generated method stub
		User user = new User();
		
		try {
			con = ConnectionProvider.getCon();
			ps = con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setUsername(rs.getString("username"));
			}	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return user;
	}

}
