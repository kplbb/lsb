package com.lsb.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.OrderDAO;
import com.lsb.dto.MemberVO;
import com.lsb.dto.OrderVO;

public class AllOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			url = "LsbServlet?command=login_form";
		} else {
			//variable to store order summary list
			ArrayList<OrderVO> orderList = new ArrayList<>();
			OrderDAO oDao = OrderDAO.getInstance();
			String userId = loginUser.getId();
			//invoke users order number (ordered)
			ArrayList<Integer> oseqList = oDao.selectSeqOrdering(userId, "%");
			//invoking order info from order numbers saved in oseqList
			for(int oseq : oseqList)  {
				List<OrderVO> detailList = oDao.listOrderById(userId, "%", oseq);   //1=not completed order
				// summary for each order
				OrderVO order = detailList.get(0);
				int count = detailList.size();
				if (count > 1) {
				order.setPname(order.getPname() + " has sizes " +(count-1));
				}
				//total price for each order
				int totalPrice = 0;
				for(OrderVO vo : detailList)  {
					totalPrice += vo.getPrice2() * vo.getQuantity();
				}
				order.setPrice2(totalPrice);
				
				orderList.add(order);	//save order summary info to orderList
			}
				request.setAttribute("title", "All Orders");
				request.setAttribute("orderList", orderList);
		}
		request.getRequestDispatcher(url).forward(request,response);
	}
}
