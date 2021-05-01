package com.lsb.admin.controller.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lsb.controller.action.Action;
import com.lsb.dao.LibraryDAO;
import com.lsb.dto.LibraryVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminLibWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LsbServlet?command=admin_lib_list";

		
		int sizeLimit = 5 * 1024*1024;  //5MB
		String savePath = "admin/images/lib";  //product images saving folder location
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
		LibraryVO lib = new LibraryVO();
		lib.setSubject(multi.getParameter("subject"));
		lib.setContent(multi.getParameter("content"));
		
		Enumeration files = multi.getFileNames();
		
		int index = 0;
		String[] uploadFiles = new String[5];
		
		while(files.hasMoreElements()) {
			String upload_param = (String)files.nextElement();
			//String new_file = multi.getFilesystemName(upload_param);
			System.out.println("new image:" + multi.getFilesystemName(upload_param));
			String imageFile = multi.getFilesystemName(upload_param);
			if (imageFile != null) {
				uploadFiles[index] = multi.getFilesystemName(upload_param);
			} else {
				uploadFiles[index] = "default.jpg";
			}
			index++;
		}
		
		lib.setImages(uploadFiles);
	
		LibraryDAO lDao = LibraryDAO.getInstance();
		lDao.insertLibrary(lib);

		response.sendRedirect(url);   //no forwarding to another jsp page with get parameter things, just command
		}
	}

