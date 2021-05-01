package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.OrderDAO;
import com.lsb.dto.OrderVO;

public class AdminOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/order/orderList.jsp";
		String key  = "";  //product name from orderList.jsp
		
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");  //if there is key value then saved to key
		}
		OrderDAO oDao = OrderDAO.getInstance();
		ArrayList<OrderVO> order = oDao.listOrder(key);
		
		request.setAttribute("orderList", order);   //orderList the name on orderList.jsp
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
