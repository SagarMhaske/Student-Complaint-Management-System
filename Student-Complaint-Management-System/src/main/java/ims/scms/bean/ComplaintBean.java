package ims.scms.bean;

import java.sql.Date;

public class ComplaintBean {
	private int complaintId;
	private String date;
	private int userId;
	private String  compType;
	private String compDestrip;
	private String compStatus;
	public int getComplaintId() {
		System.out.println("sam 2");
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		System.out.println("sam 1");
		this.complaintId = complaintId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompType() {
		return compType;
	}
	public void setCompType(String compType) {
		this.compType = compType;
	}
	public String getCompDestrip() {
		return compDestrip;
	}
	public void setCompDestrip(String compDestrip) {
		this.compDestrip = compDestrip;
	}
	public String getCompStatus() {
		return compStatus;
	}
	public void setCompStatus(String compStatus) {
		this.compStatus = compStatus;
	}
	
}
