package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;

public class AdminIndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/main.jsp";

		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
