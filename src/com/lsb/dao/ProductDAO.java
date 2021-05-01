package com.lsb.dao;

import java.sql.*;
import java.util.ArrayList;
import com.lsb.dto.*;

import util.Criteria;
import util.DBManager;
public class ProductDAO {
	private ProductDAO() {}
	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ProductVO> listAllApparel() {
		ArrayList<ProductVO> productList= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM apparel_view";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));  
				product.setKind(rs.getString("kind"));
				product.setPrice2(rs.getInt("price2"));
				String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}				
				product.setImages(image_files);
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	public ArrayList<ProductVO> listAllFootwear() {
		ArrayList<ProductVO> productList= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM footwear_view";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));  
				product.setKind(rs.getString("kind"));
				product.setPrice2(rs.getInt("price2"));
				
				String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				product.setImages(image_files);
				
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	
	public ArrayList<ProductVO> listAllProduct() {
		ArrayList<ProductVO> productList= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM product";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice2(rs.getInt("price2"));
				String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				product.setImages(image_files);
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
	public int countProductList(String productName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql="SELECT COUNT(*) FROM product "+
				"WHERE name LIKE '%'||?||'%'";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(productName == "") {
				pstmt.setString(1, "");
			} else {
				pstmt.setString(1, productName);
			}
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public ArrayList<ProductVO> listNewProduct() {
		ArrayList<ProductVO> productList= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM new_pro_view";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				/* 
				 * old method, didn't show first pic in new_arrivals.jsp
				String[] image_files = new String[10];
				image_files[1] = rs.getString("image1");
				*/
				/* og method from list all footwear
				 * 	String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				 */		
				String[] image_files = new String[10];
				for(int i=0; i<=1; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				product.setImages(image_files);
				
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return (ArrayList<ProductVO>) productList;
	}
	
	public ArrayList<ProductVO> listBestProduct() {
		ArrayList<ProductVO> productList= new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM best_pro_view";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				String[] image_files = new String[10];
				image_files[0] = rs.getString("image1");
				product.setImages(image_files);
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return (ArrayList<ProductVO>) productList;
	}
	
	public ProductVO getProduct(String pseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM product WHERE pseq=?";
		ProductVO product = new ProductVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice1(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				product.setContent(rs.getString("content"));
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				product.setImages(image_files);
				product.setUseyn(rs.getString("useyn"));
				product.setBestyn(rs.getString("bestyn"));
				product.setRegdate(rs.getTimestamp("regdate"));
			}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
		return product;
	}
	
	public ArrayList<ProductVO> listKindProduct(String kind) {
		ArrayList<ProductVO> productList= new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="SELECT * FROM product WHERE kind=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,kind);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setPrice2(rs.getInt("price2"));
				
				String[] image_files = new String[10];
				for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
				}
				product.setImages(image_files);

				
				product.setColor(rs.getString("color"));
				product.setMeasurement(rs.getString("measurement"));
				productList.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
			return productList;
	}
	
//4/7 EDIT to show images on productList.jsp admin	
	public ArrayList<ProductVO> listProductByPage(Criteria cri, String productName) {
		ArrayList<ProductVO> productList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "SELECT pseq , regdate , name, price1 , price2 , image1, image2, image3,image4,image5,image6,image7, image8, image9,image10, useyn , bestyn "
				+ "FROM "
				+ "    (SELECT rownum rn, pseq , regdate , name, price1 , price2 , image1, image2, image3,image4,image5,image6,image7, image8, image9,image10, useyn , bestyn "
				+ "    FROM product "
				+ "    WHERE rownum <= ? * ?) "
				+ "WHERE rn > ?*?  ORDER BY pseq DESC ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			//all the ?==numbers from sql
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2,cri.getNumPerPage());
			pstmt.setInt(3, cri.getPageNum()-1);
			pstmt.setInt(4, cri.getNumPerPage());
			
			rs = pstmt.executeQuery();
			
			while(rs.next())	{
				ProductVO product = new ProductVO();
				 product.setPseq(rs.getInt("pseq"));
				 product.setRegdate(rs.getTimestamp("regdate"));
				 product.setName(rs.getString("name"));
				 product.setPrice1(rs.getInt("price1"));
				 product.setPrice2(rs.getInt("price2"));
			 	 String[] image_files = new String[10];
			 	 for(int i=0; i<10; i++) {
					image_files[i] = rs.getString("image"+(i+1));
			 	 }
				 product.setImages(image_files);
				 product.setUseyn(rs.getString("useyn"));
				 product.setBestyn(rs.getString("bestyn"));
				 productList.add(product);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	
//ADMIN//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateProduct(ProductVO product) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE product SET kind=?, name=?, price1=?, "+
						"price2=?, price3=?, content=?, image1=?, image2=?, "+
						"image3=?, image4=?, image5=?, image6=?, image7=?, "+
						"image8=?, image9=?, image10=?, color=?, measurement=?, "+
						"bestyn=?, useyn=? WHERE pseq=? ";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, product.getKind());
				pstmt.setString(2, product.getName());
				pstmt.setInt(3, product.getPrice1());
				pstmt.setInt(4, product.getPrice2());
				pstmt.setInt(5, product.getPrice3());
				pstmt.setString(6, product.getContent());

				String[] image_files = product.getImages();
				for(int i=0; i<10; i++) {
					pstmt.setString(i+7, image_files[i]);
				}
				
				pstmt.setString(17, product.getColor());
				pstmt.setString(18, product.getMeasurement());
				pstmt.setString(19, product.getBestyn());
				pstmt.setString(20, product.getUseyn());
				pstmt.setInt(21, product.getPseq());

				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public void insertProduct(ProductVO product)  {
			 Connection conn = null;
			 PreparedStatement pstmt = null;
			 String sql = "INSERT INTO product " +
			 "(pseq, kind, name, price1, price2, price3, content, image1, image2, "+
			 "image3, image4, image5, image6, image7, image8, image9, image10, "+
			 "color, measurement) VALUES(product_seq.nextval, ?, ?, ?, ?, ?, ?, ?, "+
			 "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			 try {
				 conn = DBManager.getConnection();
				 pstmt = conn.prepareStatement(sql);
				 
				 pstmt.setString(1, product.getKind());
				 pstmt.setString(2, product.getName());
				 pstmt.setInt(3, product.getPrice1());
				 pstmt.setInt(4, product.getPrice2());
				 pstmt.setInt(5, product.getPrice3());
				 pstmt.setString(6, product.getContent());
				 
				String[] image_files = product.getImages();
				for(int i=0; i<10; i++) {
					pstmt.setString(i+7, image_files[i]);
				}
			
				 pstmt.setString(17, product.getColor());
				 pstmt.setString(18, product.getMeasurement());
				 pstmt.executeUpdate();
			 } catch(Exception e) {
				 e.printStackTrace();
			 } finally {
				 DBManager.close(conn, pstmt);
			 }
		}
	
	public ArrayList<ProductVO> listProduct (String productName)  {
		ArrayList<ProductVO> productList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql="SELECT pseq, name, kind, price1, price2, price3, "+
				"image1,image2,image3,image4,image5,image6,image7, "+
				"image8, image9,image10, color, measurement, useyn, "+
				"bestyn FROM product "+
				"WHERE name LIKE '%'||?||'%' ORDER BY pseq DESC";
		try {
			 conn = DBManager.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 if(productName.equals("")) {
				 pstmt.setString(1, "");
			 } else {
				 pstmt.setString(1, productName);
			 }
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 ProductVO product = new ProductVO();
				 product.setPseq(rs.getInt("pseq"));
					product.setName(rs.getString("name"));
					product.setKind(rs.getString("kind"));
					product.setPrice1(rs.getInt("price1"));
					product.setPrice2(rs.getInt("price2"));
					product.setPrice3(rs.getInt("price3"));
					String[] image_files = new String[10];
					for(int i=0; i<10; i++) {
						image_files[i] = rs.getString("image"+(i+1));
					}
					product.setImages(image_files);
					product.setColor(rs.getString("color"));
					product.setMeasurement(rs.getString("measurement"));
					product.setUseyn(rs.getString("useyn"));
					product.setBestyn(rs.getString("bestyn"));
					productList.add(product);
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 DBManager.close(conn, pstmt);
		 }
		return productList;
	}
	
	public int totalRecord (String productName) {
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="SELECT * FROM product WHERE name LIKE '%'||?||'%' ";
		 try {
			 conn = DBManager.getConnection();
			 pstmt = conn.prepareStatement(sql);
			 if(productName.equals("%")) {
				 pstmt.setString(1, "");
			 } else {
				 pstmt.setString(1, "productName");
			 rs = pstmt.executeQuery();
			 }
			 while(rs.next()) {
				 ProductVO product = new ProductVO();
			 }
		 } catch(Exception e) {
			 e.printStackTrace();
		 } finally {
			 DBManager.close(conn, pstmt);
		 }
		return 0;
	}
}