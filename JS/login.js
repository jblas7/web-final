document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.getElementById("loginForm");
  const messageContainer = document.getElementById("messageContainer");

  loginForm.addEventListener("submit", function (event) {
      event.preventDefault();
      loginUser();
  });

  function loginUser() {
      const formData = new FormData(loginForm);
      const email = formData.get('email'); // Obtener el valor del campo de email
      const contrasena = formData.get('contrasena'); // Obtener el valor del campo de contraseña

      // Construir la URL con los parámetros
      const baseURL = 'http://localhost:8080/PecBurger/Controller?action=clientes.login';
      const parametros = `?email=${encodeURIComponent(email)}&contrasena=${encodeURIComponent(contrasena)}`;
      const urlCompleta = baseURL + parametros;

      fetch(urlCompleta, {
          method: 'POST',
          headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
          }
      })
      .then(response => {
          if (!response.ok) {
              throw new Error('Error en la solicitud');
          }
          return response.json();
      })
      .then(data => {
          if (data.error) {
              messageContainer.textContent = "Error al iniciar sesión: " + data.error;
              messageContainer.style.color = "red";
          } else {
              messageContainer.textContent = "Inicio de sesión exitoso";
              messageContainer.style.color = "green";
          }
      })
      .catch(error => {
          console.error('Error en la solicitud:', error.message);
          messageContainer.textContent = "Error al iniciar sesión";
          messageContainer.style.color = "red";
      });
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
