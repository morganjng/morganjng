
var scrollheader = document.getElementById("scrollheader");
var height = scrollheader.offsetTop;
    
window.onscroll = function () {
    function scroll() {
        if(window.pageYOffset > height) {
            scrollheader.classList.add("scroll");
        } else {
            scrollheader.classList.remove("scroll");
        }
    }
};

var jumplinks = document.getElementById("jumplink");
var about = document.getElementById("about");
var github = document.getElementById("github");
var projects = document.getElementById("projects");
var contact = document.getElementById("contact");

jumplinks.onclick = function () {
    var str = jumplinks.getAttribute("href");

    if(str == "#about") {
        window.scrollTo(0, about.pageYOffset);
    } else if (str == "#github") {
        window.scrollTo(0, github.pageYOffset);
    } else if (str == "#projects") {
        window.scrollTo(0, projects.pageYOffset);
    } else if (str == "#contact") {
        window.scrollTo(0, contact.pageYOffset);
    } else {
        window.location.href = str;
    }

}