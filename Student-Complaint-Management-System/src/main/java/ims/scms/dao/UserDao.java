package ims.scms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ims.scms.bean.UserBean;
import ims.scms.bean.UserLoginBean;
import ims.scms.dbconnectin.ConnectionProvider;
import ims.scms.bean.UserRegisterBean;

public class UserDao {
	private static Connection conn = ConnectionProvider.getConnection();
	
	public UserDao() {
		conn = ConnectionProvider.getConnection();
	}
	
	// 1 user register 
	public static int userRegister(UserRegisterBean userRegisterBean) {
		int status = 0;
		try {
			
			String sql ="INSERT INTO user(userName, userContact, userEmail, userPassword) "+" VALUES(?,?,?,?)";
			System.out.println("sagar1");
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println("sagar2");
			ps.setString(1, userRegisterBean.getUserName());
			ps.setString(2, userRegisterBean.getUserContact());
			ps.setString(3, userRegisterBean.getUserEmail());
			ps.setString(4, userRegisterBean.getUserPassword());
			System.out.println(userRegisterBean.getUserName());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("userRegistration");
			e.printStackTrace();
		}
		return status;
	}
	
	
	// 2} user login
	
//	public void userLogin(UserBean userBean) {
//		String sql = "SELECT userName, userPassword, userType from user where userEmail = ? and userPassword = ? ";
//		
//	}

//    public static int userRegister(UserRegisterBean user) {
//        // check that conn is not null
//        if (conn == null) {
//            System.err.println("Connection is null!");
//            return -1;
//        }
//        
//        int i = 0;
//        try {
//            PreparedStatement ps = conn.prepareStatement(
//                "INSERT INTO user (userName, userPassword, userEmail, userContact) VALUES (?, ?, ?, ?)");
//            ps.setString(1, user.getUserName());
//            ps.setString(2, user.getUserContact());
//            ps.setString(3, user.getUserEmail());
//            ps.setString(4, user.getUserPassword());
//            i = ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return i;
//    }
	
	// 2] user login 
	public static boolean userLogin(UserLoginBean userLoginBean){  
		boolean status=false;  
		try{
			String sql ="select * from user where userEmail = ? and userPassword = ? and userType = ?";
		PreparedStatement ps=conn.prepareStatement(sql);  
		  
		ps.setString(1, userLoginBean.getUserEmail());  
		ps.setString(2, userLoginBean.getUserPassword()); 
		ps.setString(3, userLoginBean.getUserType());
		System.out.println(userLoginBean.getUserEmail() + " " + userLoginBean.getUserPassword() + " " + userLoginBean.getUserType());
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		              
		}catch(SQLException e){
			e.printStackTrace();
		}  
		  
		return status;  
		  
		}  
}
