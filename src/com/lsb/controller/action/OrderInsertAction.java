package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.*;
import com.lsb.dto.CartVO;
import com.lsb.dto.MemberVO;
import java.util.List;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		//added
		String address = request.getParameter("address");
		String payment1 = request.getParameter("payment1");
		String payment2 = request.getParameter("payment2");
		String payment3 = request.getParameter("payment3");
		String payment4 = request.getParameter("payment4");
		String payment5 = request.getParameter("payment5");
		String payment = payment1 + " "+ payment2+  " "+payment3+ " "+payment4+ " "+payment5;
		String email = request.getParameter("email");
	
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			url = "LsbServlet?command=login_form";
		} else {
			CartDAO cDao = CartDAO.getInstance();
			List<CartVO> cartList = cDao.listCart(loginUser.getId());
			
			OrderDAO oDao = OrderDAO.getInstance();
			int maxOseq = oDao.insertOrder(cartList, loginUser.getId(), address, payment, email);
			
			url = "LsbServlet?command=order_list&oseq=" + maxOseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
