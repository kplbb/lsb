package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.*;
import com.lsb.dto.*;

public class AdminLibListDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/lib/libDetail.jsp";
		String lseq = request.getParameter("lseq");
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		LibraryVO lib = lDao.getLibrary(Integer.parseInt(lseq));
		
		request.setAttribute("libVO", lib);   //libVO in libDetail.jsp
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
