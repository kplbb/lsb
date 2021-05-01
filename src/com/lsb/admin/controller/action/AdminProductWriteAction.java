package com.lsb.admin.controller.action;

import java.io.IOException;
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

public class AdminProductWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String url = "LsbServlet?command=admin_product_list";
		String url = "LsbServlet?command=admin_product_list";

		
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
		//save & process input data transmitted from screen into database
		ProductVO product = new ProductVO();
		product.setKind(multi.getParameter("kind"));
		product.setName(multi.getParameter("name"));
		product.setPrice1(Integer.parseInt(multi.getParameter("price1")));
		product.setPrice2(Integer.parseInt(multi.getParameter("price2")));
		product.setPrice3(Integer.parseInt(multi.getParameter("price3")));
		product.setColor(multi.getParameter("color"));
		product.setMeasurement(multi.getParameter("measurement"));
		product.setContent(multi.getParameter("content"));
		
		Enumeration files = multi.getFileNames();
		
		int index = 9;
		String[] uploadFiles = new String[10];
		
		while(files.hasMoreElements()) {
			String upload_param = (String)files.nextElement();
			//String new_file = multi.getFilesystemName(upload_param);
			System.out.println("new ¿ÃπÃ¡ˆ:" + multi.getFilesystemName(upload_param));
			String imageFile = multi.getFilesystemName(upload_param);
			if (imageFile != null) {
				uploadFiles[index] = multi.getFilesystemName(upload_param);
			} else {
				uploadFiles[index] = "default.jpg";
			}
			index--;
		}
		
		product.setImages(uploadFiles);
	
		
		
		/*
		product.setImages(multi.getFilesystemName("image[0]"));     //just image file name	
		product.setImages(multi.getFilesystemName("image[1]"));
		product.setImage3(multi.getFilesystemName("image[2]"));
		product.setImage4(multi.getFilesystemName("image[3]"));
		product.setImage5(multi.getFilesystemName("image[4]"));
		product.setImage6(multi.getFilesystemName("image[5]"));
		product.setImage7(multi.getFilesystemName("image[6]"));
		product.setImage8(multi.getFilesystemName("image[7]"));
		product.setImage9(multi.getFilesystemName("image[8]"));
		product.setImage10(multi.getFilesystemName("image[9]")); 
		*/
		
		/* product.setImage1(multi.getFilesystemName("image1"));     //just image file name	
		product.setImage2(multi.getFilesystemName("image2"));
		product.setImage3(multi.getFilesystemName("image3"));
		product.setImage4(multi.getFilesystemName("image4"));
		product.setImage5(multi.getFilesystemName("image5"));
		product.setImage6(multi.getFilesystemName("image6"));
		product.setImage7(multi.getFilesystemName("image7"));
		product.setImage8(multi.getFilesystemName("image8"));
		product.setImage9(multi.getFilesystemName("image9"));
		product.setImage10(multi.getFilesystemName("image10")); */
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.insertProduct(product);

		response.sendRedirect(url);   //no forwarding to another jsp page with get parameter things, just command
	}

}
