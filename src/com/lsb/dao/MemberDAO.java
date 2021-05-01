package com.lsb.dao;

import java.util.*;
import com.lsb.dto.*;
import java.sql.*;
import util.DBManager;

public class MemberDAO {
	//singleton
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
//ADMIN////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<MemberVO> listMember(String member_name) {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE name LIKE '%'||?||'%' "+
					"ORDER BY regdate DESC ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(member_name == "") {
				pstmt.setString(1, "");
			} else {
				pstmt.setString(1, member_name);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setZip_num(rs.getString("zip_num"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setNews_email_yn(rs.getString("news_email_yn"));
				member.setuseyn(rs.getString("useyn"));
				member.setRegdate(rs.getTimestamp("regdate"));
				memberList.add(member);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberList;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public int confirmID(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT pwd FROM member WHERE id=? " ;
		int result = -1;   //when not normal
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
				if(rs.next()) {  
					result = 1; //id exists in db
				} else { 		 //id doesn't exist in db
					result = -1; 
				}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public int loginCheck(String userid, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pwd_in_db = "";
		String sql = "SELECT pwd FROM member WHERE id=? " ;
		int result = -1;   //when not normal
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
				if(rs.next()) {  
					result = 0; //id exists in db
					pwd_in_db = rs.getString("pwd");
					if (pwd.equals(pwd_in_db)) {
						result = 1;
					}
					
				} else { 		 //id doesn't exist in db
					result = -1; 
				}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	public MemberVO getMember(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member WHERE id=?" ;
		MemberVO member = null ;	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
				if(rs.next()) { 
					member = new MemberVO() ;  //only when exists in data
					member.setId(rs.getString("id"));
					member.setPwd(rs.getString("pwd"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setZip_num(rs.getString("zip_num"));
					member.setAddress(rs.getString("address"));
					member.setPhone(rs.getString("phone"));
					member.setuseyn(rs.getString("useyn"));
					member.setRegdate(rs.getTimestamp("regdate"));
					}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return member;
	}
	
	//saving use info to member table
	public void insertMember(MemberVO memberVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member(id, pwd, name, email, zip_num, address, phone, news_email_yn) VALUES(?, ?, ?, ?, ?, ?, ?, ?)" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getZip_num());
			pstmt.setString(6, memberVO.getAddress());
			pstmt.setString(7, memberVO.getPhone());
			pstmt.setString(8, memberVO.getNews_email_yn());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}

