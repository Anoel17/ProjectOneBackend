package service;

import java.util.LinkedList;

import pojo.RequestPojo;

public interface RequestService {

	public void createRequest(RequestPojo RPJ);
	public LinkedList<RequestPojo> getRequestsForUser(int userId);
	public LinkedList<RequestPojo> getAllRequests();
	public LinkedList<RequestPojo> getPendingRequests();
	public LinkedList<RequestPojo> getResolvedRequests();
	public void deleteRequest(int requestId);
	public void updateRequest(int rID, String status);
	public LinkedList<RequestPojo> getUserPending(int userId);
	public LinkedList<RequestPojo> getUserResolved(int userId);
	
}
