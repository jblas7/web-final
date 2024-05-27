document.addEventListener("DOMContentLoaded", function() {
  const username = "nombre_del_usuario";
  const email = "correo_electronico";
  const password = "contrasena";
  const phoneNumber = "numero_de_telefono";

  const url = `http://localhost:8080/PecBurger/?Controller?action=CLIENTE.ADD&nombre=${username}&email=${email}&contrasena=${password}&telefono=${phoneNumber}`;

  const requestOptions = {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      }
  };

  // Realizar la solicitud fetch después de que el DOM esté completamente cargado
  fetch(url, requestOptions)
      .then(response => {
          if (!response.ok) {
              throw new Error('Hubo un problema con la solicitud.');
          }
          return response.json();
      })
      .then(data => {
          console.log('Respuesta del servidor:', data);
          // Aquí puedes manejar la respuesta del servidor según tus necesidades
      })
      .catch(error => {
          console.error('Error en la solicitud:', error);
          // Aquí puedes manejar el error si la solicitud falla
      });
});


  
function scrollToSection(sectionId) {
    const section = document.getElementById(sectionId);
    if (section) {
        section.scrollIntoView({ behavior: 'smooth' });
    }
  }
  









  
  
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
  
  
  
  
  
  
  
  
  
  

  
  
  
  
  document.addEventListener('DOMContentLoaded', function() {
    var form = document.querySelector('form');
    form.addEventListener('submit', function(event) {
        if (!validarFormulario()) {
            event.preventDefault();
        }
    });

    function validarFormulario() {
        var email = document.getElementById('email').value;
        var telefono = document.getElementById('telefono').value;
        var contrasena = document.getElementById('contrasena').value;
        var repetirContrasena = document.getElementById('repetirContrasena').value;

        // Variable para verificar si el formulario es válido
        var formValido = true;

        // Validar el email
        if (!email.includes('@')) {
            alert('Please enter a valid email address.');
            formValido = false;
        }

        // Validar el teléfono
        if (telefono.length !== 9 || isNaN(parseInt(telefono))) {
            alert('The telephone number must be exactly 9 digits long and contain only numbers.');
            formValido = false;
        }

        // Validar la contraseña
        if (contrasena !== repetirContrasena) {
            alert('Passwords do not match.');
            formValido = false;
        } else if (contrasena.length < 9) {
            alert('The password must be at least 9 characters long.');
            formValido = false;
        }

        // Si el formulario es válido, permite enviarlo
        return formValido;
    }
});







