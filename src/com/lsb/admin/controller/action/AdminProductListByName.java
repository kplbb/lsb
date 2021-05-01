package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class AdminProductListByName implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		
		String productName = request.getParameter("key");
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductVO> productList = pDao.listProduct(productName);
		
		for(ProductVO vo : productList) {
			System.out.println(vo);
		}
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher(url).forward(request, response);
		}

}
