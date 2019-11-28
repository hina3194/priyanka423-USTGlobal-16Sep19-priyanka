package com.ustglobal.jdbcapp3;

import java.sql.*;
import com.mysql.jdbc.Driver;
public class DynamicInsertQuery {

	public static void main(String[] args) {
		Connection conn=null; // import java.sql.connection;
		PreparedStatement pstmt=null;
		try {
			// Step 1: Load the Driver
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);

			// 2nd step: Get the Connection
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);

			//3rd step: Issue the sql query

			String sql="insert into employee_info values(?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			String empid=args[0];
			int id=Integer.parseInt(empid);
			pstmt.setInt(1,id);

			String name=args[1];
			pstmt.setString(2,name);

			String emsal=args[2];
			int sal=Integer.parseInt(emsal);
			pstmt.setInt(3,sal);

			String egender=args[3];
			pstmt.setString(4, egender);

			int count=pstmt.executeUpdate();

			// 4th step: Read the Result
			System.out.println(count + " Row(s) inserted");

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			// 5th step: Closed all the JDBC Objects
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}// end of main()
}// end of ExecuteInsertQuery 




