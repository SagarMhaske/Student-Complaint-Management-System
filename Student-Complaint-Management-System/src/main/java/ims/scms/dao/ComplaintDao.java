package ims.scms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ims.scms.bean.CompUserBean;
import ims.scms.bean.ComplaintBean;
import ims.scms.bean.UserBean;
import ims.scms.dbconnectin.ConnectionProvider;

public class ComplaintDao {
	private static Connection conn = ConnectionProvider.getConnection();
	
	public ComplaintDao() {
		System.out.println("sagar 1");
		conn = ConnectionProvider.getConnection();
	}
	
	// 1] log the complaint
	public static int logComplaint(ComplaintBean compBean) {
		int status = 0;
		try {
			String sql ="INSERT INTO complaint(compDate,userId,compType,compDescrip)"+" VALUES(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, compBean.getDate());
			ps.setInt(2, compBean.getUserId());
			ps.setString(3, compBean.getCompType());
			ps.setString(4, compBean.getCompDestrip());
			
			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("logComplaint");
			e.printStackTrace();
		}
		return status;
	}
	
	// 2] list of complaint
	public  List listOfComplaint() {
		List complaints = new ArrayList();
		try {
			String sql = "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CompUserBean cub = new CompUserBean();
				cub.setComplaintId(rs.getInt("compId"));
				cub.setUserName(rs.getString("userName"));
				cub.setUserContact(rs.getString("userContact"));
				cub.setCompType(rs.getString("compType"));
				cub.setCompDestrip(rs.getString("compDescrip"));
				cub.setCompStatus(rs.getString("compStatus"));
				cub.setDate(rs.getString("compDate"));
				complaints.add(cub);
			}
		} catch (SQLException e) {
			System.out.println("listOfComplaint");
			e.printStackTrace();
		}
		return complaints;
	}
	// 3] list Type Wise
	public List complaintsOfType(String compType) {
		List compListByType = new ArrayList();
		try {
			
			String sql = "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId where compType = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, compType);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					ComplaintBean cb = new ComplaintBean();
					UserBean ub = new UserBean();
					cb.setComplaintId(rs.getInt("compId"));
					ub.setUserName(rs.getString("userName"));
					ub.setUserContact(rs.getString("userContact,"));
					cb.setCompType(rs.getString("compType"));
					cb.setCompDestrip(rs.getString("compDescrip"));
					cb.setCompStatus(rs.getString("compStatus"));
					cb.setDate(rs.getString("compDate"));
					compListByType.add(cb);
					compListByType.add(ub);
				}
				
			}
			else {
				///////////-------------////////////
			}
			
		} catch (SQLException e) {
			System.out.println("complaintsOfType");
			e.printStackTrace();
		}
		return compListByType;
	}
	
	// 4] update resolve status of complaint 
	public void updateResolveStatus(ComplaintBean compbean) {
		try {
			String sql = "UPDATE complaint SET compStatus = ?"+" WHERE userId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, compbean.getCompStatus());
			ps.setInt(2, compbean.getUserId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateResolveStatus");
			e.printStackTrace();
		}
	}
	
//	5] list of complaint between date 
	public List complaintBetweenDate(Date compDate1, Date compDate2 ) {
		List complaintsBetDat = new ArrayList();
		try {
			String sql = "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId where compDate BETWEEN '?' AND '?'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, compDate1);
			ps.setDate(2, compDate2);
			
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					ComplaintBean cb = new ComplaintBean();
					UserBean ub = new UserBean();
					cb.setComplaintId(rs.getInt("compId"));
					ub.setUserName(rs.getString("userName"));
					ub.setUserContact(rs.getString("userContact,"));
					cb.setCompType(rs.getString("compType"));
					cb.setCompDestrip(rs.getString("compDescrip"));
					cb.setCompStatus(rs.getString("compStatus"));
					cb.setDate(rs.getString("compDate"));
					complaintsBetDat.add(cb);
					complaintsBetDat.add(ub);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("complaintBetweenDate");
			e.printStackTrace();
		}
		
		return complaintsBetDat;
	}
	// 5] list of resolved complaint 
	public List resolvedComplaints() {
		List resolComplaints = new ArrayList();
		try {
			String sql = "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId where complaint.compStatus = 'Resolved'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ComplaintBean cb = new ComplaintBean();
				UserBean ub = new UserBean();
				cb.setComplaintId(rs.getInt("compId"));
				ub.setUserName(rs.getString("userName"));
				ub.setUserContact(rs.getString("userContact,"));
				cb.setCompType(rs.getString("compType"));
				cb.setCompDestrip(rs.getString("compDescrip"));
				cb.setCompStatus(rs.getString("compStatus"));
				cb.setDate(rs.getString("compDate"));
				resolComplaints.add(cb);
				resolComplaints.add(ub);
			}
		} catch (SQLException e) {
			System.out.println("resolvedComplaints");
			e.printStackTrace();
		}
		return resolComplaints;
	}
	
	//6] list of pending complaint 
	public List  pendingComplaints() {
		List pendComplaints = new ArrayList();
		try {
			String sql = "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId where complaint.compStatus = 'Pending'";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ComplaintBean cb = new ComplaintBean();
				UserBean ub = new UserBean();
				cb.setComplaintId(rs.getInt("compId"));
				ub.setUserName(rs.getString("userName"));
				ub.setUserContact(rs.getString("userContact,"));
				cb.setCompType(rs.getString("compType"));
				cb.setCompDestrip(rs.getString("compDescrip"));
				cb.setCompStatus(rs.getString("compStatus"));
				cb.setDate(rs.getString("compDate"));
				pendComplaints.add(cb);
				pendComplaints.add(ub);
			}
		} catch (SQLException e) {
			System.out.println("pendingComplaints");
			e.printStackTrace();
		}
		return pendComplaints;
	}
	
//	7]  list of complaint By email and password 
	public List listByEmail(UserBean userBean) {
		List listbyemail = new ArrayList();
		try {
			String sql =  "SELECT complaint.compId, user.userName, user.userContact, complaint.compType, complaint.compDescrip, complaint.compStatus, complaint.compDate FROM user JOIN complaint ON user.userId = complaint.userId where user.userEmail = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getUserEmail());
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()) {
				CompUserBean cub = new CompUserBean();
				cub.setComplaintId(rs.getInt("compId"));
				cub.setUserName(rs.getString("userName"));
				cub.setUserContact(rs.getString("userContact,"));
				cub.setCompType(rs.getString("compType"));
				cub.setCompDestrip(rs.getString("compDescrip"));
				cub.setCompStatus(rs.getString("compStatus"));
				cub.setDate(rs.getString("compDate"));
				listbyemail.add(cub);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listbyemail;
	}
	
	// 4] update resolve status of complaint 
		public void updateComplaintStatus(String compId, String compStatus) {
			try {
				
				System.out.println(compId +" "+ compStatus);
				String sql = "UPDATE complaint SET compStatus = ?"+" WHERE compId = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, compStatus);
				ps.setInt(2, Integer.parseInt(compId));
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("updateResolveStatus");
				e.printStackTrace();
			}
		}
	
	
	
}
