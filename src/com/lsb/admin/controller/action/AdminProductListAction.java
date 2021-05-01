package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsb.controller.action.Action;
import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;

import util.Criteria;
import util.PageMaker;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		String key  = "";  //product name from productList.jsp
		String pageNum="";
		String numPerPage="";
		Criteria cri = new Criteria();
		
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");  //if there is key value then saved to key
		}
		//read the current page number entered on screen
		pageNum = request.getParameter("pageNum");
			if (pageNum != null) {
			cri.setPageNum(Integer.parseInt(pageNum));
		}
		//read the number of items per page entered on screen
		numPerPage = request.getParameter("numPerPage");
			if (numPerPage != null) {
			cri.setNumPerPage(Integer.parseInt(numPerPage));
		}

		ProductDAO pDao = ProductDAO.getInstance();
		//search for posting list
		ArrayList<ProductVO> productList = pDao.listProductByPage(cri, key);
		System.out.println(productList);
		//paging button info 
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		for(ProductVO vo : productList) {
			System.out.println(vo);
		}

		//total items/posts
		int totalCount = pDao.countProductList(key);

		//save number of lists in pageMaker and set basic page button info
		pageMaker.setTotalCount(totalCount);
		System.out.println("page button info: " + pageMaker);
		
		
		request.setAttribute("productList", productList);
		request.setAttribute("pageMaker", pageMaker);

		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
