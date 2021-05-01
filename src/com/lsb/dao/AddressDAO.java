package com.lsb.dao;

import java.sql.*;
import java.util.*;

import com.lsb.dto.AddressVO;

import util.DBManager;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();
	private AddressDAO() {}
	public static AddressDAO getInstance() {
		return instance;
	}
	
	public ArrayList<AddressVO> selectAddressByDong(String dong) {		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AddressVO> addrList = new ArrayList<>();
		String sql = "SELECT * FROM address WHERE dong LIKE '%'||?||'%' " ;
		
		try { 
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
					
			while(rs.next()) {  //while not if cuz dong isn't PK, while yields more than one, (pk like id returns 1)
				AddressVO address = new AddressVO();
				address.setZipcode(rs.getString("zipcode"));
				address.setStreet(rs.getString("street"));
				address.setState(rs.getString("state"));
				address.setProvidence(rs.getString("providence"));
				address.setCountry(rs.getString("country"));
				
				addrList.add(address);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
			return(ArrayList<AddressVO>) addrList;
	}


}

