package com.demo.ersSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.ersSpring.dao.UserDaoRepository;
import com.demo.ersSpring.entity.User;
import com.demo.ersSpring.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoRepository UDI;
	
	public UserServiceImpl() {
		
	}

	@Override
	public UserPojo login(String email, String password) {
		
		
		User user = UDI.getUserByEmail(email, password);
		return new UserPojo(user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(), user.getHomeState(), user.getHomeTown(), user.getAddress());
		
	}

	@Override
	public UserPojo getUserInfo(int uID) {
		UserPojo userPojo = null;
		
		Optional<User> optional = this.UDI.findById(uID);
		if(optional.isPresent()) {
			User user = optional.get();
			userPojo = new UserPojo(user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(), user.getHomeState(), user.getHomeTown(), user.getAddress());
		}
		return userPojo;
	}

	@Override
	public void editUser(UserPojo UPJ) {
		User user = new User(UPJ.getUserType(), UPJ.getEmail(), UPJ.getPassword(), UPJ.getScreenName(), UPJ.getHomeState(), UPJ.getHomeTown(), UPJ.getAddress());
		UDI.saveAndFlush(user);
		
	}
	@Override
	public List<UserPojo> getAllUsers() {
		List<User> allUsersEntity = this.UDI.findAll();
		List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();
		
		allUsersEntity.forEach((user) -> {
			UserPojo userPojo = new UserPojo(user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(),user.getHomeState(), user.getHomeTown(), user.getAddress());
			allUsersPojo.add(userPojo);
		});
		
		return allUsersPojo;
	}
	
	
	
}
