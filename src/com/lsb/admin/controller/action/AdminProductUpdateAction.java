package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.controller.action.Action;
import com.lsb.dao.ProductDAO;
import com.lsb.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=admin_product_list";
		
		//copied from AdminProductWriteAction.java
		int sizeLimit = 5 * 1024*1024;  //5MB
		String savePath = "product_images";  //product images saving folder location
		//find actual storage path 
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		String uploadPath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(
				request,      //request object
				uploadPath,  //upload file storage path
				sizeLimit,   //max file size
				"UTF-8",     // encoding type
				new DefaultFileRenamePolicy()       //same file name rename policy
				);
		//input data save to db
		ProductVO product = new ProductVO();
		product.setPseq(Integer.parseInt(multi.getParameter("pseq")));
		product.setKind(multi.getParameter("kind"));
		product.setName(multi.getParameter("pname"));
		product.setPrice1(Integer.parseInt(multi.getParameter("price1")));
		product.setPrice2(Integer.parseInt(multi.getParameter("price2")));
		product.setPrice3(Integer.parseInt(multi.getParameter("price3")));
		product.setContent(multi.getParameter("content"));
		product.setColor(multi.getParameter("color"));
		product.setMeasurement(multi.getParameter("measurement"));
		
		Enumeration files = multi.getFileNames();	// 이미지 파일 10개 파라미터 가져오기
		
		ArrayList<String> param_list = new ArrayList<>();
		
		//read img1~10 (multi.getFileNames())from productUpdate.jsp and put into ArrayList 
		while(files.hasMoreElements()) {
			String upload_param = (String)files.nextElement();
			param_list.add(upload_param);
		}
		//sort param_list(all imgs)
		Collections.sort(param_list);
		
		String[] uploadFiles = new String[10];
		
		// list에 들어가 있는 image1, image2, ....를 차례대로 가져와서 파일명값을 읽어온다.
		for (int i=0; i<param_list.size(); i++) {
			String new_file = multi.getFilesystemName(param_list.get(i));
			if (new_file == null) {
				//System.out.println("기존 이미지:" + multi.getParameter("nonmakeImg"+(i+1)));
				uploadFiles[i] = multi.getParameter("nonmakeImg"+(i+1));
			} else {
				//System.out.println("수정 이미지:" + multi.getFilesystemName(param_list.get(i)));
				uploadFiles[i] = multi.getFilesystemName(param_list.get(i));
			}
			System.out.println("image"+ i + ":" + uploadFiles[i]);
		}
		product.setImages(uploadFiles);
		
		product.setBestyn(multi.getParameter("bestyn"));
		product.setUseyn(multi.getParameter("useyn"));
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.updateProduct(product);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
