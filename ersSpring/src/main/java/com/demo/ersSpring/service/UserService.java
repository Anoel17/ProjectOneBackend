package com.demo.ersSpring.service;

import java.util.LinkedList;
import java.util.List;

import com.demo.ersSpring.entity.User;
import com.demo.ersSpring.pojo.UserPojo;

public interface UserService {
	
	public UserPojo login(String email, String password);
	public List<UserPojo> getAllUsers();
	public UserPojo getUserInfo(int uID);
	public void editUser(UserPojo UPJ);
}
