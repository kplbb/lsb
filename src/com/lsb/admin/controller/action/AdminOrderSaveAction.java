package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.OrderDAO;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=admin_order_list";
		
		
		String[] resultArr = request.getParameterValues("result");   //from orderList.jsp 
		for (String odseq : resultArr)  {
			System.out.println(odseq);
			
			OrderDAO oDao = OrderDAO.getInstance();
			oDao.updateOrderResult(odseq);			//complete order process
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
