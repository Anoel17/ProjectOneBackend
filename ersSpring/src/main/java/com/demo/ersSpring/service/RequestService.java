package com.demo.ersSpring.service;

import java.util.LinkedList;
import java.util.List;

import com.demo.ersSpring.entity.Request;
import com.demo.ersSpring.pojo.RequestPojo;

public interface RequestService {

	public void createRequest(RequestPojo RPJ);
	public List<RequestPojo> getRequestsForUser(int userId);
	public List<RequestPojo> getAllRequests();
	public List<RequestPojo> getPendingRequests();
	public List<RequestPojo> getResolvedRequests();
	public void deleteRequest(int requestId);
	public void updateRequest(RequestPojo RPJ);
	public List<RequestPojo> getUserPending(int userId);
	public List<RequestPojo> getUserResolved(int userId);
	
}
