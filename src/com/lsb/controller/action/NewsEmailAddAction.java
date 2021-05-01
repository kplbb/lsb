package com.lsb.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lsb.dao.NewsEmailDAO;
import com.lsb.dto.NewsEmailVO;

public class NewsEmailAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=index";

		NewsEmailVO newsemail = new NewsEmailVO();
		newsemail.setEmail(request.getParameter("newsletter_email"));
//		newsemail.setNeseq(Integer.parseInt(request.getParameter("neseq")));
		
		NewsEmailDAO nDao = NewsEmailDAO.getInstance();
		nDao.insertEmail(newsemail);		
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
