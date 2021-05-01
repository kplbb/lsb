package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class AdminProductDetailAction implements Action {
		// command = URL: lsbServlet?command admin_product_detail&pseq
	
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productDetail.jsp";
		String pseq = request.getParameter("pseq");
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO product = pDao.getProduct(pseq);
		request.setAttribute("productVO", product);  //productVO name in productDetail.jsp

		String kindList[] = {"", "T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "DRESS","JUMPSUITS","SKIRT","ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 
		//String kindList[] = {"", "T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 
		//String kindList[] = {"", "Heels" , "Boots" , "Sandals" , "Slipers" , "Sneakers", "Sale"}; 	//"" is at index 0
		int kind = Integer.parseInt(product.getKind());      //product is char/String 
		request.setAttribute("kind", kindList[kind]);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
