<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%> 

<title>LOCAL SAD BOYS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/Lsb.css" type="text/css" rel="stylesheet" >      

<style>
.slideshow-container {
	margin-top: 3px;
	margin-left: 0px;
	margin-right: 0px;
	width: 50%;
    display: inline-block;
    float: left;
    height: 100%;    
}
.indexjsp {
	margin-left:5px;
	margin-right: 3px;
}
.mySlides fade {
    object-fit: cover; 
    display: inline-block;
      
}
img {
   width: 100%;
   height: 100%; 
   bottom:0;  
    }
</style>

<div class="indexjsp">
	<div id="container">
		<div class="slideshow-container" data-cycle="2000">
			<div class="mySlides fade">
			  <img src="images/frantz (4).jpg"  ><!--"product_images/${productVO.image}"-->
			</div>
			<div class="mySlides fade">
			  <img src="images/frantz (5).jpg" >
			</div>
<!-- 			<div class="mySlides fade"> -->
<!-- 			  <img src="images/frantz (1).jpg"> -->
<!-- 			</div> -->
		</div>	

		<div class="slideshow-container" data-cycle="2000">
			<div class="mySlides fade">
			  <img src="images/frantz (1).jpg"><!--"product_images/${productVO.image}"-->
			</div>
			<div class="mySlides fade">
			  <img src="images/frantz (2).jpg">
			</div>
<!-- 			<div class="mySlides fade"> -->
<!-- 			  <img src="images/frantz (3).jpg" > -->
<!-- 			</div> -->
		</div> 
	</div>	
</div>
<script>
/* Find all slideshow containers */
var slideshowContainers = document.getElementsByClassName("slideshow-container");
/* For each container get starting variables */
for(let s = 0; s < slideshowContainers.length; s++) {
    /* Read the new data attribute */        
    var cycle = slideshowContainers[s].dataset.cycle;
    /* Find all the child nodes with class mySlides */
    var slides = slideshowContainers[s].querySelectorAll('.mySlides');
    var slideIndex = 0;
    /* Now we can cycle slides, but this recursive function must have parameters */
    /* slides and cycle never change, those are unique for each slide container */
    /* slideIndex will increase during each iteration */
    showSlides(slides, slideIndex, cycle);
};

/* Function is alsmost same, but now it uses 3 new parameters */
function showSlides(slides, slideIndex, cycle) {
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    };
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1
    };
    slides[slideIndex - 1].style.display = "block";
    /* Calling same function, but with new parameters and cycle time */
    setTimeout(function() {
        showSlides(slides, slideIndex, cycle)
    }, cycle);
};
</script>
<%@ include file="footer_news.jsp"%>
<%@ include file="footer.jsp"%> 
