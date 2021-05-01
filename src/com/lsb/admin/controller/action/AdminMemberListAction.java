package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.MemberDAO;
import com.lsb.dto.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/member/memberList.jsp";
		String key = "";  //search input name 
		
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");     //if name/key is searched/inputed save it as key
		}
		
		MemberDAO mDao = MemberDAO.getInstance();
		ArrayList<MemberVO> memberList = mDao.listMember(key);
		
		request.setAttribute("memberList", memberList);   //memberList in memberList.jsp
		
		request.getRequestDispatcher(url).forward(request, response);  
		
		
	}

}
