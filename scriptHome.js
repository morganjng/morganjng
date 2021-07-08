window.onscroll = function () { scroll() };

var scrollheader = document.getElementById("scrollheader");
var height = scrollheader.offsetTop;

function scroll() {
    if(window.pageYOffset > height) {
        scrollheader.classList.add("scroll");
    } else {
        scrollheader.classList.remove("scroll");
    }
}