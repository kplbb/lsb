package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.*;
import com.lsb.dto.*;

public class AdminLibListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/lib/libList.jsp";
		LibraryDAO lDao = LibraryDAO.getInstance();
		ArrayList<LibraryVO> libList = lDao.listAllLibrary();
		
		request.setAttribute("libList", libList);    //qnaList is name in qnaList.jsp
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}


