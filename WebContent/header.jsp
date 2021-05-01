<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="css/Lsb.css" type="text/css" rel="stylesheet" >      
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="member/member.js"></script>
	<script src="mypage/mypagejs.js"></script>	

</head>
   <body>
   
    <nav>
      <div class="logo" onclick="location='LsbServlet?command=index'">
         LOCAL SAD BOYS 
     </div>
     
     <!--  <label for="btn" class="icon">  -->
      <!-- <span class="fa fa-bars"></span> -->
  
    <!--  <input  id="btn">   -->
      <ul class=" ">            
	   	<li class=" "><a href="LsbServlet?command=new_arrivals">NEW ARRIVALS</a></li>
	                 
	    <li>
	    <label class="show"></label>
	    <a href="LsbServlet?command=apparel_view_all">APPAREL</a>
		    <ul>
		     <li><a href="LsbServlet?command=category&kind=1">T-SHIRT</a></li> <!--kind:1-->
		     <li><a href="LsbServlet?command=category&kind=2">SWEATER</a></li><!--kind:2-->
		     <li><a href="LsbServlet?command=category&kind=3">BOTTOMS</a></li><!--kind:3-->
		     <li><a href="LsbServlet?command=category&kind=4">OUTER</a></li><!--kind:4-->
		     <li><a href="LsbServlet?command=category&kind=5">SHIRT</a></li><!--kind:5-->
		     <li><a href="LsbServlet?command=category&kind=6">JEANS</a></li><!--kind:6-->
   		     <li><a href="LsbServlet?command=category&kind=7">DRESS</a></li><!--kind:7-->
   		     <li><a href="LsbServlet?command=category&kind=8">JUMPSUITS</a></li><!--kind:8-->
   		     <li><a href="LsbServlet?command=category&kind=9">SKIRT</a></li><!--kind:9-->		     		     		     
		     <li><a href="LsbServlet?command=category&kind=10">ACCESSORIES</a></li><!--kind:10-->
		     <li><a href="LsbServlet?command=apparel_view_all">VIEW ALL</a></li>
		    </ul>
	    </li>	    
	    <li class=" ">
	    <label class="show"></label>
		<a href="LsbServlet?command=footwear_view_all">FOOTWEAR</a>
		    <ul>
		     <li><a href="LsbServlet?command=category&kind=11">SNEAKERS</a></li><!--kind:11-->
		     <li><a href="LsbServlet?command=category&kind=12">BOOTS</a></li><!--kind:12-->
		     <li><a href="LsbServlet?command=category&kind=13">HEELS</a></li><!--kind:13-->
		     <li><a href="LsbServlet?command=category&kind=14">FLATS</a></li><!--kind:14-->
		     <li><a href="LsbServlet?command=footwear_view_all">VIEW ALL</a></li>
		    </ul>
	    </li>
	    
	    <li class=" "><a href="LsbServlet?command=library_list">LIBRARY</a></li>
	    
		<li class=" ">
	    <label for="btn-2" class="show">Services +</label>
	    <!-- href="LsbServlet?command=about_us" --><a>HELLO</a>
	   <!--   <input type="checkbox" id="btn-2">    --> 
	    <ul>
	   	 <c:choose>
	   	 <c:when test="${empty sessionScope.loginUser}">
	   		 <li>         
	    	  <a onclick="document.getElementById('id01').style.display='block'" 
	     	 style="width:auto;" class="login">LOGIN</a>
			</li>		
			
		<div id="id01" class="modal">					  
			  <form class="modal-content animate" action="LsbServlet?command=login" method="post">
		
		    <div class="container">
		      <label for="uname"><b>User ID</b></label>
		      <input id="headerInput" type="text" placeholder="Enter Username" name="userId" required>
		
		      <label for="psw"><b>Password</b></label>
		      <input  id="headerInput"type="password" placeholder="Enter Password" name="pwd" required>
		        
		      <button id="headerBut" type="submit">Login</button>
		    </div>
		
		    <!-- <div class="container" style="background-color:#f1f1f1">  -->
<!-- 			<button  id="headerBut" style="width: auto ; background-color: transparent; color:black;"  -->
<!-- 				type="button" class="submit" onclick="location='LsbServlet?command=find_id_form'">Forgot Password?</button>		     -->
<!-- 			<br> -->
			  <button id="headerBut"type="button" style="width: 100px; background-color:transparent; color:black;"onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button> 		    
		  </form>
		</div>
	 
	 
	    <li><a href="LsbServlet?command=contract">JOIN</a></li>
	   		   
	    </c:when>
	    <c:otherwise>
	    <li style="color:#FFF8B3; "> <!-- style="color:#C4C4C4" -->
	       <a href="LsbServlet?command=mypage">Hello ${sessionScope.loginUser.id}! </a> <!-- ${sessionScope.loginUser.name}-->
	    </li>
	  	 <li><a href="LsbServlet?command=cart_list">CART</a></li>
	  	  <li><a href="LsbServlet?command=logout">LOGOUT</a></li>
	    </c:otherwise>       
	    </c:choose> 
  </ul>
  </li>
  </ul>
  <!-- RESPONSIVE HAMBURGER  -->
  	<div class="hamburger">
  		<span class="bar"></span>
 		<span class="bar"></span>
 		<span class="bar"></span>
  	</div>
  </nav>

<script>
   $('.icon').click(function(){
     $('span').toggleClass("cancel");
   });
   
   
   
/*
 
   const hamburger = document.querySelector(".hamburger");
   const navMenu = document.querySelector(". ");

   hamburger.addEventListener("click", mobileMenu);

   function mobileMenu() {
       hamburger.classList.toggle("active");
       navMenu.classList.toggle("active");
   }   
// Inside the Media Query.

   .hamburger.active .bar:nth-child(2) {
       opacity: 0;
   }

   .hamburger.active .bar:nth-child(1) {
       transform: translateY(8px) rotate(45deg);
   }

   .hamburger.active .bar:nth-child(3) {
       transform: translateY(-8px) rotate(-45deg);
   }
   * 
   */
</script>


