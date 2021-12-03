package service;

import java.util.LinkedList;

import pojo.UserPojo;

public interface UserService {
	
	public UserPojo login(String email, String password);
	public LinkedList<UserPojo> getAllUsers();
	public UserPojo getUserInfo(int uID);
	public void editUser(UserPojo UPJ);
}
