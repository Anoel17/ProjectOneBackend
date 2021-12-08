package dao;
import pojo.RequestPojo;
import java.util.LinkedList;
import java.util.List;
public interface RequestDao {

	
	
	public void createRequest(int userId, String date, int amount);
	public List<RequestPojo> getRequestsForUser(int userId);
	public List<RequestPojo> getAllRequests();
	public List<RequestPojo> getPendingRequests();
	public List<RequestPojo> getResolvedRequests();
	public void deleteRequest(int requestId);
	public void updateRequest(int rID, String status);
	public List<RequestPojo> getUserPending(int userId);
	public List<RequestPojo> getUserResolved(int userId);
}
