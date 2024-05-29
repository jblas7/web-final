
  
  
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
    { email: "carlosruiz456@gmail.com", password: "123456789" },
  
    { email: "luismartinez789@gmail.com", password: "123456789" },
    { email: "anaperez123@gmail.com", password: "123456789" },
    { email: "pedrosanchez456@gmail.com", password: "123456789" },
    { email: "laurarodriguez789@gmail.com", password: "123456789" },
    { email: "diegogomez123@gmail.com", password: "123456789" },
    { email: "saralopez456@gmail.com", password: "123456789" },
    { email: "elenadiaz123@gmail.com", password: "123456789" },
    { email: "isabeljimenez789@gmail.com", password: "123456789" },
    { email: "pablovazquez123@gmail.com", password: "123456789" },
    { email: "luciaserrano456@gmail.com", password: "123456789" },
    { email: "antoniotorres789@gmail.com", password: "123456789" },
    { email: "carmenramirez123@gmail.com", password: "123456789" },
    { email: "javiermoreno456@gmail.com", password: "123456789" },
    { email: "nataliagutierrez789@gmail.com", password: "123456789" },
    { email: "alejandroortega123@gmail.com", password: "123456789" },
    { email: "raqueldominguez456@gmail.com", password: "123456789" },
    { email: "miguelcruz789@gmail.com", password: "123456789" },
    { email: "marinaherrera123@gmail.com", password: "123456789" },
    { email: "robertomedina456@gmail.com", password: "123456789" },
    { email: "beatrizsantos789@gmail.com", password: "123456789" },
    { email: "adrianmarquez123@gmail.com", password: "123456789" },
    { email: "rociogarrido456@gmail.com", password: "123456789" },
    { email: "danielperez789@gmail.com", password: "123456789" },
    { email: "cristinalopez123@gmail.com", password: "123456789" },
    { email: "sergiogomez456@gmail.com", password: "123456789" },
    { email: "paulamartinez789@gmail.com", password: "123456789" },
    { email: "patriciagarcia789@gmail.com", password: "123456789" },
    { email: "albertofernandez123@gmail.com", password: "123456789" },
    { email: "aliciasanchez456@gmail.com", password: "123456789" },
    { email: "franciscolopez789@gmail.com", password: "123456789" },
    { email: "evamartinez123@gmail.com", password: "123456789" },
    { email: "mariogomez789@gmail.com", password: "123456789" },
    { email: "nuriarodriguez456@gmail.com", password: "123456789" },
    { email: "raulperez789@gmail.com", password: "123456789" },
    { email: "sandrahernandez123@gmail.com", password: "123456789" },
    { email: "rubendiaz789@gmail.com", password: "123456789" },
    { email: "silviatorres456@gmail.com", password: "123456789" },
    { email: "diegoruiz789@gmail.com", password: "123456789" },
    { email: "marinagutierrez123@gmail.com", password: "123456789" },
    { email: "jorgejimenez789@gmail.com", password: "123456789" },
    { email: "sonialopez456@gmail.com", password: "123456789" },
    { email: "alvaroherrera789@gmail.com", password: "123456789" },
    { email: "lauraalvarez123@gmail.com", password: "123456789" },
    { email: "danielgarcia789@gmail.com", password: "123456789" },
    { email: "cristinafernandez456@gmail.com", password: "123456789" },
    { email: "pablomartinez789@gmail.com", password: "123456789" }
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
        // Ocultar el formulario de inicio de sesión
        document.getElementById('login-form').style.display = 'none';
        // Redirigir a trabajadores.html
        window.location.href = '../HTML/trabajadores.html';
    } else {
        console.log('Invalid email or password');
        alert('Invalid email or password.');
    }
}

// Añadir el event listener al formulario para que llame a validateLogin al hacer submit
document.getElementById('login-form').addEventListener('submit', validateLogin);

