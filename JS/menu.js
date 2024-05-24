window.addEventListener('DOMContentLoaded', () => {
    const fetchProductos = async () => {
        try {
            const response = await fetch('http://localhost:8080/PecBurger/Controller?action=productos.find_all');
            if (!response.ok) {
                throw new Error(`Error HTTP! estado: ${response.status}`);
            }
            const productos = await response.json();
            productos.forEach(producto => createProductoItem(producto));
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
            item.onclick = function () { toggleInfo(this); };

            item.innerHTML = `
                <img src="${producto.rutaImagen}" alt="${producto.nombre}">
                <div class="details hidden">
                    <h3>${producto.nombre}</h3>
                    <p class="price">${producto.precio}€</p>
                    <p class="ingredients">${producto.descripcion}</p>
                    <a class="custom-boton3" href="../HTML/ask_pec_from_pec.html">MAKE AN ORDER</a>
                </div>`;

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
                return 'tx-postr';
            default:
                return '';
        }
    }

    fetchProductos();
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
// Textos para los elementos existentes y el nuevo elemento
const texts = [
    ['STARTERS', 'TO OPEN STOMACH', 'FAST AND FORCEFUL', 'STAR STARTERS '],
    ['SMASH BURGER', 'THE CRUSHED', 'FINE BURGER', 'DOESN\'T FAIL'],
    ['MEDALLION BURGER', 'BIG BURGER', 'THE TASTY', 'JUICE AND PLEASURE'],
    ['SANDWICHES', 'MEAT AND BREAD', 'TOASTED AND CRISPY', 'SANDWICHEESE'],
    ['DESSERTS', 'EVERYONE\'S CRAVING', 'CHEESPECS', 'SENSATIONAL'],
    ['ENJOY', 'DIRTY','SNAP','RETURN','FEEL'] // Nuevo elemento añadido
];

// Función para escribir el texto de manera animada
const typeWriter = (element, textArray) => {
    let i = 0;
    let isDeleting = false;
    let txt = '';

    const typeSpeed = () => {
        const fullTxt = textArray[i];
        if (isDeleting) {
            txt = fullTxt.substring(0, txt.length - 1);
        } else {
            txt = fullTxt.substring(0, txt.length + 1);
        }

        element.textContent = txt;

        let speed = 50;
        if (isDeleting) {
            speed /= 2;
        }

        if (!isDeleting && txt === fullTxt) {
            speed = 2000; // Tiempo que el texto se mantiene quieto
            isDeleting = true;
        } else if (isDeleting && txt === '') {
            isDeleting = false;
            i = (i + 1) % textArray.length;
            speed = 200; // Tiempo que tarda en borrarse
        }

        setTimeout(typeSpeed, speed);
    };

    typeSpeed();
};

// Buscar y controlar cada elemento de texto
texts.forEach((textArray, index) => {
    const element = document.getElementById(`tx-en${index + 1}`);
    
    if (element) {
        // Controlar el nuevo elemento solo si el índice es 5
        if (index === 5) {
            typeWriter(element, textArray);
        } else {
            // Para los otros elementos, puedes usar el código que tenías antes
            let i = 0;
            let isDeleting = false;
            let txt = '';

            const typeWriter = () => {
                const fullTxt = textArray[i];
                if (isDeleting) {
                    txt = fullTxt.substring(0, txt.length - 1);
                } else {
                    txt = fullTxt.substring(0, txt.length + 1);
                }

                element.textContent = txt;

                let typeSpeed = 150;
                if (isDeleting) {
                    typeSpeed /= 2;
                }

                if (!isDeleting && txt === fullTxt) {
                    typeSpeed = 3000; // Tiempo que el texto se mantiene quieto
                    isDeleting = true;
                } else if (isDeleting && txt === '') {
                    isDeleting = false;
                    i = (i + 1) % textArray.length;
                    typeSpeed = 200; // Tiempo que tarda en borrarse
                }

                setTimeout(typeWriter, typeSpeed);
            };

            typeWriter();
        }
    }
});
