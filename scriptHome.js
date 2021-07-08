window.onscroll = function () { scroll() };

var top = document.getElementById("top");
var height = top.offsetTop;

function scroll() {
    if(window.pageYOffset > height) {
        top.classList.add("scroll");
    } else {
        top.classList.remove("scroll");
    }
}