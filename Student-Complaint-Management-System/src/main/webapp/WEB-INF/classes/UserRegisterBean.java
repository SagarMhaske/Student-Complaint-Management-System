package ims.scms.bean;

public class UserRegisterBean {
	private String userName;
	private String userContact;
	private String userEmail;
	private String userPassword;
	
	
	public String getUserName() {
		System.out.println("sagar sagar 3");
		return userName;
	}
	public void setUserName(String userName) {
		System.out.println("sagar sagar 1");
		this.userName = userName;
	}
	public String getUserContact() {
		System.out.println("sagar sagar 4");
		return userContact;
	}
	public void setUserContact(String userContact) {
		System.out.println("sagar sagar 2");
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