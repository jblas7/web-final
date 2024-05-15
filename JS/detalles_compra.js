// Variable que mantiene el estado visible del carrito
var carritoVisible = true; // Cambiar a true para mantener el carrito siempre visible

// Esperamos que todos los elementos de la página carguen para ejecutar el script
document.addEventListener('DOMContentLoaded', ready);

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
    document.getElementsByClassName('btn-pagar')[0].addEventListener('click', pagarClicked);

    // Hacemos visible el carrito al cargar la página
    if (carritoVisible) {
        hacerVisibleCarrito();
    }
}

// Función que hace visible el carrito
function hacerVisibleCarrito() {
    var carrito = document.getElementsByClassName('carrito')[0];
    carrito.style.marginRight = '0';
    carrito.style.opacity = '1';

    var items = document.getElementsByClassName('contenedor-items')[0];
    items.style.width = '60%';
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
}













































/*MOSTRAR INFORMACION DEL FORMULARIO DE TIPO DE PEDIDO*/

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







/*IR AL CATALOGO (BOTON)*/
function irAlCatalogo() {
    // Aquí puedes redirigir al usuario al catálogo
    window.location.href = "../HTML/CARRITO.html";
}
