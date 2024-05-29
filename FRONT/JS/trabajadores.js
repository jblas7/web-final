
  
  
  /*BOTON DESPLEGABLE RESPONSIVE*/
  document.addEventListener("DOMContentLoaded", function () {
    const dropdownButton = document.getElementById("dropdownButton");
    const dropdownMenu = document.getElementById("dropdownMenu");
    const closeBtn = document.getElementById("closeBtn");
  
    dropdownButton.addEventListener("click", function () {
      if (dropdownMenu.style.display === "none" || dropdownMenu.style.display === "") {
        dropdownMenu.style.display = "block";
      } else {
        dropdownMenu.style.display = "none";
      }
    });
  
    closeBtn.addEventListener("click", function () {
      dropdownMenu.style.display = "none";
    });
  });
  
  
  
  
  
  

  
  
  
  
  



document.addEventListener("DOMContentLoaded",(event) => {
  const botones = document.querySelectorAll(".boton_desplegable")
  const tablas = document.querySelectorAll(".texto_desplegable")
  botones.forEach((button, index) => {
  button.addEventListener("click", () => {
      if (tablas[index].style.display != "flex")
      {
          tablas[index].style.display = "flex";
      }
      else {
          tablas[index].style.display = "none"
      }

      tablas.forEach(tabla => {
      if (tabla != tablas[index]) 
      {
          tabla.style.display = "none"
      }
      })
  });
  });
})
