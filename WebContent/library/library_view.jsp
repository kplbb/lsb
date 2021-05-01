<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<style>
img {
	height: 30%;
	width: 30%;
	float: center;
	justify-items: center;
	margin: 10px;
}
</style>
  
   <div class="prod_det_desc">
   <br><br><h1 class="lib_subject">${libVO.subject}</h1><br>
       <fmt:formatDate value="${libVO.indate}" type="date"/>
       <hr><br>
<div class="lib_content">   
       ${libVO.content} 
 </div>  <br><br>
        ${libVO.reply}  
           	<img src="admin/images/lib/${libVO.images[1]}"/> <!-- style="height: 350px; width: 300px;"  --> 
		
		</div>
<div class="clear"></div>
     <div id="buttons" style=" width:25%; margin-left: 37%; margin-top: 30px;">
      <input id="headerBut" type="button"  value="Back"     class="submit"  onclick="location.href='LsbServlet?command=library_list'"> 
<!--       <input type="button"  value="Go Back"  class="cancel"  onclick="location.href='LsbServlet?command=index'">   -->
      </div>
    

<%@ include file="../footer_news.jsp" %>       
<%@ include file="../footer.jsp" %>