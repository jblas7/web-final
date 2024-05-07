
  
  
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

  
  

  /*APERTURA PARA INFORMACION*/  
  function toggleInfo(item) {
    var details = item.querySelector('.details');
    var allItems = document.querySelectorAll('.item');

    // Si el elemento actual ya está abierto, lo cerramos y salimos de la función
    if (item.classList.contains('clicked')) {
        details.classList.add('hidden');
        item.classList.remove('clicked');
        item.querySelector('img').style.transform = 'scale(1)';
        return;
    }

    // Oculta todas las secciones de detalles y elimina la clase 'clicked' de todos los elementos
    allItems.forEach(function (otherItem) {
        if (otherItem !== item && otherItem.classList.contains('clicked')) {
            otherItem.querySelector('.details').classList.add('hidden');
            otherItem.classList.remove('clicked');
            otherItem.querySelector('img').style.transform = 'scale(1)';
        }
    });

    // Muestra los detalles del elemento clicado
    details.classList.remove('hidden');
    item.classList.add('clicked');
    // Ajusta el tamaño de la imagen del elemento clicado
    var clickedImage = item.querySelector('img');
    clickedImage.style.transform = 'scale(1.1)';
}






function scrollToSection(sectionId) {
  const section = document.getElementById(sectionId);
  if (section) {
      section.scrollIntoView({ behavior: 'smooth' });
  }
}








/*PARTE DEL TEXTO QUE CAMBIA*/
var textos = [
  "DELICIOUS DISHES AWAIT",
  "EXPERIENCE CULINARY BLISS",
  "TASTE THE MAGIC OF OUR MENU",
  "UNFORGETTABLE FLAVORS EVERY BITE",
  "OUR FANTASTIC MENU"
];

function cambiarTexto() {
  var textoAleatorio = textos[Math.floor(Math.random() * textos.length)];
  document.getElementById("texto").innerHTML = textoAleatorio;
  setTimeout(function() {
    cambiarTextoAleatoriamente();
  }, 5000); // Cambia el texto aleatoriamente cada 5 segundos
}

function cambiarTextoAleatoriamente() {
  var textoAleatorio = textos[Math.floor(Math.random() * textos.length)];
  document.getElementById("texto").innerHTML = textoAleatorio;
  setTimeout(function() {
    cambiarTextoAleatoriamente();
  }, 5000); // Cambia el texto aleatoriamente cada 5 segundos
}

// Iniciar con un texto aleatorio al cargar la página
window.onload = function() {
  cambiarTexto();
};




