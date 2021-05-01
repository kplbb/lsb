<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>     			  	  
	<br> <br> <br>
	<div class="modal-content">					     	 
		<form  action="LsbServlet?command=login" method="post">
		 	  <br><br><span style="color:red;">${message}</span><br><br> 
		      <label for="userName"><b>User ID</b></label>
		      <input id="headerInput" type="text" placeholder="Enter Username" name="userId" required>
		
		
		      <label for="pwd"><b>Password</b></label>
		      <input  id="headerInput"type="password" placeholder="Enter Password" name="pwd" required>
		        
		      <button id="headerBut" type="submit">Login</button>
	    </form>
	    <br>
	 </div>
	  <br> <br> <br>  
 <%@ include file="../footer_news.jsp" %> 	  
<%@ include file="../footer.jsp" %>      
