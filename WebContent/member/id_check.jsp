<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID availability</title>
<link href="CSS/Lsb.css" rel="stylesheet">

<style type="text/css">
body{   
  background-color:#FFFEFE;
  font-family: Poppins;
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: Poppins;
  font-size: 45px;
  color: #000000;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(){
  opener.formm.id.value="${id}"; 
  opener.formm.reid.value="${id}";
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>ID availability check</h1>
  <form method=post name=formm style="margin-right:0 "
action="LsbServlet?command=id_check_form" >
    User ID <input type=text name="id" value=""> 
            <input type=submit value="search" class="submit"><br>     
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.id.value="";
        </script>
        ${id} is taken.
      </c:if>
      <c:if test="${message==-1}">
        ${id} is available to use.
        <input type="button" value="use" class="cancel" onclick="idok()">
      </c:if>
    </div>
  </form>
</div>  
</body>
</html>


