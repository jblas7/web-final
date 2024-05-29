document.getElementById('clienteForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Previene el comportamiento por defecto del formulario

    var nombre = document.getElementById('nombre').value;
    var apellido = document.getElementById('apellido1').value;
    var email = document.getElementById('email').value;
    var telefono = document.getElementById('telefono').value;
    var contrasena = document.getElementById('contrasena').value;
    var repetirContrasena = document.getElementById('repetirContrasena').value;
    var calle = document.getElementById('direccion').value; // Nuevo campo para la calle
    var portal = document.getElementById('portal').value; // Nuevo campo para el portal
    var piso = document.getElementById('piso').value; // Nuevo campo para el piso
    var letra = document.getElementById('letra').value; // Nuevo campo para la letra
    var messageContainer = document.getElementById('messageContainer');

    if (!nombre || !apellido || !email || !telefono || !contrasena || !repetirContrasena || !calle || !portal || !piso || !letra) {
        alert('Please complete all fields.');
        return;
    }

    if (contrasena !== repetirContrasena) {
        alert('Passwords do not match. Please try again.');
        return;
    }

    // Construcción de la URL con los nuevos campos
    const url = `http://localhost:8080/PecBurger/Controller?action=clientes.add&nombre=${nombre}&apellido=${apellido}&telefono=${telefono}&email=${email}&contrasena=${contrasena}&calle=${calle}&portal=${portal}&piso=${piso}&letra=${letra}`;
    
    // Modificamos la solicitud para que sea una solicitud GET en lugar de una solicitud POST
    fetch(url)
        .then(response => response.text())
        .then(data => {
            let message = JSON.parse(data).message;
            messageContainer.innerHTML = `<p class='success-message'>${message}</p>`;
            if (message === 'Customer successfully registered') {
                setTimeout(function() {
                    window.location.href = '../HTML/login.html';
                }, 2000);
            }
        })
        .catch(error => {
            console.error('Fetch error:', error);
            messageContainer.innerHTML = "<p class='error-message'>An error occurred. Please try again.</p>";
        });
});

  



















document.getElementById("clienteForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Evitar que el formulario se envíe
    
    const formData = new FormData(this);
    const clienteData = {};
    
    // Recorre los datos del formulario y guárdalos en un objeto
    formData.forEach(function(value, key) {
        clienteData[key] = value;
    });
    
    // Genera una clave única para cada conjunto de datos
    const key = "cliente_" + Date.now(); 
    
    // Guarda los datos en el localStorage
    localStorage.setItem(key, JSON.stringify(clienteData));
    
    // Guarda la clave del último usuario registrado en localStorage
    localStorage.setItem("lastUserKey", key);
    
    // Mostrar los datos del último cliente en la página
    const userDataElement = document.createElement("div");
    userDataElement.classList.add("user-data");
    userDataElement.innerHTML = `
        <p><strong>Nombre:</strong> ${clienteData.nombre}</p>
        <p><strong>Apellido:</strong> ${clienteData.apellido1}</p>
        <p><strong>Email:</strong> ${clienteData.email}</p>
        <p><strong>Teléfono:</strong> ${clienteData.telefono}</p>
        <p><strong>Dirección:</strong> ${clienteData.direccion}</p>
        <p><strong>Portal:</strong> ${clienteData.portal}</p>
        <p><strong>Piso:</strong> ${clienteData.piso}</p>
        <p><strong>Letra del Apartamento:</strong> ${clienteData.letra}</p>
    `;
    
    const dataContainer = document.getElementById("dataContainer");
    dataContainer.innerHTML = ""; // Limpiar el contenedor antes de agregar el nuevo usuario
    dataContainer.appendChild(userDataElement);
    
    // Limpiar el formulario después de enviar
    this.reset();
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
  
  
  
  





  /*SCROLL PARA ARRIBA BOTON*/
  
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

  