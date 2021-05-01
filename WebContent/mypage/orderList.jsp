<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
     
  <article>
      <h2> Order List </h2>
      <form name="formm" method="post">
        <table id="cartList">
       <tr>
        <th>Product Name</th> <th>Quantity</th><th>Price</th> <th>Order Date</th> <th> Order Status </th>    
       </tr>
       <c:forEach items="${orderList}"  var="orderVO">
       <tr>      
        <td>
            <a href="LsbServlet?command=product_detail&pseq=${cartVO.pseq}">
              <h3> ${orderVO.pname} </h3>              
          </a>    
        </td>
        <td> ${orderVO.quantity} </td>
        <td>${orderVO.price2*orderVO.quantity} USD<!--<fmt:formatNumber value="${orderVO.price2*orderVO.quantity}" type="currency"/>--> </td>      
        <td> <fmt:formatDate value="${orderVO.indate}" type="date"/></td>
        <td> order in process </td>
       </tr>
       </c:forEach>
       <tr>
         <th colspan="2"> Total </th>
         <th colspan="2">${totalPrice} USD<!--<fmt:formatNumber value="${totalPrice}" type="currency"/>--><br></th> 
         <th> Order processed. </th>                
       </tr> 
      </table>   
          
      <div class="clear"></div>
<!--       <div id="buttons" style="float: right"> -->
<!--        <input type="button"    value="back to browsing"  class="cancel"  onclick="location.href='LsbServlet?command=index'">      -->
<!--       </div> -->
    </form>  
  </article>
<%@ include file="../footer_news.jsp" %>       
<%@ include file="../footer.jsp" %>