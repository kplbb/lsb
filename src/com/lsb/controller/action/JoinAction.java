package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.MemberDAO;
import com.lsb.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* String url ="member/login.jsp"; */
		String url = "LsbServlet?command=index";
		
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		
		String yn = request.getParameter("news_email_yn");
		if(!yn.equals("y")) {
			member.setNews_email_yn("n");
		} else {
			member.setNews_email_yn(request.getParameter("news_email_yn"));
		}
		member.setZip_num(request.getParameter("zipNum"));
		member.setAddress(request.getParameter("addr1")+ " "+request.getParameter("addr2"));
		member.setPhone(request.getParameter("phone"));
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.insertMember(member);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);	}

}
