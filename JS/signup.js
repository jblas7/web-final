function registerClient() {
    const clientData = {
        nombre: document.getElementById('nombre').value,
        apellido: document.getElementById('apellido').value,
        telefono: document.getElementById('telefono').value,
        email: document.getElementById('email').value,
        contrasena: document.getElementById('contrasena').value
    };

    fetch('http://localhost:8080/Controller?action=add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(clientData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.message) {
            alert(data.message);
        } else if (data.error) {
            alert(data.error);
        }
    })
    .catch(error => console.error('Error:', error));
}































  
function scrollToSection(sectionId) {
    const section = document.getElementById(sectionId);
    if (section) {
        section.scrollIntoView({ behavior: 'smooth' });
    }
  }
  









  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  
  
  
  
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







