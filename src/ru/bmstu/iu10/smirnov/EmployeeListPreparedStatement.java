package ru.bmstu.iu10.smirnov;

import java.sql.*;

public class EmployeeListPreparedStatement {
	public static void main(String argv[]) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int empNumbers[] = {7369, 7499, 7521};

		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22");
			stmt = conn.prepareStatement("SELECT * from Employee WHERE empno=?");
			System.out.println("Using PreparedStatement:");
			for (int empNo: empNumbers) {
				stmt.setInt(1, empNo);
				rs = stmt.executeQuery();
				rs.next();
				String eName = rs.getString("ENAME");
				String job = rs.getString("JOB_TITLE");
				System.out.println(empNo + ", " + eName + ", " + job);
			}
		} catch (SQLException se) {
			System.out.println("SQLERROR: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
