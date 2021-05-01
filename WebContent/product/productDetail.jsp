<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>  
<style>
/* *{ */
/* box-sizing: border-box; */
/* } */
</style>
<div class="thumbnail-slider">
	<div class="thumbnail-container">
       <div class="item"> <img id="img"  src="product_images/${productVO.images[0]}">    </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[1]}" />  </div>   
       <div class="item"> <img id="img" src="product_images/${productVO.images[2]}"  /> </div>   
       <div class="item">  <img id="img" src="product_images/${productVO.images[3]}" /> </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[4]}"  /> </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[5]}" />  </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[6]}"  /> </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[7]}" />  </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[8]}"  /> </div> 
       <div class="item"> <img id="img" src="product_images/${productVO.images[9]}" />  </div> 
    </div>
</div>
<!-- 		<div class="controls">   -->
<!-- 			<ul> -->
<!-- 				<li id="1" onclick="controlSlides(this)" class="active">1</li> -->
<!-- 				<li id="2" onclick="controlSlides(this)" class="">2</li> -->
<!-- 				<li id="3" onclick="controlSlides(this)" class="">3</li> -->
<!-- 			</ul>  -->
<!-- 		</div>  -->
<br> <br> <br>
	<form  method="post" name="formm"> 
		<div class="prod_det_desc">
	     <h2> ${productVO.name}</h2><br>             
	      <p> ${productVO.price2} USD</p><br>
	       <p> ${productVO.measurement} USD</p><br>
	      <label> quantity  </label><input  type="text"      name="quantity"  size="2"      value="1"> <br><br><br><br>
	       <input  type="hidden"    name="pseq"       value="${productVO.pseq}">        	         
	       <p> ${productVO.content} </p>
	       </div>
	      <!-- <div class="clear"></div> -->
	      <br><br><br><br>
	        <input type="button" id="headerBut" style="width:33%;" value="add to cart" class="submit" onclick="go_mycart()"> 
	        <input type="button" id="headerBut" style="width:33%;" value="place order now" class="submit" onclick="go_myorder()"> 
	        <input type="reset" id="headerBut" style="width:33%;" value="cancel" class="cancel" onclick="history.go(-1);">
	 </form>  
  <br>  <br>  <br>  <br>  <br>  <br>
  
<script>
const controls=document.querySelector(".controls");
const container=document.querySelector(".thumbnail-container");
const allBox=container.children;
const containerWidth=container.offsetWidth;
const margin=30;
 var items=0;
 var totalItems=0;
 var jumpSlideWidth=0;


// item setup per slide

responsive=[
{breakPoint:{width:0,item:1}}, //if width greater than 0 (1 item will show) 
{breakPoint:{width:600,item:2}}, //if width greater than 600 (2  item will show) 
{breakPoint:{width:1000,item:3}} //if width greater than 1000 (4 item will show) 
]

function load(){
   for(let i=0; i<responsive.length;i++){
   	if(window.innerWidth>responsive[i].breakPoint.width){
   		items=responsive[i].breakPoint.item
   	}
   }
   start();
}

function start(){
	 var totalItemsWidth=0
	for(let i=0;i<allBox.length;i++){
		 // width and margin setup of items
		allBox[i].style.width=(containerWidth/items)-margin + "px";
		//allBox[i].style.margin=(margin/2)+ "px";
		allBox[i].style.margin = 0;
      totalItemsWidth+=containerWidth/items;
      totalItems++;
	}

	// thumbnail-container width set up
	container.style.width=totalItemsWidth + "px";

	// slides controls number set up
	 const allSlides=Math.ceil(totalItems/items);
   const ul=document.createElement("ul");
      for(let i=1;i<=allSlides;i++){
        const li=document.createElement("li");
             li.id=i;
             li.innerHTML=i;
             li.setAttribute("onclick","controlSlides(this)");
          	//the issue 
             //ul.appendChild(li);
             if(i==1){
             	li.className="active";
             }
      }
      controls.appendChild(ul);
}

  // when click on numbers slide to next slide
function controlSlides(ele){
     // select controls children  'ul' element 
     const ul=controls.children;

     // select ul children 'li' elements;
    const li=ul[0].children
      
     
     var active;

     for(let i=0;i<li.length;i++){
     	if(li[i].className=="active"){
     		// find who is now active
     		active=i;
     		// remove active class from all 'li' elements
     		li[i].className="";
     	}
     }
     // add active class to current slide
     ele.className="active";

     var numb=(ele.id-1)-active;
        jumpSlideWidth=jumpSlideWidth+(containerWidth*numb);
     container.style.marginLeft=-jumpSlideWidth + "px";
     
}

window.onload=load();


</script>

<%@ include file="../footer.jsp" %>    