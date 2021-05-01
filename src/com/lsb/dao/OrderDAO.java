package com.lsb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.lsb.dto.*;
import util.DBManager;

public class OrderDAO {
	public static OrderDAO instance = new OrderDAO();
	private OrderDAO() {}
	public static OrderDAO getInstance() {
		return instance;
	}
	//ADMIN////////////////////////////////////////////////////////////////////
	public void updateOrderResult(String odseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE order_detail SET result='2' "+
					"WHERE odseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,odseq);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<OrderVO> listOrder(String member_name) {  
		ArrayList<OrderVO> orderList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM order_view WHERE mname LIKE "+
					"'%'||?||'%' ORDER BY result, oseq DESC" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(member_name == "") {      //if ? from sql is empty 
				pstmt.setString(1, "");
			} else {
				pstmt.setString(1, member_name);
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVO order = new OrderVO();

				order.setOdseq(rs.getInt("odseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("ID"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setMname(rs.getString("mname"));
				order.setZipnum(rs.getString("zip_num"));
				
				order.setAddress(rs.getString("address"));
				order.setPayment(rs.getString("payment"));
				order.setEmail(rs.getString("email"));
				
				order.setPhone(rs.getString("phone"));
				order.setPseq(rs.getInt("pseq"));
				order.setPname(rs.getString("pname"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
			
				orderList.add(order);
			}		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return orderList;
	}
	///////////////////////////////////////////////////////////////////////////
	public int insertOrder(List<CartVO> cartList , String userid, String address, String payment, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxOseq = 0;
		//ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();

		try {
			conn =	DBManager.getConnection();
			
			//max order num in orders table
			String selectMaxOseq = "SELECT max(oseq) FROM orders";
			pstmt = conn.prepareStatement(selectMaxOseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxOseq = rs.getInt(1); //.getInt=(column index)
				System.out.println("max order number in order table: " + maxOseq);
			}
			pstmt.close();
			
			maxOseq += 1;
			
			String insertOrder = "INSERT INTO orders(oseq, id, address, payment, email ) VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setInt(1, maxOseq);
			pstmt.setString(2, userid);
			pstmt.setString(3, address);
			pstmt.setString(4, payment);
			pstmt.setString(5, email);	
			
//			pstmt.setString(3, address);
//			String[] payments = new String[5];
//			for(int i=0; i<5; i++) {
//				payment[i] = rs.getString(i+1);
//			}				
//			pstmt.setString[](payments);	
			
			pstmt.executeUpdate();  //insert order info into orders table
			//invoke shopping cart info(cartList) to insert order info 
			for( CartVO cart : cartList) {
				insertOrderDetail(cart, maxOseq);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return maxOseq;		
	}
	private void insertOrderDetail(CartVO cart, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			String insertOrderDetail = "INSERT INTO ORDER_DETAIL(odseq, oseq, pseq, quantity) "+
									   "VALUES(order_detail_seq.nextval, ?,?,?)";
			pstmt = conn.prepareStatement(insertOrderDetail);
			pstmt.setInt(1, maxOseq);
			pstmt.setInt(2, cart.getPseq());
			pstmt.setInt(3, cart.getQuantity());
			
			pstmt.executeUpdate();
			pstmt.close();
			
			//cart table update
			String updateCart = "UPDATE cart SET result=2 WHERE cseq=?";
			pstmt = conn.prepareStatement(updateCart);
			pstmt.setInt(1, cart.getCseq());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	/*
	 * user order info display
	 * userId=user id
	 * result: order status (1: order not completed, 2: completed)
	 * oseq: order number upon order received
	 */ 
	public List<OrderVO> listOrderById(String userId, String result, int oseq) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM order_view WHERE id=? "
				+ "AND result LIKE '%'||?||'%' AND oseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, result);
			pstmt.setInt(3, oseq);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVO order = new OrderVO();
				
				order.setOdseq(rs.getInt("oseq"));
				order.setOseq(rs.getInt("oseq"));
				order.setId(rs.getString("ID"));
				order.setIndate(rs.getTimestamp("indate"));
				order.setMname(rs.getString("mname"));
				order.setZipnum(rs.getString("zip_num"));
				
				order.setAddress(rs.getString("address"));
				order.setPayment(rs.getString("payment"));
				order.setEmail(rs.getString("email"));
				
				order.setPhone(rs.getString("phone"));
				order.setPseq(rs.getInt("pseq"));
				order.setPname(rs.getString("pname"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice2(rs.getInt("price2"));
				order.setResult(rs.getString("result"));
				
				orderList.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
			
	    return orderList;
	}
	
	//invokes order #s not yet processed 
	public ArrayList<Integer> selectSeqOrdering(String userid, String result) {
		ArrayList<Integer> oseqList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT oseq FROM order_view " +  //SPACE!!! after order_view
					"WHERE id=? AND result LIKE '%'||?||'%' ORDER BY oseq DESC" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2,  result);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				oseqList.add(rs.getInt("oseq"));
			}
			
		} catch(Exception e) {
			e.fillInStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return oseqList;
	}
	
}
