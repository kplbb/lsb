<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="../header.jsp" %>
 <%@ include file="myOrder_menu.jsp" %>       
 
 <style>
 h1 {
 text-align: center;
}
 </style>
<article>
<br><br><br><br><br>
 <h1> Cart List </h1><hr>
 <form name="formm" method="post">
 <c:choose>
 <c:when test= "${cartList.size() == 0}">
   <h3 style="color: red;text-align: center; margin-bottom: 36%;"> cart is empty. </h3> 
 </c:when>
 <c:otherwise>
   <table id="cartList">
     <tr>
       <th>Name</th><th>Quantity</th><th>Price</th><th>Order Date</th><th>Delete</th>    
     </tr>
     
     <c:forEach items="${cartList}"  var="cartVO">
     <tr>      
       <td>
         <a href="LsbServlet?command=product_detail&pseq=${cartVO.pseq}">
           <h3> ${cartVO.pname} </h3>              
         </a>    
       </td>
       <td> ${cartVO.quantity} </td>
       <td> 
       	${cartVO.price2*cartVO.quantity} USD <!--  	
         <!--<fmt:formatNumber value="${cartVO.price2*cartVO.quantity}" 
                           type="currency"/> -->
       </td>      
       <td> <fmt:formatDate value="${cartVO.indate}" type="date"/></td>      
       <td> <input type="checkbox" name="cseq" value= "${cartVO.cseq}"> 
       </td>
     </tr>
     </c:forEach>
      
     <tr>        
       <th colspan="2"> </th>
       <th> 
     	${totalPrice} USD
         <!--<fmt:formatNumber value="${totalPrice}" type="currency"/><br>-->
       </th>
       <th>
       </th> 
       <th><a href="#" onclick="go_cart_delete()"><h3>Delete</h3></a></th>                       
     </tr> 
   </table> 
<%--     </c:otherwise>   --%>
<%--     </c:choose>   --%>
     
    <div class="clear"></div>
     
     <hr>
     							     	 
			<div class="modal-content-contract">		
                <br><br><h1> Payment </h1><hr>
		           <label for="cname"><strong>&nbsp;Name on Card</strong></label>
		           <input type="text" id="headerInput_contract" name="payment1" placeholder="Name" required><br><br><br>	
		           <label for="ccnum"><strong>&nbsp;Credit card number</strong></label>
		           <input type="text" id="headerInput_contract" name="payment2" placeholder="1111-2222-3333-4444" required><br><br><br>	
		           <label for="expmonth"><strong>&nbsp;Exp Month</strong></label>
		           <input type="text" id="headerInput_contract" name="payment3" placeholder="Month" required><br><br><br>	
		               <label for="expyear"><strong>&nbsp;Exp Year</strong></label>
		               <input type="text" id="headerInput_contract" name="payment4" placeholder="Year" required><br><br><br>	
		               <label for="cvv"><strong>&nbsp;CVV</strong></label>
		               <input type="text" id="headerInput_contract" name="payment5" placeholder="123" required><br><br><br>	
		               <br><br><br><br>	          
				  <h1> Shipping</h1><hr>
		      		 <label for=name><b>&nbsp;Name</b></label> 
			      	 <input  id="headerInput_contract" type="text" value="${memberInfo.name}" name="name" required>	<br><br><br>		      
<!-- 			         <label for=name><b>&nbsp;Phone</b></label> -->
<%-- 			      	 <input  id="headerInput_contract" type="text" value="${memberInfo.phone}" name="phone" required><br><br><br>			       --%>
			         <label for=name><b>&nbsp;Address + Zip Code</b></label>
			      	 <input  id="headerInput_contract" type="text" value="${memberInfo.address}&nbsp;${memberInfo.zip_num}" name="address" required><br><br><br>					
 				     <label for=name><b>&nbsp;Email</b></label>
			      	 <input  id="headerInput_contract" type="text" value="${memberInfo.email}" name="email" required> 
			      	 <br><br><br>	
<!-- 			      	 <label><input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing</label>		 -->			      	 		      
			</div>
		      
		      					
 </c:otherwise> 
 </c:choose> 
<br><br>
    <div style="float: center; font-color:white;">
    <c:if test= "${cartList.size() != 0}">
      <input style="width:50%; float:right;" id="headerBut" type="button" value="Cancel" class="cancel" onclick="location.href='LsbServlet?command=index'">    
<%--       <c:if test= "${cartList.size() != 0}"> --%>
      <input  style="width:50%; float:right;" id="headerBut" type="button" value="Place Order"  class="submit" onclick="go_order_insert()">
      </c:if>
     </div>
     </form>
  </article>
  
<%@ include file="../footer_news.jsp" %>
<%@ include file="../footer.jsp" %>
 