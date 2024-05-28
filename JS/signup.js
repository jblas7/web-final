document.getElementById('clienteForm').addEventListener('submit', async function(event) {
    event.preventDefault(); // Previene el comportamiento por defecto del formulario

    var nombre = document.getElementById('nombre').value;
    var apellido = document.getElementById('apellido1').value;
    var email = document.getElementById('email').value;
    var telefono = document.getElementById('telefono').value;
    var contrasena = document.getElementById('contrasena').value;
    var repetirContrasena = document.getElementById('repetirContrasena').value;
    var messageContainer = document.getElementById('messageContainer');

    if (!nombre || !apellido || !email || !telefono || !contrasena || !repetirContrasena) {
        messageContainer.innerHTML = "<p class='error-message'>Please complete all fields.</p>";
        return;
    }

    if (contrasena !== repetirContrasena) {
        messageContainer.innerHTML = "<p class='error-message'>Passwords do not match. Please try again.</p>";
        return;
    }

    // Construcción de la URL
    const url = `http://localhost:8080/PecBurger/Controller?action=clientes.add&nombre=${nombre}&apellido=${apellido}&telefono=${telefono}&email=${email}&contrasena=${contrasena}`;
    
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
  
  
  
  