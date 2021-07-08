
var scrollheader = document.getElementById("scrollheader");
var height = scrollheader.offsetTop;
    
window.onscroll = function () {
    if(window.pageYOffset > height) {
        scrollheader.classList.add("scroll");
    } else {
        scrollheader.classList.remove("scroll");
    }
};


var aboutlink = document.getElementById("aboutlink");
var githublink = document.getElementById("githublink");
var projectslink = document.getElementById("projectslink");
var contactlink = document.getElementById("contactlink");

function moveTo(e) {
    var element = document.getElementById(e);
    console.log(e);
    
    window.scrollTo({ top: element.pageYOffset, left: 0, behavior: 'smooth' });
}

aboutlink.onclick = function() { moveTo("about"); };
githublink.onclick = function() { moveTo("github"); };
projectslink.onclick = function() { moveTo("projects"); };
contactlink.onclick = function() { moveTo("contact"); };