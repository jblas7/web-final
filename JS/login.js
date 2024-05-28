// Modificar el evento de envío del formulario
document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Evitar que se envíe el formulario de manera tradicional
    loginUser(); // Llamar a la función para enviar la solicitud Fetch
});

// Función para enviar la solicitud Fetch al servidor
function loginUser() {
    const formData = new FormData(document.getElementById("loginForm")); // Obtener los datos del formulario
    const formDataUrlEncoded = new URLSearchParams(formData); // Convertir los datos a formato form-urlencoded

    fetch('http://localhost:8080/PecBurger/Controller?action=clientes.login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded' // Tipo de contenido form-urlencoded
        },
        body: formDataUrlEncoded // Enviar los datos form-urlencoded
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la solicitud');
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
        messageContainer.textContent = "Inicio de sesión exitoso"; // Mensaje de éxito
    })
    .catch(error => {
        console.error('Error en la solicitud:', error.message);
        messageContainer.textContent = "Error al iniciar sesión"; // Mensaje de error
    });
}












/* BOTON DESPLEGABLE RESPONSIVE */
document.addEventListener("DOMContentLoaded", function () {
    const dropdownButton = document.getElementById("dropdownButton");
    const dropdownMenu = document.getElementById("dropdownMenu");
    const closeBtn = document.getElementById("closeBtn");
  
    if (dropdownButton && dropdownMenu && closeBtn) { // Verificar si los elementos existen antes de agregar event listeners
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
    } else {
      console.error('Error: Alguno de los elementos no se encontró en el DOM');
    }
  });
  

  
  
  

  
  
  
  
  
  
  
  





  function showInput(element) {
    document.getElementById('pick').style.display = element.value == 'pick' ? 'block' : 'none';
    document.getElementById('home').style.display = element.value == 'home' ? 'block' : 'none';
}

function submitForm() {
    document.getElementById('myForm').submit();
}