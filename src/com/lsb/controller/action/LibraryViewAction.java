package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.dao.LibraryDAO;
import com.lsb.dto.LibraryVO;
import com.lsb.dto.*;

public class LibraryViewAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "library/library_view.jsp";
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			url = "LsbServlet?command=login_form";
		}else { 
			int lseq = Integer.parseInt(request.getParameter("lseq"));
			
			LibraryDAO lDao = LibraryDAO.getInstance();
			
			LibraryVO lib = lDao.getLibrary(lseq);
			
			request.setAttribute("libVO", lib);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
