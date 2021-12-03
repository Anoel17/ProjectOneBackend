package pojo;

public class UserPojo {

	private int id= 0;
	private String userType= "_";
	private String email= "_";
	private String password= "_";
	private String screenName = "_";
	private String homeState= "_";
	private String homeTown= "_";
	private String address = "_";
	
	public UserPojo(int uID, String pLevel, String email, String pass, String screen_name, String home_state, String home_town, String address) {
		this.id =uID;
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
		this.screenName=screen_name;
		this.homeState=home_state;
		this.homeTown = home_town;
		this.address = address;
	}
	
	public UserPojo() {
		
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public String getUserType() {
		return this.userType;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	public String getHomeState() {
		return this.homeState;
	}
	
	public String getHomeTown() {
		return this.homeTown;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	
	public String toString() {
		return "UserPojo [userId=" + id + ", permissionLevel=" + userType + ", email=" + email + ", password="
				+ password + ", screenName=" + screenName + ", homeState=" + homeState + ", homeTown=" + homeTown + ", address=" + address+"]";
	}
}
