<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>   
<!-- <h1> footwear view all</h1>   -->
    
<div class="wrapper">    
	<c:forEach items="${footwearList}"  var="productVO">
  		<div class=wrapper-item  > <!-- style="height: 450px; width: 400px;" -->
 			<a href= "LsbServlet?command=product_detail&pseq=${productVO.pseq}">
           	<img style="width:100%; height: 100%;"src="product_images/${productVO.images[1]}"/> <!-- style="height: 350px; width: 300px;"  -->
 			</a>
 			
          	<div class="img__description"> 
       			<p style="margin:0; opacity:1; background-color: white;">
	       	  		<strong>${productVO.name}</strong>
	    	 		${productVO.price2} USD
       	 		</p>
            </div>  
         </div>      
	</c:forEach>  
</div>  

<%@ include file="../footer.jsp" %>
 