<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<style>
h1, table{
	margin-left:35%;
}
h1 {
	font-size: 1.3em;
	margin-left: 45%;
	}
.btn {
	justify-items: center;
	margin-left:50%;
	}
</style>
<article>
<h1>Product Registration</h1>  
<!-- [1] To upload a file, send the form tag in the post method,
The encoding type must be specified as multipart/form-data. -->
<form name="frm" method="post" enctype="multipart/form-data">
<table>  
<!--  id="list" -->
<tr>
  <th>Product Category</th>
  <td colspan="5">
  <select name="kind">
    <c:forEach items="${kindList}" var="kind" varStatus="status">
      <option value="${status.count}">${kind}</option>
   </c:forEach>
  </select>      
<tr>
  <th>Product Name</th>
  <td width="343" colspan="5">
       <input type="text" name="name" size="47" maxlength="100" value="킬힐">
  </td>
</tr>
<tr>
  <th>production cost[A]</th>
  <td width="70">
    <input type="text" name="price1" size="11" onKeyUp='NumFormat(this)' value="10000">
  </td>
  <th>retail price[B]</th>
  <td width="70">
     <input type="text" name="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="20000">
  </td>
  <th>[B-A]</th>
    <td width="72">
      <input type="text" name="price3" size="11" readonly onKeyUp='NumFormat(this)'>
    </td>
  </tr>
    
  <tr>
    <th>Product Detail</th>
    <td colspan="5">
      <textarea name="content" rows="8" cols="70" >description</textarea>
    </td>
  </tr>
  
  <tr>
  <th>Color</th>
  <td width="343" colspan="5">
       <input type="text" name="color" size="47" maxlength="100" value="color">
  </td>
</tr>
  <tr>
  <th>Measurement</th>
  <td width="343" colspan="5">
       <input type="text" name="measurement" size="47" maxlength="100" >
  </td>
</tr>

  <tr>
    <th>Product Image</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->
      Upload Image1&nbsp;&nbsp;&nbsp;<input type="file" name="image10"><br>
      Upload Image2&nbsp;&nbsp;<input type="file" name="image1"><br>
      Upload Image3&nbsp;&nbsp;&nbsp;<input type="file" name="image2"><br>
      Upload Image4&nbsp;&nbsp;&nbsp;<input type="file" name="image3"><br>
      Upload Image5&nbsp;&nbsp;&nbsp;<input type="file" name="image4"><br>
      Upload Image6&nbsp;&nbsp;&nbsp;<input type="file" name="image5"><br>
      Upload Image7&nbsp;&nbsp;&nbsp;<input type="file" name="image6"><br>
      Upload Image8&nbsp;&nbsp;&nbsp;<input type="file" name="image7"><br>
      Upload Image9&nbsp;&nbsp;&nbsp;<input type="file" name="image8"><br>
      Upload Image10&nbsp;&nbsp;<input type="file" name="image9"><br>

      
    </td>
  </tr>    
</table>
<br><br><br><br>
<div class="btn">
<input type="button" value="register" onClick="go_save()">  <!-- javascript(product.js)  -->
<input  type="button" value="cancel" onClick="go_mov()">
</div>
</form> 
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>