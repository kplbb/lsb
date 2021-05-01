package util;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;


public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//resource cancellation after SELECT statement
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//resource cancellation after INSERT statement
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}


