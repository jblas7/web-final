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



  


 /*PARTE FORMULARIO GORDO*/

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

    var modoEntrega = document.getElementById("modoEntrega").value;
    if (modoEntrega === "programarEnvio") {
      var horaEntrega = document.getElementById("horaEntrega").value.trim();
      if (horaEntrega === "") {
        alert("Por favor, ingrese la hora de entrega.");
        document.getElementById("horaEntrega").focus();
        return false;
      }
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

    var modoRecoger = document.getElementById("modoRecoger").value;
    if (modoRecoger === "programarRecogida") {
      var horaRecoger = document.getElementById("horaRecoger").value.trim();
      if (horaRecoger === "") {
        alert("Por favor, ingrese la hora de recogida.");
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

  if (modoEntrega === "programarEnvio") {
    horaEntregaDiv.style.display = "block";
  } else {
    horaEntregaDiv.style.display = "none";
  }
}

function mostrarHoraRecoger() {
  var modoRecoger = document.getElementById("modoRecoger").value;
  var horaRecogerDiv = document.getElementById("horaRecogerDiv");

  if (modoRecoger === "programarRecogida") {
    horaRecogerDiv.style.display = "block";
  } else {
    horaRecogerDiv.style.display = "none";
  }
}

window.onload = function() {
  mostrarOpciones();
};

document.getElementById("formularioPedido").addEventListener("submit", function(event) {
  var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked');
  if (!tipoPedido) {
      alert("Por favor, seleccione el tipo de pedido.");
      event.preventDefault();
      return;
  }

  if (tipoPedido.value === "entregaDomicilio") {
      var calle = document.getElementById("calle").value.trim();
      var portal = document.getElementById("portal").value.trim();
      var piso = document.getElementById("piso").value.trim();
      var letra = document.getElementById("letra").value.trim();
      if (calle === "" || portal === "" || piso === "" || letra === "") {
          alert("Por favor, complete todos los campos para la dirección de entrega.");
          event.preventDefault();
          return;
      }

      var modoEntrega = document.getElementById("modoEntrega").value;
      if (modoEntrega === "programarEnvio") {
          var horaEntrega = document.getElementById("horaEntrega").value.trim();
          if (horaEntrega === "") {
              alert("Por favor, ingrese la hora de entrega.");
              document.getElementById("horaEntrega").focus();
              event.preventDefault();
              return;
          }
      }
  } else if (tipoPedido.value === "recogerLocal") {
      var nombre = document.getElementById("nombre").value.trim();
      if (nombre === "") {
          alert("Por favor, ingrese su nombre.");
          document.getElementById("nombre").focus();
          event.preventDefault();
          return;
      }

      var telefono = document.getElementById("telefono").value.trim();
      if (telefono === "") {
          alert("Por favor, ingrese su número de teléfono.");
          document.getElementById("telefono").focus();
          event.preventDefault();
          return;
      }

      var modoRecoger = document.getElementById("modoRecoger").value;
      if (modoRecoger === "programarRecogida") {
          var horaRecoger = document.getElementById("horaRecoger").value.trim();
          if (horaRecoger === "") {
              alert("Por favor, ingrese la hora de recogida.");
              document.getElementById("horaRecoger").focus();
              event.preventDefault();
              return;
          }
      }
  }
});





/*GUARDAR INFO DEL FORMULARIO*/

function mostrarOpciones() {
  const tipoPedido = document.querySelector('input[name="tipoPedido"]:checked').value;
  document.getElementById('opcionesEntrega').style.display = tipoPedido === 'entregaDomicilio' ? 'block' : 'none';
  document.getElementById('opcionesRecoger').style.display = tipoPedido === 'recogerLocal' ? 'block' : 'none';
}

function mostrarHoraEntrega() {
  const modoEntrega = document.getElementById('modoEntrega').value;
  document.getElementById('horaEntregaDiv').style.display = modoEntrega === 'programarEnvio' ? 'block' : 'none';
}

function mostrarHoraRecoger() {
  const modoRecoger = document.getElementById('modoRecoger').value;
  document.getElementById('horaRecogerDiv').style.display = modoRecoger === 'programarRecogida' ? 'block' : 'none';
}

function guardarFormulario(event) {
  event.preventDefault();

  const tipoPedido = document.querySelector('input[name="tipoPedido"]:checked').value;
  const calle = document.getElementById('calle').value;
  const portal = document.getElementById('portal').value;
  const piso = document.getElementById('piso').value;
  const letra = document.getElementById('letra').value;
  const modoEntrega = document.getElementById('modoEntrega').value;
  const horaEntrega = document.getElementById('horaEntrega').value;
  const nombre = document.getElementById('nombre').value;
  const telefono = document.getElementById('telefono').value;
  const pec = document.getElementById('pec').value;
  const modoRecoger = document.getElementById('modoRecoger').value;
  const horaRecoger = document.getElementById('horaRecoger').value;

  const formularioDatos = {
      tipoPedido,
      calle,
      portal,
      piso,
      letra,
      modoEntrega,
      horaEntrega,
      nombre,
      telefono,
      pec,
      modoRecoger,
      horaRecoger
  };

  localStorage.setItem('formularioDatos', JSON.stringify(formularioDatos));
  alert('Información guardada con éxito!');
  window.location.href = '../HTML/CARRITO.HTML';
}
















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





  
/*CARRITO TOCHOOO*/
// Variable que mantiene el estado visible del carrito
var carritoVisible = false;

// Esperamos que todos los elementos de la página carguen para ejecutar el script
if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready();
}

function ready() {
    // Agregamos funcionalidad a los botones eliminar del carrito
    var botonesEliminarItem = document.getElementsByClassName('btn-eliminar');
    for (var i = 0; i < botonesEliminarItem.length; i++) {
        var button = botonesEliminarItem[i];
        button.addEventListener('click', eliminarItemCarrito);
    }

    // Agrego funcionalidad al botón sumar cantidad
    var botonesSumarCantidad = document.getElementsByClassName('sumar-cantidad');
    for (var i = 0; i < botonesSumarCantidad.length; i++) {
        var button = botonesSumarCantidad[i];
        button.addEventListener('click', sumarCantidad);
    }

    // Agrego funcionalidad al botón restar cantidad
    var botonesRestarCantidad = document.getElementsByClassName('restar-cantidad');
    for (var i = 0; i < botonesRestarCantidad.length; i++) {
        var button = botonesRestarCantidad[i];
        button.addEventListener('click', restarCantidad);
    }

    // Agregamos funcionalidad al botón Agregar al carrito
    var botonesAgregarAlCarrito = document.getElementsByClassName('boton-item');
    for (var i = 0; i < botonesAgregarAlCarrito.length; i++) {
        var button = botonesAgregarAlCarrito[i];
        button.addEventListener('click', agregarAlCarritoClicked);
    }

    // Agregamos funcionalidad al botón comprar
    document.getElementsByClassName('btn-pagar')[0].addEventListener('click', pagarClicked)
}

// Eliminamos todos los elementos del carrito y lo ocultamos
function pagarClicked() {
    alert("Gracias por la compra");
    // Elimino todos los elementos del carrito
    var carritoItems = document.getElementsByClassName('carrito-items')[0];
    while (carritoItems.hasChildNodes()) {
        carritoItems.removeChild(carritoItems.firstChild)
    }
    actualizarTotalCarrito();
    ocultarCarrito();
}

// Función que controla el botón clickeado de agregar al carrito
function agregarAlCarritoClicked(event) {
    var button = event.target;
    var item = button.parentElement;
    var titulo = item.getElementsByClassName('titulo-item')[0].innerText;
    var precio = item.getElementsByClassName('precio-item')[0].innerText;
    var imagenSrc = item.getElementsByClassName('img-item')[0].src;
    console.log(imagenSrc);

    agregarItemAlCarrito(titulo, precio, imagenSrc);
    hacerVisibleCarrito();
}

// Función que hace visible el carrito
function hacerVisibleCarrito() {
    carritoVisible = true;
    var carrito = document.getElementsByClassName('carrito')[0];
    carrito.style.marginRight = '0';
    carrito.style.opacity = '1';

    var items = document.getElementsByClassName('contenedor-items')[0];
    items.style.width = '60%';
}

// Función que agrega un item al carrito
function agregarItemAlCarrito(titulo, precio, imagenSrc) {
    var item = document.createElement('div');
    item.classList.add = ('item');
    var itemsCarrito = document.getElementsByClassName('carrito-items')[0];

    // Controlamos que el item que intenta ingresar no se encuentre en el carrito
    var nombresItemsCarrito = itemsCarrito.getElementsByClassName('carrito-item-titulo');
    for (var i = 0; i < nombresItemsCarrito.length; i++) {
        if (nombresItemsCarrito[i].innerText == titulo) {
            alert("El item ya se encuentra en el carrito");
            return;
        }
    }

    var itemCarritoContenido = `
        <div class="carrito-item">
            <img src="${imagenSrc}" width="80px" alt="">
            <div class="carrito-item-detalles">
                <span class="carrito-item-titulo">${titulo}</span>
                <div class="selector-cantidad">
                    <i class="fa-solid fa-minus restar-cantidad"></i>
                    <input type="text" value="1" class="carrito-item-cantidad" disabled>
                    <i class="fa-solid fa-plus sumar-cantidad"></i>
                </div>
                <span class="carrito-item-precio">${precio}€</span>
            </div>
            <button class="btn-eliminar">
                <i class="fa-solid fa-trash"></i>
            </button>
        </div>
    `;
    item.innerHTML = itemCarritoContenido;
    itemsCarrito.append(item);

    // Agregamos la funcionalidad eliminar al nuevo item
    item.getElementsByClassName('btn-eliminar')[0].addEventListener('click', eliminarItemCarrito);

    // Agregamos la funcionalidad restar cantidad del nuevo item
    var botonRestarCantidad = item.getElementsByClassName('restar-cantidad')[0];
    botonRestarCantidad.addEventListener('click', restarCantidad);

    // Agregamos la funcionalidad sumar cantidad del nuevo item
    var botonSumarCantidad = item.getElementsByClassName('sumar-cantidad')[0];
    botonSumarCantidad.addEventListener('click', sumarCantidad);

    // Actualizamos total
    actualizarTotalCarrito();
}

// Aumento en uno la cantidad del elemento seleccionado
function sumarCantidad(event) {
    var buttonClicked = event.target;
    var selector = buttonClicked.parentElement;
    console.log(selector.getElementsByClassName('carrito-item-cantidad')[0].value);
    var cantidadActual = selector.getElementsByClassName('carrito-item-cantidad')[0].value;
    cantidadActual++;
    selector.getElementsByClassName('carrito-item-cantidad')[0].value = cantidadActual;
    actualizarTotalCarrito();
}

// Resto en uno la cantidad del elemento seleccionado
function restarCantidad(event) {
    var buttonClicked = event.target;
    var selector = buttonClicked.parentElement;
    console.log(selector.getElementsByClassName('carrito-item-cantidad')[0].value);
    var cantidadActual = selector.getElementsByClassName('carrito-item-cantidad')[0].value;
    cantidadActual--;
    if (cantidadActual >= 1) {
        selector.getElementsByClassName('carrito-item-cantidad')[0].value = cantidadActual;
        actualizarTotalCarrito();
    }
}

// Elimino el item seleccionado del carrito
function eliminarItemCarrito(event) {
    var buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    // Actualizamos el total del carrito
    actualizarTotalCarrito();

    // La siguiente función controla si hay elementos en el carrito
    // Si no hay elimino el carrito
    ocultarCarrito();
}

// Función que controla si hay elementos en el carrito. Si no hay oculto el carrito.
function ocultarCarrito() {
    var carritoItems = document.getElementsByClassName('carrito-items')[0];
    if (carritoItems.childElementCount == 0) {
        var carrito = document.getElementsByClassName('carrito')[0];
        carrito.style.marginRight = '-100%';
        carrito.style.opacity = '0';
        carritoVisible = false;

        var items = document.getElementsByClassName('contenedor-items')[0];
        items.style.width = '100%';
    }
}

// Actualizamos el total de Carrito
function actualizarTotalCarrito() {
    // Seleccionamos el contenedor carrito
    var carritoContenedor = document.getElementsByClassName('carrito')[0];
    var carritoItems = carritoContenedor.getElementsByClassName('carrito-item');
    var total = 0;
    // Recorremos cada elemento del carrito para actualizar el total
    for (var i = 0; i < carritoItems.length; i++) {
        var item = carritoItems[i];
        var precioElemento = item.getElementsByClassName('carrito-item-precio')[0];
        // Quitamos el símbolo euro y el punto de milesimos.
        var precio = parseFloat(precioElemento.innerText.replace('€', '').replace('.', '').replace(',', '.'));
        var cantidadItem = item.getElementsByClassName('carrito-item-cantidad')[0];
        var cantidad = cantidadItem.value;
        total = total + (precio * cantidad);
    }
    total = total / 100;

    // Formateamos el total con punto como separador de miles y dos decimales
    var formattedTotal = total.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    // Reemplazamos la coma por un punto si es necesario
    formattedTotal = formattedTotal.replace(/,/g, '.');

    document.getElementsByClassName('carrito-precio-total')[0].innerText = formattedTotal + '€';
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

window.addEventListener('beforeunload', function (e) {
  e.preventDefault();
  e.returnValue = '';
});

window.addEventListener('unload', function() {
  if (confirm('¿Estás seguro de que deseas recargar la página? Esto eliminará los datos actuales.')) {
      window.history.replaceState(null, null, window.location.pathname);
  }
});