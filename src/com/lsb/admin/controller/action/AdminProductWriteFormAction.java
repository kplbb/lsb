package com.lsb.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;

public class AdminProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productWrite.jsp";
		///String kindList[] = {"T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 		//String kindList[] = {"Heels" , "Boots" , "Sandals" , "Slipers" , "Sneakers", "Sale"};
		String kindList[] = {"", "T-SHIRT", "SWEATER", "BOTTOMS",  "OUTER", "SHIRT", "JEANS", "DRESS","JUMPSUITS","SKIRT","ACCESSORIES", "SNEAKERS", "BOOTS", "HEELS", "FLATS"}; 

		request.setAttribute("kindList", kindList);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
