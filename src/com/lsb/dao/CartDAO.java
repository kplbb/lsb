package com.lsb.dao;

import java.sql.*;
import java.util.*;

import com.lsb.dto.*;

import util.DBManager;

public class CartDAO {
	public static CartDAO instance = new CartDAO();
	private CartDAO() {}
	public static CartDAO getInstance() {
		return instance;
	}
	
		//user selected items insert into cart table 
	   public void insertCart(CartVO  cartVO) {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   String sql = "INSERT INTO cart(cseq, id, pseq, quantity)"+ "VALUES(cart_seq.nextval,?, ?, ?)";
		   try {
			   conn = DBManager.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   
			   pstmt.setString(1, cartVO.getId());
			   pstmt.setInt(2, cartVO.getPseq());
			   pstmt.setInt(3, cartVO.getQuantity());
			   
			   pstmt.executeUpdate();

		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   DBManager.close(conn, pstmt);
		   }
	   }
	   //cart identified by userid 
	   public ArrayList<CartVO> listCart(String userid) {
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   ResultSet rs = null;
		   ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		   String sql = "SELECT * FROM cart_view WHERE id=? ORDER BY cseq DESC";
		   
		   try {
			   conn = DBManager.getConnection();
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, userid);
			   
			   rs = pstmt.executeQuery();  //no sql cuz its above
			   
			   while(rs.next()) {
				   CartVO cart = new CartVO();
				   cart.setCseq(rs.getInt("cseq"));
				   cart.setId(rs.getString("id"));
				   cart.setPseq(rs.getInt("pseq"));
				   cart.setMname(rs.getString("mname"));
				   cart.setPname(rs.getString("pname"));
				   cart.setQuantity(rs.getInt("quantity"));
				   cart.setPrice2(rs.getInt("price2"));
				   cart.setIndate(rs.getTimestamp("indate"));
				   cartList.add(cart);
			   }
		   } catch(Exception e) {
			   e.printStackTrace();
		   } finally {
			   DBManager.close(conn, pstmt, rs);
		   }
		   return cartList;
	   }
	   //delete a item identified by cseq in cart
	    public void deleteCart(int cseq) {
	    	Connection conn = null;
			PreparedStatement pstmt = null;
	    	String sql = "DELETE cart WHERE cseq=?";
			   try {
				   conn = DBManager.getConnection();
				   pstmt = conn.prepareStatement(sql);
				   
				   pstmt.setInt(1, cseq);
	
				   pstmt.executeUpdate();

			   }catch(Exception e) {
				   e.printStackTrace();
			   }finally {
				   DBManager.close(conn, pstmt);
			   }
	    }
	
	    
}
