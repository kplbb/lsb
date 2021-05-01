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
    height: 40px;
  
}

table tr:last-child {
  border: 0;
}
.btn {
	justify-items: center;
	margin-left:47%;
	}
</style>
<!-- <script type="text/javascript"> -->

<script>
  function go_view(lseq) {
    var theForm = document.frm;
    theForm.lseq.value = lseq;
    theForm.action = "LsbServlet?command=admin_lib_detail";
    theForm.submit();
  }
  function go_lib_wrt() {
		var theForm = document.frm;
		theForm.action = "LsbServlet?command=admin_lib_write_form";
		theForm.submit();
	}
</script>

<article>
<h1>Library Posts</h1>  
<form name="frm" method="post">
<input type="hidden" name="lseq">  
<table id="orderList">
  <tr>
    <th>post #</th> <th>title</th> <th>date</th>    
  </tr>
  <c:forEach items="${libList}" var="libVO">    <!-- the name saved, AdminQnaListAction -->
      <tr>
      <td>
      ${libVO.lseq}  
<%--       <c:choose>           --%>
<%--         <c:when test='${libVO.rep=="1"}'>(unreplied)</c:when> --%>
<%--         <c:otherwise>(replied)</c:otherwise> --%>
<%--       </c:choose>       --%>
      </td>
      <td> 
      <a href="#" onClick="javascript:go_view('${libVO.lseq}')">
        ${libVO.subject} 
      </a>
      </td>
      <td> <fmt:formatDate value="${libVO.indate}"/></td>
      </tr>
    </c:forEach>
    </table>
    <br><br><hr>
         <input style="width: 120px;" class="btn" type="button" name="btn_write" value="post a blog" onClick="go_lib_wrt()">
    </form>    
  </article>
<%--   <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>