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
import com.lsb.dao.*;
import com.lsb.dto.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminLibRepsaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=admin_lib_list";   
		
//		String lseq = request.getParameter("lseq");
//		String reply = request.getParameter("reply").trim();  //.trim() gets rid of black/spaces front n end
//		String content = request.getParameter("content");
//		String subject = request.getParameter("subject");
		//copied from AdminProductWriteAction.java
			int sizeLimit = 5 * 1024*1024;  //5MB
			String savePath = "admin/images/lib";  //admin/images/lib
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
		LibraryVO lib = new LibraryVO();
		lib.setLseq(Integer.parseInt(multi.getParameter("lseq")));
//		lib.setReply(multi.getParameter("reply"));
		lib.setSubject(multi.getParameter("subject"));
		lib.setContent(multi.getParameter("content"));
		
		Enumeration files = multi.getFileNames();	// 이미지 파일 10개 파라미터 가져오기
		
		ArrayList<String> param_list = new ArrayList<>();
		
		//read img1~10 (multi.getFileNames())from productUpdate.jsp and put into ArrayList 
		while(files.hasMoreElements()) {
			String upload_param = (String)files.nextElement();
			param_list.add(upload_param);
		}
		//sort param_list(all imgs)
		Collections.sort(param_list);
		
		String[] uploadFiles = new String[5];
		
		//retrieve image1, image2... in order from list  
		for (int i=0; i<param_list.size(); i++) {
			String new_file = multi.getFilesystemName(param_list.get(i));
			if (new_file == null) {
				//System.out.println("existing image:" + multi.getParameter("nonmakeImg"+(i+1)));
				uploadFiles[i] = multi.getParameter("libImg"+(i+1));
			} else {
				//System.out.println("udpated image:" + multi.getFilesystemName(param_list.get(i)));
				uploadFiles[i] = multi.getFilesystemName(param_list.get(i));
			}
			System.out.println("image"+ i + ":" + uploadFiles[i]);
		}
		lib.setImages(uploadFiles);
		
		
		LibraryDAO lDao = LibraryDAO.getInstance();
		lDao.updateLibrary(lib);
		
		response.sendRedirect(url);
	}

}
