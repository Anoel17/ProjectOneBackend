package dao;


import pojo.UserPojo;
import java.util.LinkedList;
import java.util.List;

public interface UserDao {

	public List<UserPojo> getAllUsers();
	public UserPojo getUser(int userId);
	public void editUser(int userId, String screenName, String home_state, String home_town, String address);
	public UserPojo getUserByEmail(String email, String password);
	
}
