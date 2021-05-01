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
	justify-items: left;
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
textarea, input {
	float: left;
}
.btn {
	background-color: white;
	margin-left:47%;
}
tr{
	height:30px;
	}
</style>
<script type="text/javascript">
   function go_list()
   {
    var theForm = document.frm;
    theForm.action="LsbServlet?command=admin_lib_list";
    theForm.submit();
   }

   function go_rep(lseq)
   {
      var theForm = document.frm;
    theForm.lseq.value=lseq;
    theForm.action="LsbServlet?command=admin_lib_repsave";  //ActionFactory
    theForm.submit();
   }   
</script>
<article>
<h1>Library Blog Edit</h1>   
<form name="frm" method="post" enctype="multipart/form-data">
<input type="hidden" name="lseq">    <!-- to AdminQnaRepsaveAction  -->

<input type="hidden" name="libImg1" value="${libVO.images[0]}">  
<input type="hidden" name="libImg2" value="${libVO.images[1]}">  
<input type="hidden" name="libImg3" value="${libVO.images[2]}">  
<input type="hidden" name="libImg4" value="${libVO.images[3]}">  
<input type="hidden" name="libImg5" value="${libVO.images[4]}">  


<table id="orderList">
    <tr>
        <th width="10%">Title</th>
        <td><input  type="text" name="subject" size="100" maxlength="100" value=" ${libVO.subject}"></td>
    </tr>
   <tr>
         <th>Register Date</th>
         <td style="text-align: left;"> <fmt:formatDate value="${libVO.indate}"/> </td>           
    </tr>
    <tr>
    	<th>Content</th>
         <td><textarea name="content" rows="20" cols="200" >${libVO.content}</textarea></td>        
    </tr>
</table>
<%-- <c:choose>           --%>
<%--   <c:when test='${libVO.rep=="1"}'> --%>
  <table id="orderList">
      <tr>
          <td colspan="2">
<!--       <img src="admin/images/opinionimg01.gif"> -->
      </td>
      </tr>
    <tr>
    
    
    <h1>Library Post Images</h1>

<table>
<th style="justify-items:center; background-color: white;">Image1</th>
    <th style="justify-items:center; background-color: white;">Image2</th>
    <th style="justify-items:center; background-color: white;">Image3</th>
  <tr>
    <td>
		<img src="admin/images/lib/${libVO.images[0]}" width="200px"><br><input type="file" name="image1"><br> 	
	</td>
	<td>			
		<img src="admin/images/lib/${libVO.images[1]}" width="200px"><br><input type="file" name="image2"><br> 
	</td>
	<td>			
		<img src="admin/images/lib/${libVO.images[2]}" width="200px"><br><input  type="file" name="image3"><br> 
	</td>	
	</tr>
	<th style="justify-items:center; background-color: white;">Image4</th>
    <th style="justify-items:center; background-color: white;">Image5</th> 
    <th style="justify-items:center; background-color: white;"></th> 
	<tr>
	<td>			
		<img src="admin/images/lib/${libVO.images[3]}" width="200px"><br><input type="file" name="image4"><br> 	
	</td>
	<td>			
		<img src="admin/images/lib/${libVO.images[4]}" width="200px"><br><input type="file" name="image5"><br> 
	</td>	
	<td></td>				 
  </tr>    
 </table>
<hr>
<br><br>
 <div class="btn"> 
<input type="button" value="save" onClick="go_rep('${libVO.lseq}')">    <!--  go_rep is js -->
<input type="button" value="go back" onClick="go_list()">
</div> 
<br><br>
</form>
</article>
</body>
</html>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
