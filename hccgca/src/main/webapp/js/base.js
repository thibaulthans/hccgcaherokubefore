

function testScroll(ev){
  var elmt = document.querySelector(".navbar-default");
  var elmt5 = document.querySelector(".navbar-brand");
    if(window.pageYOffset<10){
      elmt.style.paddingTop="10px";
      elmt.style.paddingBottom="10px";
      elmt5.style.paddingLeft="10px";
    }
    if(window.pageYOffset>10){
      elmt.style.paddingTop="0px";
      elmt.style.paddingBottom="0px";
      elmt5.style.paddingLeft="4px";
    }
    document.querySelector(".navbar-default").style.WebkitTransition = "all 0.5s";
    elmt5.style.WebkitTransition = "all 0.5s";

}
window.onscroll=testScroll
