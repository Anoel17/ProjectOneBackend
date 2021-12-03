package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pojo.RequestPojo;

public class RequestDaoImpl implements RequestDao {

	private static final Logger logger = LogManager.getLogger(RequestDaoImpl.class);
	
	public RequestDaoImpl() {
		
	}
	
	@Override
	public void createRequest(int userId, String date, int amount) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
			Statement stmt = conn.createStatement();
			System.out.println(userId + " " + date + " " + amount);
			String query = "insert into request_info(user_id, date, amount, status) values"
					+ " (" + userId +", '" + date + "', " + amount + ", 'pending' );";
		    stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			logger.fatal("Classnotfound while creating request for user + " + userId);
		} catch (SQLException e) {
			logger.fatal("SQL exception creating request for " + userId + ". Check code.");
		}
		
	}




	@Override
	public LinkedList<RequestPojo> getRequestsForUser(int userId) {
		
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where user_id = " + userId+";";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}
		
	


	@Override
	public LinkedList<RequestPojo> getAllRequests() {
		
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info;";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}


	@Override
	public void deleteRequest(int rID) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
			Statement stmt = conn.createStatement();
			String query = "update request_info set status = 'deleted' where request_id=" + rID + ";";
		    stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			logger.fatal("Classnotfound while updating request " + rID);
		} catch (SQLException e) {
			logger.fatal("SQL exception while updating reqest " + rID + ". Check code.");
		}
		
	}




	@Override
	public LinkedList<RequestPojo> getPendingRequests() {
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where status= 'pending';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}




	@Override
	public LinkedList<RequestPojo> getResolvedRequests() {
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where status= 'rejected' or status='approved';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}




	@Override
	public void updateRequest(int rID, String status) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
			Statement stmt = conn.createStatement();
			String query = "update request_info set status ='" +status +"' where request_id=" + rID + ";";
		    stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			logger.fatal("Classnotfound while updating request " + rID);
		} catch (SQLException e) {
			logger.fatal("SQL exception while updating reqest " + rID + ". Check code.");
		}
	}
		
	


//select * from request_info where user_id=1 and status='rejected' or user_id=1 and status='approved';


	@Override
	public LinkedList<RequestPojo> getUserResolved(int userId) {
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "select * from request_info where user_id=" + userId +" and status='rejected' or user_id="+userId+" and status='approved';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}




	@Override
	public LinkedList<RequestPojo> getUserPending(int userId) {
		LinkedList<RequestPojo> rPJ = new LinkedList<RequestPojo>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "Richie1120");
				Statement stmt = conn.createStatement();
			    String query = "select * from request_info where user_id=" + userId +" and status='pending';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5)));
			    }
			} catch (ClassNotFoundException e) {
				logger.fatal("Classnotfound while attempting to list all items");
			} catch (SQLException e) {
				logger.fatal("SQL exception while viewing list of all items. Check code.");
			}
		return rPJ;
	}
}
