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
    
    
    
    /*VENTANA EMERGENTE PARA PEDIDOS*/

    
    
    
    
    
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



    


    function validarFormulario() {
        var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked');
        if (!tipoPedido) {
            alert("Please select the type of order.");
            return false;
        }
    
        var nombre;
        var telefono;
    
        if (tipoPedido.value === "entregaDomicilio") {
            nombre = document.getElementById("nombre").value.trim();
            var telefonoEntrega = document.getElementById("telefonoEntrega").value.trim();
            var calle = document.getElementById("calle").value.trim();
            var portal = document.getElementById("portal").value.trim();
            var piso = document.getElementById("piso").value.trim();
            var letra = document.getElementById("letra").value.trim();
    
            if (nombre === "") {
                alert("Please enter your name.");
                document.getElementById("nombre").focus();
                return false;
            }
    
            if (telefonoEntrega === "" || !/^[0-9]{9}$/.test(telefonoEntrega)) {
                alert("Please enter a valid phone number for delivery.");
                document.getElementById("telefonoEntrega").focus();
                return false;
            }
    
            if (calle === "" || portal === "" || piso === "" || letra === "") {
                alert("Please complete all fields for the delivery address.");
                return false;
            }
    
            var modoEntrega = document.getElementById("modoEntrega").value;
            if (modoEntrega === "Schedule Shipment") {
                var horaEntrega = document.getElementById("horaEntrega").value.trim();
                if (horaEntrega === "") {
                    alert("Please enter the delivery time.");
                    document.getElementById("horaEntrega").focus();
                    return false;
                }
            }

     
        } else if (tipoPedido.value === "recogerLocal") {
            nombreRecoger = document.getElementById("nombreRecoger").value.trim(); 
            telefono = document.getElementById("telefono").value.trim();
    
            if (nombreRecoger === "") {
                alert("Please enter your first name for pick-up.");
                document.getElementById("nombreRecoger").focus(); 
                return false;
            }
    
            if (telefono === "" || !/^[0-9]{9}$/.test(telefono)) {
                alert("Please enter a valid phone number for pick-up.");
                document.getElementById("telefono").focus();
                return false;
            }
    
            var modoRecoger = document.getElementById("modoRecoger").value;
            if (modoRecoger === "Schedule Pickup") {
                var horaRecoger = document.getElementById("horaRecoger").value.trim();
                if (horaRecoger === "") {
                    alert("Please enter the pick-up time.");
                    document.getElementById("horaRecoger").focus();
                    return false;
                }
            }
        }
    
        return true;
    }
    






  function mostrarOpciones() {
      var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked');
      var opcionesEntrega = document.getElementById("opcionesEntrega");
      var opcionesRecoger = document.getElementById("opcionesRecoger");

      if (tipoPedido && tipoPedido.value === "entregaDomicilio") {
          opcionesEntrega.style.display = "block";
          opcionesRecoger.style.display = "none";
      } else if (tipoPedido && tipoPedido.value === "recogerLocal") {
          opcionesEntrega.style.display = "none";
          opcionesRecoger.style.display = "block";
      }
  }

  function mostrarHoraEntrega() {
      var modoEntrega = document.getElementById("modoEntrega").value;
      var horaEntregaDiv = document.getElementById("horaEntregaDiv");

      horaEntregaDiv.style.display = modoEntrega === "Schedule Shipment" ? "block" : "none";
  }

  function mostrarHoraRecoger() {
      var modoRecoger = document.getElementById("modoRecoger").value;
      var horaRecogerDiv = document.getElementById("horaRecogerDiv");

      horaRecogerDiv.style.display = modoRecoger === "Schedule Pickup" ? "block" : "none";
  }
  function guardarFormulario(event) {
    event.preventDefault(); // Prevent form submission

    if (!validarFormulario()) {
        return; // Stop if validation fails
    }

    var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked').value;
    var nombre = document.getElementById("nombre").value.trim();
    var calle = document.getElementById("calle").value.trim();
    var portal = document.getElementById("portal").value.trim();
    var piso = document.getElementById("piso").value.trim();
    var letra = document.getElementById("letra").value.trim();
    var telefonoEntrega = document.getElementById("telefonoEntrega").value.trim();
    var modoEntrega = document.getElementById("modoEntrega").value;
    var horaEntrega = document.getElementById("horaEntrega").value.trim();
    var nombre = document.getElementById("nombreRecoger").value.trim();
    var telefono = document.getElementById("telefono").value.trim();
    var Shop = document.getElementById("Shop").value.trim();
    var modoRecoger = document.getElementById("modoRecoger").value;
    var horaRecoger = document.getElementById("horaRecoger").value.trim();

    var formularioDatos = {
        tipoPedido,
        nombre,
        calle,
        portal,
        piso,
        letra,
        telefonoEntrega,
        modoEntrega,
        horaEntrega,
        nombreRecoger,
        telefono,
        Shop,
        modoRecoger,
        horaRecoger
    };

    localStorage.setItem('formularioDatos', JSON.stringify(formularioDatos));
    alert('Information successfully saved!');
    window.location.href = '../HTML/carrito.html'; // Redirect after saving data
}

