package ims.scms.bean;

public class UserLoginBean {
	private String userEmail;
	private String userPassword;
	private String userType;
	
	
	
	public String getUserEmail() {
		System.out.println("udhav1");
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		System.out.println("udhav2");
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}