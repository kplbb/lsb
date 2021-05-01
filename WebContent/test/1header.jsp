<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <link href="css/header.css" type="text/css" rel="stylesheet" >
         
	<meta name="viewport" content="width=device-width, initial-scale=1">
   </head>
   <body>
      <nav>
         <div class="logo">
            LOCAL SAD BOYS
         </div>
         <label for="btn" class="icon">
         <span class="fa fa-bars"></span>
         </label>
         <input type="checkbox" id="btn">
         <ul>            
       
       
       <li><a href="LsbServlet?command=new_arrivals">NEW ARRIVALS</a></li>
            
            
        <li>
        <label for="btn-1" class="show">Features+</label>
        <a href="LsbServlet?command=jeans_view">APPAREL</a>
        <input type="checkbox" id="btn-1">
        <ul>
	        <li><a href="LsbServlet?command=tshirt_view">T-SHIRT</a></li> <!--kind:1-->
	        <li><a href="LsbServlet?command=sweater_view">SWEATER</a></li><!--kind:2-->
	        <li><a href="LsbServlet?command=bottoms_view">BOTTOMS</a></li><!--kind:3-->
	        <li><a href="LsbServlet?command=outer_view">OUTER</a></li><!--kind:4-->
	        <li><a href="LsbServlet?command=shirt_view">SHIRT</a></li><!--kind:5-->
	        <li><a href="LsbServlet?command=jeans_view">JEANS</a></li><!--kind:6-->
	        <li><a href="LsbServlet?command=jeans_view">ACCESSORIES</a></li><!--kind:7-->
	        <li><a href="LsbServlet?command=apparel_view_all">VIEW ALL</a></li>
        </ul>
        </li>
        
        
        <li>
        <label for="btn-1" class="show">Features+</label>
   		<a class="main_menu" href="LsbServlet?command=footwear_view_all">FOOTWEAR</a>
        <input type="checkbox" id="btn-1">
        <ul>
	        <li><a href="LsbServlet?command=sneakers_view">SNEAKERS</a></li><!--kind:8-->
	        <li><a href="LsbServlet?command=boots_view">BOOTS</a></li><!--kind:9-->
	        <li><a href="LsbServlet?command=heels_view">HEELS</a></li><!--kind:10-->
	        <li><a href="LsbServlet?command=flats_view">FLATS</a></li><!--kind:11-->
	        <li><a href="LsbServlet?command=footwear_view_all">VIEW ALL</a></li>
        </ul>
        </li>
        
        <li><a href="LsbServlet?command=library_view">LIBRARY</a></li>
        
    	<li>
        <label for="btn-2" class="show">Services +</label>
        <a>HELLO</a>
        <input type="checkbox" id="btn-2">
        <ul>
          <!--   <li><a href="#">login</a></li>
           <li><a href="#">register</a></li>-->
		       <c:choose>
		      <c:when test="${empty sessionScope.loginUser}">
		      <li>         
		        <a href="LsbServlet?command=login_form" style="width:110px;">LOGIN</a> 
		      </li>
		      <li>
		     <a href="LsbServlet?command=admin_login_form" style="width:100px;">ADMIN</a>
		   </li>		       
		      <li><a href="LsbServlet?command=join">JOIN</a></li>
		      </c:when>
		      <c:otherwise>
		      <li style="color:orange">
		        ${sessionScope.loginUser.name}${sessionScope.loginUser.id}
		      </li>
		      <li><a href="LsbServlet?command=logout">LOGOUT</a></li>
		      </c:otherwise>       
		      </c:choose> 
                   <!-- <li>
                    <label for="btn-3" class="show">More +</label>
                     <a href="#">More <span class="fa fa-plus"></span></a>
                     <input type="checkbox" id="btn-3">
                     <ul>
                        <li><a href="#">Submenu-1</a></li>
                        <li><a href="#">Submenu-2</a></li>
                        <li><a href="#">Submenu-3</a></li>
                     </ul>
                  </li>  -->
      </ul>
      </li>
      </ul>
      </nav>

<script>
   $('.icon').click(function(){
     $('span').toggleClass("cancel");
   });
</script>
</body>
</html>
