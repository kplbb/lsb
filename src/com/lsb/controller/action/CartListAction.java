package com.lsb.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.CartDAO;
import com.lsb.dao.MemberDAO;
import com.lsb.dto.CartVO;
import com.lsb.dto.MemberVO;
import com.lsb.dto.OrderVO;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/cartList.jsp";
		int totalPrice = 0; 
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		CartDAO cDao = CartDAO.getInstance();
		ArrayList<CartVO> cartList = cDao.listCart(member.getId());		
		
		//address 
		MemberDAO mDao = MemberDAO.getInstance();
		member = mDao.getMember(member.getId());

		
		for (CartVO cartVO : cartList) {
			totalPrice += cartVO.getPrice2() * cartVO.getQuantity();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartList", cartList);
		//address
		request.setAttribute("memberInfo", member);
		request.getRequestDispatcher(url).forward(request, response);
}
}