window.onload = function() {
    mostrarOpciones();
};

document.getElementById("formularioPedido").addEventListener("submit", guardarFormulario);
document.querySelectorAll('input[name="tipoPedido"]').forEach(el => el.addEventListener("change", mostrarOpciones));
document.getElementById("modoEntrega").addEventListener("change", mostrarHoraEntrega);
document.getElementById("modoRecoger").addEventListener("change", mostrarHoraRecoger);

function mostrarVentana() {
    var ventanaEmergente = document.getElementById("ventanaEmergente");
    ventanaEmergente.style.display = "block";
    document.body.style.overflow = "hidden"; // Bloquear el scroll
}

function cerrarVentana() {
    var ventanaEmergente = document.getElementById("ventanaEmergente");
    ventanaEmergente.style.display = "none";
    document.body.style.overflow = "auto"; // Habilitar el scroll nuevamente
}

document.addEventListener("DOMContentLoaded", function() {
    var scrollTopButton = document.getElementById('scrollTopButton');

    // Mostrar o ocultar el botón basado en el desplazamiento de la página
    window.addEventListener('scroll', function() {
        if (window.scrollY > 200) { // Cambia 200 por la cantidad de píxeles de desplazamiento que desees antes de mostrar el botón
            scrollTopButton.classList.add('show');
        } else {
            scrollTopButton.classList.remove('show');
        }
    });

    // Animar el desplazamiento hacia arriba al hacer clic en el botón
    scrollTopButton.addEventListener('click', function() {
        window.scrollTo({
            top: 0,
            behavior: 'smooth' // Para un desplazamiento suave
        });
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





  


  function pagarClicked() {
      // Redirige a la página de pago
      window.location.href = '../HTML/inicio.html';
  }














  

  /*GUARDAR INFO*/


  window.onload = function() {
    // Obtener los parámetros de la URL
    const urlParams = new URLSearchParams(window.location.search);

    // Crear una lista de detalles de la compra
    const detallesCompra = document.getElementById('detallesCompra');
    const listaDetalles = document.createElement('ul');

    // Recorrer todos los parámetros y agregarlos a la lista
    urlParams.forEach((value, key) => {
        const detalle = document.createElement('li');
        detalle.textContent = `${key}: ${value}`;
        listaDetalles.appendChild(detalle);
    });

    // Mostrar la lista de detalles en la página
    detallesCompra.appendChild(listaDetalles);
  };

  window.addEventListener('beforeunload', function (event) {
    event.preventDefault();
    event.returnValue = '';
    return '';
  });

  window.addEventListener('unload', function() {
    if (confirm('¿Estás seguro de que deseas recargar la página? Esto eliminará los datos actuales.')) {
        window.location.href = window.location.pathname;
    }
  });
