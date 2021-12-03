package service;

import java.util.LinkedList;

import dao.UserDaoImpl;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDaoImpl UDI;
	
	public UserServiceImpl() {
		UDI = new UserDaoImpl();
	}

	@Override
	public UserPojo login(String email, String password) {
		// TODO Auto-generated method stub
		return UDI.getUserByEmail(email, password);
	}

	@Override
	public UserPojo getUserInfo(int uID) {
		// TODO Auto-generated method stub
		return UDI.getUser(uID);
	}

	@Override
	public void editUser(UserPojo UPJ) {
		UDI.editUser(UPJ.getId(), UPJ.getScreenName(), UPJ.getHomeState(), UPJ.getHomeTown(), UPJ.getAddress());
		
	}
	@Override
	public LinkedList<UserPojo> getAllUsers() {
		return UDI.getAllUsers();
	}
	
	
	
}
