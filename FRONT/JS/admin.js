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
       
                    <span class="precio-item">${producto.precio}</span>
                   
                `;


                //<p class="ingredients">${producto.descripcion}</p>
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








function showMenu(menuType) {
    // Oculta todos los menús
    var menus = document.getElementsByClassName('menu');
    for (var i = 0; i < menus.length; i++) {
        menus[i].style.display = 'none';
    }

    // Muestra el menú específico según el tipo
    var menuId = menuType + 'Menu';
    var menu = document.getElementById(menuId);
    if (menu) {
        menu.style.display = 'block';
    }
}






/*FETCH UPDATE PRODUCTOS*/
// Obtener el modal
const modal = document.getElementById("productModal");
const btn = document.getElementById("updateProductButton");
const span = document.getElementsByClassName("close")[0];

// Cuando el usuario hace clic en el botón, abre el modal
btn.onclick = function(event) {
    event.preventDefault();
    modal.style.display = "block";
    loadProducts(); // Cargar productos cuando se abre el modal
}

// Cuando el usuario hace clic en <span> (x), cierra el modal
span.onclick = function() {
    modal.style.display = "none";
}

// Cuando el usuario hace clic en cualquier lugar fuera del modal, lo cierra
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// Función para cargar todos los productos
async function loadProducts() {
    const baseURL = 'http://localhost:8080/PecBurger';
    const url = `${baseURL}/Controller?action=productos.findAll`;
    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error(`Error en la petición: ${response.status}`);
        }

        const products = await response.json();
        populateProductSelect(products);
    } catch (error) {
        console.error('Error al cargar productos:', error);
    }
}

// Función para poblar el select con productos
function populateProductSelect(products) {
    const productSelect = document.getElementById("productSelect");
    productSelect.innerHTML = ''; // Limpiar el select

    products.forEach(product => {
        const option = document.createElement("option");
        option.value = product.id;
        option.text = product.nombre;
        productSelect.appendChild(option);
    });

    // Cargar datos del primer producto al inicio
    if (products.length > 0) {
        loadProductData(products[0]);
    }

    // Agregar evento para cambiar datos al seleccionar otro producto
    productSelect.onchange = function() {
        const selectedProduct = products.find(p => p.id == this.value);
        loadProductData(selectedProduct);
    }
}

// Función para cargar datos del producto seleccionado en el formulario
function loadProductData(product) {
    document.getElementById("productName").value = product.nombre;
    document.getElementById("productPrice").value = product.precio;
    document.getElementById("productImage").value = product.imagen;
    document.getElementById("productDescription").value = product.descripcion;
}

// Función para construir la URL de actualización de productos con parámetros en la URL
function buildProductUpdateURL(baseURL, action, id, nombre, precio, imagen, descripcion) {
    return `${baseURL}/Controller?action=${action}&id=${id}&nombre=${nombre}&precio=${precio}&imagen=${imagen}&descripcion=${descripcion}`;
}

// Función para realizar la petición de actualización de productos
async function updateProduct(baseURL, action, id, nombre, precio, imagen, descripcion) {
    const url = buildProductUpdateURL(baseURL, action, id, nombre, precio, imagen, descripcion);
    try {
        const response = await fetch(url, {
            method: 'POST', // O 'GET', según lo que requiera tu servidor
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' // Puede ser opcional dependiendo de la configuración del servidor
            }
        });

        if (!response.ok) {
            throw new Error(`Error en la petición: ${response.status}`);
        }

        const data = await response.json(); // Asumiendo que la respuesta es JSON
        return data;
    } catch (error) {
        console.error('Error al actualizar el producto:', error);
    }
}

// Manejar el envío del formulario
document.getElementById("productForm").onsubmit = function(event) {
    event.preventDefault();

    const id = document.getElementById("productSelect").value;
    const nombre = document.getElementById("productName").value;
    const precio = document.getElementById("productPrice").value;
    const imagen = document.getElementById("productImage").value;
    const descripcion = document.getElementById("productDescription").value;

    const baseURL = 'http://localhost:8080/PecBurger';
    const action = 'productos.update';

    updateProduct(baseURL, action, id, nombre, precio, imagen, descripcion)
        .then(data => {
            console.log('Producto actualizado:', data);
            modal.style.display = "none"; // Cerrar el modal al completar la actualización
        })
        .catch(error => console.error('Error:', error));
}





  
/* BOTON DESPLEGABLE RESPONSIVE */
document.addEventListener("DOMContentLoaded", function () {
    const dropdownButton = document.getElementById("dropdownButton");
    const dropdownMenu = document.getElementById("dropdownMenu");
  
    if (dropdownButton && dropdownMenu) {
        dropdownButton.addEventListener("click", function () {
            if (dropdownMenu.style.display === "none" || dropdownMenu.style.display === "") {
                dropdownMenu.style.display = "block";
            } else {
                dropdownMenu.style.display = "none";
            }
        });
    } else {
        console.error('Error: Alguno de los elementos no se encontró en el DOM');
    }
  });
  
  
  
  
  
  

  
  