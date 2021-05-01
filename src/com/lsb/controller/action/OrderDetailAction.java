package com.lsb.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.OrderDAO;
import com.lsb.dto.*;

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderDetail.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			url = "LsbServlet?command=login_form";
	}	else {
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			
			OrderDAO oDao = OrderDAO.getInstance();
			List<OrderVO> orderList = oDao.listOrderById(loginUser.getId(), "%" , oseq);
			
			int totalPrice = 0;
			for (OrderVO order : orderList)   {
				totalPrice += order.getPrice2() * order.getQuantity();
			}
			
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("orderList", orderList);
	}
		request.getRequestDispatcher(url).forward(request, response);
	}
}


