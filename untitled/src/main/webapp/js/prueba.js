window.addEventListener("scroll", function() {
    var header = document.querySelector("header");
    if (window.scrollY > 0) {
        header.classList.add("minimizado");
    } else {
        header.classList.remove("minimizado");
    }
});
window.addEventListener('scroll', function() {
    var header = document.querySelector('header');
    var spacer = document.querySelector('.spacer');
    
    if (window.scrollY > 0) {
        header.classList.add('minimizado');
        spacer.style.height = header.clientHeight + 'px';
    } else {
        header.classList.remove('minimizado');
        spacer.style.height = '0';
    }
});


document.addEventListener("DOMContentLoaded", function() {
    const dropdownButton = document.getElementById("dropdownButton");
    const dropdownMenu = document.getElementById("dropdownMenu");
    const closeBtn = document.getElementById("closeBtn");
  
    dropdownButton.addEventListener("click", function() {
      if (dropdownMenu.style.display === "none" || dropdownMenu.style.display === "") {
        dropdownMenu.style.display = "block";
      } else {
        dropdownMenu.style.display = "none";
      }
    });
  
    closeBtn.addEventListener("click", function() {
      dropdownMenu.style.display = "none";
    });
  });
  