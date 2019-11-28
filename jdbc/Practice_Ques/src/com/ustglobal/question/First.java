package com.ustglobal.question;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out=resp.getWriter();
		String id=req.getParameter("empid");
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn=DriverManager.getConnection(url);
			String sql="select * from employee_info where id="+id;
			pstmt=conn.prepareStatement(sql);

			out.println("<html>");
			out.println("<body>");
			out.println("<table><tr><th>id</th><th>name</th><th>sal</th><th>gender</th></tr></table>");
			out.println("</body>");
			out.println("</html>");
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				out.println("<tr><td></td>");
				out.println(rs.getInt(1));
				out.println("<td></td>");
				out.println(rs.getString(2));
				out.println("<td></td>");
				out.println(rs.getInt(3));
				out.println("<td></td>");
				out.println(rs.getString(4));
				out.println("</tr>");

			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
	}

}







