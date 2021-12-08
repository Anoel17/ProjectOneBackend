package service;

import java.util.LinkedList;
import java.util.List;

import pojo.UserPojo;

public interface UserService {
	
	public UserPojo login(String email, String password);
	public List<UserPojo> getAllUsers();
	public UserPojo getUserInfo(int uID);
	public void editUser(UserPojo UPJ);
}
