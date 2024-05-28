document.getElementById('loginForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Previene el comportamiento por defecto del formulario
  
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('contrasena');
    const messageContainer = document.getElementById('messageContainer');
  
    const email = emailInput.value;
    const password = passwordInput.value;
  
    if (email && password) {
        try {
            const response = await fetch('http://localhost:8080/PecBurger/Controller?action=clientes.login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'email=' + encodeURIComponent(email) + '&contrasena=' + encodeURIComponent(password)
            });
  
            if (!response.ok) {
                throw new Error('Error en la solicitud.');
            }
  
            const data = await response.json();
  
            if (data.message) {
                messageContainer.innerHTML = "<p>" + data.message + "</p>";
                // Redirigir al usuario a carrito.html después de 2 segundos
                setTimeout(function() {
                    window.location.href = '../HTML/carrito.html';
                }, 2000);
            } else if (data.error) {
                messageContainer.innerHTML = "<p>" + data.error + "</p>";
            } else {
                messageContainer.innerHTML = "<p>An error occurred. Please try again.</p>";
            }
        } catch (error) {
            messageContainer.innerHTML = "<p>An error occurred. Please try again.</p>"; // Manejo del error
        }
    } else {
        messageContainer.innerHTML = "<p>Please, complete all fields.</p>";
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




















function submitForm() {
  document.getElementById('myForm').submit();
}

function showInput(element) {
    document.getElementById('pick').style.display = element.value == 'pick' ? 'block' : 'none';
    document.getElementById('home').style.display = element.value == 'home' ? 'block' : 'none';
}

function submitForm() {
    document.getElementById('myForm').submit();
}
