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
.buttons {
	justify-items: center;
	margin-left: 45%;
	}
</style>
<article>
<h1>View product details</h1> 
<form name="frm" method="post">
<table id="list">
  <tr>
    <th>product category</th>
    <td  colspan="5">
  ${kind}
     </td>    
    </tr>    
    
      <tr><th>Product #</th><td>${productVO.pseq}</td></tr>
    
    <tr>
        <th align="center" >product name</th>
        <td colspan="5">${productVO.name}</td>
    </tr>
    
    <tr>
        <th >production cost[A]</th>
        <td width="60">${productVO.price1}</td>
        <th>retail price[B]</th>
        <td width="60">${productVO.price2}</td>
        <th>[B-A]</th><td>${productVO.price3}</td>
    </tr>
     
    <tr>
        <th>product detail</th>
        <td colspan="5">${productVO.content}</td>
    </tr>
    
     <tr>
        <th>color</th>
        <td colspan="5">${productVO.color}</td>
    </tr>
     <tr>
        <th>measurement</th>
        <td colspan="5">${productVO.measurement}</td>
    </tr>
</table>
  <h1>Product Images</h1>
  <hr>
  <table>
    <th style="justify-items:center; background-color: white;">Image1</th>
    <th style="justify-items:center; background-color: white;">Image2</th>
    <th style="justify-items:center; background-color: white;">Image3</th>
    <th style="justify-items:center; background-color: white;">Image4</th>
    <th style="justify-items:center; background-color: white;">Image5</th> 
  <tr>
   <td>
   <img src="product_images/${productVO.images[0]}" width="200px">
	</td>
	<td>		
		<img src="product_images/${productVO.images[1]}" width="200px">
	</td>
	<td>		
		<img src="product_images/${productVO.images[2]}" width="200px">
	</td>	
	<td>		
		<img src="product_images/${productVO.images[3]}" width="200px">
	</td>
	<td>		
		<img src="product_images/${productVO.images[4]}" width="200px">
	</td>	
	</tr>
	<th style="justify-items:center; background-color: white;">Image6</th>
    <th style="justify-items:center; background-color: white;">Image7</th>
    <th style="justify-items:center; background-color: white;">Image8</th>
    <th style="justify-items:center; background-color: white;">Image9</th>
    <th style="justify-items:center; background-color: white;">Image10</th> 
	<tr>
	<td>			
		<img src="product_images/${productVO.images[5]}" width="200px">
	</td>	
	<td>			
		<img src="product_images/${productVO.images[6]}" width="200px">
	</td>	
	<td>			
		<img src="product_images/${productVO.images[7]}" width="200px">
	</td>
	<td>			
		<img src="product_images/${productVO.images[8]}" width="200px">
	</td>
	<td>			
		<img src="product_images/${productVO.images[9]}" width="200px">
	</td>						 
  </tr>   
</table><br><br><br>
<!--[8] If the edit button is clicked, it moves to the product edit page, but delivers the current page and product serial number value. -->
<div class="buttons">
<input class="btn"  type="button" value="edit" onClick="go_mod('${tpage}','${productVO.pseq}')">
<!--[9] When the list button is pressed, it moves to the product list page, but delivers the current page. -->
<input class="btn"  type="button" value="back to product list" onClick="go_list('${tpage}')"> 
</div>          
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>