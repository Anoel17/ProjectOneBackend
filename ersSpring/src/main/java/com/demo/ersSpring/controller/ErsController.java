package com.demo.ersSpring.controller;



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
	
	// http://localhost:8080/api/hello
	@GetMapping("hello")
	public String getHello() {
		return "Hello";
	}
	
	//http://localhost8080/api/helloparam/{pid}
	@GetMapping("helloparam/{pid}")
	public String getHelloPathParam(@PathVariable("pid") Integer processId) {
		return "" + processId;
	}
	
	// http://localhost:8080/api/request
	@GetMapping("request")
	public List<RequestPojo> getAllRequests() {
		return RSI.getAllRequests();
	}
	
			//fetch user's requests
			// http://localhost:8080/api/request/{uid}
	@GetMapping("api/request/{uid}")
	public List<RequestPojo> getRequestsForuser(@PathVariable("uid") Integer userId) {
		return RSI.getRequestsForUser(userId);
	}
			//delete a request
	@DeleteMapping("api/request/{rid}")
	public void deleteRequest(@PathVariable("rid") Integer requestId){
		RSI.deleteRequest(requestId);
	}
			
	// http://localhost4040/api/request
	@PostMapping("api/request")
	public void createRequest(@RequestBody RequestPojo requestPojo){
		RSI.createRequest(requestPojo);
	}
			
			
	@PutMapping("api/request")
	public void updateRequest(@RequestBody RequestPojo requestPojo) {
		RSI.updateRequest(requestPojo);
	}
				
			
	@GetMapping("api/requestpending")
	public List<RequestPojo> allPending(){
		return RSI.getPendingRequests();
	}
			
	@GetMapping("api/request/pending/{uid}")
	public List<RequestPojo> getUserPending(@PathVariable("uid")Integer userId){
		return RSI.getUserPending(userId);
	}
			
	@GetMapping("api/requestresolved")
	public List<RequestPojo> allResolved(){
		return RSI.getResolvedRequests();
	}
			
	@GetMapping("api/request/resolved/{uid}")
	public List<RequestPojo> getUserResolved(@PathVariable("uid") Integer userId){
		return RSI.getUserResolved(userId);
	}
			
	@GetMapping("api/user/login/{email}/{password}")
	public UserPojo logIn(@PathVariable("email") String email, @PathVariable("password") String password){
		return USI.login(email, password);
	}
			
	@GetMapping("api/user/{userId}")
	public UserPojo getUserInfo(@PathVariable("userId") Integer userId){
		return USI.getUserInfo(userId);
	}
			
	@GetMapping("api/user")
	public List<UserPojo> getAllUsers(){
		return USI.getAllUsers();
	}
			
	@PutMapping("api/user")
	public void editUser(@RequestBody UserPojo userPojo){
		USI.editUser(userPojo);
	}
	
	
	
	
}
