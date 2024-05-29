/*FETCH CARRITO*/

// Variable para verificar si el código ya se ejecutó
let codigoEjecutado = false;

window.addEventListener('DOMContentLoaded', () => {
    // Verificar si el código ya se ejecutó
    if (!codigoEjecutado) {
        codigoEjecutado = true; 

        const fetchProductos = async () => {
            try {
                const response = await fetch('http://localhost:8080/PecBurger/Controller?action=productos.find_all');
                if (!response.ok) {
                    throw new Error(`Error HTTP! estado: ${response.status}`);
                }
                const productos = await response.json();
                productos.forEach(producto => createProductoItem(producto));
                ready()
            } catch (error) {
                console.error('Error al obtener productos:', error);
            }
        }

        const createProductoItem = (producto) => {
            const containerId = getContainerId(producto.idCategoria);
            const container = document.getElementById(containerId);
            if (container) {
                const item = document.createElement('div');
                item.classList.add('item');

                item.innerHTML = `
                    <span class="titulo-item">${producto.nombre}</span>
                    <img src="${producto.rutaImagen}" alt="" class="img-item">
                    <span class="precio-item">${producto.precio}</span>
                    <button class="boton-item">ADD TO CART</button>
                `;

                container.appendChild(item);
            }
        }

        const getContainerId = (idCategoria) => {
            switch (idCategoria) {
                case 1:
                    return 'tx-en';
                case 2:
                    return 'tx-smash';
                case 3:
                    return 'tx-medall';
                case 4:
                    return 'tx-sand';
                case 5:
                    return 'tx-sals';
                case 6:
                    return 'tx-postr'; 
                case 7:
                    return 'tx-beb'; 
                default:
                    return '';
            }
        }

        fetchProductos()
    
    }
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

  









/*FETCH PEDIDOOOOOOOOOO*/
  document.addEventListener("DOMContentLoaded", function() {
    // Aquí va el código que se ejecutará cuando el DOM esté completamente cargado
    
    // Función para guardar el formulario de pedido
    async function guardarFormulario(event) {
        event.preventDefault(); // Previene el comportamiento por defecto del formulario

        // Recolectar datos del formulario de pedido
        var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked').value;
        var modoEntrega = document.getElementById('modoEntrega').value;
        var horaEntrega = document.getElementById('horaEntrega').value;
        var shop = document.getElementById('Shop').value;
        var modoRecoger = document.getElementById('modoRecoger').value;
        var horaRecoger = document.getElementById('horaRecoger').value;

        // Validar campos obligatorios para pedido
        if (!tipoPedido) {
            alert("Please select Order Type");
            return;
        }
        if (!modoEntrega && tipoPedido === "entregaDomicilio") {
            alert("Please select Delivery Mode");
            return;
        }
        if (!horaEntrega && modoEntrega === "Schedule Shipment") {
            alert("Please select Delivery Time");
            return;
        }
        if (!shop && tipoPedido === "recogerLocal") {
            alert("Please select Pickup Shop");
            return;
        }
        if (!modoRecoger && tipoPedido === "recogerLocal") {
            alert("Please select Pickup Mode");
            return;
        }
        if (!horaRecoger && modoRecoger === "Schedule Pickup") {
            alert("Please select Pick-up Time");
            return;
        }

        // Construir la URL de la solicitud para guardar pedido
        let pedidoUrl = `http://localhost:8080/PecBurger/Controller?action=pedidos.add&tipo_pedido=${tipoPedido}&modo_entrega=${(modoEntrega)}&hora_entrega=${(horaEntrega)}&shop=${(shop)}&modo_recoger=${(modoRecoger)}&hora_recoger=${(horaRecoger)}`;

        try {
            // Realizar la solicitud fetch para guardar pedido
            const pedidoResponse = await fetch(pedidoUrl, {
                method: 'GET'
            });
            const pedidoData = await pedidoResponse.text();
            console.log(pedidoData);
            if (pedidoData.includes("Pedido guardado exitosamente")) {
                alert("Pedido guardado exitosamente");
            } else {
                alert("Error al guardar el pedido");
            }
        } catch (error) {
            console.error('Fetch error:', error);
            alert("Error al guardar el pedido");
        }
    }

    // Asignar la función guardarFormulario al evento submit del formulario
    document.getElementById('formularioPedido').addEventListener('submit', guardarFormulario);
});





























  
/*CARRITO TOCHOOO*/
//Variable que mantiene el estado visible del carrito
var carritoVisible = false;

//Espermos que todos los elementos de la pàgina cargen para ejecutar el script
if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready();
}

function ready() {

    //Agregremos funcionalidad a los botones eliminar del carrito
    var botonesEliminarItem = document.getElementsByClassName('btn-eliminar');
    for (var i = 0; i < botonesEliminarItem.length; i++) {
        var button = botonesEliminarItem[i];
        button.addEventListener('click', eliminarItemCarrito);
    }

    //Agrego funcionalidad al boton sumar cantidad
    var botonesSumarCantidad = document.getElementsByClassName('sumar-cantidad');
    for (var i = 0; i < botonesSumarCantidad.length; i++) {
        var button = botonesSumarCantidad[i];
        button.addEventListener('click', sumarCantidad);
    }

    //Agrego funcionalidad al buton restar cantidad
    var botonesRestarCantidad = document.getElementsByClassName('restar-cantidad');
    for (var i = 0; i < botonesRestarCantidad.length; i++) {
        var button = botonesRestarCantidad[i];
        button.addEventListener('click', restarCantidad);
    }

    //Agregamos funcionalidad al boton Agregar al carrito
    var botonesAgregarAlCarrito = document.getElementsByClassName('boton-item');
    for (var i = 0; i < botonesAgregarAlCarrito.length; i++) {
        var button = botonesAgregarAlCarrito[i];
        button.addEventListener('click', agregarAlCarritoClicked);
    }

    //Agregamos funcionalidad al botón comprar
    document.getElementsByClassName('btn-pagar')[0].addEventListener('click', pagarClicked)
}
//Eliminamos todos los elementos del carrito y lo ocultamos
function pagarClicked() {
    alert("Thank you for the purchase, enjoy.");
    //Elimino todos los elmentos del carrito
    var carritoItems = document.getElementsByClassName('carrito-items')[0];
    while (carritoItems.hasChildNodes()) {
        carritoItems.removeChild(carritoItems.firstChild)
    }
    actualizarTotalCarrito();
    ocultarCarrito();
}
//Funciòn que controla el boton clickeado de agregar al carrito
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

//Funcion que hace visible el carrito
function hacerVisibleCarrito() {
    carritoVisible = true;
    var carrito = document.getElementsByClassName('carrito')[0];
    carrito.style.marginRight = '0';
    carrito.style.opacity = '1';

    var items = document.getElementsByClassName('contenedor-items')[0];
    items.style.width = '60%';
}

//Funciòn que agrega un item al carrito
function agregarItemAlCarrito(titulo, precio, imagenSrc) {
    var item = document.createElement('div');
    item.classList.add = ('item');
    var itemsCarrito = document.getElementsByClassName('carrito-items')[0];

    //controlamos que el item que intenta ingresar no se encuentre en el carrito
    var nombresItemsCarrito = itemsCarrito.getElementsByClassName('carrito-item-titulo');
    for (var i = 0; i < nombresItemsCarrito.length; i++) {
        if (nombresItemsCarrito[i].innerText == titulo) {
            alert("The item is already in the cart");
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
    `
    item.innerHTML = itemCarritoContenido;
    itemsCarrito.append(item);

    //Agregamos la funcionalidad eliminar al nuevo item
    item.getElementsByClassName('btn-eliminar')[0].addEventListener('click', eliminarItemCarrito);

    //Agregmos al funcionalidad restar cantidad del nuevo item
    var botonRestarCantidad = item.getElementsByClassName('restar-cantidad')[0];
    botonRestarCantidad.addEventListener('click', restarCantidad);

    //Agregamos la funcionalidad sumar cantidad del nuevo item
    var botonSumarCantidad = item.getElementsByClassName('sumar-cantidad')[0];
    botonSumarCantidad.addEventListener('click', sumarCantidad);

    //Actualizamos total
    actualizarTotalCarrito();
}
//Aumento en uno la cantidad del elemento seleccionado
function sumarCantidad(event) {
    var buttonClicked = event.target;
    var selector = buttonClicked.parentElement;
    console.log(selector.getElementsByClassName('carrito-item-cantidad')[0].value);
    var cantidadActual = selector.getElementsByClassName('carrito-item-cantidad')[0].value;
    cantidadActual++;
    selector.getElementsByClassName('carrito-item-cantidad')[0].value = cantidadActual;
    actualizarTotalCarrito();
}
//Resto en uno la cantidad del elemento seleccionado
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

//Elimino el item seleccionado del carrito
function eliminarItemCarrito(event) {
    var buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    //Actualizamos el total del carrito
    actualizarTotalCarrito();

    //la siguiente funciòn controla si hay elementos en el carrito
    //Si no hay elimino el carrito
    ocultarCarrito();
}
//Funciòn que controla si hay elementos en el carrito. Si no hay oculto el carrito.
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
function actualizarTotalCarrito() {
    // Seleccionamos el contenedor del carrito
    var carritoContenedor = document.getElementsByClassName('carrito')[0];
    var carritoItems = carritoContenedor.getElementsByClassName('carrito-item');
    var total = 0;

    // Recorremos cada elemento del carrito para calcular el total
    for (var i = 0; i < carritoItems.length; i++) {
        var item = carritoItems[i];
        var precioElemento = item.getElementsByClassName('carrito-item-precio')[0];

        // Extraemos el precio del elemento y lo convertimos a un número con decimales
        var precio = parseFloat(precioElemento.innerText.replace('€', '').replace(',', '.'));

        var cantidadItem = item.getElementsByClassName('carrito-item-cantidad')[0];
        var cantidad = cantidadItem.value;
        total += precio * cantidad;
    }

    // Formateamos el total manualmente con dos decimales y símbolo de euro
    var formattedTotal = total.toFixed(2) + '€';

    // Mostramos el total en el elemento correspondiente
    document.getElementsByClassName('carrito-precio-total')[0].innerText = formattedTotal;
}


















































function realizarPedido() {
    // Mostrar el mensaje
    alert("Your order has been placed, enjoy!");
    // Recargar la página
    window.location.reload();
  }



document.addEventListener('DOMContentLoaded', function() {
    const formularioDatos = JSON.parse(localStorage.getItem('formularioDatos'));
    if (formularioDatos) {
        const { tipoPedido, calle, portal, piso, letra, telefonoEntrega, modoEntrega, horaEntrega, nombre, telefono, Shop, modoRecoger, horaRecoger } = formularioDatos;
        let infoHTML = ``;

        if (tipoPedido === 'entregaDomicilio') {
            infoHTML += `
                <h3>Home Delivery</h3>
                <p>Address: ${calle}, ${portal}, ${piso} ${letra}</p>
                <p>Phone: ${telefonoEntrega}</p>
                <p>Mode of Delivery: ${modoEntrega}</p>
                ${modoEntrega === 'Schedule Shipment' ? `<p>Delivery Time: ${horaEntrega}</p>` : ''}
            `;
        } else if (tipoPedido === 'recogerLocal') {
            infoHTML += `
                <h3>Local Pick Up</h3>
                <p>Name: ${nombre}</p>
                <p>Phone: ${telefono}</p>
                <p>Shop: ${Shop}</p>
                <p>Pickup Mode: ${modoRecoger}</p>
                ${modoRecoger === 'Schedule Pickup' ? `<p>Pick-up time: ${horaRecoger}</p>` : ''}
            `;
        }

        document.getElementById('infoSection').innerHTML = infoHTML;
    } else {
        document.getElementById('infoSection').innerHTML = '<p>No information is stored.</p>';
    }
});

 // Obtener referencia a la sección de información guardada
 var infoSection = document.getElementById('infoSection');

 // Mostrar la sección de información guardada cuando el carrito esté visible
 function mostrarInfoSection() {
     var carrito = document.getElementById('carrito');
     if (carrito.style.display !== 'none') {
         infoSection.style.display = 'block';
     }
 }

 // Ocultar la sección de información guardada cuando el carrito esté oculto
 function ocultarInfoSection() {
     infoSection.style.display = 'none';
 }

 // Evento que se activa cuando se muestra el carrito
 document.getElementById('dropdownButton').addEventListener('click', function () {
     // Llamar a la función para mostrar u ocultar la sección de información guardada
     if (infoSection.style.display !== 'none') {
         ocultarInfoSection();
     } else {
         mostrarInfoSection();
     }
 });




 /*VENTANA EMERGENTE CONFIRMAR PEDIDO*/

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
  
/*
  document.getElementById("openPopup").addEventListener("click", function() {
    document.getElementById("popup").classList.add("active");
    document.body.classList.add("popup-background");
  });
  
  document.getElementById("closePopup").addEventListener("click", function() {
    document.getElementById("popup").classList.remove("active");
    document.body.classList.remove("popup-background");
  });
  */

  






























  function mostrarOpciones() {
    var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked');
    if (!tipoPedido) return;

    var opcionesEntrega = document.getElementById('opcionesEntrega');
    var opcionesRecoger = document.getElementById('opcionesRecoger');

    if (tipoPedido.value === "entregaDomicilio") {
        opcionesEntrega.style.display = 'block';
        opcionesRecoger.style.display = 'none';
    } else if (tipoPedido.value === "recogerLocal") {
        opcionesEntrega.style.display = 'none';
        opcionesRecoger.style.display = 'block';
    }
}

function mostrarHoraEntrega() {
    var modoEntrega = document.getElementById('modoEntrega').value;
    var horaEntregaDiv = document.getElementById('horaEntregaDiv');

    horaEntregaDiv.style.display = (modoEntrega === "Schedule Shipment") ? 'block' : 'none';
}

function mostrarHoraRecoger() {
    var modoRecoger = document.getElementById('modoRecoger').value;
    var horaRecogerDiv = document.getElementById('horaRecogerDiv');

    horaRecogerDiv.style.display = (modoRecoger === "Schedule Pickup") ? 'block' : 'none';
}

function guardarFormulario(event) {
    event.preventDefault();
    if (validarFormulario()) {
        document.getElementById("formularioPedido").style.display = "none";
    }
}

function validarFormulario() {
    var tipoPedido = document.querySelector('input[name="tipoPedido"]:checked');
    if (!tipoPedido) {
        return false;
    }

    var calle = document.getElementById("calle").value.trim();
    var portal = document.getElementById("portal").value.trim();
    var piso = document.getElementById("piso").value.trim();
    var letra = document.getElementById("letra").value.trim();
    var modoEntrega = document.getElementById("modoEntrega").value;
    var horaEntrega = document.getElementById("horaEntrega").value.trim();
    var nombreRecoger = document.getElementById("nombreRecoger").value.trim();
    var telefono = document.getElementById("telefono").value.trim();
    var horaRecoger = document.getElementById("horaRecoger").value.trim();

    if (tipoPedido.value === "entregaDomicilio") {
        if (calle === "" || portal === "" || piso === "" || letra === "") {
            return false;
        }

        if (modoEntrega === "") {
            return false;
        }

        if (modoEntrega === "Schedule Shipment" && horaEntrega === "") {
            document.getElementById("horaEntrega").focus();
            return false;
        }
    } else if (tipoPedido.value === "recogerLocal") {
        if (nombreRecoger === "" || telefono === "") {
            return false;
        }

        if (modoRecoger === "") {
            return false;
        }

        if (modoRecoger === "Schedule Pickup" && horaRecoger === "") {
            document.getElementById("horaRecoger").focus();
            return false;
        }
    }

    return true;
}

window.onload = function() {
    var formularioPedido = document.getElementById("formularioPedido");
    if (formularioPedido) {
        mostrarOpciones();
        formularioPedido.addEventListener("submit", function(event) {
            event.preventDefault(); // Prevenir el envío automático del formulario
            guardarFormulario(event);
        });
    }
};















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




  /**
   * let obj {
   *    user:
   *    pedi
   * }
   * fetch (url, {
   *    headers:{}
   *    body: stringify(object)
   * }) 
   * 
   */