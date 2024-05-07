
  
  
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
/**/  
  

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
  ['DELICIOUS STARTERS', 'HEALTHY SALADS', 'VEGAN OPTIONS'],
  ['TASTY MAINS', 'MEAT LOVERS', 'SEAFOOD DELIGHTS'],
  ['SWEET DESSERTS', 'CHOCOLATE HEAVEN', 'FRUIT PARADISE'],
  ['REFRESHING DRINKS', 'COOL COCKTAILS', 'NON-ALCOHOLIC BEVERAGES'],
  ['HAPPY HOUR SPECIALS', 'LATE NIGHT SNACKS', 'EARLY BIRD DISCOUNTS']
];
var i = 0;
var j = 0;
var k = 0;
var currentText = '';
var isDeleting = false;
var isWaiting = false;
var waitTime = 2000; // Tiempo de espera en milisegundos
var deleteSpeed = 160; // Velocidad de borrado en milisegundos
var id = setInterval(typeWriter, 80);

function typeWriter() {
  var idElemento = 'tx-en' + (i + 1);
  var elemento = document.getElementById(idElemento);
  if (elemento) {
      if (isDeleting) {
          if (!isWaiting) {
              currentText = currentText.slice(0, currentText.length - 1);
              elemento.innerHTML = currentText + '<span class="cursor">|</span>';
              if (currentText === '') {
                  isDeleting = false;
                  k = (k + 1) % textos[i].length;
                  if (k === 0) {
                      i = (i + 1) % textos.length;
                  }
              }
          }
      } else {
          if (!isWaiting) {
              currentText = textos[i][k].slice(0, j + 1);
              elemento.innerHTML = currentText + '<span class="cursor">|</span>';
              j++;
              if (currentText === textos[i][k]) {
                  isDeleting = true;
                  j = 0;
                  isWaiting = true;
                  setTimeout(function() { isWaiting = false; }, waitTime);
              }
          }
      }
  } else {
      clearInterval(id);
  }
}
