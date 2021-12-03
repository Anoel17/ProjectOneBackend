package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pojo.UserPojo;

public class UserDaoImpl implements UserDao{

	
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
	@Override
	public LinkedList<UserPojo> getAllUsers() {
		LinkedList<UserPojo> uPJ = new LinkedList<UserPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "select * from user_info;";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	uPJ.add(new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
			    			rs.getString(7), rs.getString(8)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all users");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all users. Check code.");
			}
		return uPJ;
	}
	
	
	

	@Override
	public UserPojo getUser(int userId) {
		UserPojo output=null;
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "select * from user_info where user_id ="+userId+ ";";
			    ResultSet rs = stmt.executeQuery(query);
			    
			    while (rs.next()) {
			    output= new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
			    			rs.getString(7), rs.getString(8));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to get user info");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing user info.");
			}
		return output;
	}

	@Override
	public void editUser(int userId, String screenName, String home_state, String home_town, String address) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
			Statement stmt = conn.createStatement();
			String query = "update user_info set screen_name='"+screenName+"', home_state='"+home_state+"', home_town='"+home_town+
					"', address='" + address+"' where user_id=" + userId + ";";
		    stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			logger.fatal("Classnotfound while updating user " + userId);
		} catch (SQLException e) {
			logger.fatal("SQL exception while updating user " + userId + ". Check code.");
		}
		
	}




	@Override
	public UserPojo getUserByEmail(String email, String password) {
		UserPojo uPJ = null;
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "select * from user_info where email='" + email+"' and password='" +password+"';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	uPJ = new UserPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
			    			rs.getString(7), rs.getString(8));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("ClassNotFound in login. Check connection");
			} catch (SQLException e) {
				logger.fatal("Login Failed with email " + email);
			}
		return uPJ;
	}

}
