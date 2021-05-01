<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
	font: poppins;
}
#loginform {
	margin-left: 0px;
	justify-items: center;
	text-align: center;
}
article {
	justify-items: center;
	text-align: center;
}
header {
	justify-items: center;
	text-align: center;
}
table {
	text-align: center;
	justify-items: center;
	text-align: center;
	margin-left:45%;
	margin-top: 20%;
}
</style>
<html>
<head>
<meta charset="UTF-8">
<title>Lsb Admin</title>
<!-- <link rel="stylesheet" href="admin/css/admin.css"> -->
<script type="text/javascript">
function worker_check()
{
  if(document.frm.workId.value==""){
      alert("enter id.");
      return false;
  }else if(document.frm.workPw.value==""){
     alert("enter password.");
      return false;
    }
    return true;  
}
</script>
</head>

<body>
  <div id="wrap">
    <header>      
      <div id="logo">
        <a href="LsbServlet?command=admin_login_form"> <!-- "admin/main.jsp" --> 
        <img src="admin/images/LSB_admin_banner.JPG" style="float:left">
        <img src="admin/images/admin.jpg">
        </a>
      </div>      
    </header>
<!--     <div class="clear"></div> -->
    <article>
<!--       <div id="loginform"> -->
      <form name="frm" method="post" action="LsbServlet?command=admin_login">
      <table>
        <tr>
          <td> I D </td>
          <td> <input type="text" name="workerId" size="10" value="admin"></td>
        </tr>
        <tr>
          <td> PASSWORD </td>
          <td> 
            <input type="password" name="workerPwd" size="10" value="admin">
          </td>
        </tr>
        <tr align="center" >
          <td  colspan="2">          
            <input class="btn" type="submit" value="admin login" 
onclick="return worker_check()"><br><br>
            <h4 style="color:red">${message}</h4>
          </td>
        </tr>
      </table>
      </form>
<!--       </div> -->
    </article>
  </div>
</body>
</html>