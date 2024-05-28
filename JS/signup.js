const registroForm = document.getElementById('clienteForm');
const submitButtonRegistro = registroForm.querySelector('.crear-cuenta-boton');

const handleSubmit = async (event) => {
    event.preventDefault(); 
    submitButtonRegistro.disabled = true; 

    try {
        const formDataRegistro = new FormData(registroForm);
        const response = await fetch('http://localhost:8080/PecBurger/Controller?action=clientes.add', {
            method: 'POST',
            body: formDataRegistro,
            mode: 'cors'
        });

        if (!response.ok) {
            throw new Error('Error en la solicitud al servidor');
        }

        const data = await response.json();
        if (data.error) {
            throw new Error(data.error);
        }

        console.log('Success:', data);
        registroForm.reset();
    } catch (error) {
        console.error('Error:', error.message);
    } finally {
        submitButtonRegistro.disabled = false;
    }
};

registroForm.addEventListener('submit', handleSubmit);








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
  