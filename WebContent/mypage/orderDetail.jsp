<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="myOrder_menu.jsp" %>  
<style>
h3 {
	text-align:center;
}
td{
	font-size: 13px;
}
</style>     
  <article>
<!--     <h2> My Page(주문 상세 정보) </h2> -->
    <form name="formm" method="post">
<!--       <h3> Orderer Information </h3>      -->
<!--       <table id="cartList">       -->
<!--       <tr> -->
<!--         <th>Order Date</th> <th>Order Number</th> <th>Orderer</th><th> Order Total </th>      -->
<!--      </tr>      -->
<!--      <tr>   -->
<%--        <td>${orderDetail.indate} USD <!--<fmt:formatDate value="${orderDetail.indate}" type="date"/>--></td> --%>
<%--        <td> ${orderDetail.oseq} </td>     --%>
<%--        <td> ${orderDetail.mname} </td> --%>
<%--        <td>${totalPrice} USD <!--<fmt:formatNumber type="currency" value="${totalPrice}" />--> </td> --%>
<!--      </tr>     -->
<!--      </table>          -->
<br><br><br><br><br><br><br><br>
     <h3> Product Ordered Information </h3><hr>
     <table style="margin-left:0;" >
     <tr>
       <th>Product Name</th> <th>Order Number</th><th>Order Date</th> <th>Quantity</th> <th>Name</th> <th>Address</th>  <th> Email</th> 
 		<th>Order Total</th> <th> Payment</th> <th> Order Status</th>  
     </tr>
     <c:forEach items="${orderList}"  var="orderVO"> 
     <tr>
       <td>${orderVO.pname} </td>
       <td> ${orderVO.odseq} </td> 
       <td> ${orderVO.indate} </td>
  		<td> ${orderVO.quantity} </td>
         <td> ${orderDetail.mname}   </td>
		<td> ${orderVO.address}</td>    
		<td> ${orderVO.email}</td>    		
       <%-- 
       <td> <fmt:formatNumber type="currency"
			value="${orderVO.price2 * orderVO.quantity} " /> </td> --%>
	   <td>${orderVO.price2* orderVO.quantity} USD</td> 	
	    <td> ${orderVO.payment}   </td>
       <td>
      <c:choose> 
       <c:when test='${orderVO.result=="1"}'> Order in Process </c:when>
         <c:otherwise> <span style="color:red"> Order Processed </span></c:otherwise> 
       </c:choose>
       </td>
     </tr>
   </c:forEach>    
     </table>   
          
     <div class="clear"></div>
<!--     <div id="buttons" style="float: right">   -->
<!--        <input type="button"    value="Local Sad Boys"  class="cancel"   -->
<!-- 	onclick="location.href='LsbServlet?command=index'"> -->
<!--      </div> -->
    </form>  
  </article>
 <%@ include file="../footer_news.jsp" %> 
<%@ include file="../footer.jsp" %>