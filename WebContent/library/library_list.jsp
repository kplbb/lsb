<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<style>
img {
    position:relative;
}

h3, p {
   
    text-align:center;
    top: 30px;
    width: 100%
}
</style>    
  <br><br><h1 class="lib_subject">Library of Local Sad Boys </h1><hr><br><br>
    
<div class="wrapper">        
 	<c:forEach items="${libraryList}"  var="libraryVO">
          <div class=wrapper-item>
	            <h3><a href="LsbServlet?command=library_view&lseq=${libraryVO.lseq}">${libraryVO.subject}</a></h3>
	            <p>published:${libraryVO.indate}</p>
            <br>    
            <a href="LsbServlet?command=library_view&lseq=${libraryVO.lseq}">
           	<img style="width:100%; height: 100%;"src="admin/images/lib/${libraryVO.images[1]}"/>
           	</a>   
           </div>
 	</c:forEach>   
</div> 
<%@ include file="../footer_news.jsp" %>           
<%@ include file="../footer.jsp" %>
 
 <%--             <p> ${libraryVO.reply}</p>      --%>
<%--             <p> ${libraryVO.content}</p>     --%>
 <%--            	 <p>${libraryVO.indate} </p><br>           	 --%>
 