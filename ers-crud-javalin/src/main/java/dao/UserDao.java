package dao;


import pojo.UserPojo;
import java.util.LinkedList;

public interface UserDao {

	public LinkedList<UserPojo> getAllUsers();
	public UserPojo getUser(int userId);
	public void editUser(int userId, String screenName, String home_state, String home_town, String address);
	public UserPojo getUserByEmail(String email, String password);
	
}
