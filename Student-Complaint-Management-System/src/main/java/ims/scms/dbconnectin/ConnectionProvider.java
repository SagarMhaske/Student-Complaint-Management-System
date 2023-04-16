package ims.scms.dbconnectin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	private static Connection con = null;
	public static Connection getConnection() {
		if(con != null) {
//			System.out.println("sagar");
			return con;
		}
		else {
			try {
//				System.out.println("sagar");
				String deiver = "com.mysql.cj.jdbc.Driver";
				String url ="jdbc:mysql://localhost:3306/scms";
				String user ="root";
				String password ="";
				
				Class.forName(deiver);
				
				con = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

}