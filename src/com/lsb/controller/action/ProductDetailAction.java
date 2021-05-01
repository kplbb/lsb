package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/productDetail.jsp" ;
		String pseq = request.getParameter("pseq");
	
	ProductDAO pDao = ProductDAO.getInstance();
	ProductVO product = pDao.getProduct(pseq);
	request.setAttribute("productVO", product);
	
	RequestDispatcher rd = request.getRequestDispatcher(url);
	rd.forward(request, response);
		
	}

}
