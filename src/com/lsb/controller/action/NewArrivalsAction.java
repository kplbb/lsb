package com.lsb.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class NewArrivalsAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/new_arrivals.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductVO> newProdList = pDao.listNewProduct();
		
		request.setAttribute("newProdList", newProdList);

		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}
}
