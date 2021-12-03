package pojo;

public class RequestPojo {
	private int id=0;
	private int userId=0;
	private String date="";
	private int amount=0;
	private String status="";
	
	public RequestPojo(int rID, int uID, String date, int amount, String status) {
		this.id =rID;
		this.userId = uID;
		this.date = date;
		this.amount=amount;
		this.status = status;
	}
	
	public RequestPojo() {
		
	}
	
	
	
	
	public int getId() {
		return this.id;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getAmount() {
		return this.amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString() {
		return "BookPojo [requestId=" + id + ", userId=" + userId + ", date=" + date + ", amount="
				+ amount + ", status=" + status + "]";
	}
	
}
