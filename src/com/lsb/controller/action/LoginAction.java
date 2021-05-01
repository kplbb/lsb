package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.MemberDAO;
import com.lsb.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = -1;
		String url = "member/login_fail.jsp";
		String id = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO member = mDao.getMember(id);
		 result = mDao.loginCheck(id, pwd);

		if (result==1) {
//			url="member/index.jsp";
			url="index.jsp";
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", member);			

		} else if (result==0) {
			url="member/login.jsp";
			request.setAttribute("message", "ID & Password don't match.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
