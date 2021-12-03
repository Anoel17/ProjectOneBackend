package dao;
import pojo.RequestPojo;
import java.util.LinkedList;
public interface RequestDao {

	
	
	public void createRequest(int userId, String date, int amount);
	public LinkedList<RequestPojo> getRequestsForUser(int userId);
	public LinkedList<RequestPojo> getAllRequests();
	public LinkedList<RequestPojo> getPendingRequests();
	public LinkedList<RequestPojo> getResolvedRequests();
	public void deleteRequest(int requestId);
	public void updateRequest(int rID, String status);
	public LinkedList<RequestPojo> getUserPending(int userId);
	public LinkedList<RequestPojo> getUserResolved(int userId);
}
