package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.CartDAO;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=cart_list";
		
		String[] cseqArr = request.getParameterValues("cseq");
		
		CartDAO cDao = CartDAO.getInstance(); 
		for(String cseq:cseqArr) {
			cDao.deleteCart(Integer.parseInt(cseq));
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
