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
tr{
	height: 30px;
	}
</style>
<script type="text/javascript">
  function go_search()
  {
     document.frm.action="LsbServlet?command=admin_member_list";
     document.frm.submit();
  }
</script>

<article>
<h1>List of Members</h1>  
<form name="frm" method="post">
<table style="float:right; ">
  <tr>
  <td> 
  Member Name
  <input type="text" name="key">  <!-- input(name) == key -->
  <input class="btn" type="button" value="search" onclick="go_search()">   <!--SEARCH BY NAME in js-->
  </td>
  </tr>
</table>  
<br>
<table id="orderList">
  <tr>
    <th> ID(all) </th><th> NAME </th><th> EMAIL </th><th> ZIP CODE </th>  
    <th> ADDRESS </th><th>PHONE</th><th> REGISTER DATE </th><th>NEWS SUB</th>
  </tr>
  <c:forEach items="${memberList}" var="memberVO">  
  <tr>
    <td>${memberVO.id} 
<%--     <c:choose> --%>
<%--       <c:when test='${memberVO.useyn=="y"}'> --%>
<!--         <input type="checkbox" name="useyn" disabled="disabled"> -->
<%--       </c:when> --%>
<%--       <c:otherwise> --%>
<!--         <input type="checkbox" name="useyn" checked="checked" disabled="disabled"> -->
<%--       </c:otherwise> --%>
<%--     </c:choose> --%>
    </td>
    <td> ${memberVO.name} </td>
    <td> ${memberVO.email} </td> 
    <td> ${memberVO.zip_num} </td>
    <td> ${memberVO.address} </td>
    <td> ${memberVO.phone} </td> 
    <td> <fmt:formatDate value="${memberVO.regdate}"/></td>
    <td> ${memberVO.news_email_yn}</td> 
  </tr>
  </c:forEach>
</table>
</form>
</article>
<br><br><br><br>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>