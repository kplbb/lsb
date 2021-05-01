package com.lsb.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

public class FootwearViewAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/footwear_view.jsp";
		ProductDAO pDao = ProductDAO.getInstance();
		
		ArrayList<ProductVO> footwearList = pDao.listAllFootwear();	
		request.setAttribute("footwearList", footwearList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
