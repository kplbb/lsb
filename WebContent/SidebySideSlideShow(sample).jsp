<style>
/* * {
    box-sizing: border-box;
} 
*/
/* img {
    vertical-align: middle;
}
*/
/* Slideshow container */
/* Fading animation */
/* .fade {
    -webkit-animation-name: fade;
    -webkit-animation-duration: 1.5s;
    animation-name: fade;
    animation-duration: 1.5s;
}  */

.slideshow-container {
   width: 50%;
    /* position: relative; */
    margin-top: 0;
    margin-bottom: 0;
    display: inline-block;
    float: left;
    padding: 0;
     top:0;
    bottom:0;
}
/* .active {
    background-color: #717171;
}  */
.mySlides {
    display: inline-block;
       width: 100%;
       height: 100%;
       margin-top: 0;
    margin-bottom: 0;
    top:0;
    bottom:0;
    padding:0;
    
}
@-webkit-keyframes fade {
    from {
        opacity: .4
    }

    to {
        opacity: 1
    }
}

@keyframes fade {
    from {
        opacity: .4
    }

    to {
        opacity: 1
    }
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
    .text {
        font-size: 11px
    }
}
</style>


<div class="slideshow-container" data-cycle="1000">

    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/animals" style="height:100%; width:100%;">
    </div>

    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/nature" style="height:100%; width:100%;">
    </div>

    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/people" style="height:100%; width:100%;">
    </div>

</div>



<div class="slideshow-container" data-cycle="1000">

    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/animals" style="height:100%; width:100%;">
    </div>
    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/nature" style="height:100%; width:100%;">
    </div>
    <div class="mySlides fade">
        <img src="https://placeimg.com/320/240/animals" style="height:100%; width:100%;">
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
