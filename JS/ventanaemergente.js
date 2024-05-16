document.addEventListener("DOMContentLoaded", function () {
    // Obtener todas las imágenes del carrusel222
    var imagenesCarrusel222 = document.querySelectorAll('#carrusel222 .img-carrusel222');

    // Agregar un event listener a cada imagen del carrusel222
    imagenesCarrusel222.forEach(function (imagen) {
        imagen.addEventListener('click', function () {
            // Mostrar la ventana emergente al hacer clic en la imagen
            document.getElementById('ventanaEmergente').classList.add('ventana-activa');
            // Bloquear el scroll
            document.body.style.overflow = 'hidden';
        });
    });

    // Agregar event listener para cerrar la ventana emergente al hacer clic en el botón "Cerrar"
    document.getElementById('cerrarVentana').addEventListener('click', function () {
        document.getElementById('ventanaEmergente').classList.remove('ventana-activa');
        // Desbloquear el scroll
        document.body.style.overflow = 'auto';
    });
});