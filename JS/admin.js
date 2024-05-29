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
  
  
  
  
  
  

  
  
  
  
  
  

  

