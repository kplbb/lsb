package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productUpdate.jsp";
		String pseq = request.getParameter("pseq");
		
		ProductDAO pDao = ProductDAO.getInstance();
		ProductVO product = pDao.getProduct(pseq);
		
		request.setAttribute("productVO", product);
		
		//String kindList[] = {"T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"};   //no "" at begining cause no index use
		//String kindList[] = {"", "T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "DRESS","JUMPSUITS","SKIRT","ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 
		String kindList[] = {"T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "DRESS","JUMPSUITS","SKIRT","ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 

		request.setAttribute("kindList", kindList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
