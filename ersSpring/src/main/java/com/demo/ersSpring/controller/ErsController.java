package com.demo.ersSpring.controller;


import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.pojo.RequestPojo;
import com.demo.ersSpring.pojo.UserPojo;
import com.demo.ersSpring.service.RequestService;
import com.demo.ersSpring.service.RequestServiceImpl;
import com.demo.ersSpring.service.UserService;
import com.demo.ersSpring.service.UserServiceImpl;




@RestController
@RequestMapping("api")
public class ErsController {

	@Autowired
	RequestService RSI;
	
	@Autowired
	UserService USI;
	
	//Exceptions ensure that if no results are obtained, the backend will return an empty list or dummy object instead of a null.
	

	// http://localhost:8080/api/request
	@GetMapping("request")
	public List<RequestPojo> getAllRequests(){
		try {
		List<RequestPojo> requestList = RSI.getAllRequests();
		return requestList;
		} catch (NullReturnException nre) {
			return new LinkedList<RequestPojo>();
		}
	}
	
			
	@GetMapping("request/{uid}")
	public List<RequestPojo> getRequestsForuser(@PathVariable("uid") Integer userId) {
		try {
			return RSI.getRequestsForUser(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@DeleteMapping("request/{rid}")
	public void deleteRequest(@PathVariable("rid") Integer requestId){
		RSI.deleteRequest(requestId);
	}
			
	
	@PostMapping("request")
	public void createRequest(@Valid @RequestBody RequestPojo requestPojo){
		RSI.createRequest(requestPojo);
	}
			
	
	@PutMapping("request")
	public void updateRequest(@Valid @RequestBody RequestPojo requestPojo) {
		RSI.updateRequest(requestPojo);
	}
				
		
	@GetMapping("requestpending")
	public List<RequestPojo> allPending(){
		try {
			return RSI.getPendingRequests();
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	
	@GetMapping("request/pending/{uid}")
	public List<RequestPojo> getUserPending(@PathVariable("uid")Integer userId){
		try {
			return RSI.getUserPending(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("requestresolved")
	public List<RequestPojo> allResolved(){
		try {
			return RSI.getResolvedRequests();
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("request/resolved/{uid}")
	public List<RequestPojo> getUserResolved(@PathVariable("uid") Integer userId){
		try {
			return RSI.getUserResolved(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("user/login/{email}/{password}")
	public UserPojo logIn(@PathVariable("email") String email, @PathVariable("password") String password){
		try {
			return USI.login(email, password);
		} catch (NullReturnException e) {
			return new UserPojo();
		}
	}
			
	@GetMapping("user/{userId}")
	public UserPojo getUserInfo(@PathVariable("userId") Integer userId){
		try {
			return USI.getUserInfo(userId);
		} catch (NullReturnException e) {
			return new UserPojo();
		}
	}
			
	@GetMapping("user")
	public List<UserPojo> getAllUsers(){
		try {
			return USI.getAllUsers();
		} catch (NullReturnException e) {
			return new LinkedList<UserPojo>();
		}
	}
			
	@PutMapping("user")
	public void editUser(@Valid @RequestBody UserPojo userPojo){
		USI.editUser(userPojo);
	}
	
	
	
	
}
