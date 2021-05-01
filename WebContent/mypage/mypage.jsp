<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<%@ include file="myOrder_menu.jsp" %>       
   
  <article>
    <h2 style="margin-top:3%; margin-left: 8%;">${title} </h2>  <!-- My Page(${title}) -->
    <form name="formm" method="post">
      <table id="cartList">
      <tr>
        <th>Order Date</th> <th>Order Number</th> <th>Product Name</th> <th>Total</th> <th> Order Detail</th><th>Address</th><th>Email</th>   
      </tr>
      <hr>
      <c:forEach items="${orderList}"  var="orderVO">
      <tr>  
        <td> <fmt:formatDate value="${orderVO.indate}" type="date"/></td>
        <td> ${orderVO.oseq} </td>    
        <td> ${orderVO.pname} </td>
        <td> ${orderVO.price2} USD<!--<fmt:formatNumber value="${orderVO.price2}" type="currency"/>--> </td>
        <td> <a href="LsbServlet?command=order_detail&oseq=${orderVO.oseq}"> search </a></td>
        <td> ${orderVO.address} </td>
        <td> ${orderVO.email} </td>       
      </tr>
      </c:forEach>    
      </table>   
      <div class="clear"></div>
<!--       <div id="buttons" style="float: right"> -->
<!--        <input type="button"    value="back to Local Sad Boys"  class="cancel"  onclick="location.href='LsbServlet?command=index'">  -->
<!--       </div> -->
    </form>  
  </article>
<%@ include file="../footer_news.jsp" %>       
<%@ include file="../footer.jsp" %> 
