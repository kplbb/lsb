<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

* {
	font: poppins;
	font-size:1em;
}
ul {
  list-style-type: none;
  margin-bottom: 0px;
  padding: 0px;
  overflow: hidden;
  background-color: white;
  
  	font: poppins;
	font-size:1em;
}

li {
  float: left;
  
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 16px;
  text-decoration: none;
  color:black;
  
}

li a:hover {
  background-color: gray;
}
</style>
<!-- <nav id="sub_menu"> -->
<ul>
<li><a href='LsbServlet?command=admin_product_list'> Products</a></li>
<li><a href='LsbServlet?command=admin_order_list'> Orders</a></li>
<li><a href='LsbServlet?command=admin_member_list'> Members</a></li>
<li><a href='LsbServlet?command=admin_lib_list'> Library</a></li>
<li><input style="margin-left:10%; margin-top: 10px;" class="btn" type="button"  value="logout"  style="float: right;"
			   onClick="location.href='LsbServlet?command=admin_logout'"></li>
</ul>
<!-- </nav> -->
