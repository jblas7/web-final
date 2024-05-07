/*CARRUSEL AUTOMÁTICO (CONTROL)*/
var myCarousel = new bootstrap.Carousel(document.getElementById('miCarrusel'), {
  interval: 6000 // tiempo para pasar de una imagen a otra
});

// Reinicia el intervalo del carrusel después de que el usuario realice alguna acción
document.addEventListener("DOMContentLoaded", function () {
  var carouselEl = document.getElementById('miCarrusel');
  carouselEl.addEventListener('mouseover', function () {
      myCarousel.pause();
  });
  carouselEl.addEventListener('mouseleave', function () {
      myCarousel.cycle();
  });
  window.addEventListener('scroll', function () {
      myCarousel.cycle();
  });
});



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











/*VENTANA EMERGENTE PARA EL CARRUSEL DESLIZANTE*/
document.addEventListener('DOMContentLoaded', function () {
  let timeoutId;
  let lastScrollTop = 0; // Variable para almacenar la última posición de desplazamiento

  const imagenes = document.querySelectorAll('.img-carrusel222');
  const ventanaEmergente = document.getElementById('ventanaEmergente');

  imagenes.forEach(imagen => {
      imagen.addEventListener('mouseenter', iniciarTimeout);
      imagen.addEventListener('mouseleave', cancelarTimeout);
  });

  // Evento de desplazamiento de la ventana
  window.addEventListener('scroll', function() {
      const currentScroll = window.pageYOffset || document.documentElement.scrollTop;
      if (currentScroll > lastScrollTop){
          // Desplazamiento hacia abajo
          ventanaEmergente.style.display = 'none'; // Ocultar la ventana emergente al desplazarse hacia abajo
      }
      lastScrollTop = currentScroll <= 0 ? 0 : currentScroll; // Para móviles o navegadores con ventana inferior
  });

  function iniciarTimeout(event) {
      const titulo = event.target.getAttribute('data-title');
      const ingredientes = event.target.getAttribute('data-ingredients');

      timeoutId = setTimeout(() => {
          mostrarVentana(titulo, ingredientes, event.target);
      }, 500);
  }

  function cancelarTimeout() {
      clearTimeout(timeoutId);
      ventanaEmergente.style.display = 'none';
  }

  function mostrarVentana(titulo, ingredientes, imagen) {
      const imagenRect = imagen.getBoundingClientRect();
      const ventanaAncho = ventanaEmergente.offsetWidth;
      const ventanaAlto = ventanaEmergente.offsetHeight;
      const ventanaX = imagenRect.left + (imagenRect.width / 2) - (ventanaAncho / 2);
      const ventanaY = imagenRect.top - ventanaAlto - 20;

      ventanaEmergente.innerHTML = `<h3 class=""><strong>${titulo}</strong></h3><p>${ingredientes}</p>`;
      ventanaEmergente.style.left = ventanaX + 'px';
      ventanaEmergente.style.top = ventanaY + 'px';
      ventanaEmergente.style.display = 'block';
  }
});










/*CARRUSEL DESLIZABLEEE*/
const carousel = document.getElementById('carrusel222');
let isDown = false;
let startX;
let scrollLeft;

carousel.addEventListener('mousedown', (e) => {
    isDown = true;
    carousel.classList.add('active');
    startX = e.pageX - carousel.offsetLeft;
    scrollLeft = carousel.scrollLeft;
});

carousel.addEventListener('mouseleave', () => {
    isDown = false;
    carousel.classList.remove('active');
});

carousel.addEventListener('mouseup', () => {
    isDown = false;
    carousel.classList.remove('active');
});

carousel.addEventListener('mousemove', (e) => {
    if (!isDown) return;
    e.preventDefault();
    const x = e.pageX - carousel.offsetLeft;
    const walk = (x - startX) * 1; // Puedes ajustar el multiplicador para cambiar la sensibilidad
    carousel.scrollLeft = scrollLeft - walk;
});