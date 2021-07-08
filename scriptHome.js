window.onload = function() {
    console.log("Javascript is functioning.");

    document.getElementById("aboutlink").removeAttribute("href");
    document.getElementById("githublink").removeAttribute("href");
    document.getElementById("projectslink").removeAttribute("href");
    document.getElementById("contactlink").removeAttribute("href");
}


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
    var rect = element.getBoundingClientRect();
    var d = 54;

    if(!scrollheader.classLint.contains("scroll")) {
        d += 54;
    }
    
    if(e === "about") {
        window.scrollTo({
            top: 0,
            left: window.pageYOffset,
            behavior: 'smooth'
        });
    } 
    else {
        window.scrollTo({ 
            top: window.pageYOffset + rect.y - delta,
            left: window.pageXOffset,
            behavior: 'smooth'   } );
    }
}

aboutlink.onclick = function() { moveTo("about"); };
githublink.onclick = function() { moveTo("github"); };
projectslink.onclick = function() { moveTo("projects"); };
contactlink.onclick = function() { moveTo("contact"); };