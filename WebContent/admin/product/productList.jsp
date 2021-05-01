<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
	font: poppins;
	}
table{
	width:100%;
	 border-collapse: collapse;
}
th, td, h1 {
	text-align: center;
	justify-items: center;
/* 	border:1px solid black; */
}
h1{
	font-size: 1.5em;
	}
th{
	font-size: 1.1em;
	}

table tr {
  border-bottom: 1px solid black;
}

table tr:last-child {
  border: 0;
}
</style>
<article>
<h1>Product List</h1>	
<form name="frm" method="post">
<table style="border: none;">
  <tr>
  <td width="642">
      product name 
     <input type="text" name="key">
     
<%--      <c:when test="key == null"> --%>
<!--      <input class="btn" type="button" name="btn_search" value="search" onClick="go_search()"> -->
<%--      </c:when> --%>
<%--      <c:otherwise> --%>
<%--      <input class="btn" type="button" name="btn_search" value="${key}" onClick="go_search()"> --%>
<%--      </c:otherwise> --%>
     
     <input class="btn" type="button" name="btn_search" value="search" onClick="go_search()">
     <input class="btn" type="button" name="btn_total" value="view all " onClick="go_total()">
     <input style="width: 130px;" class="btn" type="button" name="btn_write" value="register product" onClick="go_wrt()"><br><br>
  </td>
  </tr>
</table>
<table id="productList">
    <tr>
    <th>Product Image</th><th>Product Number</th><th>Product Name</th><th>Production Cost</th><th>Retail Price</th><th>Register Date</th><th>Availability</th>
    </tr><br><br>
    <c:choose>
    <c:when test="${productListSize<=0}">
    <tr>
      <td width="100%" colspan="7" align="center" height="23">
        No registered product.
      </td>      
    </tr>
    </c:when>
	<c:otherwise>
	<c:forEach items="${productList}" var="productVO">
	<tr>
	<td>
	<img style="height: 30px; width: 25px;" src="product_images/${productVO.images[1]}" />
	</td>	
   <!--<tr>  --> 
      <td height="23" align="center" >${productVO.pseq}</td>
      <td style="text-align: left; padding-left: 50px; padding-right: 0px;">   
        <a href="#" onClick="go_detail('${tpage}', '${productVO.pseq}')">
    	 ${productVO.name}     
   		</a>
   	  </td>
      <td><fmt:formatNumber value="${productVO.price1}"/></td>
      <td><fmt:formatNumber value="${productVO.price2}"/></td>
      <td><fmt:formatDate value="${productVO.regdate}"/></td>
      <td>
      	<c:choose>
   	 		<c:when test='${productVO.useyn=="1"}'>usage not available</c:when>
   	 		<c:otherwise>usage available</c:otherwise>   	 		
   	 	</c:choose>	 
   	  </td> 
    </tr>
    </c:forEach>
    <tr><td colspan="7" style="text-align: center;"> ${paging} </td></tr>
	</c:otherwise>	
</c:choose>  
</table>
</form> 
<br><br><br>
<%@ include file="../page_area.jsp" %>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>