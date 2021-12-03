package service;

import java.util.LinkedList;
import java.util.Scanner;

import dao.RequestDao;
import dao.RequestDaoImpl;
import pojo.RequestPojo;

public class RequestServiceImpl implements RequestService{
	public RequestDaoImpl RDI = new RequestDaoImpl();
	
	public RequestServiceImpl() {
		
	}
	
	private void scanBody(int... rows) {
		
		
	}
	
	@Override
	public void createRequest(RequestPojo RPJ) {
		
		
		RDI.createRequest(RPJ.getId(), RPJ.getDate(), RPJ.getAmount());
		
	}
	

	@Override
	public LinkedList<RequestPojo> getRequestsForUser(int userId) {
		
		
		return RDI.getRequestsForUser(userId);
		
		
	}

	@Override
	public LinkedList<RequestPojo> getAllRequests() {
		// TODO Auto-generated method stub
		return RDI.getAllRequests();
	}

	@Override
	public LinkedList<RequestPojo> getPendingRequests() {
		return RDI.getPendingRequests();
	}

	@Override
	public LinkedList<RequestPojo> getResolvedRequests() {
		return RDI.getResolvedRequests();
	}

	@Override
	public void deleteRequest(int requestId) {
		RDI.deleteRequest(requestId);
		
	}

	@Override
	public void updateRequest(int rID, String status) {
		RDI.updateRequest(rID, status);
		
	}



	@Override
	public LinkedList<RequestPojo> getUserPending(int userId) {
		return RDI.getUserPending(userId);
		
	}

	@Override
	public LinkedList<RequestPojo> getUserResolved(int userId) {
		return RDI.getUserResolved(userId);
		
	}

}
