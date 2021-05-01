package com.lsb.controller.action;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

import util.DBManager;

public class ApparelViewAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "product/apparelViewAll.jsp";
		
		ProductDAO pDao = ProductDAO.getInstance();
		ArrayList<ProductVO> allProdList = pDao.listAllApparel();
		
		request.setAttribute("allProductList", allProdList);

		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

	