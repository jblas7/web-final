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
      alert("Por favor, seleccione el tipo de pedido.");
      return false;
    }

    if (tipoPedido.value === "entregaDomicilio") {
      var calle = document.getElementById("calle").value.trim();
      var portal = document.getElementById("portal").value.trim();
      var piso = document.getElementById("piso").value.trim();
      var letra = document.getElementById("letra").value.trim();
      if (calle === "" || portal === "" || piso === "" || letra === "") {
        alert("Por favor, complete todos los campos para la dirección de entrega.");
        return false;
      }

      var horaEntrega = document.getElementById("horaEntrega").value.trim();
      if (horaEntrega === "") {
        alert("Por favor, ingrese la hora de entrega.");
        document.getElementById("horaEntrega").focus();
        return false;
      }
    } else if (tipoPedido.value === "recogerLocal") {
      var nombre = document.getElementById("nombre").value.trim();
      if (nombre === "") {
        alert("Por favor, ingrese su nombre.");
        document.getElementById("nombre").focus();
        return false;
      }

      var telefono = document.getElementById("telefono").value.trim();
      if (telefono === "") {
        alert("Por favor, ingrese su número de teléfono.");
        document.getElementById("telefono").focus();
        return false;
      }

      var horaRecoger = document.getElementById("horaRecoger").value.trim();
      if (horaRecoger === "") {
        alert("Por favor, ingrese la hora de recogida.");
        document.getElementById("horaRecoger").focus();
        return false;
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

  function generarHoras() {
    var selectHoraEntrega = document.getElementById("horaEntrega");
    selectHoraEntrega.innerHTML = ""; // Limpiar opciones anteriores

    var selectHoraRecoger = document.getElementById("horaRecoger");
    selectHoraRecoger.innerHTML = ""; // Limpiar opciones anteriores

    for (var hora = 0; hora < 24; hora++) {
      for (var minuto = 0; minuto < 60; minuto += 5) {
        var horaString = (hora < 10 ? "0" + hora : hora) + ":" + (minuto < 10 ? "0" + minuto : minuto);
        var opcion = document.createElement("option");
        opcion.text = horaString;
        opcion.value = horaString;
        selectHoraEntrega.add(opcion.cloneNode(true));
        selectHoraRecoger.add(opcion.cloneNode(true));
      }
    }
  }

  // Llamar a la función para generar las opciones de hora al cargar la página
  window.onload = function() {
    mostrarOpciones();
    generarHoras();
  };
  function mostrarHoraEntrega() {
    var modoEntrega = document.getElementById("modoEntrega").value;
    var horaEntregaDiv = document.getElementById("horaEntregaDiv");
  
    if (modoEntrega === "programarEnvio") {
      horaEntregaDiv.style.display = "block";
      generarHoras("horaEntrega");
    } else {
      horaEntregaDiv.style.display = "none";
    }
  }
  function mostrarHoraRecoger() {
    var modoRecoger = document.getElementById("modoRecoger").value;
    var horaRecogerDiv = document.getElementById("horaRecogerDiv");
  
    if (modoRecoger === "programarRecogida") {
      horaRecogerDiv.style.display = "block";
      generarHoras("horaRecoger");
    } else {
      horaRecogerDiv.style.display = "none";
    }
  }
  