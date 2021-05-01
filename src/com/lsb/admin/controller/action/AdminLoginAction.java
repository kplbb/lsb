package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.controller.action.Action;
import com.lsb.dao.WorkerDAO;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String workerId = request.getParameter("workerId");
		String workerPwd = request.getParameter("workerPwd");
		String url = "LsbServlet?command=admin_login_form";  //default 
		String message = "";
		
		WorkerDAO wDao = WorkerDAO.getInstance();
		
		int result = wDao.workerCheck(workerId, workerPwd);
		
			if(result==1) {		//login successful
				HttpSession session = request.getSession();
				session.setAttribute("workerId", workerId);
				 url = "LsbServlet?command=admin_product_list";  //url directory once login successful
			} else if (result == 0) {
				 message = "please check password";
			} else {			//result = -1
				message = "Please check id";
			}
		request.setAttribute("message", message);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
