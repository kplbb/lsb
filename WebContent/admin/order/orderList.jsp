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
<script type="text/javascript">
  function go_order_save() {
    var count = 0;
    if (document.frm.result.length == undefined) {
      if (document.frm.result.checked == true) {
        count++;
      }
    } else {
      for ( var i = 0; i < document.frm.result.length; i++) {
        if (document.frm.result[i].checked == true) {
          count++;
        }
      }
    }
    if (count == 0) {
      alert("select orders to mark as complete.");
    } else {
      document.frm.action = "LsbServlet?command=admin_order_save";
      document.frm.submit();
    }
  }
  function go_search() {
		var theForm = document.frm;
		theForm.action =  "LsbServlet?command=admin_order_list";
		theForm.submit();
	}
</script>
<article>
<h1>order list</h1>
<form name="frm" method="post">
  <table style="float: right;">
    <tr>
      <td>customer name&nbsp;&nbsp;<input type="text" name="key"> 
      <input class="btn" type="button" value="search" onclick="go_search()">
      </td>
    </tr>
  </table>
  <br><br>
  <table id="orderList">
  <tr>
    <th>order number(all)</th><th>orderer</th><th>item name</th><th>quantity</th>
   <th>address</th><th>order date</th><th>payment</th><th>email</th>
  </tr>
  <c:forEach items="${orderList}" var="orderVO">
  <tr>
    <td>
      <c:choose>
        <c:when test='${orderVO.result=="1"}'>
        <span style="font-weight: bold; color: blue">${orderVO.odseq}</span>
        (<input type="checkbox" name="result" value="${orderVO.odseq}"> incomplete)
        </c:when>
        <c:otherwise>
          <span style="font-weight: bold; color: red">${orderVO.odseq}</span>
          (<input type="checkbox" checked="checked" disabled="disabled">complete)
        </c:otherwise>
      </c:choose>
    </td>
    <td>${orderVO.mname}</td> <td>${orderVO.pname}</td>
    <td>${orderVO.quantity}</td>
    <td >${orderVO.address}</td>  
    <td><fmt:formatDate value="${orderVO.indate}" /></td>
    <td>${orderVO.payment}</td>
    <td>${orderVO.email}</td>
  </tr>
  </c:forEach>
  </table><br><br><br>
  <input type="button" style="width: 320px; margin-left:42%;"
      value="process orders (upon deposit confirmation)" onClick="go_order_save()">
</form>
</article>
<%-- <%@ include file="/admin/footer.jsp"%> --%>
</body>
</html>