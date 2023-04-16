package ims.scms.bean;

public class UserRegisterBean {
	private String userName;
	private String userContact;
	private String userEmail;
	private String userPassword;
	
	
	public String getUserName() {
		System.out.println("getname");
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("setname");
		this.userName = userName;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}