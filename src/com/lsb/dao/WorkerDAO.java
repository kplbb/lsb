package com.lsb.dao;

import java.sql.*;
import util.DBManager;

public class WorkerDAO {
	private WorkerDAO () {}
	public static WorkerDAO instance = new WorkerDAO();
	public static WorkerDAO getInstance() {
		return instance;
	}
	/*
	 *  1 = match, login successful 
	 * -1 = no id
	 *  0 = pwd no match
	 */
	public int workerCheck(String userId, String userPwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT pwd FROM worker WHERE id=?";
		int result = -1 ;    //no id in db
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
				
				if(rs.next()) {   //id exists in db
					String pwd_in_db = rs.getString(1);  //1=index (cuz only one value) or pwd 
					result = 0;
					if(userPwd.equals(pwd_in_db)) {      //input & db passwords match
							result = 1; 
					}
				}
		} catch(Exception e) {
			e.fillInStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
}

