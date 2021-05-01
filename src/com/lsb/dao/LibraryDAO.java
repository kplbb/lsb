package com.lsb.dao;

import java.sql.*;
import java.util.*;
import com.lsb.dto.*;
import util.DBManager;

public class LibraryDAO {
	public static LibraryDAO instance = new LibraryDAO();
	private LibraryDAO() {}
	public static LibraryDAO getInstance() {
		return instance;
	}
//ADMIN////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateLibrary(LibraryVO lib) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="UPDATE library SET content=?, subject=?, "+
		"image1=?, image2=?, image3=?, image4=?, image5=? "+
		"WHERE lseq=? "; 		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//add
			pstmt.setString(1, lib.getContent());
			pstmt.setString(2, lib.getSubject());
			
			String[] image_files = lib.getImages();
			for(int i=0; i<5; i++) {
				pstmt.setString(i+3, image_files[i]);
			}
			//
			
			pstmt.setInt(8, lib.getLseq());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<LibraryVO> listAllLibrary() {
		ArrayList<LibraryVO> libList = new ArrayList<LibraryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM library ORDER BY indate DESC";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LibraryVO lib = new LibraryVO();
				
				//save contents retreived from DB to lib object
				lib.setLseq(rs.getInt("lseq"));
				lib.setSubject(rs.getString("subject"));
				lib.setContent(rs.getString("content"));
			//	lib.setId(rs.getString("id"));
				lib.setIndate(rs.getTimestamp("indate"));
				String[] image_files = new String[5];
				for(int i=0; i<5; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				lib.setImages(image_files);
				libList.add(lib);
			}
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return libList;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// with user id, display lib 
	public ArrayList<LibraryVO> listLibrary(String id) {
		ArrayList<LibraryVO> libList = new ArrayList<LibraryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM library where id=? ORDER BY lseq DESC";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LibraryVO lib = new LibraryVO();
				
				//save contents retreived from DB to lib object
				lib.setLseq(rs.getInt("lseq"));
				lib.setSubject(rs.getString("subject"));
				lib.setContent(rs.getString("content"));
				lib.setId(rs.getString("id"));
				lib.setIndate(rs.getTimestamp("indate"));
				String[] image_files = new String[5];
				for(int i=0; i<5; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				lib.setImages(image_files);
				
				libList.add(lib);
			}
		} catch(Exception e) {
			e.fillInStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return libList;
	}
	//search for post based on lib order number 
	public LibraryVO getLibrary(int lseq) {
		LibraryVO lib = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM library where lseq=? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lseq);
		
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				lib = new LibraryVO();
				
				//save contents retreived from DB to lib object
				lib.setLseq(rs.getInt("lseq"));
				lib.setSubject(rs.getString("subject"));
				lib.setContent(rs.getString("content"));
				lib.setId(rs.getString("id"));
				lib.setIndate(rs.getTimestamp("indate"));
				String[] image_files = new String[5];
				for(int i=0; i<5; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				lib.setImages(image_files);
			}
		} catch(Exception e) {
			e.fillInStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lib;
	}
	public void insertLibrary(LibraryVO lib) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO library(lseq, subject, content, image1, " +
					"image2, image3, image4, image5) " + 
					"VALUES(lib_seq.nextval, ?, ?, ?, ?, ?, ?,?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lib.getSubject());
			pstmt.setString(2, lib.getContent());
			//pstmt.setString(3, session_id);   String session_id
			
			String[] image_files = lib.getImages();
			for(int i=0; i<5; i++) {
				pstmt.setString(i+3, image_files[i]);
			}			
			pstmt.executeUpdate();
			
		} catch(Exception e)  {
			e.fillInStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		public void deleteLib(int lseq) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE library WHERE lseq=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,  lseq);
				pstmt.executeUpdate();
			  }catch(Exception e) {
				   e.printStackTrace();
			   }finally {
				   DBManager.close(conn, pstmt);
		}
	}	
}
