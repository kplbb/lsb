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
	background-color: #FFF8B3;
	}

table tr {
  border-bottom: 1px solid black;
}

table tr:last-child {
  border: 0;
}

#list td{ 
	padding: 8px 5px;
	text-align: left;
}
.btn {
	justify-items: center;
	margin-left: 45%;
	}
img {
	height: 200px;
	width: 180px;
}
</style>
<article>
<h1>Product Update</h1>  
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="pseq" value="${productVO.pseq}">  
<input type="hidden" name="code" >
<input type="hidden" name="nonmakeImg1" value="${productVO.images[0]}">  
<input type="hidden" name="nonmakeImg2" value="${productVO.images[1]}">  
<input type="hidden" name="nonmakeImg3" value="${productVO.images[2]}">  
<input type="hidden" name="nonmakeImg4" value="${productVO.images[3]}">  
<input type="hidden" name="nonmakeImg5" value="${productVO.images[4]}">  
<input type="hidden" name="nonmakeImg6" value="${productVO.images[5]}">  
<input type="hidden" name="nonmakeImg7" value="${productVO.images[6]}">  
<input type="hidden" name="nonmakeImg8" value="${productVO.images[7]}">  
<input type="hidden" name="nonmakeImg9" value="${productVO.images[8]}">  
<input type="hidden" name="nonmakeImg10" value="${productVO.images[9]}">  

<table id="list">
  <tr>
    <th>Product Category</th>
    <td colspan="5">
    <select name="kind">
      <c:forEach items="${kindList}" var="kind" varStatus="status">
        <c:choose>
          <c:when test="${productVO.kind==status.count}">
            <option value="${status.count}" selected="selected">${kind}</option>
          </c:when>
          <c:otherwise>
            <option value="${status.count}">${kind}</option>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </select> 
    </td>
  </tr>
  
  <tr><th>Product #</th><td>${productVO.pseq}</td></tr>
  
  <tr>
    <th>Product Name</th>
    <td width="343" colspan="5">
      <input type="text" name="pname" size="47" maxlength="100" value="${productVO.name}">
    </td>
  </tr>
  <tr>
    <th>production cost[A]</th>
    <td width="70">        
      <input type="text" name="price1" size="11" onKeyUp='NumFormat(this)' value="${productVO.price1}">
    </td>
    <th>retail price[B]</th>
    <td width="70">
      <input type="text" name="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="${productVO.price2}">
    </td>
    <th>[B-A]</th>
    <td width="72">
      <input type="text" name="price3" size="11" readonly onKeyUp='NumFormat(this)'>
    </td>
  </tr>
  
   <tr>
    <th>Color</th>
    <td width="343" colspan="5">
      <input type="text" name="color" size="47" maxlength="100" value="${productVO.color}">
    </td>
  </tr>
  
   <tr>
    <th>Measurement</th>
    <td width="343" colspan="5">
      <input type="text" name="measurement" size="47" maxlength="100" value="${productVO.measurement}">
    </td>
  </tr>
  
  <tr>
    <th>Best Product</th>
    <td>
      <c:choose>
        <c:when test='${productVO.bestyn=="y"}'>
          <input type="checkbox" name="bestyn" value="y" checked="checked">
        </c:when>
        <c:otherwise>
          <input type="checkbox" name="bestyn" value="n">
        </c:otherwise>
      </c:choose>
    </td>        
    <th>Availability</th>
    <td>
      <c:choose>
        <c:when test='${productVO.useyn=="y"}'>
          <input type="checkbox" name="useyn" value="y" checked="checked">
        </c:when>
      <c:otherwise>
        <input type="checkbox" name="useyn" value="n">
      </c:otherwise>
    </c:choose>
    </td>
  </tr>
  <tr>
    <th>Product Detail</th>
    <td colspan="5">
      <textarea name="content" rows="8" cols="170" >${productVO.content}</textarea>
    </td>
  </tr>
  </table>

  <table>
   <th style="justify-items:center; background-color: white;">Image1</th>
    <th style="justify-items:center; background-color: white;">Image2</th>
    <th style="justify-items:center; background-color: white;">Image3</th>
    <th style="justify-items:center; background-color: white;">Image4</th>
    <th style="justify-items:center; background-color: white;">Image5</th> 
  <tr>
    <td>
		<img src="product_images/${productVO.images[0]}" width="200px"><input type="file" name="image1">	
	</td><br>
	<td>			
		<img src="product_images/${productVO.images[9]}" width="200px"><input type="file" name="image10">
	</td>
	<td>			
		<img src="product_images/${productVO.images[1]}" width="200px"><input type="file" name="image2">
	</td>
	<td>			
		<img src="product_images/${productVO.images[2]}" width="200px"><input type="file" name="image3">
	</td>	
	<td>			
		<img src="product_images/${productVO.images[3]}" width="200px"><input type="file" name="image4">
	</td>	
	</tr><br>
	<th style="justify-items:center; background-color: white;">Image6</th>
    <th style="justify-items:center; background-color: white;">Image7</th>
    <th style="justify-items:center; background-color: white;">Image8</th>
    <th style="justify-items:center; background-color: white;">Image9</th>
    <th style="justify-items:center; background-color: white;">Image10</th>
	<tr><br>
	<td>			
		<img src="product_images/${productVO.images[4]}" width="200px"><input type="file" name="image5">
	</td>	
	
	<td>			
		<img src="product_images/${productVO.images[5]}" width="200px"><input type="file" name="image6"> 
	</td>	
	<td>				
		<img src="product_images/${productVO.images[6]}" width="200px"><input type="file" name="image7"> 	
	</td>	
	<td>			
		<img src="product_images/${productVO.images[7]}" width="200px"><input type="file" name="image8">	
	</td>
	<td>			
		<img src="product_images/${productVO.images[8]}" width="200px"><input type="file" name="image9">
	</td>						 
  </tr>   
</table><br><br><br>
<div class="btn">
<input   type="button" value="update" onClick="go_mod_save('${productVO.pseq}')">           
<input   type="button" value="cancel" onClick="go_mov()">
</div>
</form> 
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>