document.getElementById('clienteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const formData = new FormData(this);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    fetch('http://localhost:8080/PECBURGER/?Controller?action=clientes.add', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        // Handle success, e.g., show a message or redirect
    })
    .catch(error => {
        console.error('Error:', error);
        // Handle error, e.g., show an error message
    });
});



  
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







