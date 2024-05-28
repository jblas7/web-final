
  
  
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
  
  
  
  
  
  

  
  
  
  
  
  

  



const authorizedUsers = [
  { email: "juan@gmail.com", password: "123456789" },
  { email: "maria@gmail.com", password: "123456789" },
  { email: "manuelfernandez789@gmail.com", password: "123456789" },
  { email: "carlosruiz456@gmail.com", password: "123456789" }
];

function validateLogin(event) {
  event.preventDefault(); 

  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;

  console.log(`Email: ${email}`);
  console.log(`Password: ${password}`);

  const user = authorizedUsers.find(user => user.email === email && user.password === password);

  if (user) {
      console.log('Login successful');
      document.getElementById('login-form').style.display = 'none';
  } else {
      console.log('Invalid email or password');
      alert('Invalid email or password.');
  }
}


// Seleccion de tabla

const botones = document.querySelectorAll(".boton_seleccion")
const tablas = document.querySelectorAll(".container")
botones.forEach((button, index) => {
  button.addEventListener("click", () => {
    if (tablas[index].style.display != "flex")
    {
      tablas[index].style.display = "flex"
    }
    else {tablas[index].style.display = "none"}

    tablas.forEach(tabla => {
      if (tabla != tablas[index]) {tabla.style.display = "none"}
    })
  });
});
