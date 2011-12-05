package ru.bmstu.iu10.smirnov;

import java.sql.*;

public class OrdersTransaction {
	public static void main(String argv[]) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Lesson22-2");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("INSERT into Orders VALUES(123, 'Buy', 'IBM', 200)");
			stmt.addBatch("INSERT into OrderDetail VALUES('JSmith', 'Broker131', '05/20/20')");
			stmt.executeBatch();
			conn.commit();
		} catch (SQLException se) {
			System.out.println("SQLERROR: " + se.getMessage() + " code: " + se.getErrorCode());
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
