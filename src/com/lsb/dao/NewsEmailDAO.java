package com.lsb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.lsb.dto.*;

import util.DBManager;

public class NewsEmailDAO {
	private static NewsEmailDAO instance = new NewsEmailDAO();
	private NewsEmailDAO() {}
	public static NewsEmailDAO getInstance() {
		return instance;
	}

public void insertEmail(NewsEmailVO newsemailVO) {
	 Connection conn = null;
	 PreparedStatement pstmt = null;
	 String sql = "INSERT INTO news_email(neseq, email) "+
	 "VALUES(news_email_seq.nextval, ?)";
	 try {
		 conn = DBManager.getConnection();
		 pstmt = conn.prepareStatement(sql);
		 
		 pstmt.setString(1, newsemailVO.getEmail());
		 
		 pstmt.executeUpdate();
	 	
	 } catch(Exception e) {
		 e.printStackTrace();
	 } finally {
		 DBManager.close(conn, pstmt);
	 }
}

public ArrayList<NewsEmailVO> listAllEmail() {
	ArrayList<NewsEmailVO> emailList= new ArrayList<>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql="SELECT * FROM news_email";
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			NewsEmailVO newsEmail = new NewsEmailVO();
			newsEmail.setEmail(rs.getString("email"));
			newsEmail.setNeseq(rs.getInt("neseq"));
			newsEmail.setRegdate(rs.getTimestamp("regdate"));
			emailList.add(newsEmail);
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	return emailList;
	}
}