<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<style>
h1, table{
	margin-left:30%;
}
h1 {
	font-size: 1.3em;
	margin-left: 45%;
	}
.btn {
	justify-items: center;
	margin-left:50%;
	}
	.btn {
	background-color: white;
	margin-left:49%;
}
</style>
<article>
<h1>Library Blog Registration</h1>  
<!-- [1] To upload a file, send the form tag in the post method,
The encoding type must be specified as multipart/form-data. -->
<form name="frm" method="post" enctype="multipart/form-data">
<table id="orderList">
    <tr>
        <th width="10%">Title</th>
        <td><input type="text" name="subject" size="100" maxlength="100" value="blog title"></td>
    </tr>
<!--    <tr> -->
<!--          <th>Register Date</th> -->
<!--          <td style="text-align: left;"><input type='date' id='currentDate' name="indate"/> </td>            -->
<!--     </tr> -->
    <tr>
    	<th>Content</th>
         <td><textarea name="content" rows="20" cols="100" >content</textarea></td>        
    </tr>
	<tr>
    <th>Product Image</th>
    <td width="343" colspan="5">
<!--  [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다.  -->    
      Upload Image1&nbsp;&nbsp;&nbsp;<input type="file" name="image1"><br>
      Upload Image2&nbsp;&nbsp;&nbsp;<input type="file" name="image5"><br>
      Upload Image3&nbsp;&nbsp;&nbsp;<input type="file" name="image4"><br>      
      Upload Image4&nbsp;&nbsp;&nbsp;<input type="file" name="image3"><br>     
      Upload Image5&nbsp;&nbsp;&nbsp;<input type="file" name="image2"><br>      
    </td>
  </tr>    
</table>
<br><br><hr>
<div class="btn">
<input  type="button" value="submit" onClick="go_lib_save()">  <!-- javascript(product.js)  -->
<input  type="button" value="cancel" onClick="go_lib_mov()">
</div>
</form> 
</article>
<script>
function go_lib_save() {
	var theForm = document.frm;
	theForm.encoding = "multipart/form-data";
	theForm.action = "LsbServlet?command=admin_lib_write";
	theForm.submit();
}
function go_lib_mov(){
	var theForm = document.frm;
	theForm.action = "LsbServlet?command=admin_lib_list";
	theForm.submit();
}
</script>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>