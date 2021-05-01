package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.CartDAO;
import com.lsb.dto.*;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "LsbServlet?command=cart_list";

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null)    {          	//user not signed in 
			url = "LsbServlet?command=login_form";
		} else {
			CartVO cart = new CartVO();

			cart.setId(loginUser.getId());    //set id saved in session 
			cart.setPseq(Integer.parseInt(request.getParameter("pseq")));
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	

			CartDAO cartDAO = CartDAO.getInstance();
			cartDAO.insertCart(cart);
		}
			response.sendRedirect(url);
	}
}
