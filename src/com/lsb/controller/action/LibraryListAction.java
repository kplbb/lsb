package com.lsb.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.dao.LibraryDAO;
import com.lsb.dto.LibraryVO;

public class LibraryListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "library/library_list.jsp";
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		ArrayList<LibraryVO> libList = lDao.listAllLibrary();
		
		request.setAttribute("libraryList", libList);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
